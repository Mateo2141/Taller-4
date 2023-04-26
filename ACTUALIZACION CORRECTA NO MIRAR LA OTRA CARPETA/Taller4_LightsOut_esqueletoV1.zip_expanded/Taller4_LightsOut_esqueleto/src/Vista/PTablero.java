package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Control;

public class PTablero extends JPanel{
    private JButton[][] matrizBotones;
    private int tamanio;
    
    public PTablero(int tamanio) {
        this.tamanio = tamanio;
        this.setLayout(new GridLayout(tamanio, tamanio, 5, 5)); 
        crearMatrizBotones();
    }
    
    private void crearMatrizBotones() {
        this.matrizBotones = new JButton[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(80, 80));
                ImageIcon imagen = new ImageIcon("data/luz.png"); 
                boton.setIcon(imagen);
                boton.setOpaque(true);
                boton.setBackground(Color.YELLOW); 
                boton.setBorder(BorderFactory.createCompoundBorder(
                        new EmptyBorder(5, 5, 5, 5), 
                        boton.getBorder())); 
                matrizBotones[i][j] = boton;
                this.add(boton);
            }   
        }
    }
    
    public void setTamanio(int nuevoTamanio) {
        this.tamanio = nuevoTamanio;
        this.removeAll();
        this.setLayout(new GridLayout(nuevoTamanio, nuevoTamanio, 5, 5));
        this.matrizBotones = new JButton[nuevoTamanio][nuevoTamanio];
        crearMatrizBotones();
        this.revalidate();
        this.repaint();
    }
    
    public void cambiarColores(boolean[][] matriz) {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (matriz[i][j]) {
                    matrizBotones[i][j].setBackground(Color.YELLOW);
                } else {
                    matrizBotones[i][j].setBackground(Color.BLACK);
                }
            }
        }
    }

}