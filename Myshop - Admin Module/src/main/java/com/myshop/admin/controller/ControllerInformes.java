package com.myshop.admin.controller;

import java.util.List;
import java.util.Map;

import org.sql2o.Connection;

import com.myshop.admin.util.DefaultSql2o;

public class ControllerInformes {

	public List<Map<String, Object>> primerInforme() {
		String complexSql = "SELECT Fecha, ParticularesCON, ParticularesSIN, " + "Minoristas FROM " + "("
				+ "(SELECT parti.Date AS Fecha,IFNULL(parti.particularesSIN, 0) "
				+ "AS ParticularesSIN, IFNULL(parti.particularesCON, 0) AS ParticularesCON, IFNULL"
				+ "(mino.minoristas, 0) AS Minoristas FROM (SELECT DATE(date_received) AS Date, COUNT"
				+ "(CASE WHEN C.user_id IS NULL THEN 1 ELSE NULL END) AS particularesSIN, "
				+ "COUNT(CASE WHEN C.user_id IS NOT NULL THEN 1 ELSE NULL END) AS particularesCON "
				+ "FROM myshop.order O, myshop.individual_customer C WHERE O.customer_id = C.customer_id "
				+ "GROUP BY DATE(date_received)) AS parti LEFT JOIN (SELECT DATE(O.date_received) AS Date, "
				+ "COUNT(*) AS minoristas FROM myshop.order O, myshop.company CO WHERE O.customer_id = CO.company_id"
				+ " GROUP BY DATE(O.date_received)) AS mino ON parti.Date = mino.Date) "

				+ "UNION (SELECT mino.Date AS Fecha, IFNULL(parti.particularesSIN, 0) AS"
				+ " ParticularesSIN, IFNULL(parti.particularesCON, 0) AS ParticularesCON, "
				+ "IFNULL(mino.minoristas, 0) AS Minoristas FROM (SELECT DATE(date_received) "
				+ "AS Date, COUNT(CASE WHEN C.user_id IS NULL THEN 1 ELSE NULL END) AS "
				+ "particularesSIN, COUNT(CASE WHEN C.user_id IS NOT NULL THEN 1 ELSE NULL END) "
				+ "AS particularesCON FROM myshop.order O, myshop.individual_customer C "
				+ "WHERE O.customer_id = C.customer_id GROUP BY DATE(date_received)) AS "
				+ "parti RIGHT JOIN (SELECT DATE(O.date_received) AS Date, COUNT(*) AS "
				+ "minoristas FROM myshop.order O, myshop.company CO WHERE  "
				+ "O.customer_id = CO.company_id GROUP BY DATE(O.date_received)) AS mino"
				+ " ON parti.Date = mino.Date)) AS resultado group by Fecha order by Fecha asc";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}

	public List<Map<String, Object>> segundoInforme() {
		String complexSql = "select Date(date_received) as fecha, SUM(if(payment_type = 'tarjeta', 1, 0)) as tarjeta,SUM(if(payment_type = 'transferencia'"
				+ ", 1, 0)) as transferencia,SUM(if(payment_type = 'contrareembolso', 1, 0)) as contrareembolso "
				+ "from full_order group by fecha order by fecha asc ;";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}

	public List<Map<String, Object>> tercerInforme() {
		String complexSql = "select Date(date_received) as fecha, SUM(if(wk_id = 1, 1, 0)) as suma1,SUM(if(wk_id = 2, 1, 0)) "
				+ "as suma2,SUM(if(wk_id = 3, 1, 0)) as suma3, SUM(if(wk_id = 4, 1, 0)) as suma4, SUM(if(wk_id = 5, 1, 0)) as"
				+ " suma5 from full_order where status='pendiente_de_envio' or status='enviado' group by fecha order by fecha asc";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}

	public List<Map<String, Object>> cuartoInforme() {
		String complexSql = "select Date(date_completed) as fecha, SUM(if(wk_id = 1, 1, 0)) as suma1,"
				+ "SUM(if(wk_id = 2, 1, 0)) as suma2, SUM(if(wk_id = 3, 1, 0)) as suma3 , SUM(if(wk_id = 4, 1, 0)) as suma4,"
				+ "SUM(if(wk_id = 5, 1, 0)) as suma5 from working_plan group by "
				+ "fecha order by fecha asc";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}
}
