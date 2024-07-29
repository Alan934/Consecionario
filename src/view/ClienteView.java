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
import model.Cliente;
import controller.VehiculoTablaController;


public class ClienteView extends javax.swing.JFrame {
    private Login vLogin;
    private Cliente cliente;
    private VehiculoTablaController vehiculoTablaController;
    private Connection connection;
    
    public ClienteView(Cliente cliente) {
        this.cliente = cliente;
        this.vehiculoTablaController = new VehiculoTablaController();
        initComponents();
        labelNombre.setText(cliente.getNombre());
        labelApellido.setText(cliente.getApellido());
        labelIDCliente.setText(Integer.toString(cliente.getId()));
        listarVehiculos();
    }
    
    public ClienteView(Cliente cliente, Connection connection) {
        this.cliente = cliente;
        this.vehiculoTablaController = new VehiculoTablaController(connection); // Pasar la conexión aquí
        initComponents();
        labelNombre.setText(cliente.getNombre());
        labelApellido.setText(cliente.getApellido());
        labelIDCliente.setText(Integer.toString(cliente.getId()));
        listarVehiculos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculo = new javax.swing.JTable();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnListar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        labelIDCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(1, 37, 56));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Bienvenido Cliente");
        background.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        tablaVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Marca", "Color", "Modelo", "Rodado", "Patente", "CantidadPuertas", "Precio", "Tipo", "Carga", "TipoMoto", "TipoBici"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVehiculo);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 990, 530));

        labelNombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setText("Nombre");
        background.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 90, 30));

        labelApellido.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        labelApellido.setForeground(new java.awt.Color(255, 255, 255));
        labelApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelApellido.setText("Apellido");
        background.add(labelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 90, 30));

        jPanel2.setBackground(new java.awt.Color(1, 37, 62));

        btnListar.setBackground(new java.awt.Color(204, 204, 204));
        btnListar.setText("Listar");
        btnListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnComprar.setBackground(new java.awt.Color(204, 204, 204));
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 410, 50));

        btnAtras.setBackground(new java.awt.Color(251, 152, 51));
        btnAtras.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        background.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 680, 106, -1));

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
        background.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 680, 106, -1));

        labelIDCliente.setForeground(new java.awt.Color(255, 255, 255));
        labelIDCliente.setText("IDCliente");
        background.add(labelIDCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        getContentPane().add(background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarVehiculos();
    }//GEN-LAST:event_btnListarActionPerformed

    private void listarVehiculos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculo.getModel();
        vehiculoTablaController.listarVehiculos(modelo, "Cliente");
    }
    
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if(vLogin == null){
            vLogin = new Login();
        }
        vLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this,"Esta seguro que desea salir?","A V I S O",2,1)==0){
            cerrarConexion();
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        int selectedRow = tablaVehiculo.getSelectedRow();
        if (selectedRow != -1) {
            int idVehiculo = (int) tablaVehiculo.getValueAt(selectedRow, 0); // Assuming the ID is in the first column
            boolean exito = vehiculoTablaController.comprarVehiculo(idVehiculo, cliente.getId());

            if (exito) {
                JOptionPane.showMessageDialog(this, "Compra realizada con éxito!");
            } else {
                JOptionPane.showMessageDialog(this, "Error al realizar la compra. Por favor, intente nuevamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un vehículo.");
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]) {
        Cliente clienteEjemplo = new Cliente("Nombre Ejemplo", "Apellido Ejemplo", "12345678", "contrasena");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteView(clienteEjemplo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelIDCliente;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTitulo;
    public javax.swing.JTable tablaVehiculo;
    // End of variables declaration//GEN-END:variables
}
