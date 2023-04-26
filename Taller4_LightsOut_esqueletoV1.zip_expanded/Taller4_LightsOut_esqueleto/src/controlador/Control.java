package controlador;
import java.util.Collection;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class Control {
	private Tablero modelo;
	private RegistroTop10 formaRegistros;
	private Top10 registros;
	private Top10 textoRegistros;
	

	public Control() {
		this.modelo = new Tablero(5);
		this.registros = new Top10();
	}
	/*
	 * manipula el modelo 
	 */	
	public void darTamaño (int tamaño) {
		this.modelo = new Tablero(tamaño);
		salvarTablero();
		
	}
	
	public void nivel (int dificultad) {
		modelo.desordenar(dificultad);
	}
	
	public void reiniciar () {
		modelo.reiniciar();
	}

	
	public void registrarJugador(String nombre) {
		registros.agregarRegistro(nombre,verPuntos());
	}
	
	public void empezaTop10() {
		this.textoRegistros = new Top10();
	}
	
	
	
	/*
	 * Actualiza la vista
	 */
	
	public int verJugadas() {
		int resultado = modelo.darJugadas();
		return resultado;
	}
	
	public int verPuntos() {
		int resultado = modelo.calcularPuntaje();
		return resultado;
	}
	
	public boolean[][] darTablero() {
		boolean[][] resultado = modelo.darTablero();
		return resultado;
	}
	
	public void salvarTablero() {
		modelo.salvar_tablero();
	}

	
	
	
	
	
	
}