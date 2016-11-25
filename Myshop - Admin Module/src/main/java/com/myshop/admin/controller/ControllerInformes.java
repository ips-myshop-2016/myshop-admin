package com.myshop.admin.controller;

import java.util.List;
import java.util.Map;

import org.sql2o.Connection;

import com.myshop.admin.util.DefaultSql2o;

public class ControllerInformes {

	
	public List<Map<String,Object>> primerInforme() {
		String complexSql = "SELECT Fecha, ParticularesCON, ParticularesSIN, "
				+ "Minoristas FROM "
				+ "("
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
				+ " ON parti.Date = mino.Date)) AS resultado ORDER BY Fecha";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}
	
	public List<Map<String,Object>> segundoInforme() {
		String complexSql = "";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}
	
	public List<Map<String,Object>> tercerInforme() {
		String complexSql = "SELECT count(*) as suma , wk_id , Date(date_received) "
				+ "as fecha FROM myshop.full_order where status='finalizado' and wk_id is not null group by fecha, wk_id ";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}
	
	public List<Map<String,Object>> cuartoInforme() {
		String complexSql = "SELECT count(*) as suma , p.wk_id , Date(w.date_completed) as fecha FROM myshop."
				+ "full_order p , myshop.working_plan w where w.wp_id=p.working_plan_id and w.date_completed is not null "
				+ "group by fecha, p.wk_id ";
		try (Connection con = DefaultSql2o.SQL2O.open()) {
			return con.createQuery(complexSql).executeAndFetchTable().asList();
		}
	}
}
