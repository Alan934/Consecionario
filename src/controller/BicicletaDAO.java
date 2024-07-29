package controller;

import controller.VehiculoDAO;
import model.Bicicleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BicicletaDAO {
        private Connection connection;
    private VehiculoDAO vehiculoDAO;
    
    public BicicletaDAO(Connection connection) {
        this.connection = connection;
        this.vehiculoDAO = new VehiculoDAO(connection);
    }
    
    // Inserta una nueva bicicleta en la base de datos
    public void insertarBicicleta(Bicicleta bici) throws SQLException {
        // Inserta la información básica del vehículo en la tabla 'vehiculo' y obtiene el ID generado
        int biciId = vehiculoDAO.insertarVehiculo(bici, "Bicicleta");
        // Inserta la información específica de la bicicleta en la tabla 'bicicleta'
        String query = "INSERT INTO bicicleta (idVehiculo, tipoBici) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, biciId);  // Asocia la bicicleta con el ID del vehículo
            stmt.setString(2, bici.getTipoBici());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Insertar Bicicleta: " + ex);
        }
    }
    
    // Actualiza la información de una bicicleta existente en la base de datos
    public void actualizarBicicleta(Bicicleta bici) throws SQLException {
        // Actualiza la información básica del vehículo en la tabla 'vehiculo'
        vehiculoDAO.actualizarVehiculo(bici);
        // Actualiza la información específica de la bicicleta en la tabla 'bicicleta'
        String query = "UPDATE bicicleta SET tipoBici = ? WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, bici.getTipoBici());
            stmt.setInt(2, bici.getId());  // Usa el ID del vehículo para identificar la bicicleta
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Actualizar Bicicleta: " + ex);
        }
    }
    
    // Elimina una bicicleta de la base de datos
    public void eliminarBicicleta(int bicicletaId) throws SQLException {
        // Elimina la información específica de la bicicleta en la tabla 'bicicleta'
        String query = "DELETE FROM bicicleta WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bicicletaId);  // Usa el ID del vehículo para identificar la bicicleta
            stmt.executeUpdate();
        }
    }
}
