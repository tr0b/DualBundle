/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconcuflappy;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.edisoncor.gui.panel.PanelImage;

/**
 *
 * @author Josue Hernandez
 */
public class Jugar extends javax.swing.JFrame {

    public static JLabel jFlappy;
    public static JLabel jLbl2;
    public static JLabel jLbl3;
    public static JLabel jLbl4;
    private final JPanel jPnl1;
    public static JLabel Puntuacion;
    public PanelImage Piso;
    public static JLabel jTubo_abajo1;
    public static JLabel jTubo_abajo2;
    public static JLabel jTubo_arriba1;
    public static JLabel jTubo_arriba2;
    public static PanelImage panelImage1;
    private Flappy mvnt_flappy;
    private Tubos mvnt_tubos;
    private boolean empezar = false;
    private Puntuacion puntaje;
    private final Login login;
    private JPanel panel1;
    private JPanel panel2;
    public String nombre;
    static public boolean con_exitosa = false;
    Point posicionflappy;
    public String ruta = "";
    int velocidad = 4;

    public Jugar() {
        jLbl2 = new javax.swing.JLabel();
        jLbl3 = new javax.swing.JLabel();
        jLbl4 = new javax.swing.JLabel();
        jPnl1 = new javax.swing.JPanel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        Piso = new org.edisoncor.gui.panel.PanelImage();
        Puntuacion = new javax.swing.JLabel();
        jFlappy = new javax.swing.JLabel();
        jTubo_arriba1 = new javax.swing.JLabel();
        jTubo_abajo1 = new javax.swing.JLabel();
        jTubo_arriba2 = new javax.swing.JLabel();
        jTubo_abajo2 = new javax.swing.JLabel();
        initComponents();
        this.setLocationRelativeTo(null);
        ocularObjetos(false);
        login = new Login();
        mostrarLogin();
        EventosExternos();
        this.setTitle("Flappy Bird");
        puntaje = new Puntuacion(this);
        posicionflappy = jFlappy.getLocation();
        this.jPnl1.setSize(400, 607);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPnl1.setBackground(new java.awt.Color(255, 255, 255));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png")));
        panelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelImage1MousePressed(evt);
            }
        });
        panelImage1.setLayout(null);

        Piso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tierra.png")));

        javax.swing.GroupLayout jSueloLayout = new javax.swing.GroupLayout(Piso);
        Piso.setLayout(jSueloLayout);
        jSueloLayout.setHorizontalGroup(
                jSueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );
        jSueloLayout.setVerticalGroup(
                jSueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 180, Short.MAX_VALUE)
        );

        panelImage1.add(Piso);
        Piso.setBounds(-130, 470, 580, 180);

        Puntuacion.setFont(new java.awt.Font("Andres", 1, 40));
        Puntuacion.setForeground(new java.awt.Color(255, 255, 255));
        Puntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Puntuacion.setText("0");
        panelImage1.add(Puntuacion);
        Puntuacion.setBounds(0, 10, 400, 49);

        jFlappy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flappy.png")));
        jFlappy.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFlappyKeyReleased(evt);
            }
        });
        panelImage1.add(jFlappy);
        jFlappy.setBounds(70, 230, 34, 24);

        jTubo_arriba1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tuboNorte.png")));
        panelImage1.add(jTubo_arriba1);
        jTubo_arriba1.setBounds(70, -120, 52, 320);

        jTubo_abajo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tuboSur.png")));
        panelImage1.add(jTubo_abajo1);
        jTubo_abajo1.setBounds(70, 280, 52, 320);

        jTubo_arriba2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tuboNorte.png")));
        panelImage1.add(jTubo_arriba2);
        jTubo_arriba2.setBounds(290, -120, 52, 320);

        jTubo_abajo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tuboSur.png")));
        panelImage1.add(jTubo_abajo2);
        jTubo_abajo2.setBounds(290, 280, 52, 320);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPnl1);
        jPnl1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }

    private void jFlappyKeyReleased(java.awt.event.KeyEvent evt) {
        if (empezar) {
            if (evt.getExtendedKeyCode() == 32) {
                this.mvnt_flappy.setVelocidad(aumentarVelocidad());
                this.mvnt_flappy.setSaltar(true);
                jFlappy.requestFocus(true);              
            }
            validarChoqueTubos();
        }
    }

    private void panelImage1MousePressed(java.awt.event.MouseEvent evt) {
        if (empezar) {
            this.mvnt_flappy.setVelocidad(aumentarVelocidad());
            this.mvnt_flappy.setSaltar(true);
            jFlappy.requestFocus(true);
        }
    }

    private int aumentarVelocidad() {
        int puntos = Integer.parseInt(Puntuacion.getText());
        if (puntos == 150 || puntos == 300) {
            velocidad = velocidad - 1;
        }
        return velocidad;
    }

    private void EventosExternos() {
        login.jBtn1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        nombre = this.login.jTxtF1.getText();
        this.panel1.setVisible(false);
        Empezar();
        ocularObjetos(true);
    }

    public void Empezar() {
        mvnt_tubos = new Tubos();
        mvnt_flappy = new Flappy(this);
        mvnt_tubos.start();
        mvnt_flappy.start();
        empezar = true;
        jFlappy.requestFocus();
        this.setTitle("FLAPPY BIRD - " + nombre);
    }

    public void validarChoqueTubos() {
        Point loclz_Flappy = jFlappy.getLocation();
        Point loclz_Tubo1 = jTubo_arriba1.getLocation();
        Point loclz_Tubo2 = jTubo_arriba2.getLocation();
        Point loclz_Tubo3 = jTubo_abajo1.getLocation();
        Point loclz_Tubo4 = jTubo_abajo2.getLocation();
        if (loclz_Flappy.x > (loclz_Tubo1.x - 32) && loclz_Flappy.x < ((loclz_Tubo1.x - 32) + 82) && loclz_Flappy.y < (loclz_Tubo1.y + 318)) {
            this.mvnt_tubos.stop();
            this.mvnt_flappy.setSaltar(false);
            empezar = false;
        } else if (loclz_Flappy.x > (loclz_Tubo2.x - 32) && loclz_Flappy.x < ((loclz_Tubo2.x - 32) + 82) && loclz_Flappy.y < (loclz_Tubo2.y + 318)) {
            this.mvnt_tubos.stop();
            this.mvnt_flappy.setSaltar(false);
            empezar = false;
        } else if (loclz_Flappy.x > (loclz_Tubo3.x - 32) && loclz_Flappy.x < ((loclz_Tubo3.x - 32) + 82) && loclz_Flappy.y > (loclz_Tubo3.y - 22)) {           
            this.mvnt_tubos.stop();
            this.mvnt_flappy.setSaltar(false);
            empezar = false;
        } else if (loclz_Flappy.x > (loclz_Tubo4.x - 32) && loclz_Flappy.x < ((loclz_Tubo4.x - 32) + 82) && loclz_Flappy.y > (loclz_Tubo4.y - 22)) {
            this.mvnt_tubos.stop();
            this.mvnt_flappy.setSaltar(false);
            empezar = false;
            
        }
    }

    private void ocularObjetos(boolean accion) {
        jFlappy.setVisible(accion);
        jTubo_abajo1.setVisible(accion);
        jTubo_abajo2.setVisible(accion);
        jTubo_arriba1.setVisible(accion);
        jTubo_arriba2.setVisible(accion);
        Puntuacion.setVisible(accion);
    }

    public synchronized void ValidarChoque() {
        int y = jFlappy.getLocation().y;
        if (y == 448) {            
            Fin gamerover = new Fin(this, true);
            try {
                Thread hilo = new Thread() {
                    @Override
                    public void run() {
                        mvnt_tubos.stop();
                        Flappy.detenethilo = true;
                        stop();
                    }
                };
                hilo.start();
            } catch (Exception e) {
            }
            gamerover.setVisible(true);
        }
    }

    public void mostrarPuntaje() {
        ocularObjetos(false);
        panel2 = new JPanel();
        panel2.setBounds(0, 0, this.getWidth(), 550);
        panel2.add(puntaje);
        puntaje.setBounds(0, 0, panel2.getWidth(), panel2.getHeight());
        panelImage1.add(panel2);
        panel2.setBackground(new Color(255, 255, 153));
        puntaje.setVisible(true);
        puntaje.mostrar();
        panel2.setVisible(true);
    }

    public void EmpezarNuevo() {
        jFlappy.setLocation(posicionflappy);
        Puntuacion.setText("0");
        this.panel2.setVisible(false);
        Empezar();
        ocularObjetos(true);
        puntaje = new Puntuacion(this);
    }

    private void mostrarLogin() {
        panel1 = new JPanel();
        panel1.setBounds(10, 200, 380, 140);
        panel1.add(login);
        login.setBounds(0, 0, panel1.getWidth(), panel1.getHeight());
        panelImage1.add(panel1);
        panel1.setBackground(new Color(255, 255, 153));
        login.setVisible(true);
        panel1.setVisible(true);
    }

}
