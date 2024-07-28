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
    
    public void insertarCamioneta(Camioneta camioneta) throws SQLException{
        int camionetaId = vehiculoDAO.insertarVehiculo(camioneta, "Camioneta");
        String query = "INSERT INTO camioneta (idVehiculo, patente, carga) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, camionetaId);
            stmt.setString(2, camioneta.getPatente());
            stmt.setDouble(3, camioneta.getCarga());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Insertar Camioneta: "+ex);
        }
    }
    
    public void actualizarCamioneta(Camioneta camioneta) throws SQLException {
        vehiculoDAO.actualizarVehiculo(camioneta);
        String query = "UPDATE camioneta SET patente = ?, carga = ? WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, camioneta.getPatente());
            stmt.setDouble(2, camioneta.getCarga());
            stmt.setInt(3, camioneta.getId());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Actualizar Camioneta: "+ex);
        }
    }
    
    public void eliminarCamioneta(int camionetaId) throws SQLException {
        String query = "DELETE FROM camioneta WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, camionetaId);
            stmt.executeUpdate();
        }
    }

}
