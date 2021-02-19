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
public class Login extends javax.swing.JPanel {

    public javax.swing.JButton jBtn1;
    private javax.swing.JLabel jLbl1;
    private javax.swing.JLabel jLbl2;
    private javax.swing.JLabel jLbl3;
    private javax.swing.JPanel jPnl1;
    private javax.swing.JPanel jPnl2;
    public javax.swing.JTextField jTxtF1;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPnl1 = new javax.swing.JPanel();
        jPnl2 = new javax.swing.JPanel();
        jLbl1 = new javax.swing.JLabel();
        jTxtF1 = new javax.swing.JTextField();
        jBtn1 = new javax.swing.JButton();
        jLbl2 = new javax.swing.JLabel();
        jLbl3 = new javax.swing.JLabel();

        jPnl1.setBackground(new java.awt.Color(255, 255, 153));

        jPnl2.setBackground(new java.awt.Color(255, 255, 153));
        jPnl2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLbl1.setFont(new java.awt.Font("Andres", 1, 18));
        jLbl1.setText("MI NOMBRE:");

        jTxtF1.setFont(new java.awt.Font("Andres", 1, 18));
        jTxtF1.setForeground(new java.awt.Color(0, 0, 255));
        jTxtF1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jBtn1.setFont(new java.awt.Font("Andres", 1, 14));
        jBtn1.setForeground(new java.awt.Color(255, 0, 0));
        jBtn1.setText("JUGAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPnl2);
        jPnl2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLbl1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTxtF1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLbl1)
                                        .addComponent(jTxtF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jBtn1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLbl2.setFont(new java.awt.Font("Andres", 0, 10));
        jLbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl2.setText("Hacer click en la pantalla del juego para mantener en vuelo al personaje.");

        jLbl3.setFont(new java.awt.Font("Andres", 0, 10));
        jLbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl3.setText("Pasar por el medio de los tubos, para obtener más puntos.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPnl1);
        jPnl1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPnl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLbl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLbl3)
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {

    }

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {
        int tamaño = this.jTxtF1.getText().length();
        if (tamaño >= 12) {
            evt.consume();
        }
    }
}
