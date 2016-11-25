package com.myshop.admin.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.myshop.admin.controller.ControllerInformes;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel titleBar;
	private JPanel leftMenu;
	private JPanel mainPane;
	private JPanel footer;
	private JLabel lblPrimerInforme;
	private JLabel lblSegundoInforme;
	private JLabel lblTercerInforme;
	private JLabel lblCuartoInforme;
	private JPanel pnPrimerInforme;
	private JPanel pnSegundoInforme;
	private JPanel pnTercerInforme;
	private JPanel pnCuartoInforme;
	private JScrollPane scpTercerInforme;
	private JTable tbTercerInforme;
	private DefaultTableModel modeloTablaPrimerInforme;
	private DefaultTableModel modeloTablaSegundoInforme;
	private DefaultTableModel modeloTablaTercerInforme;
	private DefaultTableModel modeloTablaCuartoInforme;
	private JScrollPane scpPrimerInforme;
	private JTable tbPrimerInforme;
	private JScrollPane scpSegundoInforme;
	private JTable tbSegundoInforme;
	private JScrollPane scpCuartoInforme;
	private JTable tbCuartoInforme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setFont(new Font("SF UI Text", Font.PLAIN, 12));
		setTitle("myShop Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 410);
		setMinimumSize(new Dimension(665, 410));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTitleBar(), BorderLayout.NORTH);
		contentPane.add(getLeftMenu(), BorderLayout.WEST);
		contentPane.add(getMainPane(), BorderLayout.CENTER);
		contentPane.add(getFooter(), BorderLayout.SOUTH);
	}

	private JPanel getTitleBar() {
		if (titleBar == null) {
			titleBar = new JPanel();
			titleBar.setLayout(new BorderLayout(0, 0));
		}
		return titleBar;
	}
	private JPanel getLeftMenu() {
		if (leftMenu == null) {
			leftMenu = new JPanel();
			leftMenu.setLayout(new GridLayout(4, 1, 0, 0));
			leftMenu.add(getLblPrimerInforme());
			leftMenu.add(getLblSegundoInforme());
			leftMenu.add(getLblTercerInforme());
			leftMenu.add(getLblCuartoInforme());
		}
		return leftMenu;
	}
	private JPanel getMainPane() {
		if (mainPane == null) {
			mainPane = new JPanel();
			mainPane.setLayout(new CardLayout(0, 0));
			mainPane.add(getPnPrimerInforme(), "name_5548202142181");
			mainPane.add(getPnSegundoInforme(), "name_5566166419391");
			mainPane.add(getPnTercerInforme(), "name_5576256697813");
			mainPane.add(getPnCuartoInforme(), "name_5588217201325");
		}
		return mainPane;
	}
	private JPanel getFooter() {
		if (footer == null) {
			footer = new JPanel();
			footer.setLayout(new BorderLayout(0, 0));
		}
		return footer;
	}
	private JLabel getLblPrimerInforme() {
		if (lblPrimerInforme == null) {
			lblPrimerInforme = new JLabel("Primer Informe");
			lblPrimerInforme.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					rellenarPrimerInforme();
					getPnSegundoInforme().setVisible(false);
					getPnTercerInforme().setVisible(false);
					getPnCuartoInforme().setVisible(false);
					getPnPrimerInforme().setVisible(true);	
				}
			});
		}
		return lblPrimerInforme;
	}
	private JLabel getLblSegundoInforme() {
		if (lblSegundoInforme == null) {
			lblSegundoInforme = new JLabel("Segundo Informe");
			lblSegundoInforme.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					rellenarSegundoInforme();
					getPnPrimerInforme().setVisible(false);
					getPnTercerInforme().setVisible(false);
					getPnCuartoInforme().setVisible(false);
					getPnSegundoInforme().setVisible(true);
				}
			});
		}
		return lblSegundoInforme;
	}
	private JLabel getLblTercerInforme() {
		if (lblTercerInforme == null) {
			lblTercerInforme = new JLabel("Tercer Informe");
			lblTercerInforme.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						rellenarTercerInforme();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					getPnPrimerInforme().setVisible(false);
					getPnSegundoInforme().setVisible(false);
					getPnCuartoInforme().setVisible(false);
					getPnTercerInforme().setVisible(true);
				}
			});
		}
		return lblTercerInforme;
	}
	private JLabel getLblCuartoInforme() {
		if (lblCuartoInforme == null) {
			lblCuartoInforme = new JLabel("Cuarto Informe");
			lblCuartoInforme.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						rellenarCuartoInforme();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					getPnPrimerInforme().setVisible(false);
					getPnSegundoInforme().setVisible(false);
					getPnTercerInforme().setVisible(false);
					getPnCuartoInforme().setVisible(true);
				}
			});
		}
		return lblCuartoInforme;
	}
	private JPanel getPnPrimerInforme() {
		if (pnPrimerInforme == null) {
			pnPrimerInforme = new JPanel();
			pnPrimerInforme.setLayout(new BorderLayout(0, 0));
			pnPrimerInforme.add(getScpPrimerInforme(), BorderLayout.CENTER);
		}
		return pnPrimerInforme;
	}
	private JPanel getPnSegundoInforme() {
		if (pnSegundoInforme == null) {
			pnSegundoInforme = new JPanel();
			pnSegundoInforme.setLayout(new BorderLayout(0, 0));
			pnSegundoInforme.add(getScpSegundoInforme(), BorderLayout.CENTER);
		}
		return pnSegundoInforme;
	}
	private JPanel getPnTercerInforme() {
		if (pnTercerInforme == null) {
			pnTercerInforme = new JPanel();
			pnTercerInforme.setLayout(new BorderLayout(0, 0));
			pnTercerInforme.add(getScpTercerInforme(), BorderLayout.CENTER);
		}
		return pnTercerInforme;
	}
	private JPanel getPnCuartoInforme() {
		if (pnCuartoInforme == null) {
			pnCuartoInforme = new JPanel();
			pnCuartoInforme.setLayout(new BorderLayout(0, 0));
			pnCuartoInforme.add(getScpCuartoInforme(), BorderLayout.CENTER);
		}
		return pnCuartoInforme;
	}
	private JScrollPane getScpTercerInforme() {
		if (scpTercerInforme == null) {
			scpTercerInforme = new JScrollPane();
			scpTercerInforme.setViewportView(getTbTercerInforme());
		}
		return scpTercerInforme;
	}
	private JTable getTbTercerInforme() {
		if (tbTercerInforme == null) {
			String[] columnas = { "Dia","Empaquetados a1", "Empaquetados a2","Empaquetados a3", "Empaquetados a4","Empaquetados a5"};
			modeloTablaTercerInforme = new DefaultTableModel(columnas, 0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			tbTercerInforme = new JTable(modeloTablaTercerInforme);
		}
		return tbTercerInforme;
	}
	
	private void rellenarPrimerInforme(){
		reiniciarPrimerInforme();
		//TODO cada vez que le das a la label de primer informe llama 
		//a este metodo, sin el reiniciar se llenaria con los mismos datos una y otra vez
		Object[] nuevaFila = new Object[4];
		List<Map<String,Object>> informe = new ControllerInformes().primerInforme();
		
		for (Map<String,Object> map : informe) {
			nuevaFila[0] = map.get("fecha");
			nuevaFila[1] = map.get("particularessin");
			nuevaFila[2] = map.get("particularescon");
			nuevaFila[3] = map.get("minoristas");
			modeloTablaPrimerInforme.addRow(nuevaFila);
		}
	}
	
	private void rellenarSegundoInforme(){
		reiniciarSegundoInforme();
		//TODO cada vez que le das a la label de segundo informe llama a este metodo, 
		//sin el reiniciar se llenaria con los mismos datos una y otra vez
		Object[] nuevaFila = new Object[4];
		List<Map<String,Object>> informe = new ControllerInformes().segundoInforme();
		
		for (Map<String,Object> map : informe) {
			/*nuevaFila[0] = map.get("date");
			nuevaFila[1] = map.get("suma1");
			nuevaFila[2] = map.get("suma2");
			nuevaFila[3] = map.get("suma3")*/
			modeloTablaSegundoInforme.addRow(nuevaFila);
		}
	}

	private boolean estaFecha(String d,List<Map<String,Object>> l){
		for(Map<String,Object> m : l){
			if(m.get("date").equals(d)){
				return true;
			}
		}
		return false;
	}
	
	private void rellenarTercerInforme() throws ParseException{
		reiniciarTercerInforme();
		Object[] nuevaFila = new Object[6];
		List<Map<String,Object>> informe = new ControllerInformes().tercerInforme();
		List<Map<String,Object>> aux = new ArrayList<Map<String,Object>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> mp;
		for(Map<String,Object> m : informe){
			mp = new HashMap<String,Object>();
			mp.put("wk_id", m.get("wk_id"));
			mp.put("date_received",sdf.format((Date)m.get("date_received")));
			mp.put("suma", m.get("suma"));
			aux.add(mp);
		}
		List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();
		for (Map<String,Object> map1 : aux) {
			Map<String,Object> mapa = new HashMap<String,Object>();
			if(!estaFecha((String)map1.get("date_received"),res)){
				mapa.put("date", map1.get("date_received"));
				mapa.put("suma1", map1.get("suma"));
				mapa.put("id", map1.get("wk_id"));
				res.add(mapa);
			}
		}
		
		for (Map<String,Object> map1 : aux) {
			for(Map<String,Object> mapa2 : res){
				if(map1.get("wk_id") != null && !map1.get("wk_id").equals(mapa2.get("id")) 
						&& map1.get("date_received").equals(mapa2.get("date"))){
					mapa2.put("suma2", map1.get("suma"));
				}
			}
		}
		
		for (Map<String,Object> map : res) {
			nuevaFila[0] = map.get("date");
			if(map.get("suma1") == null)
				nuevaFila[1] = 0;
			else
				nuevaFila[1] = map.get("suma1");
			if(map.get("suma2") == null)
				nuevaFila[2] = 0;
			else
				nuevaFila[2] = map.get("suma2");
			if(map.get("suma3") == null)
				nuevaFila[3] = 0;
			else
				nuevaFila[3] = map.get("suma3");
			if(map.get("suma4") == null)
				nuevaFila[4] = 0;
			else
				nuevaFila[4] = map.get("suma4");
			if(map.get("suma5") == null)
				nuevaFila[5] = 0;
			else
				nuevaFila[5] = map.get("suma5");
			modeloTablaTercerInforme.addRow(nuevaFila);
			
		}
	}
	
	private void rellenarCuartoInforme() throws ParseException{
		reiniciarCuartoInforme();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
		Object[] nuevaFila = new Object[6];
		List<Map<String,Object>> informe = new ControllerInformes().cuartoInforme();
		List<Map<String,Object>> aux = new ArrayList<Map<String,Object>>();
		Map<String,Object> mp;
		for(Map<String,Object> m : informe){
			mp = new HashMap<String,Object>();
			mp.put("wk_id", m.get("wk_id"));
			mp.put("date_completed",sdf.format((Date)m.get("date_completed")));
			mp.put("suma", m.get("suma"));
			aux.add(mp);
		}
		List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();
		for (Map<String,Object> map1 : aux) {
			Map<String,Object> mapa = new HashMap<String,Object>();
			if(!estaFecha((String)map1.get("date_completed"),res)){
				mapa.put("date", map1.get("date_completed"));	
				if((int)map1.get("wk_id") == 1){
					mapa.put("suma1", map1.get("suma"));
					mapa.put("id", map1.get("wk_id"));
				}
				if((int)map1.get("wk_id") == 2){
					mapa.put("suma2", map1.get("suma"));
					mapa.put("id", map1.get("wk_id"));
				}
				if((int)map1.get("wk_id") == 3){
					mapa.put("suma3", map1.get("suma"));
					mapa.put("id", map1.get("wk_id"));
				}
				if((int)map1.get("wk_id") == 4){
					mapa.put("suma4", map1.get("suma"));
					mapa.put("id", map1.get("wk_id"));
				}
				if((int)map1.get("wk_id") == 5){
					mapa.put("suma5", map1.get("suma"));
					mapa.put("id", map1.get("wk_id"));
				}
				res.add(mapa);
			}
		}
		
		for (Map<String,Object> map1 : aux) {
			for(Map<String,Object> mapa2 : res){
				if(map1.get("wk_id") != null && !map1.get("wk_id").equals(mapa2.get("id")) 
						&& map1.get("date_completed").equals(mapa2.get("date"))){
					if((int)mapa2.get("id") == 1)
						mapa2.put("suma1", map1.get("suma"));
					if((int)mapa2.get("id") == 2)
						mapa2.put("suma2", map1.get("suma"));
					if((int)mapa2.get("id") == 3)
						mapa2.put("suma3", map1.get("suma"));
					if((int)mapa2.get("id") == 4)
						mapa2.put("suma4", map1.get("suma"));
					if((int)mapa2.get("id") == 5)
						mapa2.put("suma5", map1.get("suma"));

				}
			}
		}
		
		for (Map<String,Object> map : res) {
			nuevaFila[0] = map.get("date");
			if(map.get("suma1") == null)
				nuevaFila[1] = 0;
			else
				nuevaFila[1] = map.get("suma1");
			if(map.get("suma2") == null)
				nuevaFila[2] = 0;
			else
				nuevaFila[2] = map.get("suma2");
			if(map.get("suma3") == null)
				nuevaFila[3] = 0;
			else
				nuevaFila[3] = map.get("suma3");
			if(map.get("suma4") == null)
				nuevaFila[4] = 0;
			else
				nuevaFila[4] = map.get("suma4");
			if(map.get("suma5") == null)
				nuevaFila[5] = 0;
			else
				nuevaFila[5] = map.get("suma5");
			modeloTablaCuartoInforme.addRow(nuevaFila);
			
		}
	}
	
	private void reiniciarPrimerInforme(){
		for(int i = modeloTablaPrimerInforme.getRowCount()-1;i>=0;i--){
			modeloTablaPrimerInforme.removeRow(i);
		}
	}
	
	private void reiniciarSegundoInforme(){
		for(int i = modeloTablaSegundoInforme.getRowCount()-1;i>=0;i--){
			modeloTablaSegundoInforme.removeRow(i);
		}
	}
	
	private void reiniciarTercerInforme(){
		for(int i = modeloTablaTercerInforme.getRowCount()-1;i>=0;i--){
			modeloTablaTercerInforme.removeRow(i);
		}
	}
	
	private void reiniciarCuartoInforme(){
		for(int i = modeloTablaCuartoInforme.getRowCount()-1;i>=0;i--){
			modeloTablaCuartoInforme.removeRow(i);
		}
	}
	private JScrollPane getScpPrimerInforme() {
		if (scpPrimerInforme == null) {
			scpPrimerInforme = new JScrollPane();
			scpPrimerInforme.setViewportView(getTbPrimerInforme());
		}
		return scpPrimerInforme;
	}
	private JTable getTbPrimerInforme() {
		if (tbPrimerInforme == null) {
			String[] columnas = {  "Dia","N.Compras U.Anonimo", "N.Compras U.Registrado","N.Compras Minoristas"};
			modeloTablaPrimerInforme = new DefaultTableModel(columnas, 0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			tbPrimerInforme = new JTable(modeloTablaPrimerInforme);
		}
		return tbPrimerInforme;
	}
	private JScrollPane getScpSegundoInforme() {
		if (scpSegundoInforme == null) {
			scpSegundoInforme = new JScrollPane();
			scpSegundoInforme.setViewportView(getTbSegundoInforme());
		}
		return scpSegundoInforme;
	}
	private JTable getTbSegundoInforme() {
		if (tbSegundoInforme == null) {
			String[] columnas = {  "Dia","Compras Tarjeta", "Compras Transferencia","Compras Contra reembolso"};
			modeloTablaSegundoInforme = new DefaultTableModel(columnas, 0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			tbSegundoInforme = new JTable(modeloTablaSegundoInforme);
		}
		return tbSegundoInforme;
	}
	private JScrollPane getScpCuartoInforme() {
		if (scpCuartoInforme == null) {
			scpCuartoInforme = new JScrollPane();
			scpCuartoInforme.setViewportView(getTbCuartoInforme());
		}
		return scpCuartoInforme;
	}
	private JTable getTbCuartoInforme() {
		if (tbCuartoInforme == null) {
			String[] columnas = {  "Dia","OrdenesTrabajo a1", "OrdenesTrabajo a2","OrdenesTrabajo a3", "OrdenesTrabajo a4","OrdenesTrabajo a5"};
			modeloTablaCuartoInforme = new DefaultTableModel(columnas, 0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			tbCuartoInforme = new JTable(modeloTablaCuartoInforme);
		}
		return tbCuartoInforme;
	}
}
