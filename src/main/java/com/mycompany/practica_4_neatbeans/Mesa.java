package com.mycompany.practica_4_neatbeans;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mesa extends javax.swing.JFrame {

    private ArrayList<JPanel> panelesZonasJugadores;
    private ArrayList<JLabel> labelsDeJugadores;
    private ArrayList<CartaLogica> cartasLogicasJugadas;
    private ArrayList<CartaLogica> ultimasCartasSeleccionadasLogicas;
    private ArrayList<VistaCarta> ultimasCartasSeleccionadasGraficas;

    public Mesa() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        pack();

        cartasLogicasJugadas = new ArrayList<>();
        ultimasCartasSeleccionadasLogicas = new ArrayList<>();
        ultimasCartasSeleccionadasGraficas = new ArrayList<>();

        // Inicializar paneles para las cartas de los jugadores
        panelesZonasJugadores = new ArrayList<>();
        panelesZonasJugadores.add(zona_Jugador1);
        panelesZonasJugadores.add(zona_Jugador2);
        panelesZonasJugadores.add(zona_Jugador3);
        panelesZonasJugadores.add(zona_Jugador4);

        labelsDeJugadores = new ArrayList<>();
        labelsDeJugadores.add(nombreJugador1);
        labelsDeJugadores.add(nombreJugador2);
        labelsDeJugadores.add(nombreJugador3);
        labelsDeJugadores.add(nombreJugador4);

        /*botonesJugadores = new ArrayList<>();
        botonesJugadores.add(new ArrayList<>(List.of(ponerCarta1_Jugador1, ponerCarta2_Jugador1, ponerCarta3_Jugador1, ponerCarta4_Jugador1, ponerCarta5_Jugador1)));
        botonesJugadores.add(new ArrayList<>(List.of(ponerCarta1_Jugador2, ponerCarta2_Jugador2, ponerCarta3_Jugador2, ponerCarta4_Jugador2, ponerCarta5_Jugador2)));
        botonesJugadores.add(new ArrayList<>(List.of(ponerCarta1_Jugador3, ponerCarta2_Jugador3, ponerCarta3_Jugador3, ponerCarta4_Jugador3, ponerCarta5_Jugador3)));
        botonesJugadores.add(new ArrayList<>(List.of(ponerCarta1_Jugador4, ponerCarta2_Jugador4, ponerCarta3_Jugador4, ponerCarta4_Jugador4, ponerCarta5_Jugador4)));*/
    }

    public void mostrarCartasJugadores(ArrayList<Jugador> jugadores) {
        for (JPanel zonaJugador : panelesZonasJugadores) {
            zonaJugador.removeAll();
            zonaJugador.setVisible(false);
        }

        for (JLabel nombreJugador : labelsDeJugadores) {
            nombreJugador.setVisible(false);
        }

        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            JPanel zonaJugador = panelesZonasJugadores.get(i);
            JLabel nombreJugador = labelsDeJugadores.get(i);

            zonaJugador.setVisible(true);
            nombreJugador.setVisible(true);

            for (int j = 0; j < jugador.getManoSize(); j++) {
                VistaCarta vistaCarta = new VistaCarta(jugador.getCarta(j), this);
                zonaJugador.add(vistaCarta);
            }
            zonaJugador.revalidate();
            zonaJugador.repaint();
        }
    }

    public void mostrarGanador(int jugadorGanador) {
        // Mostrar mensaje indicando el ganador
        JOptionPane.showMessageDialog(this, "¡El ganador es: " + labelsDeJugadores.get(jugadorGanador).getText() + "!");
    }

    public CartaLogica getUltimaCarta() {
        if (cartasLogicasJugadas.size() > 0) {
            return cartasLogicasJugadas.get(cartasLogicasJugadas.size() - 1);
        } else {
            return null;
        }
    }

    public void guardarUltimaCartaSeleccionada(VistaCarta cartaGrafica) {
        ultimasCartasSeleccionadasGraficas.add(cartaGrafica);
        CartaLogica cartaLogica = cartaGrafica.getCarta();
        ultimasCartasSeleccionadasLogicas.add(cartaLogica);
        System.out.println("Carta logica guardada: " + cartaLogica);
    }
    
    public CartaLogica obtenerUltimaCartaSeleccionadaLogica (){
        if (ultimasCartasSeleccionadasLogicas.size() > 0) {
            return ultimasCartasSeleccionadasLogicas.get(ultimasCartasSeleccionadasLogicas.size() - 1);
        } else {
            return null; // Si no hay cartas seleccionadas, devuelve null
        }
    }
    
    public VistaCarta obtenerUltimaCartaSeleccionadaGrafica (){
        if (ultimasCartasSeleccionadasGraficas.size() > 0) {
            return ultimasCartasSeleccionadasGraficas.get(ultimasCartasSeleccionadasGraficas.size() - 1);
        } else {
            return null; // Si no hay cartas seleccionadas, devuelve null
        }
    }

    public void moverCartaAJugadas(VistaCarta vistaCarta) {
        cartasJugadas.removeAll();
        JPanel zonaJugador = (JPanel) vistaCarta.getParent();
        zonaJugador.remove(vistaCarta);

        // Obtener la carta lógica asociada a la VistaCarta
        CartaLogica cartaLogica = vistaCarta.getCarta();
        cartasLogicasJugadas.add(cartaLogica);

        // Agregar la carta al panel de cartas jugadas
        cartasJugadas.add(vistaCarta);

        zonaJugador.revalidate();
        zonaJugador.repaint();

        // Actualizar la interfaz para mostrar la carta en el panel de cartas jugadas
        cartasJugadas.revalidate();
        cartasJugadas.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        zona_Jugador1 = new javax.swing.JPanel();
        zona_Jugador2 = new javax.swing.JPanel();
        nombreJugador2 = new javax.swing.JLabel();
        nombreJugador3 = new javax.swing.JLabel();
        nombreJugador1 = new javax.swing.JLabel();
        nombreJugador4 = new javax.swing.JLabel();
        zona_Jugador3 = new javax.swing.JPanel();
        zona_Jugador4 = new javax.swing.JPanel();
        cartasJugadas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel1.setBackground(new java.awt.Color(161, 130, 98));
        jPanel1.setPreferredSize(new java.awt.Dimension(1700, 780));

        zona_Jugador1.setBackground(new java.awt.Color(161, 130, 98));
        zona_Jugador1.setLayout(new java.awt.GridLayout(1, 5, 3, 0));

        zona_Jugador2.setBackground(new java.awt.Color(161, 130, 98));
        zona_Jugador2.setLayout(new java.awt.GridLayout(5, 1, 0, 3));

        nombreJugador2.setFont(new java.awt.Font("BankGothic Md BT", 0, 24)); // NOI18N
        nombreJugador2.setForeground(new java.awt.Color(255, 200, 255));
        nombreJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador2.setText("Jugador 2");
        nombreJugador2.setPreferredSize(new java.awt.Dimension(170, 40));

        nombreJugador3.setFont(new java.awt.Font("BankGothic Md BT", 0, 24)); // NOI18N
        nombreJugador3.setForeground(new java.awt.Color(180, 232, 255));
        nombreJugador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador3.setText("Jugador 3");
        nombreJugador3.setPreferredSize(new java.awt.Dimension(170, 40));

        nombreJugador1.setFont(new java.awt.Font("BankGothic Md BT", 0, 24)); // NOI18N
        nombreJugador1.setForeground(new java.awt.Color(180, 232, 255));
        nombreJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador1.setText("Jugador 1");
        nombreJugador1.setPreferredSize(new java.awt.Dimension(170, 40));

        nombreJugador4.setFont(new java.awt.Font("BankGothic Md BT", 0, 24)); // NOI18N
        nombreJugador4.setForeground(new java.awt.Color(180, 232, 255));
        nombreJugador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador4.setText("Jugador 4");
        nombreJugador4.setPreferredSize(new java.awt.Dimension(170, 40));

        zona_Jugador3.setBackground(new java.awt.Color(161, 130, 98));
        zona_Jugador3.setLayout(new java.awt.GridLayout(1, 5, 0, 3));

        zona_Jugador4.setBackground(new java.awt.Color(161, 130, 98));
        zona_Jugador4.setPreferredSize(new java.awt.Dimension(250, 545));
        zona_Jugador4.setLayout(new java.awt.GridLayout(5, 1, 0, 3));

        cartasJugadas.setMinimumSize(new java.awt.Dimension(100, 130));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(zona_Jugador4, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(nombreJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(nombreJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zona_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(nombreJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(zona_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addComponent(cartasJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(zona_Jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(279, 279, 279))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zona_Jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(127, 127, 127))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zona_Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zona_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145)
                .addComponent(cartasJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zona_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cartasJugadas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreJugador1;
    private javax.swing.JLabel nombreJugador2;
    private javax.swing.JLabel nombreJugador3;
    private javax.swing.JLabel nombreJugador4;
    private javax.swing.JPanel zona_Jugador1;
    private javax.swing.JPanel zona_Jugador2;
    private javax.swing.JPanel zona_Jugador3;
    private javax.swing.JPanel zona_Jugador4;
    // End of variables declaration//GEN-END:variables
}
