package gameUNO;

public class Bot extends Jugador{

	public Bot(String nombre) {
		super(nombre);
	}
	
	// Permite jugar o robar una carta automáticamente dependiendo de si su carta es jugable o no
	public void tomarDecision(Baraja baraja) {
		for (int i = 0; i < getMano().size(); i++) {
			if (getMano().get(i).esJugable(baraja.obtenerUltimaCartaDescartada())) {
				jugarCarta(i, baraja);
			}
		}
		recibirCarta(baraja.robarCarta());
	}

}
