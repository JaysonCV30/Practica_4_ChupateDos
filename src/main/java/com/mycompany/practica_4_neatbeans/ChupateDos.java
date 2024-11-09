package com.mycompany.practica_4_neatbeans;

import java.util.*;

/**
 * Esta es la clase principal, en la cual se comienza el juego y se determina la
 * cantidad de jugadores, los puntos y se involucran todas las clases creadas
 * anteriormente
 */
public class ChupateDos {

    private ArrayList<Jugador> jugadores;
    private Baraja baraja;
    private MesaDeJuego mesa;
    private boolean invertido;
    
    //atributos para lo grafico
    //private VistaBaraja barajaGrafica;
    private Mesa mesaGrafica;

    public ChupateDos(int cantidadJugadores) {
        jugadores = new ArrayList();
        int cartasARepartir = 5;
        
        if (cantidadJugadores < 2 || cantidadJugadores > 4) {
            System.out.println("La cantidad de jugadores que ingresó es incorrecta");
            return;
        }
            
        if (cantidadJugadores != 2 && cantidadJugadores != 3
                && cantidadJugadores != 4) {
            System.out.println("La cantidad de jugadores que ingresÃ³ es incorrecta");
        } else {
            // CreaciÃ³n de jugadores
            for (int i = 0; i < cantidadJugadores; i++) {
                jugadores.add(new Jugador("Jugador " + (i + 1)));
            }

            baraja = new Baraja();
            mesa = new MesaDeJuego();
            baraja.mezclar();
            invertido = false;
            
            //barajaGrafica = new VistaBaraja();
            mesaGrafica = new Mesa();
        }

        // Imprimiendo la baraja completa
        System.out.println("Baraja en mesa: ");
        baraja.imprimirCartas();
        System.out.println(baraja.getSize());
        
        // Repartiendo las cartasGraficas a los jugadores
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = 0; j < cartasARepartir; j++) {
                CartaLogica carta = baraja.darCarta();
                jugadores.get(i).agregarCartaAMano(carta); 
                VistaCarta cartaGrafica = new VistaCarta(carta,mesaGrafica);
                jugadores.get(i).agregarCartaGraficaAMano(cartaGrafica); 
            }
        }
        
        System.out.println("Baraja ya repartida");
        System.out.println(baraja.getSize());

        // Mostrando la mano de los jugadores
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("Jugador " + (i + 1) + ":");
            jugadores.get(i).imprimirMano();
        }
        
        // Mostrar la mesa
        mesaGrafica.mostrarCartasJugadores(jugadores);
        mesaGrafica.setVisible(true);

        iniciarJuego();
    }

    public void iniciarJuego() {
            boolean hayGanador=false;
            Scanner sc = new Scanner(System.in);
            int cartaEscogida;
            boolean primeraCarta=false;
            
        while(hayGanador==false){
           for (int i = 0; i < jugadores.size(); i++) {
               //mesaGrafica.actualizarTurno(i); // Pasar al siguiente jugador visualmente
               
               if(primeraCarta==true){
                   System.out.println("Carta en mesa: ");
                   System.out.println(mesa.getUltimaCarta());
                   //System.out.println(mesaGrafica.getUltimaCarta());
                   sc = new Scanner(System.in);
                   System.out.println(jugadores.get(i).getNombre()+ " escoga una carta para colocar ");
                   jugadores.get(i).imprimirMano();
                   cartaEscogida = sc.nextInt();  //Aqui seria el cambio, en vez de que reciba un int en consola, que reciba una carta logica
                   i=verificarCartaJugada(i,cartaEscogida);
                   hayGanador=determinarGanador();
                    if(hayGanador){  
                       mesaGrafica.mostrarGanador(i);
                       break;
                    }
                }
                else{
                   System.out.println("Jugador 1 esocga una carta para colocar");
                   jugadores.get(0).imprimirMano();
                   cartaEscogida = sc.nextInt();  
                   if(jugadores.get(0).getCarta(cartaEscogida-1).getValue() == "2"){
                       mesa.agregarCartaAMesa(jugadores.get(0).colocarCarta(cartaEscogida-1));
                       jugadores.get(1).agregarCartaAMano(baraja.darCarta());
                       jugadores.get(1).agregarCartaAMano(baraja.darCarta());
                       System.out.println(jugadores.get(1).getNombre()+ " comió " + 2 + " cartas");
                       primeraCarta=true;
                   }
                   if(jugadores.get(0).getCarta(cartaEscogida-1).getValue() == "3"){
                       mesa.agregarCartaAMesa(jugadores.get(0).colocarCarta(cartaEscogida-1));
                       for(int j=0;j<4;j++){
                         jugadores.get(1).agregarCartaAMano(baraja.darCarta());
                       }
                       System.out.println(jugadores.get(1).getNombre()+ " comió " + 4 + " cartas");
                       primeraCarta=true;
                    }
                   if(jugadores.get(0).getCarta(cartaEscogida-1).getValue() == "Sota"){
                            System.out.println("Se cambió la dirección de la partida");
                            mesa.agregarCartaAMesa(jugadores.get(0).colocarCarta(cartaEscogida-1));
                            Collections.reverse(jugadores);
                            if(i==0){
                            i=jugadores.size();
                            }
                            if(i==jugadores.size()-1){
                                i=i-1;
                            }
                            primeraCarta=true;
                    }
                    if(jugadores.get(0).getCarta(cartaEscogida-1).getValue() == "As"){
                        mesa.agregarCartaAMesa(jugadores.get(0).colocarCarta(cartaEscogida-1));
                        System.out.println("Jugador " +1+ " tira otra vez ");
                        jugarUnaVuelta(0);
                        primeraCarta=true;
                    }
                    if(primeraCarta==false){
                        mesa.agregarCartaAMesa(jugadores.get(0).colocarCarta(cartaEscogida-1));
                        primeraCarta=true;
                    }
                }
                // Actualizar la interfaz gráfica después de la jugada
                mesaGrafica.mostrarCartasJugadores(jugadores);
            }
        }        
    }

    public boolean verificarCarta(CartaLogica carta1, CartaLogica carta2) {
        if (carta1.getValue() == carta2.getValue() || carta1.getSuit() == carta2.getSuit()) {
            return true;
        }
        return false;
    }

    public void jugarUnaVuelta(int indice) {
        for (int i = indice; i < (indice + 1); i++) {
            System.out.println("Carta en mesa: ");
            System.out.println(mesa.getUltimaCarta());
            Scanner sc = new Scanner(System.in);
            System.out.println(jugadores.get(i).getNombre()+ " escoga una carta para colocar ");
            jugadores.get(i).imprimirMano();
            int cartaEscogida = sc.nextInt();
            verificarCartaJugada(i,cartaEscogida);
            boolean hayGanador=determinarGanador();
            if(hayGanador){
                hayGanador=true;
                break;
            }
        }
    }

    public void invertirJugadores() {
        ArrayList<Jugador> nombresInvertidos = new ArrayList<>();
        for (int i = jugadores.size() - 1; i >= 0; i--) {
            nombresInvertidos.add(jugadores.get(i));
        }
        jugadores = nombresInvertidos;
    }

    public boolean banderaParaManosDeJugadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).estaVaciaMano() == true) {
                return true;
            }
        }
        return false;
    }

    public boolean determinarGanador() {
        boolean hayGanador=false;
        Jugador ganador = jugadores.get(0);
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).estaVaciaMano() == true) {
                ganador = jugadores.get(i);
                System.out.println("El ganador de la ronda fue el " + ganador);
                hayGanador=true;
            }
        }
        return hayGanador;
    }

    public void llenarBaraja() {
        for (int i = 0; i < mesa.getMesa().size() - 2; i++) {
            baraja.agregarCartaABaraja(mesa.colocarCarta());
        }
        baraja.mezclar();
        System.out.println("Las cartas se acabaron, mezclando baraja... ");
        System.out.println("Ya se mezclÃ³ ");
    }
    
    public int corregirCartaErronea(int i){
        System.out.println("Esa carta no se puede poner ");
        boolean continuarJuego = false;
        do {
            System.out.println("Carta en mesa: ");
            System.out.println(mesa.getUltimaCarta());
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Jugador " + (i + 1) + " escoga una carta para colocar ");
            jugadores.get(i).imprimirMano();
            int cartaEscogida2 = sc2.nextInt();
            if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida2-1), mesa.getUltimaCarta()) == true
                && jugadores.get(i).getCarta(cartaEscogida2-1).getValue() == "2") {
                mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida2-1));

                if (i == jugadores.size() - 1) {
                int contador = 0;
                do {
                    jugadores.get(0).agregarCartaAMano(baraja.darCarta());
                    contador++;
                    if (baraja.getBaraja().isEmpty()) {
                        llenarBaraja();
                    }
                } while (contador < 2);

                 System.out.println(jugadores.get(0).getNombre()+" comió " + contador + " cartas");
                } else {
                    int contador = 0;
                    do {
                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                        contador++;
                        if (baraja.getBaraja().isEmpty()) {
                        llenarBaraja();
                        }
                    } while (contador < 2);

                    System.out.println(jugadores.get(i+1).getNombre()+ " comió " + contador + " cartas");
                }

                System.out.println("Se puso un 2");
                continuarJuego = true;
                } else {
                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida2-1), mesa.getUltimaCarta()) == true
                        && jugadores.get(i).getCarta(cartaEscogida2-1).getValue() == "3") {
                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida2-1));

                        if (i == jugadores.size() - 1) {
                            int contador = 0;
                            do {
                                jugadores.get(0).agregarCartaAMano(baraja.darCarta());
                                contador++;
                                if (baraja.getBaraja().isEmpty()) {
                                    llenarBaraja();
                                }
                            } while (contador < 4);

                            System.out.println(jugadores.get(0).getNombre()+" comió " + contador + " cartas");
                        } else {
                            int contador = 0;
                            do {
                                jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                                contador++;
                                if (baraja.getBaraja().isEmpty()) {
                                    llenarBaraja();
                                }
                            } while (contador < 4);

                            System.out.println(jugadores.get(i+1).getNombre()+ " comió³ " + contador + " cartas");
                        }

                        System.out.println("Se puso un 3");
                        continuarJuego = true;
                    } else {
                        if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida2-1), mesa.getUltimaCarta()) == true
                            && jugadores.get(i).getCarta(cartaEscogida2-1).getValue() == "Sota") {
                            mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida2-1));
                            System.out.println("Se cambió la dirección de la partida");
                            Collections.reverse(jugadores);
                            if(i==0){
                            i=jugadores.size();
                            }
                            if(i==jugadores.size()-1){
                                i=i-1;
                            }
                            continuarJuego = true;
                         } else {
                             if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida2-1), mesa.getUltimaCarta()) == true
                                && jugadores.get(i).getCarta(cartaEscogida2-1).getValue() == "As") {
                                mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida2-1));
                                System.out.println("Jugador " + (i + 1) + " tira otra vez ");
                                jugarUnaVuelta(i);
                                continuarJuego = true;
                            } else {
                                if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida2-1), mesa.getUltimaCarta()) == true
                                    || jugadores.get(i).getCarta(cartaEscogida2-1).getValue() == "Rey") {
                                    mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida2-1));
                                    continuarJuego = true;
                                }
                            }
                        }
                    }
                }
            } while (!continuarJuego);
        return i;
    }
    
    public int verificarCartaJugada(int i,int cartaEscogida){
        if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                    && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "2") {
                mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));

                if (i == jugadores.size() - 1) {
                    int contador = 0;
                    do {
                        jugadores.get(0).agregarCartaAMano(baraja.darCarta());
                        contador++;
                        if (baraja.getBaraja().isEmpty()) {
                            llenarBaraja();
                        }
                    } while (contador < 2);

                    System.out.println(jugadores.get(0).getNombre()+"comió³ " + contador + " cartas");
                } else {
                    int contador = 0;
                    do {
                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                        contador++;
                        if (baraja.getBaraja().isEmpty()) {
                            llenarBaraja();
                        }
                    } while (contador < 2);

                    System.out.println(jugadores.get(i+1).getNombre()+ " comió³ " + contador + " cartas");
                }

                System.out.println("Se puso un 2");

            } else {
                if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                        && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "3") {
                    mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));

                    if (i == jugadores.size() - 1) {
                        int contador = 0;
                        do {
                            jugadores.get(0).agregarCartaAMano(baraja.darCarta());
                            contador++;
                            if (baraja.getBaraja().isEmpty()) {
                                llenarBaraja();
                            }
                        } while (contador < 4);

                        System.out.println(jugadores.get(0).getNombre()+" comió " + contador + " cartas");
                    } else {
                        int contador = 0;
                        do {
                            jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                            contador++;
                            if (baraja.getBaraja().isEmpty()) {
                                llenarBaraja();
                            }
                        } while (contador < 4);

                        System.out.println(jugadores.get(i+1).getNombre()+ " comió " + contador + " cartas");
                    }

                    System.out.println("Se puso un 3");
                } else {
                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                            && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Sota") {
                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                        System.out.println("Se cambió la dirección de la partida");
                        Collections.reverse(jugadores);
                        if(i==0){
                            i=jugadores.size();
                            }
                            if(i==jugadores.size()-1){
                                i=i-1;
                            }

                    } else {
                        if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "As") {
                            mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                            System.out.println("Jugador " + (i + 1) + " tira otra vez ");
                            jugarUnaVuelta(i);
                        } else {
                            if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                    || jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Rey") {
                                mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                            } else {
                                if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == false
                                        && jugadores.get(i).verificarMano(mesa.getUltimaCarta()) == true) {
                                    i=corregirCartaErronea(i);

                                    System.out.println("Carta en mesa: ");
                                    System.out.println(mesa.getUltimaCarta());

                                } else {
                                    if (cartaEscogida-1 < 0 || cartaEscogida-1 > jugadores.get(i).getManoSize()) {
                                            System.out.println("Ingresó un número invalido ");
                                            boolean continuarJuego = false;
                                            do {
                                                jugarUnaVuelta(i);
                                            } while (cartaEscogida-1 < 0 || cartaEscogida-1 > jugadores.get(i).getManoSize());
                                            
                                            System.out.println("Carta en mesa: ");
                                            System.out.println(mesa.getUltimaCarta());
                                        }else{
                                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == false
                                            && jugadores.get(i).verificarMano(mesa.getUltimaCarta()) == false) {
                                        int contador = 0;
                                        do {
                                            jugadores.get(i).agregarCartaAMano(baraja.darCarta());
                                            contador++;
                                            if (baraja.getBaraja().isEmpty()) {
                                                llenarBaraja();
                                            }
                                        } while (contador<2);

                                        System.out.println("CHUPATE DOS, Jugador " + (i + 1) + " comió " + contador + " cartas");
                                        
                                    }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        return i;
    }
}