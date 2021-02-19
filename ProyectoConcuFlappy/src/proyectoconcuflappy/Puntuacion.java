/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconcuflappy;

/**
 *
 * @author Josue Hernandez
 */
public class Puntuacion extends javax.swing.JPanel {

    Jugar parent;
    boolean conectandose;
    int intentos = 1;
    private javax.swing.JButton jBtn1;
    private javax.swing.JPanel jPnl1;
    private javax.swing.JPanel jPnl3;
    private javax.swing.JLabel jLbll5;
    private javax.swing.JLabel jLbll6;
    private javax.swing.JLabel jLbll7;
    private javax.swing.JLabel jLbll8;
    private javax.swing.JLabel jLbll9;

    public Puntuacion(Jugar parent) {
        initComponents();
        this.parent = parent;
    }

    public void mostrar() {
        this.jLbll6.setText(parent.nombre);
        this.jLbll8.setText(Jugar.Puntuacion.getText());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jBtn1 = new javax.swing.JButton();
        jPnl1 = new javax.swing.JPanel();
        jPnl3 = new javax.swing.JPanel();
        jLbll5 = new javax.swing.JLabel();
        jLbll6 = new javax.swing.JLabel();
        jLbll7 = new javax.swing.JLabel();
        jLbll8 = new javax.swing.JLabel();
        jLbll9 = new javax.swing.JLabel();

        jPnl1.setBackground(new java.awt.Color(255, 255, 153));

        jPnl3.setBackground(new java.awt.Color(255, 255, 153));
        jPnl3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Puntuacion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Andres", 1, 12), new java.awt.Color(0, 0, 0)));

        jLbll5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbll5.setText(" ");

        jLbll6.setFont(new java.awt.Font("Andres", 1, 36));
        jLbll6.setForeground(new java.awt.Color(255, 102, 0));
        jLbll6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbll6.setText("ADMIN");

        jLbll7.setFont(new java.awt.Font("Andres", 1, 36));
        jLbll7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbll7.setText("Mi Puntuacion es:");

        jLbll8.setFont(new java.awt.Font("Andres", 1, 36));
        jLbll8.setForeground(new java.awt.Color(255, 102, 0));
        jLbll8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbll8.setText("00");

        jLbll9.setFont(new java.awt.Font("Andres", 1, 36));
        jLbll9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbll9.setText("USUARIO:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPnl3);
        jPnl3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLbll5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLbll9, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLbll6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLbll7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                340, Short.MAX_VALUE)
                                        .addComponent(jLbll8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLbll9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLbll6)
                                .addGap(46, 46, 46)
                                .addComponent(jLbll7)
                                .addGap(18, 18, 18)
                                .addComponent(jLbll8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                                .addComponent(jLbll5)
                                .addContainerGap())
        );

        jBtn1.setFont(new java.awt.Font("Andres", 1, 12));
        jBtn1.setForeground(new java.awt.Color(255, 0, 0));
        jBtn1.setText("CONTINUAR");
        jBtn1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPnl1);
        jPnl1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jBtn1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jPnl3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPnl3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtn1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPnl1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPnl1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.parent.EmpezarNuevo();
    }
}
