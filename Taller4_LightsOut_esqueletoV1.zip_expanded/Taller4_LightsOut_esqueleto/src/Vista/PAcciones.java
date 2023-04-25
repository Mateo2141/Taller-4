package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.Control;

public class PAcciones extends JPanel{
	private JButton bNuevo;
	private JButton bReiniciar;
	private JButton bTop10;
	private JButton bCambiarJugador;
	private Control matriz;
	
	public PAcciones () {
		setBackground(new Color(228, 244, 253));
		setLayout(new GridLayout(4, 1, 10, 10));
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.bNuevo = new JButton("Nuevo Juego");
		this.bReiniciar = new JButton("Reiniciar Juego");
		this.bTop10 = new JButton("Ver el Top 10");
		this.bCambiarJugador = new JButton("Cambiar de Jugador");
		this.matriz = new Control();
		this.add(bNuevo);
		this.add(bReiniciar);
		this.add(bTop10);
		this.add(bCambiarJugador);
		
		this.bNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				matriz.darTamaño(5);
				matriz.reiniciar();
			}
		});
		
		this.bReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				matriz.reiniciar();
			}
		});

		this.bTop10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.bCambiarJugador.addActionListener(new ActionListener() {
			//ACA ESTA PASANDO ALGO PORQUE NO SE BORRA, PERO TODO PARECE BIEN????
			@Override
			public void actionPerformed(ActionEvent e) {
				PContadorYRegistros texto = new PContadorYRegistros();
				texto.eliminarCampoJugador();
			}
		});
	}
	
}
