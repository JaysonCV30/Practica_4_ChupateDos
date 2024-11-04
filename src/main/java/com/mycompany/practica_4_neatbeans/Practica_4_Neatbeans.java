package com.mycompany.practica_4_neatbeans;

import javax.swing.JFrame;

public class Practica_4_Neatbeans {
    
    public static void main(String[] args) {
        SeleccionJugadoresDialog dialog = new SeleccionJugadoresDialog(new JFrame());
        dialog.setVisible(true);
        
        int cantidadJugadores = dialog.getCantidadJugadores();
        System.out.println(cantidadJugadores);
        ChupateDos juego = new ChupateDos(cantidadJugadores);
    }
}