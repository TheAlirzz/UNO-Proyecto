package gameUNO;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
	
	private ArrayList<Carta> mazoRobar;
	private ArrayList<Carta> mazoDescartar;
	
	public Baraja() {
		this.mazoRobar = new ArrayList<Carta>();
		this.mazoDescartar = new ArrayList<Carta>();
		inicializarBaraja();
		barajar();
	}
	
	// Crea el la baraja de juego con todas sus cartas
	private void inicializarBaraja() {
		String[] colores = {
			"Azul", "Verde", "Amarillo", "Rojo"	
		};
		for (String color : colores) {
			mazoRobar.add(new Carta(color, TipoCarta.NUMERICA, 0));
			for (int i = 1; i <= 9; i++) {
				mazoRobar.add(new Carta(color, TipoCarta.NUMERICA, i));
				mazoRobar.add(new Carta(color, TipoCarta.NUMERICA, i));
			}
			mazoRobar.add(new Carta(color, TipoCarta.SALTO_TURNO, 20));
			mazoRobar.add(new Carta(color, TipoCarta.SALTO_TURNO, 20));
			mazoRobar.add(new Carta(color, TipoCarta.REVERSA, 20));
			mazoRobar.add(new Carta(color, TipoCarta.REVERSA, 20));
			mazoRobar.add(new Carta(color, TipoCarta.TOMA_DOS, 20));
			mazoRobar.add(new Carta(color, TipoCarta.TOMA_DOS, 20));
		}
		for (int i = 0; i < 4; i++) {
			mazoRobar.add(new Carta("Negro", TipoCarta.COMODIN, 50));
			mazoRobar.add(new Carta("Negro", TipoCarta.COMODIN_TOMA_CUATRO, 50));
		}
	}
	
	// Baraja el mazo de cartas
	public void barajar() {
		Collections.shuffle(mazoRobar);
	}
	
	// Devueve la primera carta de mazoRobar si hay cartas dentro sino devuelve null
	public Carta robarCarta() {
		if (mazoRobar.isEmpty()) reconstruirMazoRobar();
		return mazoRobar.isEmpty() ? null : mazoRobar.remove(0) ;
	}
	
	// Añade una carta al mazoDescartar
	public void agregarDescarte(Carta carta) {
		mazoDescartar.add(carta);
	}
	
	// Reconstruye el mazoRobar cuando se acaban las cartas de robar
	public void reconstruirMazoRobar() {
		if(mazoDescartar.size() > 1) {
			Carta ultimaCarta = mazoDescartar.remove(mazoDescartar.size() - 1);
			mazoRobar.addAll(mazoDescartar);
			mazoDescartar.clear();
			mazoDescartar.add(ultimaCarta);
			barajar();
		}
	}
	
	// Obtiene la ultima carta jugada en el mazo de descartes
	public Carta obtenerUltimaCartaDescartada() {
		return mazoDescartar.isEmpty() ? null : mazoDescartar.get(mazoDescartar.size() - 1);
	}
	
}
