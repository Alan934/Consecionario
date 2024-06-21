package view;
//import controller.Connection;
import controller.PersonaDAO;
import model.Empleado;
import model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Registrarse extends javax.swing.JFrame {
    private Login vLogin;
    
    public Registrarse() {
        initComponents();
    }

    public void setvLogin(Login vLogin) {
        this.vLogin = vLogin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        panelBtn = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        labelDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        labelContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(153, 153, 0));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Registrar Usuario");
        labelTitulo.setToolTipText("");
        background.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 400, 70));

        btnAceptar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnLayout = new javax.swing.GroupLayout(panelBtn);
        panelBtn.setLayout(panelBtnLayout);
        panelBtnLayout.setHorizontalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        panelBtnLayout.setVerticalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79))
        );

        background.add(panelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 400, 140));

        labelNombre.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        labelNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtNombre.setText("Nombre");
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        labelApellido.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        labelApellido.setText("Apellido");

        txtApellido.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtApellido.setText("Apellido");
        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoFocusGained(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        labelDni.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        labelDni.setText("DNI");

        txtDni.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtDni.setText("DNI");
        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniFocusGained(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        labelContrasena.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        labelContrasena.setText("Contraseña");

        txtContrasena.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtContrasena.setText("Contraseña");
        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(labelContrasena)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre)
                    .addComponent(labelApellido)
                    .addComponent(txtApellido)
                    .addComponent(labelDni)
                    .addComponent(txtDni))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelApellido)
                .addGap(10, 10, 10)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDni)
                .addGap(14, 14, 14)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 460, 430));

        getContentPane().add(background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if(vLogin == null){
            vLogin = new Login();
        }
        vLogin.setvRegistrarse(this);
        vLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "");
            PersonaDAO personaDAO = new PersonaDAO(connection);

            Empleado empleado = new Empleado("Juan", "Perez", "12345678", 50000, "123456");
            personaDAO.insertarEmpleado(empleado);

            Cliente cliente = new Cliente(txtNombre.getText(), txtApellido.getText(), txtDni.getText(), txtContrasena.getText());
            personaDAO.insertarCliente(cliente);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c<'A') | c>'Z') evt.consume();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c<'A') | c>'Z') evt.consume();
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c = evt.getKeyChar();
        if(c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        txtNombre.setText("");
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusGained
        txtApellido.setText("");
    }//GEN-LAST:event_txtApellidoFocusGained

    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        txtDni.setText("");
    }//GEN-LAST:event_txtDniFocusGained

    private void txtContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusGained
        txtContrasena.setText("");
    }//GEN-LAST:event_txtContrasenaFocusGained

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Jbackgrounda SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelContrasena;
    private javax.swing.JLabel labelDni;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBtn;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
