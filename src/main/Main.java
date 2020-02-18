package main;

import gui.*;
import javax.swing.JFrame;

public class Main {
	
	public static JFrame frame;

	public static void main(String[] args) {
		
		frame = new FramePrincipal();
		frame.setContentPane(new InterfazPrincipal());
		
	}

}
