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
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
					//TODO
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
					//TODO
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
					rellenarTercerInforme();
					getPnTercerInforme().setVisible(true);
					getScpTercerInforme().setVisible(true);
					getTbTercerInforme().setVisible(true);
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
					rellenarCuartoInforme();
					getPnCuartoInforme().setVisible(true);
					getScpCuartoInforme().setVisible(true);
					getTbCuartoInforme().setVisible(true);
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
			String[] columnas = { "Id almacenero","Pedidos Empaquetados", "Fecha"};
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
		//TODO
	}
	
	private void rellenarSegundoInforme(){
		reiniciarSegundoInforme();
		//TODO
	}
	
	private void rellenarTercerInforme(){
		reiniciarTercerInforme();
		Object[] nuevaFila = new Object[3];
		List<Map<String,Object>> informe = new ControllerInformes().tercerInforme();

		for (Map<String,Object> map : informe) {
			if(!(map.get("wk_id") == null) && !(map.get("date_received") == null)){
				nuevaFila[0] = map.get("wk_id");
				nuevaFila[1] = map.get("suma");
				nuevaFila[2] = map.get("date_received");
				modeloTablaTercerInforme.addRow(nuevaFila);
			}
		}
	}
	
	private void rellenarCuartoInforme(){
		reiniciarCuartoInforme();
		
		Object[] nuevaFila = new Object[3];
		List<Map<String,Object>> informe = new ControllerInformes().cuartoInforme();

		for (Map<String,Object> map : informe) {
			if(!(map.get("wk_id") == null)){
				nuevaFila[0] = map.get("wk_id");
				nuevaFila[1] = map.get("suma");
				nuevaFila[2] = map.get("date_completed");
				modeloTablaCuartoInforme.addRow(nuevaFila);
			}
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
			tbPrimerInforme = new JTable();
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
			tbSegundoInforme = new JTable();
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
			String[] columnas = { "Id almacenero","Ordenes de trabajo", "Fecha completadas"};
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
