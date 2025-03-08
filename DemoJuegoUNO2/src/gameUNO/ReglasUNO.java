package gameUNO;

public class ReglasUNO {
	
	public static boolean esJugadaValida(Carta jugada, Carta cartaSuperior) {
		return jugada.getColor().equals(cartaSuperior.getColor()) || jugada.getTipo() == cartaSuperior.getTipo() || jugada.esComodin();
	}
	
	public static void aplicarReglasEspeciales(Mesa mesa, Carta jugada) {
		mesa.aplicarEfecto(jugada);
	}

}
