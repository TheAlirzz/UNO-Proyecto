package gameUNO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Juego {
	
	private Mesa mesa;
	private boolean juegoActivo;
	private int puntajeMaximo;
	
	public Juego(int numJugadores, boolean[] bots, int puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
		this.juegoActivo = true;
		List<Jugador> jugadores = new ArrayList<Jugador>();
		
		for (int i = 0; i < numJugadores; i++) {
				if(bots[i]) jugadores.add(new Bot("Chinchon " + (i + 1)));
				else {
					String nombreJugador;
					nombreJugador = JOptionPane.showInputDialog(null, "Ingrese su nombre de jugador:", "Nombre de jugador:", JOptionPane.PLAIN_MESSAGE);
					if (nombreJugador == null || nombreJugador.trim().isEmpty()) nombreJugador = "Jugador";
					jugadores.add(new Jugador(nombreJugador));
				}
		}
		this.mesa = new Mesa(jugadores);
	}
	
	public void iniciarJuego() {
		while(juegoActivo) {
			jugarRonda();
			if(alguienAlcanzoPuntajeMaximo()) juegoActivo = false;
		}
		JOptionPane.showMessageDialog(null, "Juego terminado!!!", "Fin del juego!!!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void jugarRonda() {
		while(!mesa.partidaTerminada()) {
			Jugador jugadorActual = mesa.obtenerJugadorActual();
			System.out.println("Turno de " + jugadorActual.getNombre());
			mesa.siguienteTurno();
		}
		JOptionPane.showMessageDialog(null, "Ronda finalizada!!!", "Fin de ronda!!!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public boolean alguienAlcanzoPuntajeMaximo() {
		for(Jugador jugador : mesa.getJugadores()) {
			if (jugador.getPuntos() >= puntajeMaximo) {
				JOptionPane.showMessageDialog(null, jugador.getNombre() + " ha alcanzado los 500 puntos!!!", "Ganador", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
		}
		return false;
	}
	
	

}
