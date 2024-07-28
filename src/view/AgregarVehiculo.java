package view;

import controller.VehiculoDAO;
import controller.AutoDAO;
import controller.CamionetaDAO;
import controller.MotoDAO;
import controller.BicicletaDAO;
import model.Auto;
import model.Moto;
import model.Camioneta;
import model.Bicicleta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Empleado;
import controller.VehiculoTablaController;


public class AgregarVehiculo extends javax.swing.JFrame {
    private Administracion vAdmin;
    private Empleado empleado;
    private VehiculoTablaController vehiculoTablaController;

    public AgregarVehiculo(){
        
    }
    
    public AgregarVehiculo(Empleado empleado, Administracion vAdmin) {
        this.empleado = empleado;
        this.vAdmin = vAdmin;
        this.vehiculoTablaController = new VehiculoTablaController();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        panelVehiculo = new javax.swing.JPanel();
        txtMarca = new javax.swing.JTextField();
        labelMarca = new javax.swing.JLabel();
        labelColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        labelModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        labelPatente = new javax.swing.JLabel();
        txtPatente = new javax.swing.JTextField();
        labelCantidadPuertas = new javax.swing.JLabel();
        txtCantidadPuertas = new javax.swing.JTextField();
        labelRodado = new javax.swing.JLabel();
        txtRodado = new javax.swing.JTextField();
        labelPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        labelTipoMoto = new javax.swing.JLabel();
        txtTipoMoto = new javax.swing.JTextField();
        comboBoxTipo = new javax.swing.JComboBox<>();
        txtCarga = new javax.swing.JTextField();
        labelCarga = new javax.swing.JLabel();
        labelTipoBici1 = new javax.swing.JLabel();
        txtTipoBici = new javax.swing.JTextField();
        labelTipoVehiculo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Agregar Vehiculo");

        panelVehiculo.setBackground(new java.awt.Color(1, 37, 56));
        panelVehiculo.setForeground(new java.awt.Color(255, 255, 255));

        txtMarca.setBackground(new java.awt.Color(77, 85, 91));
        txtMarca.setForeground(new java.awt.Color(255, 255, 255));
        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelMarca.setForeground(new java.awt.Color(255, 255, 255));
        labelMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMarca.setText("Marca");

        labelColor.setForeground(new java.awt.Color(255, 255, 255));
        labelColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColor.setText("Color");

        txtColor.setBackground(new java.awt.Color(77, 85, 91));
        txtColor.setForeground(new java.awt.Color(255, 255, 255));
        txtColor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelModelo.setForeground(new java.awt.Color(255, 255, 255));
        labelModelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelModelo.setText("Modelo");

        txtModelo.setBackground(new java.awt.Color(77, 85, 91));
        txtModelo.setForeground(new java.awt.Color(255, 255, 255));
        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelPatente.setForeground(new java.awt.Color(255, 255, 255));
        labelPatente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPatente.setText("Patente");

        txtPatente.setBackground(new java.awt.Color(77, 85, 91));
        txtPatente.setForeground(new java.awt.Color(255, 255, 255));
        txtPatente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelCantidadPuertas.setForeground(new java.awt.Color(255, 255, 255));
        labelCantidadPuertas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCantidadPuertas.setText("Cantidad Puertas");

        txtCantidadPuertas.setBackground(new java.awt.Color(77, 85, 91));
        txtCantidadPuertas.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidadPuertas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelRodado.setForeground(new java.awt.Color(255, 255, 255));
        labelRodado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRodado.setText("Rodado");

        txtRodado.setBackground(new java.awt.Color(77, 85, 91));
        txtRodado.setForeground(new java.awt.Color(255, 255, 255));
        txtRodado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelPrecio.setForeground(new java.awt.Color(255, 255, 255));
        labelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrecio.setText("Precio");

        txtPrecio.setBackground(new java.awt.Color(77, 85, 91));
        txtPrecio.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelTipoMoto.setForeground(new java.awt.Color(255, 255, 255));
        labelTipoMoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTipoMoto.setText("Tipo Moto");

        txtTipoMoto.setBackground(new java.awt.Color(77, 85, 91));
        txtTipoMoto.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoMoto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        comboBoxTipo.setBackground(new java.awt.Color(77, 85, 91));
        comboBoxTipo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        comboBoxTipo.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auto", "Bicicleta", "Camioneta", "Moto" }));
        comboBoxTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoActionPerformed(evt);
            }
        });

        txtCarga.setBackground(new java.awt.Color(77, 85, 91));
        txtCarga.setForeground(new java.awt.Color(255, 255, 255));
        txtCarga.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelCarga.setForeground(new java.awt.Color(255, 255, 255));
        labelCarga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCarga.setText("Carga");

        labelTipoBici1.setForeground(new java.awt.Color(255, 255, 255));
        labelTipoBici1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTipoBici1.setText("Tipo Bici");

        txtTipoBici.setBackground(new java.awt.Color(77, 85, 91));
        txtTipoBici.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoBici.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTipoBici.setCaretColor(new java.awt.Color(255, 255, 255));

        labelTipoVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTipoVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        labelTipoVehiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTipoVehiculo.setText("Tipo de Vehiculo");

        jPanel2.setBackground(new java.awt.Color(1, 37, 62));

        btnAceptar.setBackground(new java.awt.Color(252, 200, 73));
        btnAceptar.setText("Crear Vehiculo");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(251, 152, 51));
        btnAtras.setText("Atras");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 51, 51));
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelVehiculoLayout = new javax.swing.GroupLayout(panelVehiculo);
        panelVehiculo.setLayout(panelVehiculoLayout);
        panelVehiculoLayout.setHorizontalGroup(
            panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtColor, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(labelColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(labelModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelRodado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRodado, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(labelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelVehiculoLayout.createSequentialGroup()
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPatente, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(labelPatente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidadPuertas)
                            .addComponent(labelCantidadPuertas, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTipoBici, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(labelTipoBici1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTipoMoto, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(labelTipoMoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCarga, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(labelCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(labelTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelVehiculoLayout.setVerticalGroup(
            panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRodado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRodado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoBici1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCantidadPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoBici, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this,"Esta seguro que desea salir?","A V I S O",2,1)==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String tipo = comboBoxTipo.getSelectedItem().toString();
        String marca = txtMarca.getText();
        String color = txtColor.getText();
        String modeloVehiculo = txtModelo.getText();
        int rodado;
        double precio;
        String patente = txtPatente.getText();
        int cantidadPuertas = 0;
        String tipoMoto = txtTipoMoto.getText();
        String tipoBici = txtTipoBici.getText();
        double carga = 0.0;
        
        // Validación de campos vacíos
        if (marca.isEmpty() || color.isEmpty() || modeloVehiculo.isEmpty() || txtRodado.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos obligatorios.");
            return;
        }
                
        try {
            rodado = Integer.parseInt(txtRodado.getText());
            precio = Double.parseDouble(txtPrecio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa valores numéricos válidos para rodado y precio.");
            return;
        }
        
        try {
            if (tipo.equals("Auto")) {
                if (txtCantidadPuertas.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos obligatorios.");
                    return;
                }
                cantidadPuertas = Integer.parseInt(txtCantidadPuertas.getText());
            } else if (tipo.equals("Camioneta")) {
                if (txtCarga.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos obligatorios.");
                    return;
                }
                carga = Double.parseDouble(txtCarga.getText());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa valores numéricos válidos para los campos adicionales.");
            return;
        }

        vehiculoTablaController.agregarVehiculo(tipo, marca, color, modeloVehiculo, rodado, precio, patente, cantidadPuertas, tipoMoto, tipoBici, carga);
        JOptionPane.showMessageDialog(this, "Vehículo agregado correctamente.");
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if(vAdmin == null){
            vAdmin = new Administracion(empleado);
        }
        vAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed
        
    private void comboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoActionPerformed
        String valor = (String) comboBoxTipo.getSelectedItem();
        vehiculoTablaController.habilitarCampos(valor, txtMarca, txtColor, txtModelo, txtRodado, 
                                            txtPrecio, txtPatente, txtCantidadPuertas, 
                                            txtCarga, txtTipoMoto, txtTipoBici);
    }//GEN-LAST:event_comboBoxTipoActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCantidadPuertas;
    private javax.swing.JLabel labelCarga;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelPatente;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelRodado;
    private javax.swing.JLabel labelTipoBici1;
    private javax.swing.JLabel labelTipoMoto;
    private javax.swing.JLabel labelTipoVehiculo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelVehiculo;
    private javax.swing.JTextField txtCantidadPuertas;
    private javax.swing.JTextField txtCarga;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPatente;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRodado;
    private javax.swing.JTextField txtTipoBici;
    private javax.swing.JTextField txtTipoMoto;
    // End of variables declaration//GEN-END:variables
}
