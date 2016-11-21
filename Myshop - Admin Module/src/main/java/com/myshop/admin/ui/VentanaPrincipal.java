package com.myshop.admin.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;

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
		}
		return lblPrimerInforme;
	}
	private JLabel getLblSegundoInforme() {
		if (lblSegundoInforme == null) {
			lblSegundoInforme = new JLabel("Segundo Informe");
		}
		return lblSegundoInforme;
	}
	private JLabel getLblTercerInforme() {
		if (lblTercerInforme == null) {
			lblTercerInforme = new JLabel("Tercer Informe");
		}
		return lblTercerInforme;
	}
	private JLabel getLblCuartoInforme() {
		if (lblCuartoInforme == null) {
			lblCuartoInforme = new JLabel("Cuarto Informe");
		}
		return lblCuartoInforme;
	}
	private JPanel getPnPrimerInforme() {
		if (pnPrimerInforme == null) {
			pnPrimerInforme = new JPanel();
		}
		return pnPrimerInforme;
	}
	private JPanel getPnSegundoInforme() {
		if (pnSegundoInforme == null) {
			pnSegundoInforme = new JPanel();
		}
		return pnSegundoInforme;
	}
	private JPanel getPnTercerInforme() {
		if (pnTercerInforme == null) {
			pnTercerInforme = new JPanel();
		}
		return pnTercerInforme;
	}
	private JPanel getPnCuartoInforme() {
		if (pnCuartoInforme == null) {
			pnCuartoInforme = new JPanel();
		}
		return pnCuartoInforme;
	}
}
