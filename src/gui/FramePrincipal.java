package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import gui.oyentes.OyenteMenu;

public class FramePrincipal extends JFrame{
	
	public FramePrincipal() {
		
		super("COURMENDER");
		setSize(700, 700);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu archivo = new JMenu("Archivo");
		JMenu ayuda = new JMenu("Ayuda");

		JMenuItem salir = new JMenuItem("Salir");
		JMenuItem ver_ayuda = new JMenuItem("Ver ayuda");
		JMenuItem info = new JMenuItem("Acerca de nosotros");

		salir.setActionCommand("Salir");
		salir.addActionListener(new OyenteMenu());

		ver_ayuda.setActionCommand("Ayuda");
		ver_ayuda.addActionListener(new OyenteMenu());

		info.setActionCommand("Info");
		info.addActionListener(new OyenteMenu());

		menuBar.add(archivo);
		menuBar.add(ayuda);

		archivo.add(salir);

		ayuda.add(ver_ayuda);
		ayuda.add(info);
		
	}
	
}
