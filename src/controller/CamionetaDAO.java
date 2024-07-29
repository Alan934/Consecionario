package controller;

import controller.VehiculoDAO;
import model.Camioneta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CamionetaDAO {
    private Connection connection;
    private VehiculoDAO vehiculoDAO;
    
    public CamionetaDAO(Connection connection) {
        this.connection = connection;
        this.vehiculoDAO = new VehiculoDAO(connection);
    }
    
    // Inserta una nueva camioneta en la base de datos
    public void insertarCamioneta(Camioneta camioneta) throws SQLException{
        // Inserta la información básica del vehículo en la tabla 'vehiculo' y obtiene el ID generado
        int camionetaId = vehiculoDAO.insertarVehiculo(camioneta, "Camioneta");
        // Inserta la información específica de la camioneta en la tabla 'camioneta'
        String query = "INSERT INTO camioneta (idVehiculo, patente, carga) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, camionetaId); // Asocia la camioneta con el ID del vehículo
            stmt.setString(2, camioneta.getPatente());
            stmt.setDouble(3, camioneta.getCarga());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Insertar Camioneta: "+ex);
        }
    }
    
    // Asocia la camioneta con el ID del vehículo
    public void actualizarCamioneta(Camioneta camioneta) throws SQLException {
        // Actualiza la información básica del vehículo en la tabla 'vehiculo'
        vehiculoDAO.actualizarVehiculo(camioneta);
        // Actualiza la información específica de la camioneta en la tabla 'camioneta'
        String query = "UPDATE camioneta SET patente = ?, carga = ? WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, camioneta.getPatente());
            stmt.setDouble(2, camioneta.getCarga());
            stmt.setInt(3, camioneta.getId());// Usa el ID del vehículo para identificar la camioneta
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Actualizar Camioneta: "+ex);
        }
    }
    
    // Elimina una camioneta de la base de datos
    public void eliminarCamioneta(int camionetaId) throws SQLException {
        // Elimina la información específica de la camioneta en la tabla 'camioneta'
        String query = "DELETE FROM camioneta WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, camionetaId);// Usa el ID del vehículo para identificar la camioneta
            stmt.executeUpdate();
        }
    }

}
