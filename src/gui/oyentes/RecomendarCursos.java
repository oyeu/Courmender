package gui.oyentes;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jess.*;
import jess.ConsolePanel;
import jess.Fact;
import jess.JessException;
import jess.Rete;
import jess.Value;
import jess.swing.JTextAreaWriter;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class RecomendarCursos implements ActionListener{

	JTextField T1;
	JTextField T2;
	JTextField T3;
	JTextField T4;
	JTextField T5;
	JTextArea TA1;
	JTextAreaWriter TAW1;
	
	public RecomendarCursos(JTextField t1, JTextField t2, JTextField t3,JTextField t4,JTextField t5, JTextArea ta1, JTextAreaWriter taw1) {
		// TODO Auto-generated constructor stub
		T1 = t1;
		T2 = t2;
		T3 = t3;
		T4 = t4;
		T5 = t5;
		TA1 = ta1;
		TAW1 = taw1;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		String actionCommand = e.getActionCommand();
		if (e.getSource() instanceof JButton) {
			if("Enviar".equals(actionCommand)) {
				FIS determinar_tipo = FIS.load("src/ld/tipo_curso.FCL", true);
				
				// Set inputs
				determinar_tipo.setVariable("tiempo_disponible", Double.parseDouble(T3.getText()));
				determinar_tipo.setVariable("tiempo_esperado", Double.parseDouble(T4.getText()));
		        
		        // Evaluate
				determinar_tipo.evaluate(); 

		        //Graficas de conjuntos difusos
		        JFuzzyChart.get().chart(determinar_tipo.getFunctionBlock("determinar_tipo"));
		        
		        Map<String, Double> map = new HashMap<String, Double>();
		        map.put("taller", determinar_tipo.getVariable("tipo_curso").getMembership("taller"));
		        map.put("intensivo", determinar_tipo.getVariable("tipo_curso").getMembership("intensivo"));
		        map.put("diplomado", determinar_tipo.getVariable("tipo_curso").getMembership("diplomado"));
		        map.put("bimestral", determinar_tipo.getVariable("tipo_curso").getMembership("bimestral"));
		        map.put("trimestral", determinar_tipo.getVariable("tipo_curso").getMembership("trimestral"));
		        map.put("semestral", determinar_tipo.getVariable("tipo_curso").getMembership("semestral"));
		        map.put("anual", determinar_tipo.getVariable("tipo_curso").getMembership("anual"));
		        String tipo_c = "taller";
		        double aux = 0;
		        String[] tipos = {"taller", "intensivo", "diplomado","bimestral","trimestral","semestral","anual"};
		        for(int i = 0; i<tipos.length; i++) {
		        	if(map.get(tipos[i])> aux) {
		        		aux =map.get(tipos[i]);
		        		tipo_c = tipos[i];
		        	}
		        }    
		        
		        TA1.setText(TA1.getText() + "Bienvenido a Courmender "+T1.getText());		        
		        TA1.setText(TA1.getText() + "\n" + "El metodo usado para 'defuzzificar' el tipo de curso fue: " + determinar_tipo.getVariable("tipo_curso").getDefuzzifier());
		        TA1.setText(TA1.getText() + "\n \n" + "El grado de pertenencia a los conjuntos difusos es: ");
		        TA1.setText(TA1.getText() + "\n" + "	'taller': " + determinar_tipo.getVariable("tipo_curso").getMembership("taller"));
		        TA1.setText(TA1.getText() + "\n" + "	'intensivo': " + determinar_tipo.getVariable("tipo_curso").getMembership("intensivo"));
		        TA1.setText(TA1.getText() + "\n" + "	'diplomado': " + determinar_tipo.getVariable("tipo_curso").getMembership("diplomado"));
		        TA1.setText(TA1.getText() + "\n" + "	'bimestral': " + determinar_tipo.getVariable("tipo_curso").getMembership("bimestral"));
		        TA1.setText(TA1.getText() + "\n" + "	'trimestral': " + determinar_tipo.getVariable("tipo_curso").getMembership("trimestral"));
		        TA1.setText(TA1.getText() + "\n" + "	'semestral': " + determinar_tipo.getVariable("tipo_curso").getMembership("semestral"));
		        TA1.setText(TA1.getText() + "\n" + "	'anual': " + determinar_tipo.getVariable("tipo_curso").getMembership("anual"));
		        TA1.setText(TA1.getText() + "El tipo de curso recomendado es: " + tipo_c);
		        
		        
		        Rete rete = new Rete();
		        try {
		        rete.batch("src/se/cursos.CLP");
		        rete.reset();
		        Fact Usuario = new Fact("Usuario",rete);
		        Usuario.setSlotValue("nombre", new Value(T1.getText(),RU.STRING));
		        Usuario.setSlotValue("area_interes", new Value(T2.getText(),RU.STRING));
		        Usuario.setSlotValue("tipo_curso", new Value(tipo_c,RU.STRING));
		        Usuario.setSlotValue("presupuesto", new Value(Integer.parseInt(T5.getText()),RU.INTEGER));
		        rete.assertFact(Usuario);
		        rete.addOutputRouter("log", TAW1);
		        rete.run();

		        }
		        catch(JessException err) {
		        	System.out.println(err.toString());
		        }
		        
		        
		        
		        TA1.setEditable(false);
			}
		}
	}
}