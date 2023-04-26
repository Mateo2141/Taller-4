package Vista;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controlador.Control;
import Vista.ventanaTop10;

public class PAcciones extends JPanel{
	private JButton bNuevo;
	private JButton bReiniciar;
	private JButton bTop10;
	private JButton bCambiarJugador;
	private Control matriz;
	private PTablero botonesTablero;
	private ventanaTop10 ventana;
	
	public PAcciones () {
		setBackground(new Color(228, 244, 253));
		setLayout(new GridLayout(4, 1, 10, 10));
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.bNuevo = new JButton("Nuevo Juego");
		this.bReiniciar = new JButton("Reiniciar Juego");
		this.bTop10 = new JButton("Ver el Top 10");
		this.bCambiarJugador = new JButton("Cambiar de Jugador");
		this.matriz = new Control();
	    this.botonesTablero = new PTablero(5);
		this.add(bNuevo);
		this.add(bReiniciar);
		this.add(bTop10);
		this.add(bCambiarJugador);
		
		this.bNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				matriz.darTamaño(5);
				matriz.reiniciar();
				boolean[][] tablero = matriz.darTablero();
				botonesTablero.cambiarColores(tablero);
				FPrincipal ventanaPrincipal = (FPrincipal) SwingUtilities.getWindowAncestor(PAcciones.this);
		        ventanaPrincipal.actualizarPTablero(botonesTablero);
				
			}
		});
		
		this.bReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				matriz.reiniciar();
				boolean[][] tablero2 = matriz.darTablero();
				botonesTablero.cambiarColores(tablero2);
				FPrincipal ventanaPrincipal = (FPrincipal) SwingUtilities.getWindowAncestor(PAcciones.this);
		        ventanaPrincipal.actualizarPTablero(botonesTablero);
			}
		});

		this.bTop10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana = new ventanaTop10();
			}
		});
		
		this.bCambiarJugador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PContadorYRegistros texto = new PContadorYRegistros();
				texto.eliminarCampoJugador();
			}
		});
	}
	
}
