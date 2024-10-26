package com.mycompany.practica_4_neatbeans;

import java.util.*;

/**
 *
 * @authors Andres Le Gresley - Paul Chavez
 *
 * Esta es la clase principal, en la cual se comienza el juego y se determina la
 * cantidad de jugadores, los puntos y se involucran todas las clases creadas
 * anteriormente
 *
 * Version (1.0)
 *
 *
 */
public class ChupateDos {

    private ArrayList<Jugador> jugadores;
    private Baraja baraja;
    private MesaDeJuego mesa;
    private boolean invertido;

    public ChupateDos(int cantidadJugadores) {
        jugadores = new ArrayList();
        int cartasARepartir = 0;
        if (cantidadJugadores == 2) {
            cartasARepartir = 8;
        } else {
            if (cantidadJugadores == 3) {
                cartasARepartir = 7;
            } else {
                if (cantidadJugadores == 4) {
                    cartasARepartir = 6;
                }
            }
        }
        if (cantidadJugadores != 2 && cantidadJugadores != 3
                && cantidadJugadores != 4) {
            System.out.println("La cantidad de jugadores que ingresó es incorrecta");
        } else {
            // Creación de jugadores
            for (int i = 0; i < cantidadJugadores; i++) {
                jugadores.add(new Jugador("Jugador " + (i + 1)));
            }

            baraja = new Baraja();
            mesa = new MesaDeJuego();
            baraja.mezclar();
            invertido = false;

        }

        // Imprimiendo la baraja completa
        System.out.println("Baraja en mesa: ");
        baraja.imprimirCartas();

        // Repartiendo las cartas a los jugadores
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = 0; j < cartasARepartir; j++) {
                jugadores.get(i).agregarCartaAMano(baraja.darCarta());
            }
        }

        // Mostrando la mano de los jugadores
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("Jugador " + (i + 1) + ":");
            jugadores.get(i).imprimirMano();
        }

        iniciarJuego();
    }

    public void iniciarJuego() {
        // El primer jugador coloca la primer carta
        mesa.agregarCartaAMesa(jugadores.get(0).colocarCarta(0));
        System.out.println("Jugador 1 coloca carta ");
        System.out.println("Carta en mesa: ");
        System.out.println(mesa.getUltimaCarta());

        for (int i = 1; i < jugadores.size(); i++) {
            System.out.println("Carta en mesa: ");
            System.out.println(mesa.getUltimaCarta());
            Scanner sc = new Scanner(System.in);
            System.out.println("Jugador " + (i + 1) + " escoga una carta para colocar ");
            jugadores.get(i).imprimirMano();
            int cartaEscogida = sc.nextInt();

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

                    System.out.println("Jugador 1 comió " + contador + " cartas");
                } else {
                    int contador = 0;
                    do {
                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                        contador++;
                        if (baraja.getBaraja().isEmpty()) {
                            llenarBaraja();
                        }
                    } while (contador < 2);

                    System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
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

                        System.out.println("Jugador 1 comió " + contador + " cartas");
                    } else {
                        int contador = 0;
                        do {
                            jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                            contador++;
                            if (baraja.getBaraja().isEmpty()) {
                                llenarBaraja();
                            }
                        } while (contador < 4);

                        System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                    }

                    System.out.println("Se puso un 3");
                } else {
                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                            && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Sota") {
                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                        System.out.println("Se cambió la dirección de la partida");
                        invertido = true;
                        do {
                            invertirPartida();
                            invertirJugadores();
                        } while (invertido == true);

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

                                                System.out.println("Jugador 1 comió " + contador + " cartas");
                                            } else {
                                                int contador = 0;
                                                do {
                                                    jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                                                    contador++;
                                                    if (baraja.getBaraja().isEmpty()) {
                                                        llenarBaraja();
                                                    }
                                                } while (contador < 2);

                                                System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                                            }

                                            System.out.println("Se puso un 2");
                                            continuarJuego = true;
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

                                                    System.out.println("Jugador 1 comió " + contador + " cartas");
                                                } else {
                                                    int contador = 0;
                                                    do {
                                                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                                                        contador++;
                                                        if (baraja.getBaraja().isEmpty()) {
                                                            llenarBaraja();
                                                        }
                                                    } while (contador < 4);

                                                    System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                                                }

                                                System.out.println("Se puso un 3");
                                                continuarJuego = true;
                                            } else {
                                                if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                        && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Sota") {
                                                    mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                    System.out.println("Se cambió la dirección de la partida");
                                                    invertido = true;
                                                    invertirJugadores();
                                                    do {
                                                        invertirPartida();
                                                    } while (invertido == true);
                                                    continuarJuego = true;
                                                } else {
                                                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                            && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "As") {
                                                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                        System.out.println("Jugador " + (i + 1) + " tira otra vez ");
                                                        jugarUnaVuelta(i);
                                                        continuarJuego = true;
                                                    } else {
                                                        if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                                || jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Rey") {
                                                            mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                            continuarJuego = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } while (!continuarJuego);

                                    System.out.println("Carta en mesa: ");
                                    System.out.println(mesa.getUltimaCarta());

                                } else {
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

        do {
            jugarUnaVuelta();
        } while (banderaParaManosDeJugadores() == false);
        determinarGanador();
    }

    public boolean verificarCarta(CartaLogica carta1, CartaLogica carta2) {
        if (carta1.getValue() == carta2.getValue() || carta1.getSuit() == carta2.getSuit()) {
            return true;
        }
        return false;
    }

    public void jugarUnaVuelta() {
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("Carta en mesa: ");
            System.out.println(mesa.getUltimaCarta());
            Scanner sc = new Scanner(System.in);
            System.out.println("Jugador " + (i + 1) + " escoga una carta para colocar ");
            jugadores.get(i).imprimirMano();
            int cartaEscogida = sc.nextInt();

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

                    System.out.println("Jugador 1 comió " + contador + " cartas");
                } else {
                    int contador = 0;
                    do {
                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                        contador++;
                        if (baraja.getBaraja().isEmpty()) {
                            llenarBaraja();
                        }
                    } while (contador < 2);

                    System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
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

                        System.out.println("Jugador 1 comió " + contador + " cartas");
                    } else {
                        int contador = 0;
                        do {
                            jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                            contador++;
                            if (baraja.getBaraja().isEmpty()) {
                                llenarBaraja();
                            }
                        } while (contador < 4);

                        System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                    }

                    System.out.println("Se puso un 3");
                } else {
                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                            && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Sota") {
                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                        System.out.println("Se cambió la dirección de la partida");
                        invertido = true;
                        do {
                            invertirPartida();
                        } while (invertido == true);

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

                                                System.out.println("Jugador 1 comió " + contador + " cartas");
                                            } else {
                                                int contador = 0;
                                                do {
                                                    jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                                                    contador++;
                                                    if (baraja.getBaraja().isEmpty()) {
                                                        llenarBaraja();
                                                    }
                                                } while (contador < 2);

                                                System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                                            }

                                            System.out.println("Se puso un 2");
                                            continuarJuego = true;
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

                                                    System.out.println("Jugador 1 comió " + contador + " cartas");
                                                } else {
                                                    int contador = 0;
                                                    do {
                                                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                                                        contador++;
                                                        if (baraja.getBaraja().isEmpty()) {
                                                            llenarBaraja();
                                                        }
                                                    } while (contador < 4);

                                                    System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                                                }

                                                System.out.println("Se puso un 3");
                                                continuarJuego = true;
                                            } else {
                                                if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                        && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Sota") {
                                                    mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                    System.out.println("Se cambió la dirección de la partida");
                                                    invertido = true;
                                                    invertirJugadores();
                                                    do {
                                                        invertirPartida();
                                                    } while (invertido == true);
                                                    continuarJuego = true;
                                                } else {
                                                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                            && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "As") {
                                                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                        System.out.println("Jugador " + (i + 1) + " tira otra vez ");
                                                        jugarUnaVuelta(i);
                                                        continuarJuego = true;
                                                    } else {
                                                        if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                                || jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Rey") {
                                                            mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                            continuarJuego = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } while (!continuarJuego);

                                    System.out.println("Carta en mesa: ");
                                    System.out.println(mesa.getUltimaCarta());

                                } else {
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
    }

    public void jugarUnaVuelta(int indice) {
        for (int i = indice; i < (indice + 1); i++) {
            System.out.println("Carta en mesa: ");
            System.out.println(mesa.getUltimaCarta());
            Scanner sc = new Scanner(System.in);
            System.out.println("Jugador " + (i + 1) + " escoga una carta para colocar ");
            jugadores.get(i).imprimirMano();
            int cartaEscogida = sc.nextInt();

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

                    System.out.println("Jugador 1 comió " + contador + " cartas");
                } else {
                    int contador = 0;
                    do {
                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                        contador++;
                        if (baraja.getBaraja().isEmpty()) {
                            llenarBaraja();
                        }
                    } while (contador < 2);

                    System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
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

                        System.out.println("Jugador 1 comió " + contador + " cartas");
                    } else {
                        int contador = 0;
                        do {
                            jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                            contador++;
                            if (baraja.getBaraja().isEmpty()) {
                                llenarBaraja();
                            }
                        } while (contador < 4);

                        System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                    }

                    System.out.println("Se puso un 3");
                } else {
                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                            && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Sota") {
                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                        System.out.println("Se cambió la dirección de la partida");
                        invertido = true;
                        invertirJugadores();
                        do {
                            invertirPartida();
                        } while (invertido == true);

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

                                    System.out.println("Esa carta no se puede poner ");
                                    boolean continuarJuego = false;
                                    do {
                                        System.out.println("Carta en mesa: ");
                                        System.out.println(mesa.getUltimaCarta());
                                        Scanner sc2 = new Scanner(System.in);
                                        System.out.println("Jugador " + (i + 1) + " escoga una carta para colocar ");
                                        jugadores.get(i).imprimirMano();
                                        int cartaEscogida2 = sc2.nextInt();
                                        if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
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

                                                System.out.println("Jugador 1 comió " + contador + " cartas");
                                            } else {
                                                int contador = 0;
                                                do {
                                                    jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                                                    contador++;
                                                    if (baraja.getBaraja().isEmpty()) {
                                                        llenarBaraja();
                                                    }
                                                } while (contador < 2);

                                                System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                                            }

                                            System.out.println("Se puso un 2");
                                            continuarJuego = true;
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

                                                    System.out.println("Jugador 1 comió " + contador + " cartas");
                                                } else {
                                                    int contador = 0;
                                                    do {
                                                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                                                        contador++;
                                                        if (baraja.getBaraja().isEmpty()) {
                                                            llenarBaraja();
                                                        }
                                                    } while (contador < 4);

                                                    System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                                                }

                                                System.out.println("Se puso un 3");
                                                continuarJuego = true;
                                            } else {
                                                if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                        && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Sota") {
                                                    mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                    System.out.println("Se cambió la dirección de la partida");
                                                    invertido = true;
                                                    invertirJugadores();
                                                    do {
                                                        invertirPartida();
                                                    } while (invertido == true);
                                                    continuarJuego = true;
                                                } else {
                                                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                            && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "As") {
                                                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                        System.out.println("Jugador " + (i + 1) + " tira otra vez ");
                                                        jugarUnaVuelta(i);
                                                        continuarJuego = true;
                                                    } else {
                                                        if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                                                                || jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Rey") {
                                                            mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                                                            continuarJuego = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    } while (!continuarJuego);

                                    System.out.println("Carta en mesa: ");
                                    System.out.println(mesa.getUltimaCarta());

                                } else {
                                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == false
                                            && jugadores.get(i).verificarMano(mesa.getUltimaCarta()) == false) {
                                        int contador = 0;
                                        do {
                                            jugadores.get(i).agregarCartaAMano(baraja.darCarta());
                                            contador++;
                                            if (baraja.getBaraja().isEmpty()) {
                                                llenarBaraja();
                                            }
                                        } while (jugadores.get(i).verificarMano(mesa.getUltimaCarta()) == false);

                                        System.out.println("CHUPATE DOS, Jugador " + (i + 1) + " comió " + contador + " cartas");
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void invertirPartida() {
        for (int i = jugadores.size() - 1; i >= 0; i--) {
            System.out.println("Carta en mesa: ");
            System.out.println(mesa.getUltimaCarta());
            Scanner sc = new Scanner(System.in);
            System.out.println("Jugador " + (i + 1) + " escoga una carta para colocar ");
            jugadores.get(i).imprimirMano();
            int cartaEscogida = sc.nextInt();

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

                    System.out.println("Jugador 1 comió " + contador + " cartas");
                } else {
                    int contador = 0;
                    do {
                        jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                        contador++;
                        if (baraja.getBaraja().isEmpty()) {
                            llenarBaraja();
                        }
                    } while (contador < 2);

                    System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
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

                        System.out.println("Jugador 1 comió " + contador + " cartas");
                    } else {
                        int contador = 0;
                        do {
                            jugadores.get(i + 1).agregarCartaAMano(baraja.darCarta());
                            contador++;
                            if (baraja.getBaraja().isEmpty()) {
                                llenarBaraja();
                            }
                        } while (contador < 4);

                        System.out.println("Jugador " + (i + 2) + " comió " + contador + " cartas");
                    }

                    System.out.println("Se puso un 3");
                } else {
                    if (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == true
                            && jugadores.get(i).getCarta(cartaEscogida-1).getValue() == "Sota") {
                        mesa.agregarCartaAMesa(jugadores.get(i).colocarCarta(cartaEscogida-1));
                        System.out.println("Se cambió la dirección de la partida");
                        invertido = false;
                        invertirJugadores();
                        do {
                            jugarUnaVuelta();
                        } while (invertido = false);

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
                                    System.out.println("Esa carta no se puede poner ");
                                    boolean continuarJuego = false;
                                    do {
                                        jugarUnaVuelta(i);
                                    } while (verificarCarta(jugadores.get(i).getCarta(cartaEscogida-1), mesa.getUltimaCarta()) == false
                                            && jugadores.get(i).verificarMano(mesa.getUltimaCarta()) == true);

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
                                    } else {
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
        }
    }

    public boolean banderaParaManosDeJugadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).estaVaciaMano() == true) {
                return true;
            }
        }
        return false;
    }

    public void determinarGanador() {
        Jugador ganador = jugadores.get(0);
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).estaVaciaMano() == true) {
                ganador = jugadores.get(i);
            }
        }
        System.out.println("El ganador de la ronda fue el " + ganador);
    }

    public void llenarBaraja() {
        for (int i = 0; i < mesa.getMesa().size() - 2; i++) {
            baraja.agregarCartaABaraja(mesa.colocarCarta());
        }
        baraja.mezclar();
        System.out.println("Las cartas se acabaron, mezclando baraja... ");
        System.out.println("Ya se mezcló ");
    }

    public void invertirJugadores() {
        ArrayList<Jugador> nombresInvertidos = new ArrayList<>();
        for (int i = jugadores.size() - 1; i >= 0; i--) {
            nombresInvertidos.add(jugadores.get(i));
        }
        jugadores = nombresInvertidos;
    }
}
