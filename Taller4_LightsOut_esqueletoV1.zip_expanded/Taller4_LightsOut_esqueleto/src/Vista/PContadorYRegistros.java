package Vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controlador.Control;

public class PContadorYRegistros extends JPanel{
	private JLabel t_jugadas;
	private JLabel t_jugador;
	private JLabel jugadas;
	private JTextField jugador;
	private Control matriz;
	private Control registro;
	
	
	public PContadorYRegistros() {
		setBackground(new Color(228, 244, 253));
		setLayout(new GridLayout(1, 4));
		this.t_jugadas = new JLabel("Jugadas: ");
		this.t_jugador = new JLabel("Jugador(Llenar al final): ");
		this.jugadas = new JLabel("0");
		this.jugador = new JTextField();
		this.add(t_jugadas);
		this.add(jugadas);
		this.add(t_jugador);
		this.add(jugador);
		this.matriz = new Control();
		this.registro = new Control();
		
		this.jugador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombrejugador = jugador.getText();
				registro.registrarJugador(nombrejugador);
				eliminarCampoJugador();
						
			}
		});
	}
	
	public void update() {
		this.jugadas.setText("Jugadas: " + matriz.verJugadas());
	}
	
	public void eliminarCampoJugador() {
			jugador.setText("");
	}
	
}

