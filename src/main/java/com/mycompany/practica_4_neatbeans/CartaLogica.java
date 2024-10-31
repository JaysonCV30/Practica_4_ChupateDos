package com.mycompany.practica_4_neatbeans;

/**
 * Esta clase sirve para modelar una carta de baraja española la cual podra ser
 * vista desde la terminal de java.
 */
public class CartaLogica {

    //Atributos privados de la clase para poder crear la carta
    private String suit; // Palos: "Oros", "Copas", "Espadas", "Bastos"
    private String value; // Valores: "1", "2", "3", ..., "10", "Sota", 
    // "Caballo", "Rey"

    //Constructor de la carta
    public CartaLogica(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    //Getters de la clase
    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    //Setters de la clase
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //Metodo toString sobreescrito
    @Override
    public String toString() {
        return value + " de " + suit;
    }
}