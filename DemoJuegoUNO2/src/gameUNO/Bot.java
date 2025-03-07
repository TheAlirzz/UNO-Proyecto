package gameUNO;

public class Bot extends Jugador{

	public Bot(String nombre) {
		super(nombre);
	}
	
	public void tomarDecision(Baraja baraja) {
		for (int i = 0; i < getMano().size(); i++) {
			if (getMano().get(i).esJugable(baraja.obtenerUltimaCarta())) {
				jugarCarta(i, baraja, null);
				
			}
		}
		
	}

}
