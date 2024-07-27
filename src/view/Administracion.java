package view;

import javax.swing.JOptionPane;
import controller.PersonaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import model.Empleado;
import model.Auto;
import model.Moto;
import model.Bicicleta;
import model.Camioneta;
import model.Vehiculo;
import controller.VehiculoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.AutoDAO;
import controller.MotoDAO;
import controller.CamionetaDAO;
import controller.BicicletaDAO;

public class Administracion extends javax.swing.JFrame {
    private Login vLogin;
    private Empleado empleado;
    private AgregarVehiculo vAgregarVehiculo;
    
    public Administracion(Empleado empleado) {
        this.empleado = empleado;
        initComponents();        
        labelNombre.setText(empleado.getNombre());
        labelApellido.setText(empleado.getApellido());
        //labelMostrarSueldo.setText(String.format("%.2f", empleado.getSueldo()));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelPrincipal = new javax.swing.JPanel();
        labelAdministracion = new javax.swing.JLabel();
        panelBtn = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        panelBienvenida = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelBienvenida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCrearVehiculo = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        labelAdministracion.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labelAdministracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdministracion.setText("ADMINISTRACION");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(labelAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 690, 70));

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

        jPanel1.add(panelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 670, 650, 130));

        labelNombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setText("nombre");

        labelApellido.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelApellido.setText("apellido");

        labelBienvenida.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBienvenida.setText("Bienvenido");

        javax.swing.GroupLayout panelBienvenidaLayout = new javax.swing.GroupLayout(panelBienvenida);
        panelBienvenida.setLayout(panelBienvenidaLayout);
        panelBienvenidaLayout.setHorizontalGroup(
            panelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBienvenidaLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(panelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBienvenidaLayout.createSequentialGroup()
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBienvenidaLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(labelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        panelBienvenidaLayout.setVerticalGroup(
            panelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBienvenidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido)
                    .addComponent(labelNombre))
                .addGap(15, 15, 15))
        );

        jPanel1.add(panelBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 390, 100));

        tablaVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Marca", "Color", "Modelo", "Rodado", "Patente", "CantidadPuertas", "Precio", "Tipo", "carga", "tipoMoto", "tipoBici"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVehiculo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1000, 470));

        btnCrearVehiculo.setText("Crear Vehiculo");
        btnCrearVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearVehiculoActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearVehiculo)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 530, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if(vLogin == null){
            vLogin = new Login();
        }
        vLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this,"Esta seguro que desea salir?","A V I S O",2,1)==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCrearVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVehiculoActionPerformed
        if(vAgregarVehiculo == null){
            vAgregarVehiculo = new AgregarVehiculo();
        }
        vAgregarVehiculo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearVehiculoActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculo.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        Connection connection;
        int cantidadColumnas = 9;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "");
            VehiculoDAO vehiculoDAO = new VehiculoDAO(connection);
            List<Vehiculo> vehiculos = vehiculoDAO.obtenerVehiculos();
            for (Vehiculo vehiculo : vehiculos) {
                Object[] row = new Object[cantidadColumnas];
                row[0] = vehiculo.getId();
                row[1] = vehiculo.getMarca();
                row[2] = vehiculo.getColor();
                row[3] = vehiculo.getModelo();
                row[4] = vehiculo.getRodado();
                row[5] = vehiculo instanceof Auto ? ((Auto) vehiculo).getPatente() : "-";
                row[6] = vehiculo instanceof Auto ? ((Auto) vehiculo).getCantidadPuertas() : "-";
                row[7] = vehiculo.getPrecio();
                row[8] = vehiculo.getTipo();
                modelo.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnListarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = tablaVehiculo.getSelectedRow();
        if (selectedRow >= 0) {
            int vehiculoId = (int) tablaVehiculo.getValueAt(selectedRow, 0);
            String tipo = (String) tablaVehiculo.getValueAt(selectedRow, 8);

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "")) {
                VehiculoDAO vehiculoDAO = new VehiculoDAO(connection);

                if ("Auto".equals(tipo)) {
                    AutoDAO autoDAO = new AutoDAO(connection);
                    autoDAO.eliminarAuto(vehiculoId);
                } else if ("Moto".equals(tipo)) {
                    MotoDAO motoDAO = new MotoDAO(connection);
                    motoDAO.eliminarMoto(vehiculoId);
                } else if ("Bicicleta".equals(tipo)) {
                    BicicletaDAO bicicletaDAO = new BicicletaDAO(connection);
                    bicicletaDAO.eliminarBicicleta(vehiculoId);
                } else if ("Camioneta".equals(tipo)) {
                    CamionetaDAO camionetaDAO = new CamionetaDAO(connection);
                    camionetaDAO.eliminarCamioneta(vehiculoId);
                }

                // Luego elimina el registro de la tabla Vehiculo
                vehiculoDAO.eliminarVehiculo(vehiculoId);

                // Eliminar la fila de la tabla
                DefaultTableModel modelo = (DefaultTableModel) tablaVehiculo.getModel();
                modelo.removeRow(selectedRow);

                JOptionPane.showMessageDialog(this, "Vehículo eliminado correctamente.");
            } catch (SQLException ex) {
                Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al eliminar el vehículo.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un vehículo para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    int selectedRow = tablaVehiculo.getSelectedRow();
    if (selectedRow >= 0) {
        int vehiculoId = (int) tablaVehiculo.getValueAt(selectedRow, 0);
        String marca = (String) tablaVehiculo.getValueAt(selectedRow, 1);
        String color = (String) tablaVehiculo.getValueAt(selectedRow, 2);
        String modelo = (String) tablaVehiculo.getValueAt(selectedRow, 3);
        int rodado = (int) tablaVehiculo.getValueAt(selectedRow, 4);
        double precio = (double) tablaVehiculo.getValueAt(selectedRow, 7);
        String tipo = (String) tablaVehiculo.getValueAt(selectedRow, 8);

        Vehiculo vehiculo;
        if ("Auto".equals(tipo)) {
            String patente = (String) tablaVehiculo.getValueAt(selectedRow, 5);
            String cantidadPuertas = (String) tablaVehiculo.getValueAt(selectedRow, 6);
            vehiculo = new Auto(patente, cantidadPuertas, marca, color, modelo, rodado, precio, tipo);
        } else if ("Moto".equals(tipo)) {
            String patente = (String) tablaVehiculo.getValueAt(selectedRow, 5);
            String tipoMoto = (String) tablaVehiculo.getValueAt(selectedRow, 6);
            vehiculo = new Moto(patente, tipoMoto, marca, color, modelo, rodado, precio, tipo);
        } else if ("Bicicleta".equals(tipo)) {
            String tipoBici = (String) tablaVehiculo.getValueAt(selectedRow, 5);
            vehiculo = new Bicicleta(tipoBici, marca, color, modelo, rodado, precio, tipo);
        } else if ("Camioneta".equals(tipo)) {
            String patente = (String) tablaVehiculo.getValueAt(selectedRow, 5);
            String carga = (String) tablaVehiculo.getValueAt(selectedRow, 6);
            vehiculo = new Camioneta(patente, carga, marca, color, modelo, rodado, precio, tipo);
        } else {
            vehiculo = new Vehiculo(marca, color, modelo, rodado, precio, tipo);
        }
        vehiculo.setId(vehiculoId);

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "");
            if (vehiculo instanceof Auto) {
                AutoDAO autoDAO = new AutoDAO(connection);
                autoDAO.actualizarAuto((Auto) vehiculo);
            } else if (vehiculo instanceof Moto) {
                MotoDAO motoDAO = new MotoDAO(connection);
                motoDAO.actualizarMoto((Moto) vehiculo);
            } else if (vehiculo instanceof Bicicleta) {
                BicicletaDAO biciDAO = new BicicletaDAO(connection);
                biciDAO.actualizarBicicleta((Bicicleta) vehiculo);
            } else if (vehiculo instanceof Camioneta) {
                CamionetaDAO camionetaDAO = new CamionetaDAO(connection);
                camionetaDAO.actualizarCamioneta((Camioneta) vehiculo);
            } else {
                VehiculoDAO vehiculoDAO = new VehiculoDAO(connection);
                vehiculoDAO.actualizarVehiculo(vehiculo);
            }
            JOptionPane.showMessageDialog(this, "Vehículo actualizado correctamente.");
        } catch (SQLException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al actualizar el vehículo.");
        }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un vehículo para actualizar.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    public static void main(String args[]) {
        Empleado empleadoEjemplo = new Empleado("Nombre Ejemplo", "Apellido Ejemplo", "12345678", 1500.0, "contrasena");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administracion(empleadoEjemplo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCrearVehiculo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAdministracion;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelBienvenida;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPanel panelBienvenida;
    private javax.swing.JPanel panelBtn;
    private javax.swing.JPanel panelPrincipal;
    public javax.swing.JTable tablaVehiculo;
    // End of variables declaration//GEN-END:variables
}
