package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Auto;
import model.Bicicleta;
import model.Camioneta;
import model.Cliente;
import model.Moto;
import model.Vehiculo;
import view.Administracion;
import controller.VehiculoDAO;

public class VehiculoTablaController {
    private VehiculoDAO vehiculoDAO;
    
    public VehiculoTablaController(){
        
    }
    
    public VehiculoTablaController(Connection connection) {
        this.vehiculoDAO = new VehiculoDAO(connection); // Asegúrate de que el constructor de VehiculoDAO esté bien definido
    }

    // Lista los vehículos en un modelo de tabla
    public void listarVehiculos(DefaultTableModel modelo, String persona) {
        modelo.setRowCount(0); // Limpiar la tabla
        Connection connection;
        int cantidadColumnas = 13;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "");
            VehiculoDAO vehiculoDAO = new VehiculoDAO(connection);
            List<Vehiculo> vehiculos = vehiculoDAO.obtenerVehiculos();
            for (Vehiculo vehiculo : vehiculos) {
                if (persona.equals("Cliente") && !vehiculo.getEstado().equalsIgnoreCase("Disponible")) {
                    continue; // Si es un cliente y el vehículo no está disponible, se omite
                }
                
                // Crear una fila con los datos del vehículo
                Object[] row = new Object[cantidadColumnas];
                row[0] = vehiculo.getId();
                row[1] = vehiculo.getMarca();
                row[2] = vehiculo.getColor();
                row[3] = vehiculo.getModelo();
                row[4] = vehiculo.getRodado();
                row[5] = vehiculo instanceof Auto ? ((Auto) vehiculo).getPatente() :
                        vehiculo instanceof Moto ? ((Moto) vehiculo).getPatente() :
                        vehiculo instanceof Camioneta ? ((Camioneta) vehiculo).getPatente() : "-";
                row[6] = vehiculo instanceof Auto ? ((Auto) vehiculo).getCantidadPuertas() : "-";
                row[7] = vehiculo.getPrecio();
                row[8] = vehiculo.getTipo();
                row[9] = vehiculo instanceof Camioneta ? ((Camioneta) vehiculo).getCarga() : 0;
                row[10] = vehiculo instanceof Moto ? ((Moto) vehiculo).getTipoMoto() : "-";
                row[11] = vehiculo instanceof Bicicleta ? ((Bicicleta) vehiculo).getTipoBici() : "-";
                row[12] = vehiculo.getEstado();

                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println("Error al listar vehículos: " + e);
        }
    }
    
    // Agregar un nuevo vehículo
    public void agregarVehiculo(String tipo, String marca, String color, String modeloVehiculo, int rodado, double precio, String patente, int cantidadPuertas, String tipoMoto, String tipoBici, double carga) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "");
            AutoDAO autoDAO = new AutoDAO(connection);
            MotoDAO motoDAO = new MotoDAO(connection);
            BicicletaDAO biciDAO = new BicicletaDAO(connection);
            CamionetaDAO camionetaDAO = new CamionetaDAO(connection);
            
            // Crear e insertar el vehículo según su tipo
            switch(tipo){
                case "Auto":
                    Auto auto = new Auto(patente, cantidadPuertas, marca, color, modeloVehiculo, rodado, precio, tipo);
                    autoDAO.insertarAuto(auto);
                    break;
                case "Moto":
                    Moto moto = new Moto(patente, tipoMoto, marca, color, modeloVehiculo, rodado, precio, tipo);
                    motoDAO.insertarMoto(moto);
                    break;
                case "Bicicleta":
                    Bicicleta bici = new Bicicleta(tipoBici, marca, color, modeloVehiculo, rodado, precio, tipo);
                    biciDAO.insertarBicicleta(bici);
                    break;
                case "Camioneta":
                    Camioneta camioneta = new Camioneta(patente, carga, marca, color, modeloVehiculo, rodado, precio, tipo);
                    camionetaDAO.insertarCamioneta(camioneta);
                    break;                    
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Elimina un vehículo seleccionado en la tabla
    public void eliminarVehiculo(DefaultTableModel modelo, int selectedRow) {
        if (selectedRow >= 0) {
            int vehiculoId = (int) modelo.getValueAt(selectedRow, 0); // Obtener el ID del vehículo seleccionado
            String tipo = (String) modelo.getValueAt(selectedRow, 8); // Obtener el tipo del vehículo

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "")) {
                VehiculoDAO vehiculoDAO = new VehiculoDAO(connection);
                
                // Eliminar el vehículo según su tipo
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

                // Elimina el registro de la tabla Vehiculo
                vehiculoDAO.eliminarVehiculo(vehiculoId);

                // Eliminar la fila de la tabla
                modelo.removeRow(selectedRow);

                JOptionPane.showMessageDialog(null, "Vehículo eliminado correctamente.");
            } catch (SQLException ex) {
                Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al eliminar el vehículo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un vehículo para eliminar.");
        }
    }
    
    // Actualiza un vehículo seleccionado en la tabla
    public void actualizarVehiculo(DefaultTableModel modelo, int selectedRow) {
        if (selectedRow >= 0) {
            try {
                // Obtener datos de la tabla
                int vehiculoId = (int) modelo.getValueAt(selectedRow, 0);
                String marca = (String) modelo.getValueAt(selectedRow, 1);
                String color = (String) modelo.getValueAt(selectedRow, 2);
                String vehiculoModelo = (String) modelo.getValueAt(selectedRow, 3);
                int rodado = Integer.parseInt(modelo.getValueAt(selectedRow, 4).toString());
                double precio = Double.parseDouble(modelo.getValueAt(selectedRow, 7).toString());
                String tipo = (String) modelo.getValueAt(selectedRow, 8);
                String estado = (String) modelo.getValueAt(selectedRow, 12);
                
                // Crear una instancia del vehículo según su tipo
                Vehiculo vehiculo;
                if ("Auto".equals(tipo)) {
                    String patente = (String) modelo.getValueAt(selectedRow, 5);
                    int cantidadPuertas = Integer.parseInt(modelo.getValueAt(selectedRow, 6).toString());
                    vehiculo = new Auto(patente, cantidadPuertas, marca, color, vehiculoModelo, rodado, precio, tipo);
                } else if ("Moto".equals(tipo)) {
                    String patente = (String) modelo.getValueAt(selectedRow, 5);
                    String tipoMoto = (String) modelo.getValueAt(selectedRow, 10);
                    vehiculo = new Moto(patente, tipoMoto, marca, color, vehiculoModelo, rodado, precio, tipo);
                } else if ("Bicicleta".equals(tipo)) {
                    String tipoBici = (String) modelo.getValueAt(selectedRow, 11);
                    vehiculo = new Bicicleta(tipoBici, marca, color, vehiculoModelo, rodado, precio, tipo);
                } else if ("Camioneta".equals(tipo)) {
                    String patente = (String) modelo.getValueAt(selectedRow, 5);
                    double carga = modelo.getValueAt(selectedRow, 9).toString().equals("-") ? 0 : Double.parseDouble(modelo.getValueAt(selectedRow, 9).toString());
                    vehiculo = new Camioneta(patente, carga, marca, color, vehiculoModelo, rodado, precio, tipo);
                } else {
                    vehiculo = new Vehiculo(marca, color, vehiculoModelo, rodado, precio, tipo);
                }
                vehiculo.setEstado(estado);
                vehiculo.setId(vehiculoId);

                // Conectar a la base de datos y actualizar el vehículo
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "")) {
                    VehiculoDAO vehiculoDAO = new VehiculoDAO(connection);
                    
                    // Actualizar el vehículo según su tipo
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
                        vehiculoDAO.actualizarVehiculo(vehiculo);
                    }

                    JOptionPane.showMessageDialog(null, "Vehículo actualizado correctamente.");
                } catch (SQLException ex) {
                    Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al actualizar el vehículo: " + ex.getMessage());
                }
            } catch (Exception e) {
                Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "Error al procesar los datos del vehículo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un vehículo para actualizar.");
        }
    }
    
    // Habilita campos en la interfaz según el tipo de vehículo seleccionado
    public void habilitarCampos(String tipo, javax.swing.JTextField txtMarca, javax.swing.JTextField txtColor, 
                                javax.swing.JTextField txtModelo, javax.swing.JTextField txtRodado, 
                                javax.swing.JTextField txtPrecio, javax.swing.JTextField txtPatente, 
                                javax.swing.JTextField txtCantidadPuertas, javax.swing.JTextField txtCarga, 
                                javax.swing.JTextField txtTipoMoto, javax.swing.JTextField txtTipoBici) {
        // Definir qué campos deben habilitarse según el tipo de vehículo
        boolean habilitarMarcaColorModeloRodadoPrecio = true;
        boolean habilitarPatente = tipo.equals("Auto") || tipo.equals("Camioneta") || tipo.equals("Moto");
        boolean habilitarCantidadPuertas = tipo.equals("Auto");
        boolean habilitarCarga = tipo.equals("Camioneta");
        boolean habilitarTipoMoto = tipo.equals("Moto");
        boolean habilitarTipoBici = tipo.equals("Bicicleta");
        
        // Habilitar o deshabilitar los campos
        txtMarca.setEnabled(habilitarMarcaColorModeloRodadoPrecio);
        txtColor.setEnabled(habilitarMarcaColorModeloRodadoPrecio);
        txtModelo.setEnabled(habilitarMarcaColorModeloRodadoPrecio);
        txtRodado.setEnabled(habilitarMarcaColorModeloRodadoPrecio);
        txtPrecio.setEnabled(habilitarMarcaColorModeloRodadoPrecio);

        // Limpiar los campos deshabilitados
        txtPatente.setEnabled(habilitarPatente);
        txtCantidadPuertas.setEnabled(habilitarCantidadPuertas);
        txtCarga.setEnabled(habilitarCarga);
        txtTipoMoto.setEnabled(habilitarTipoMoto);
        txtTipoBici.setEnabled(habilitarTipoBici);

        if (!habilitarPatente) txtPatente.setText("");
        if (!habilitarCantidadPuertas) txtCantidadPuertas.setText("");
        if (!habilitarCarga) txtCarga.setText("");
        if (!habilitarTipoMoto) txtTipoMoto.setText("");
        if (!habilitarTipoBici) txtTipoBici.setText("");
    }
    
    // Registra la compra de un vehículo por un cliente
    public boolean comprarVehiculo(int idVehiculo, int idCliente) {
        return vehiculoDAO.venderVehiculo(idVehiculo, idCliente);
    }
}
