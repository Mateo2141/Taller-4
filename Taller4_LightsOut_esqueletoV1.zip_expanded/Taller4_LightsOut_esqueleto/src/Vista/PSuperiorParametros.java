package Vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import controlador.Control;

public class PSuperiorParametros extends JPanel{
	private JLabel tamaño;
	private JLabel dificultad;
	private JComboBox <String> comboBox;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	private Control matriz;

	
	public PSuperiorParametros() {
       this.tamaño = new JLabel("Tamaño:");
       this.dificultad = new JLabel("Dificultad:");
       this.comboBox = new JComboBox<>(new String[]{"5x5", "7x7", "9x9"});
       this.facil = new JRadioButton("Fácil");
       this.medio = new JRadioButton("Medio");
       this.dificil = new JRadioButton("Difícil");
       this.matriz = new Control();
       
       ButtonGroup grupoDificultad = new ButtonGroup();
       grupoDificultad.add(facil);
       grupoDificultad.add(medio);
       grupoDificultad.add(dificil);
       
       setLayout(new FlowLayout());
       add(tamaño);
       add(comboBox);
       add(dificultad);
       add(facil);
       add(medio);
       add(dificil);
       setBackground(new Color(64, 157, 196));
       
       ItemListener listener = new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			JRadioButton opcion = (JRadioButton) e.getSource();
			int estado;
			if (opcion == facil) {
				estado = 3;
			} else if (opcion == medio) {
				estado = 9;
			} else {
				estado = 12;
			}
			matriz.nivel(estado);
		}
	};
	
	    facil.addItemListener(listener);
	    medio.addItemListener(listener);
	    dificil.addItemListener(listener);
		
       
       this.comboBox.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox comboBox = (JComboBox) e.getSource();
			String opcion = (String) comboBox.getSelectedItem();
			opcion = opcion.substring(0, 1);
			int intTamaño = Integer.parseInt(opcion);
			//NO SE ESTA ACTUALIZANDO :(

			PTablero botonesTablero = new PTablero(intTamaño);
			botonesTablero.setTamanio(intTamaño);
			matriz.darTamaño(intTamaño);
			
			FPrincipal ventanaPrincipal = (FPrincipal) SwingUtilities.getWindowAncestor(PSuperiorParametros.this);
	        ventanaPrincipal.actualizarPTablero(botonesTablero);
		}	
	});
       
	}
}
