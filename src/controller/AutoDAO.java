package controller;

import controller.VehiculoDAO;
import model.Auto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AutoDAO {
    private Connection connection;
    private VehiculoDAO vehiculoDAO;

    public AutoDAO(Connection connection) {
        this.connection = connection;
        this.vehiculoDAO = new VehiculoDAO(connection);
    }
    
    // Ingresa un nuevo auto en la base de datos
    public void insertarAuto(Auto auto) throws SQLException {
        // Inserta la información básica del vehículo en la tabla 'vehiculo' y obtiene el ID generado
        int autoId = vehiculoDAO.insertarVehiculo(auto, "Auto");
        // Inserta la información específica del auto en la tabla 'auto'
        String query = "INSERT INTO auto (idVehiculo, patente, cantidadPuertas) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, autoId);  // Asocia el auto con el ID del vehículo
            stmt.setString(2, auto.getPatente());
            stmt.setInt(3, auto.getCantidadPuertas());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Insertar Auto: " + ex);
        }
    }
    
    // Actualiza la información de un auto existente en la base de datos
    public void actualizarAuto(Auto auto) throws SQLException {
        // Actualiza la información básica del vehículo en la tabla 'vehiculo'
        vehiculoDAO.actualizarVehiculo(auto);
        // Actualiza la información específica del auto en la tabla 'auto'
        String query = "UPDATE Auto SET patente = ?, cantidadPuertas = ? WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, auto.getPatente());
            stmt.setInt(2, auto.getCantidadPuertas());
            stmt.setInt(3, auto.getId());  // Usa el ID del vehículo para identificar el auto
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Actualizar Auto: " + ex);
        }
    }
    
    // Elimina un auto de la base de datos
    public void eliminarAuto(int autoId) throws SQLException {
        // Elimina la información específica del auto en la tabla 'auto'
        String query = "DELETE FROM auto WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, autoId);  // Usa el ID del vehículo para identificar el auto
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Eliminar Auto: " + ex);
        }
    }

}
