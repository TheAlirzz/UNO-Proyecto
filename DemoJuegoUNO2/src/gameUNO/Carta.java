package gameUNO;

public class Carta {
	
	private String color;
	private TipoCarta tipo;
	private int valor;
	
	// Constructor de Carta
	public Carta(String color, TipoCarta tipo, int valor) {
		this.color = color;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	// Devuelve true si la carta se puede jugar
	boolean esJugable(Carta otra) {
		return this.color.equals(otra.color) || this.tipo == otra.tipo || this.tipo == TipoCarta.COMODIN || this.tipo == TipoCarta.COMODIN_TOMA_CUATRO;
	}
	
	// Devuelve true si es la carta es un comodin
	boolean esComodin() {
		return this.tipo == tipo.COMODIN || this.tipo == tipo.COMODIN_TOMA_CUATRO;
	}

	// Metodo que devuelve informacion de una carta
	@Override
	public String toString() {
		return "Carta " + color + ", " + tipo + ", " + valor;
	}
	
	// Metodos getters
	public String getColor() {
		return color;
	}
	public TipoCarta getTipo() {
		return tipo;
	}
	public int valor() {
		return valor;
	}
	
}
