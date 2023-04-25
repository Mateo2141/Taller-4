package Vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FPrincipal extends JFrame {
	
	private PSuperiorParametros psuperiorParametros;
	private PTablero pTablero;
	private PContadorYRegistros pContadorYRegistros;
	private PAcciones pAcciones;
	
	public FPrincipal() {		
		/*
		 * CREO LOS ASPECTOS TECNICOS: TAMAÑO DE LA VENTANA, NOMBRE, ETC.
		 */	
		this.setTitle("Lights Out");
		this.setSize(800,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		this.psuperiorParametros = new PSuperiorParametros();
		this.pContadorYRegistros = new PContadorYRegistros();
		this.pAcciones = new PAcciones();
		this.pTablero = new PTablero(5);
		

		getContentPane().add(psuperiorParametros, BorderLayout.NORTH);
		getContentPane().add(pContadorYRegistros, BorderLayout.SOUTH);
		getContentPane().add(pAcciones, BorderLayout.EAST);
		getContentPane().add(pTablero, BorderLayout.CENTER);

		
		this.setVisible(true);
	}
	
	public void actualizarPTablero(PTablero nuevoPTablero) {
	    getContentPane().remove(pTablero);
	    pTablero = nuevoPTablero;
	    getContentPane().add(pTablero, BorderLayout.CENTER);
	    revalidate();
	    repaint();
	}
	
	public static void main(String[] args) {
		new FPrincipal();
	}
	
}
