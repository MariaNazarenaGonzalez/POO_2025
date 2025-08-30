package ar.edu.unlu.ng190217.tp1.punto11;

import java.util.ArrayList;

public class ScrabbleAcotado {
    private ArrayList<Jugador> jugadores;
    private ArrayList<String> diccionario;

    //METODOS PRIVADOS

    private boolean esLetraEspecial (char letra) {

        boolean esEspecial = false;

        if ( (letra  == 'k') |
                (letra  == 'z') |
                (letra  == 'x') |
                (letra  == 'y') |
                (letra  == 'w') |
                (letra  == 'q')   ) {

            esEspecial = true;

        }

        return esEspecial;

    }

    private int calcularPuntaje (String palabra) {

        int puntajePalabra = 0;

        puntajePalabra += palabra.length();

        char letra = ' ';

        for (int i = 0; i < palabra.length(); i++) {

            letra = palabra.charAt(i);

            if (esLetraEspecial(letra)) {

                puntajePalabra++;

            }

        }

        return puntajePalabra;
    }

    //CONSTRUCTORES
    public ScrabbleAcotado () {

        jugadores = new ArrayList<Jugador>();
        diccionario = new ArrayList<String>();

    }

    //***SETTERS Y GETTERS***

    public String getPalabraN (int n) {
        String palabra = null;
        if ((n < 1) | (n > diccionario.size())) {System.out.println("Posición no válida.");
        } else {palabra = diccionario.get(n-1);}
        return palabra;
    }

    public int getPuntajeJugadorN (int n) {
        int puntaje = -1;
        if ((n < 1) | (n > jugadores.size())) {System.out.println("Jugador no válido.");
        } else {puntaje = jugadores.get(n-1).getPuntaje();}
        return puntaje;
    }

    public String getJugadorMayorPuntaje () {
        String nickMayorPuntaje = "";
        int mayorPuntaje = -1;
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() > mayorPuntaje) {nickMayorPuntaje = jugador.getNick();}
        }
        return nickMayorPuntaje;
    }

    //***METODOS PUBLICOS***

    public void aniadirJugador (Jugador jugador) {jugadores.add(jugador);}

    public void aniadirPalabraDiccionario (String palabra) {diccionario.add(palabra);}

    public void aniadirPalabraJugadorN (String palabra, int n) {
        if ((n < 1) | (n > jugadores.size())) {System.out.println("Jugador no válido.");
        } else {
            if (diccionario.contains(palabra)) {
                jugadores.get(n-1).formarPalabra(palabra, calcularPuntaje(palabra));
            } else {System.out.println("Palabra no válida.");}
        }
    }

    public String toString () {
        String juego = "Scrabble";
        juego = juego.concat("\nPalabras válidas: ");
        for (String palabra: diccionario) {juego = juego.concat(palabra + " ");}
        juego = juego.concat("\nJugadores:");
        for (Jugador jugador: jugadores) {juego = juego.concat("\n"+jugador.getNick()+" Puntaje:"+jugador.getPuntaje());}
        return juego;
    }

}
