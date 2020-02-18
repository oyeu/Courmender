package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import gui.oyentes.RecomendarCursos;
import jess.swing.JTextAreaWriter;
import main.Main;

public class InterfazPrincipal extends Container implements ActionListener {
	JLabel L1,L2,L3,L4,L5,bienvenida;
	JTextField T1,T2,T3,T4,T5;
	JTextArea TA1;
	JTextAreaWriter TAW1;
	JButton B1;
	JComboBox J1;
	
    public InterfazPrincipal() {
        setBackground(Color.WHITE);
        setLayout(null);
        
        bienvenida = new JLabel(
				"<html><center><font size=6><center>Bienvenidos a</center></font><font size=7><center>COURMENDER</center></font><font size=3><center>Llena los campos y te recomendaremos el curso perfecto para ti</center></font></center></html>");
		bienvenida.setBounds(150,10 ,500, 100);
		add(bienvenida);
		
        L1 = new JLabel("Nombre: ");
        L1.setToolTipText("<html>Tu nombre</html>");
        L1.setBounds(170,130,60,30);
        add(L1);
        
        T1 = new JTextField();
        T1.setBounds(250, 130, 200, 30);
        add(T1);
        
		L2 = new JLabel("Area_interes: ");
		L2.setToolTipText("<html>¿Que quieres aprender?</html>");
		L2.setBounds(170,180,100,30);
        add(L2);
        
        J1 = new JComboBox<String>();
        J1.setBounds(250, 180, 200, 30);
        add(J1);
		
		L3 = new JLabel("Tiempo disponible: ");
		L3.setToolTipText("<html>¿Cuanto tiempo tienes para estudiar al dÃ­a?(horas)</html>");
		
		L4 = new JLabel("Tiempo esperado: ");
		L4.setToolTipText("<html>¿En cuanto tiempo esperas completar el curso?(meses)</html>");
		
		L5 = new JLabel("Presupuesto: ");
		L5.setToolTipText("<html>¿Cuanto dinero estas dispuesto a invertir?</html>");
		
		
		
		T2 = new JTextField(9);
		T3 = new JTextField(9);
		T4 = new JTextField(9);
		T5 = new JTextField(9);
		
		TA1 = new JTextArea(18, 38);
		TAW1= new JTextAreaWriter (TA1);
		
		B1 = new JButton("Enviar");
		B1.setActionCommand("Enviar");
		B1.addActionListener(new RecomendarCursos(T1, T2, T3,T4,T5, TA1,TAW1));

		// Panel scroll
		JScrollPane JS1 = new JScrollPane(TA1);
		JS1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		
		
		
		// Menu
		
      
        SwingUtilities.updateComponentTreeUI(Main.frame);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Consulta de instancias"));
		
	}
}
