package gameUNO;

public class Puntuacion {
	
	public int calcularPuntos(Jugador jugador) {
		int puntos = 0;
		for (Carta carta : jugador.getMano()) {
			puntos += carta.getValor();
		}
		return puntos;
	}

}
