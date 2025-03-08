package gameUNO;

import java.util.List;

import javax.swing.JOptionPane;

public class Mesa {

	private List<Jugador> jugadores;
	private Baraja baraja;
	private int turnoActual;
	private boolean sentidoHorario;
	private String colorActual;
	
	public Mesa(List<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.baraja = new Baraja();
		this.turnoActual = 0;
		this.sentidoHorario = true;
		this.colorActual = baraja.obtenerUltimaCartaDescartada().getColor();
	}
	
	// Avanza al siguiente turno
	public void siguienteTurno() {
		if (sentidoHorario) turnoActual = (turnoActual + 1) % jugadores.size();
		else turnoActual = (turnoActual - 1 + jugadores.size()) % jugadores.size();
	}
	
	// Aplica los efectos de las cartas especiales
	public void aplicarEfecto(Carta carta) {
		switch(carta.getTipo()) {
		case TOMA_DOS:
			siguienteTurno();
			jugadores.get(turnoActual).recibirCarta(baraja.robarCarta());
			jugadores.get(turnoActual).recibirCarta(baraja.robarCarta());
			siguienteTurno();
			break;
		case REVERSA:
			sentidoHorario = !sentidoHorario;
			break;
		case SALTO_TURNO:
			siguienteTurno();
			break;
		case COMODIN:
			seleccionarNuevoColor();
			break;
		case COMODIN_TOMA_CUATRO:
			seleccionarNuevoColor();
			for(int i = 0; i < 4; i++) {
				jugadores.get(turnoActual).recibirCarta(baraja.robarCarta());
			}
			break;
		default:
			break;
		}
	}
	
	private void seleccionarNuevoColor() {
        String[] opciones = {"Rojo", "Azul", "Verde", "Amarillo"};
        String nuevoColor = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona un color:",
                "Cambio de Color",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        if (nuevoColor != null) {
            colorActual = nuevoColor;
        }
    }
	
	// Retorna el jugador en su turno
	public Jugador obtenerJugadorActual() {
		return jugadores.get(turnoActual);
	}
	
	// Verifica si el jugador dijo UNO cuando le quedaba una carta
	public boolean verificarUNO(Jugador jugador) {
		if (jugador.getMano().size() == 1 && !jugador.isDijoUNO()) {
			jugador.recibirCarta(baraja.robarCarta());
			jugador.recibirCarta(baraja.robarCarta());
			return false;
		}
		return true;
	}
	
	// Verifica si algun jugador se ha quedado sin cartas por lo que acabará la partida
	public boolean partidaTerminada() {
		for (Jugador jugador : jugadores) {
			if (jugador.getMano().isEmpty()) return true;
		}
		return false;
	}

	// Getters necesarios
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	
	public Carta obtenerUltimaCartaDescartada() {
	    return baraja.obtenerUltimaCartaDescartada();
	}

	public Baraja getBaraja() {
		return baraja;
	}

	
	
}
