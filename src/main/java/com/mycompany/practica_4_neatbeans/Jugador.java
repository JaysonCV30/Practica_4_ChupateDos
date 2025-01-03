package com.mycompany.practica_4_neatbeans;

import java.util.ArrayList;

/**
 * Esta clase modela al jugador, el cual podra recibir cartas de la baraja y
 * jugar cartas en la mesa de juego
 */
public class Jugador {

    private String nombre;
    private ArrayList<CartaLogica> mano;
    private ArrayList<VistaCarta> manoGrafica;

    //Constructor de la clase
    public Jugador(String nombre) {
        this.nombre = nombre; //Se le asigna un nombre al jugador
        this.mano = new ArrayList<>();  //Se crea la mano del jugador
        this.manoGrafica = new ArrayList<>();
    }

    //Metodo para tomar una carta de la baraja
    public void agregarCartaAMano(CartaLogica carta) {
        mano.add(carta);
    }

    public void agregarCartaGraficaAMano(VistaCarta cartaGrafica) {
        manoGrafica.add(cartaGrafica);
    }

    // Metodo para saber si la mano esta vacia
    public boolean estaVaciaMano() {
        return mano.isEmpty();
    }

    //Metodo para colocar una carta escogida por el jugador
    /*public CartaLogica colocarCarta(int indice) {
        if (!estaVaciaMano()) {
            return mano.remove(indice);
        } else {
            return null; // Mano esta vacia
        }
    }*/

    //Metodo para colocar una carta escogida por el jugador
    public void colocarCarta(CartaLogica cartaEscogida) {
        for (int i = 0; i < mano.size(); i++) {
            CartaLogica carta = mano.get(i);
            if (cartaEscogida.getValue() == carta.getValue() && cartaEscogida.getSuit() == carta.getSuit()) {
                mano.remove(i);
            }
        }
    }

    // Metodo para acceder a una carta cualquiera que se tenga en mano
    public CartaLogica getCarta(int indice) {
        if (!estaVaciaMano() && indice < mano.size()) {
            return mano.get(indice);
        } else {
            return null; // Mano esta vacia
        }
    }

    public VistaCarta getCartaGrafica(int indice) {
        if (!estaVaciaMano() && indice < manoGrafica.size()) {
            return manoGrafica.get(indice);
        } else {
            return null; // Mano esta vacia
        }
    }

    //Getters de la clase
    public String getNombre() {
        return nombre;
    }

    public ArrayList<CartaLogica> getMano() {
        return mano;
    }

    //Setters de la clase
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMano(ArrayList<CartaLogica> mano) {
        this.mano = mano;
    }

    //Metodo que muestra toda la mano del jugador
    public void imprimirMano() {
        int contador = 0;
        for (CartaLogica carta : mano) {
            System.out.println("(" + (contador + 1) + ")" + ".- " + carta);
            contador++;
        }
    }

    // Metodod para comparar la carta de la mesa con las cartas que se tienen en mano
    public boolean verificarMano(CartaLogica cartaEnMesa) {
        for (int i = 0; i < mano.size(); i++) {
            if (verificarCarta(mano.get(i), cartaEnMesa) == true || mano.get(i).getValue() == "Rey") {
                return true;
            }
        }
        return false;
    }

    // Metodo para comparar la carta que se tiene en mano con la carta que esta en la mesa
    public boolean verificarCarta(CartaLogica carta1, CartaLogica carta2) {
        if (carta1.getValue() == carta2.getValue() || carta1.getSuit() == carta2.getSuit()) {
            return true;
        }
        return false;
    }

    // Metodo de acceso al tamaño de mano del jugador
    public int getManoSize() {
        return mano.size();
    }

    // Metodo de acceso a la ultima carta de mano
    public CartaLogica getUltimaCartaDeMano() {
        return mano.get(mano.size() - 1);
    }

    // Metodo para colocar la ultima carta de la mano
    public CartaLogica colocarUltimaCartaDeMano() {
        return mano.remove(mano.size() - 1);
    }

    // Metodo toString sobreescrito para el nombre del jugador
    @Override
    public String toString() {
        return nombre;
    }
}
