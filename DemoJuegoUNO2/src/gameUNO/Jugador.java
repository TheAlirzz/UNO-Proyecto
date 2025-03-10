package gameUNO;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private String nombre;
	private List<Carta> mano;
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
	public boolean jugarCarta(int indice, Baraja baraja) {
        if (indice >= 0 && indice < mano.size()) {
            Carta carta = mano.get(indice);
            if (carta.esJugable(baraja.obtenerUltimaCartaDescartada())) {
                mano.remove(indice);
                baraja.agregarDescarte(carta);
                return true;
            }
        }
        return false;
    }
	
	// Se llama este método cuando le jugador dice uno y la variable dijoUNO se pone en true
	public void decirUno() {
		dijoUNO = true;
	}
	
	// Devuelve true si al jugador aun le quedan cartas en su mano y devulve false si al jugador ya no le quedan cartas en su mano
	public boolean tieneCartas() {
		return !mano.isEmpty();
	}
	
	// Devuelve los puntos de una mano
	public void sumarPuntos(int puntosGanados) {
		this.puntos += puntosGanados;
	}
	
	// Metodos getters para nombre, mano y puntos
	public String getNombre() {
		return nombre;
	}

	public List<Carta> getMano() {
		return mano;
	}

	public int getPuntos() {
		return puntos;
	}

	public boolean isDijoUNO() {
		return dijoUNO;
	}

}
