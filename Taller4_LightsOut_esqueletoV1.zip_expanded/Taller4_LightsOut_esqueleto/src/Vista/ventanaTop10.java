package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import controlador.Control;

public class ventanaTop10 extends JFrame{
	private Control registros;
	
	public ventanaTop10() {
		this.setTitle("Top 10");
		this.setSize(300,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.registros = new Control();


        JPanel panelSuperior = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("# Nombre", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        panelSuperior.add(titulo, BorderLayout.CENTER);
        panelSuperior.setBackground(new Color(64, 157, 196));


        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBackground(new Color(228, 244, 253));
        JTextArea texto = new JTextArea();
        StringBuilder sb = new StringBuilder();
        //ACA PONGO UNA COLECCION AHORITA PARA RECORRELA, LO UNICO ES QUE TENGO QUE PASAR
        //DE OBJETO A STRNG 
        
        for (String elemento : coleccion) {
            sb.append(elemento).append("\n");
        }
        texto.setText(sb.toString());
        panelInferior.add(texto, BorderLayout.CENTER);
        

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelSuperior, BorderLayout.NORTH);
        getContentPane().add(panelInferior, BorderLayout.CENTER);
		
        this.setVisible(true);
        
		
	}
	
	public static void main(String[] args) {
		new ventanaTop10();
	}
}
