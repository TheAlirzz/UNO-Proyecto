package gameUNO;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazJuego {
    private JFrame ventana;
    private JPanel panelMenu;
    private JPanel panelJuego;
    private Juego juego;
    private JLabel ultimaCarta;
    private JButton btnRobar;
    private JPanel panelCartasJugador;
    private JLabel bot1, bot2, bot3;

    public InterfazJuego() {
        ventana = new JFrame("UNO - Juego de Cartas");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new CardLayout());
        
        inicializarMenu();
        
        ventana.setVisible(true);
    }

    private void inicializarMenu() {
        panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(3, 1));

        JButton btnJugar = new JButton("Jugar");
        JButton btnReglas = new JButton("Reglas");
        JButton btnSalir = new JButton("Salir");
        
        btnJugar.addActionListener(e -> mostrarSeleccionBots());
        btnReglas.addActionListener(e -> mostrarReglas());
        btnSalir.addActionListener(e -> System.exit(0));
        
        panelMenu.add(btnJugar);
        panelMenu.add(btnReglas);
        panelMenu.add(btnSalir);
        
        ventana.add(panelMenu, "Menu");
    }

    private void mostrarReglas() {
        JPanel panelReglas = new JPanel(new BorderLayout());
        JTextArea txtReglas = new JTextArea("Reglas del juego UNO...\n(TEXTO A COMPLETAR)");
        txtReglas.setEditable(false);
        panelReglas.add(new JScrollPane(txtReglas), BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> volverAlMenu());
        panelReglas.add(btnVolver, BorderLayout.SOUTH);
        
        ventana.add(panelReglas, "Reglas");
        ((CardLayout) ventana.getContentPane().getLayout()).show(ventana.getContentPane(), "Reglas");
    }

    private void mostrarSeleccionBots() {
        String[] opciones = {"1", "2", "3"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione la cantidad de bots:", "Seleccionar Bots", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        
        if (seleccion != null) {
            int numBots = Integer.parseInt(seleccion);
            mostrarIngresoNombre(numBots);
        }
    }

    private void mostrarIngresoNombre(int numBots) {
        String nombreJugador = JOptionPane.showInputDialog(null, "Ingrese su nombre:", "Nombre del Jugador", JOptionPane.PLAIN_MESSAGE);
        if (nombreJugador == null || nombreJugador.trim().isEmpty()) {
            nombreJugador = "Jugador";
        }
        iniciarJuego(nombreJugador, numBots);
    }

    private void iniciarJuego(String nombreJugador, int numBots) {
        boolean[] bots = new boolean[numBots + 1];
        for (int i = 1; i <= numBots; i++) {
            bots[i] = true;
        }
        juego = new Juego(numBots + 1, bots, 500);

        panelJuego = new JPanel(new BorderLayout());
        
        // Panel de cartas del jugador
        panelCartasJugador = new JPanel();
        panelCartasJugador.setLayout(new FlowLayout());
        panelJuego.add(panelCartasJugador, BorderLayout.SOUTH);
        
        // Panel de los bots
        bot1 = new JLabel("Bot 1 - Cartas restantes: ");
        bot2 = new JLabel("Bot 2 - Cartas restantes: ");
        bot3 = new JLabel("Bot 3 - Cartas restantes: ");
        
        if (numBots >= 1) panelJuego.add(bot1, BorderLayout.EAST);
        if (numBots >= 2) panelJuego.add(bot2, BorderLayout.NORTH);
        if (numBots == 3) panelJuego.add(bot3, BorderLayout.WEST);
        
        // Panel de la mesa (última carta jugada y mazo de robar)
        JPanel panelMesa = new JPanel();
        ultimaCarta = new JLabel("Última Carta Jugada");
        btnRobar = new JButton("Robar Carta");
        btnRobar.addActionListener(e -> robarCarta());
        
        panelMesa.add(ultimaCarta);
        panelMesa.add(btnRobar);
        panelJuego.add(panelMesa, BorderLayout.CENTER);
        
        ventana.add(panelJuego, "Juego");
        ((CardLayout) ventana.getContentPane().getLayout()).show(ventana.getContentPane(), "Juego");
    }

    private void robarCarta() {
        JOptionPane.showMessageDialog(ventana, "Has robado una carta.", "Robo de Carta", JOptionPane.INFORMATION_MESSAGE);
        // Aquí se debe actualizar la mano del jugador y la carta visible en el centro
    }

    private void volverAlMenu() {
        ((CardLayout) ventana.getContentPane().getLayout()).show(ventana.getContentPane(), "Menu");
    }

    public static void main(String[] args) {
        new InterfazJuego();
    }
}
