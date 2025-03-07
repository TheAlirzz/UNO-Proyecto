package gameUNO;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private ArrayList<Carta> mano;
	private int puntos;
	private boolean dijoUNO;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		mano = new ArrayList<Carta>();
		this.puntos = 0;
		this.dijoUNO = false;
	}
	
	// La mazo mano del jugador recibe una carta de mazoRobar
	public void recibirCarta(Carta carta) {
		mano.add(carta);
	}
	
	// Cuando el jugador intente jugar una carta si es válida devolverá true, si no lo es devolverá false
	public boolean jugarCarta(int indice, Baraja baraja, Mesa mesa) {
		if (indice >= 0 && indice < mano.size()) {
			Carta cartaJugada = mano.remove(indice);
			baraja.agregarDescarte(cartaJugada);
			return true;
		}
		return false;
	}
	
	// Se llama este método cuando le jugador dice uno y la variable dijoUNO se pone en true
	public void decirUno() {
		dijoUNO = true;
	}
	
	// Devuelve true si el jugador jugó todas sus cartas y devuelve false si el jugador aún tiene cartas
	public boolean tieneCartas() {
		return mano.isEmpty();
	}
	
	public int calcularPuntosMano() {
		
	}

}
