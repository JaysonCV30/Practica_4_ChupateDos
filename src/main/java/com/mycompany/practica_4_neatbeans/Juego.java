package com.mycompany.practica_4_neatbeans;

import java.util.Scanner;

public class Juego {

    private ChupateDos juego;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("############# Chupate dos card play ############");
        System.out.println("Ingrese la cantidad de jugadores que van a jugar");
        System.out.println("~~~~~~~~~~~~~(Minimo 2 - Maximo 4)~~~~~~~~~~~~~~");
        int cantidadJugadores = sc.nextInt();
        if (cantidadJugadores < 2 || cantidadJugadores > 4) {
            System.out.println("No se puede jugar con " + cantidadJugadores + " jugadores.");
            System.out.println("Saliendo...");
            sc.close();
            return;
        }
        ChupateDos juego = new ChupateDos(cantidadJugadores);
        
        /*// Inicia la ventana gráfica
        Juego_ChupateDos ventana = new Juego_ChupateDos();
        ventana.setVisible(true);*/
    }
}