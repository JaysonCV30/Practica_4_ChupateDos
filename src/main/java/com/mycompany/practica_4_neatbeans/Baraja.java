package com.mycompany.practica_4_neatbeans;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Esta clase crea una baraja usando ArrayList de tipo carta para poder crear
 * todas las cartas necesarias que componen una baraja española.
 */
public class Baraja {

    //Atributo ArrayList de tipo CartaLogica el cual almacenara todas las cartas
    private ArrayList<CartaLogica> baraja;

    public Baraja() {
        baraja = new ArrayList<>(); //Se instancia el objeto ArrayList

        //Se crean dos vectores, uno de palos y otro de valores
        String[] suits = {"Oros", "Copas", "Espadas", "Bastos"};
        String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Sota", "Caballo", "Rey"};

        //Se llena el ArrayList usando los vectores anteriormente creados
        for (String suit : suits) {
            for (String value : values) {
                baraja.add(new CartaLogica(suit, value));
            }
        }
    }

    //Metodo para mezclar las cartas
    public void mezclar() {
        Collections.shuffle(baraja);
    }

    // Metodo de acceso al tamaño de la baraja (Numero de cartas restantes)
    public int getSize() {
        return baraja.size();
    }

    //Metodo para poder disponer del ArrayList
    public ArrayList<CartaLogica> getBaraja() {
        return baraja;
    }

    // Imprimir las cartas en la baraja usando lambda
    public void imprimirCartas() {
        getBaraja().forEach(CartaLogica -> System.out.println(CartaLogica));
    }

    //Metodo para poder dar una carta
    public CartaLogica darCarta() {
        if (!baraja.isEmpty()) {
            return baraja.remove(0);
        } else {
            System.out.println("La baraja está vacía, no se puede enviar más cartas.");
            return null;
        }
    }

    // Metodo de acceso a una unica carta de la baraja
    public CartaLogica getCarta(int i) {
        if (i >= 0 && i < baraja.size()) {
            return baraja.get(i);
        } else {
            System.out.println("Índice fuera de rango.");
            //System.out.println("La baraja está vacia");
            return null;
        }
    }

    // Metodo para agregar cartas a la baraja
    public void agregarCartaABaraja(CartaLogica carta) {
        baraja.add(carta);
    }
}