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

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel titleBar;
	private JPanel leftMenu;
	private JPanel mainPane;
	private JPanel footer;
	private JLabel lblPrimerInforme;

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
		}
		return leftMenu;
	}
	private JPanel getMainPane() {
		if (mainPane == null) {
			mainPane = new JPanel();
			mainPane.setLayout(new BorderLayout(0, 0));
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
}
