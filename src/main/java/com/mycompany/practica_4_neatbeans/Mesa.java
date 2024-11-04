package com.mycompany.practica_4_neatbeans;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Mesa extends javax.swing.JFrame {

    private ArrayList<JPanel> panelesCartasJugadores;

    public Mesa() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        panelCartas.setLayout(new OverlayLayout(panelCartas));
        panelCartas.setPreferredSize(new java.awt.Dimension(130, 180));

        // Inicializar paneles para las cartas de los jugadores
        panelesCartasJugadores = new ArrayList<>();
        panelesCartasJugadores.add(zona_Jugador1); // Asegúrate de que estas zonas existan
        panelesCartasJugadores.add(zona_Jugador2);
        panelesCartasJugadores.add(zona_Jugador3);
        panelesCartasJugadores.add(zona_Jugador4);
    }

    public void mostrarCartasEnBaraja(ArrayList<VistaCarta> cartas) {
        // Limpiar el panel antes de agregar nuevas cartas
        panelCartas.removeAll();

        for (VistaCarta vistaCarta : cartas) {
            panelCartas.add(vistaCarta);
        }
        revalidate(); // Para refrescar el JPanel
        repaint(); // Para volver a dibujar el JPanel
    }

    public void mostrarCartasJugadores(ArrayList<Jugador> jugadores) {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            JPanel zonaJugador = panelesCartasJugadores.get(i); // Obtener los paneles del jugador
            JPanel[] panelesCartas = {
                (JPanel) zonaJugador.getComponent(0),
                (JPanel) zonaJugador.getComponent(1),
                (JPanel) zonaJugador.getComponent(2),
                (JPanel) zonaJugador.getComponent(3),
                (JPanel) zonaJugador.getComponent(4)};

            // Limpiar los paneles de cartas
            for (JPanel panel : panelesCartas) {
                panel.removeAll();
            }

            for (int j = 0; j < jugador.getManoSize(); j++) {
                if (j < panelesCartas.length) {
                    CartaLogica cartaLogica = jugador.getCarta(j);
                    VistaCarta vistaCarta = new VistaCarta(cartaLogica);
                    //JLabel etiquetaCarta = new JLabel((Icon) vistaCarta);
                    //panelesCartas[j].add(etiquetaCarta);
                    panelesCartas[j].add(vistaCarta);
                }
            }
            zonaJugador.revalidate();
            zonaJugador.repaint();
        }
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
        panelCartas = new javax.swing.JPanel();
        zona_Jugador1 = new javax.swing.JPanel();
        carta1_Jugador1 = new javax.swing.JPanel();
        carta2_Jugador1 = new javax.swing.JPanel();
        carta3_Jugador1 = new javax.swing.JPanel();
        carta4_Jugador1 = new javax.swing.JPanel();
        carta5_Jugador1 = new javax.swing.JPanel();
        zona_Jugador2 = new javax.swing.JPanel();
        carta2_Jugador2 = new javax.swing.JPanel();
        carta3_Jugador2 = new javax.swing.JPanel();
        carta4_Jugador2 = new javax.swing.JPanel();
        carta5_Jugador2 = new javax.swing.JPanel();
        carta1_Jugador2 = new javax.swing.JPanel();
        zona_Jugador3 = new javax.swing.JPanel();
        carta4_Jugador3 = new javax.swing.JPanel();
        carta3_Jugador3 = new javax.swing.JPanel();
        carta2_Jugador3 = new javax.swing.JPanel();
        carta1_Jugador3 = new javax.swing.JPanel();
        carta5_Jugador3 = new javax.swing.JPanel();
        zona_Jugador4 = new javax.swing.JPanel();
        carta1_Jugador4 = new javax.swing.JPanel();
        carta2_Jugador4 = new javax.swing.JPanel();
        carta3_Jugador4 = new javax.swing.JPanel();
        carta4_Jugador4 = new javax.swing.JPanel();
        carta5_Jugador4 = new javax.swing.JPanel();
        nombreJugador2 = new javax.swing.JLabel();
        nombreJugador3 = new javax.swing.JLabel();
        nombreJugador1 = new javax.swing.JLabel();
        nombreJugador4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel1.setBackground(new java.awt.Color(161, 130, 98));
        jPanel1.setPreferredSize(new java.awt.Dimension(1700, 780));

        panelCartas.setBackground(new java.awt.Color(255, 255, 255));
        panelCartas.setPreferredSize(new java.awt.Dimension(130, 180));

        javax.swing.GroupLayout panelCartasLayout = new javax.swing.GroupLayout(panelCartas);
        panelCartas.setLayout(panelCartasLayout);
        panelCartasLayout.setHorizontalGroup(
            panelCartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        panelCartasLayout.setVerticalGroup(
            panelCartasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        carta1_Jugador1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta1_Jugador1Layout = new javax.swing.GroupLayout(carta1_Jugador1);
        carta1_Jugador1.setLayout(carta1_Jugador1Layout);
        carta1_Jugador1Layout.setHorizontalGroup(
            carta1_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta1_Jugador1Layout.setVerticalGroup(
            carta1_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        carta2_Jugador1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta2_Jugador1Layout = new javax.swing.GroupLayout(carta2_Jugador1);
        carta2_Jugador1.setLayout(carta2_Jugador1Layout);
        carta2_Jugador1Layout.setHorizontalGroup(
            carta2_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta2_Jugador1Layout.setVerticalGroup(
            carta2_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        carta3_Jugador1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta3_Jugador1Layout = new javax.swing.GroupLayout(carta3_Jugador1);
        carta3_Jugador1.setLayout(carta3_Jugador1Layout);
        carta3_Jugador1Layout.setHorizontalGroup(
            carta3_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta3_Jugador1Layout.setVerticalGroup(
            carta3_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        carta4_Jugador1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta4_Jugador1Layout = new javax.swing.GroupLayout(carta4_Jugador1);
        carta4_Jugador1.setLayout(carta4_Jugador1Layout);
        carta4_Jugador1Layout.setHorizontalGroup(
            carta4_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta4_Jugador1Layout.setVerticalGroup(
            carta4_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        carta5_Jugador1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta5_Jugador1Layout = new javax.swing.GroupLayout(carta5_Jugador1);
        carta5_Jugador1.setLayout(carta5_Jugador1Layout);
        carta5_Jugador1Layout.setHorizontalGroup(
            carta5_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta5_Jugador1Layout.setVerticalGroup(
            carta5_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout zona_Jugador1Layout = new javax.swing.GroupLayout(zona_Jugador1);
        zona_Jugador1.setLayout(zona_Jugador1Layout);
        zona_Jugador1Layout.setHorizontalGroup(
            zona_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zona_Jugador1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carta1_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta2_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta3_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta4_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta5_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        zona_Jugador1Layout.setVerticalGroup(
            zona_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zona_Jugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zona_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zona_Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(carta5_Jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carta4_Jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carta3_Jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carta2_Jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(carta1_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        carta2_Jugador2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta2_Jugador2Layout = new javax.swing.GroupLayout(carta2_Jugador2);
        carta2_Jugador2.setLayout(carta2_Jugador2Layout);
        carta2_Jugador2Layout.setHorizontalGroup(
            carta2_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carta2_Jugador2Layout.setVerticalGroup(
            carta2_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        carta3_Jugador2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta3_Jugador2Layout = new javax.swing.GroupLayout(carta3_Jugador2);
        carta3_Jugador2.setLayout(carta3_Jugador2Layout);
        carta3_Jugador2Layout.setHorizontalGroup(
            carta3_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carta3_Jugador2Layout.setVerticalGroup(
            carta3_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        carta4_Jugador2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta4_Jugador2Layout = new javax.swing.GroupLayout(carta4_Jugador2);
        carta4_Jugador2.setLayout(carta4_Jugador2Layout);
        carta4_Jugador2Layout.setHorizontalGroup(
            carta4_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );
        carta4_Jugador2Layout.setVerticalGroup(
            carta4_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        carta5_Jugador2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta5_Jugador2Layout = new javax.swing.GroupLayout(carta5_Jugador2);
        carta5_Jugador2.setLayout(carta5_Jugador2Layout);
        carta5_Jugador2Layout.setHorizontalGroup(
            carta5_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carta5_Jugador2Layout.setVerticalGroup(
            carta5_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        carta1_Jugador2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta1_Jugador2Layout = new javax.swing.GroupLayout(carta1_Jugador2);
        carta1_Jugador2.setLayout(carta1_Jugador2Layout);
        carta1_Jugador2Layout.setHorizontalGroup(
            carta1_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carta1_Jugador2Layout.setVerticalGroup(
            carta1_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout zona_Jugador2Layout = new javax.swing.GroupLayout(zona_Jugador2);
        zona_Jugador2.setLayout(zona_Jugador2Layout);
        zona_Jugador2Layout.setHorizontalGroup(
            zona_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zona_Jugador2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zona_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carta4_Jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta3_Jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta2_Jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta5_Jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta1_Jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 106, Short.MAX_VALUE))
        );
        zona_Jugador2Layout.setVerticalGroup(
            zona_Jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zona_Jugador2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carta1_Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta2_Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta3_Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta4_Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta5_Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        carta4_Jugador3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta4_Jugador3Layout = new javax.swing.GroupLayout(carta4_Jugador3);
        carta4_Jugador3.setLayout(carta4_Jugador3Layout);
        carta4_Jugador3Layout.setHorizontalGroup(
            carta4_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta4_Jugador3Layout.setVerticalGroup(
            carta4_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        carta3_Jugador3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta3_Jugador3Layout = new javax.swing.GroupLayout(carta3_Jugador3);
        carta3_Jugador3.setLayout(carta3_Jugador3Layout);
        carta3_Jugador3Layout.setHorizontalGroup(
            carta3_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta3_Jugador3Layout.setVerticalGroup(
            carta3_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        carta2_Jugador3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta2_Jugador3Layout = new javax.swing.GroupLayout(carta2_Jugador3);
        carta2_Jugador3.setLayout(carta2_Jugador3Layout);
        carta2_Jugador3Layout.setHorizontalGroup(
            carta2_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta2_Jugador3Layout.setVerticalGroup(
            carta2_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        carta1_Jugador3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta1_Jugador3Layout = new javax.swing.GroupLayout(carta1_Jugador3);
        carta1_Jugador3.setLayout(carta1_Jugador3Layout);
        carta1_Jugador3Layout.setHorizontalGroup(
            carta1_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta1_Jugador3Layout.setVerticalGroup(
            carta1_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        carta5_Jugador3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta5_Jugador3Layout = new javax.swing.GroupLayout(carta5_Jugador3);
        carta5_Jugador3.setLayout(carta5_Jugador3Layout);
        carta5_Jugador3Layout.setHorizontalGroup(
            carta5_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        carta5_Jugador3Layout.setVerticalGroup(
            carta5_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout zona_Jugador3Layout = new javax.swing.GroupLayout(zona_Jugador3);
        zona_Jugador3.setLayout(zona_Jugador3Layout);
        zona_Jugador3Layout.setHorizontalGroup(
            zona_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zona_Jugador3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carta1_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta2_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta3_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta4_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta5_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        zona_Jugador3Layout.setVerticalGroup(
            zona_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zona_Jugador3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(zona_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zona_Jugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(carta3_Jugador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carta4_Jugador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carta2_Jugador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carta5_Jugador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(carta1_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        carta1_Jugador4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta1_Jugador4Layout = new javax.swing.GroupLayout(carta1_Jugador4);
        carta1_Jugador4.setLayout(carta1_Jugador4Layout);
        carta1_Jugador4Layout.setHorizontalGroup(
            carta1_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );
        carta1_Jugador4Layout.setVerticalGroup(
            carta1_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        carta2_Jugador4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta2_Jugador4Layout = new javax.swing.GroupLayout(carta2_Jugador4);
        carta2_Jugador4.setLayout(carta2_Jugador4Layout);
        carta2_Jugador4Layout.setHorizontalGroup(
            carta2_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carta2_Jugador4Layout.setVerticalGroup(
            carta2_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        carta3_Jugador4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta3_Jugador4Layout = new javax.swing.GroupLayout(carta3_Jugador4);
        carta3_Jugador4.setLayout(carta3_Jugador4Layout);
        carta3_Jugador4Layout.setHorizontalGroup(
            carta3_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carta3_Jugador4Layout.setVerticalGroup(
            carta3_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        carta4_Jugador4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta4_Jugador4Layout = new javax.swing.GroupLayout(carta4_Jugador4);
        carta4_Jugador4.setLayout(carta4_Jugador4Layout);
        carta4_Jugador4Layout.setHorizontalGroup(
            carta4_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carta4_Jugador4Layout.setVerticalGroup(
            carta4_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        carta5_Jugador4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carta5_Jugador4Layout = new javax.swing.GroupLayout(carta5_Jugador4);
        carta5_Jugador4.setLayout(carta5_Jugador4Layout);
        carta5_Jugador4Layout.setHorizontalGroup(
            carta5_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carta5_Jugador4Layout.setVerticalGroup(
            carta5_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout zona_Jugador4Layout = new javax.swing.GroupLayout(zona_Jugador4);
        zona_Jugador4.setLayout(zona_Jugador4Layout);
        zona_Jugador4Layout.setHorizontalGroup(
            zona_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zona_Jugador4Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(zona_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carta1_Jugador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta2_Jugador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta3_Jugador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta4_Jugador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta5_Jugador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        zona_Jugador4Layout.setVerticalGroup(
            zona_Jugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zona_Jugador4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carta1_Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta2_Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta3_Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta4_Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta5_Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(nombreJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nombreJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombreJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(zona_Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(panelCartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zona_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zona_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zona_Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(808, 808, 808))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombreJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zona_Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(zona_Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(panelCartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(zona_Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zona_Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(229, 229, 229))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel carta1_Jugador1;
    private javax.swing.JPanel carta1_Jugador2;
    private javax.swing.JPanel carta1_Jugador3;
    private javax.swing.JPanel carta1_Jugador4;
    private javax.swing.JPanel carta2_Jugador1;
    private javax.swing.JPanel carta2_Jugador2;
    private javax.swing.JPanel carta2_Jugador3;
    private javax.swing.JPanel carta2_Jugador4;
    private javax.swing.JPanel carta3_Jugador1;
    private javax.swing.JPanel carta3_Jugador2;
    private javax.swing.JPanel carta3_Jugador3;
    private javax.swing.JPanel carta3_Jugador4;
    private javax.swing.JPanel carta4_Jugador1;
    private javax.swing.JPanel carta4_Jugador2;
    private javax.swing.JPanel carta4_Jugador3;
    private javax.swing.JPanel carta4_Jugador4;
    private javax.swing.JPanel carta5_Jugador1;
    private javax.swing.JPanel carta5_Jugador2;
    private javax.swing.JPanel carta5_Jugador3;
    private javax.swing.JPanel carta5_Jugador4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreJugador1;
    private javax.swing.JLabel nombreJugador2;
    private javax.swing.JLabel nombreJugador3;
    private javax.swing.JLabel nombreJugador4;
    private javax.swing.JPanel panelCartas;
    private javax.swing.JPanel zona_Jugador1;
    private javax.swing.JPanel zona_Jugador2;
    private javax.swing.JPanel zona_Jugador3;
    private javax.swing.JPanel zona_Jugador4;
    // End of variables declaration//GEN-END:variables
}