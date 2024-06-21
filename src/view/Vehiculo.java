package view;

import javax.swing.JOptionPane;
import model.Cliente;

public class Vehiculo extends javax.swing.JFrame {
    private Login vLogin;
    private Cliente cliente;
    
    public Vehiculo(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        txtDni.setText(cliente.getDni());
        txtNombre.setEnabled(false);
        txtDni.setEnabled(false);
        txtApellido.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        panelBtn = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(153, 153, 0));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Bienvenido Cliente");
        background.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 400, 120));

        txtApellido.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtApellido.setText("Apellido");
        background.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNombre.setText("Nombre");
        background.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        txtDni.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtDni.setText("DNI");
        background.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 51, 51));
        btnSalir.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setName("txtSalir"); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
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
                .addGap(64, 64, 64)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        panelBtnLayout.setVerticalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        background.add(panelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 650, 130));

        getContentPane().add(background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this,"Esta seguro que desea salir?","A V I S O",2,1)==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if(vLogin == null){
            vLogin = new Login();
        }
        vLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    public static void main(String args[]) {
        Cliente clienteEjemplo = new Cliente("Nombre Ejemplo", "Apellido Ejemplo", "12345678", "contrasena");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vehiculo(clienteEjemplo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBtn;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
