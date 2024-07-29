package controller;

import controller.VehiculoDAO;
import model.Moto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MotoDAO {
    private Connection connection;
    private VehiculoDAO vehiculoDAO;
    
    public MotoDAO(Connection connection) {
        this.connection = connection;
        this.vehiculoDAO = new VehiculoDAO(connection);
    }
    
    // Inserta una nueva moto en la base de datos
    public void insertarMoto(Moto moto) throws SQLException{
        // Inserta la información básica del vehículo en la tabla 'vehiculo' y obtiene el ID generado
        int motoId = vehiculoDAO.insertarVehiculo(moto, "Moto");
        String query = "INSERT INTO moto (idVehiculo, patente, tipoMoto) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, motoId); // Asocia la moto con el ID del vehículo
            stmt.setString(2, moto.getPatente());
            stmt.setString(3, moto.getTipoMoto());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Insertar Moto: "+ex);
        }
    }
    
    // Actualiza la información de una moto existente en la base de datos
    public void actualizarMoto(Moto moto) throws SQLException {
        // Actualiza la información básica del vehículo en la tabla 'vehiculo
        vehiculoDAO.actualizarVehiculo(moto);
        // Actualiza la información específica de la moto en la tabla 'moto'
        String query = "UPDATE moto SET patente = ?, tipoMoto = ? WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, moto.getPatente());
            stmt.setString(2, moto.getTipoMoto());
            stmt.setInt(3, moto.getId());// Usa el ID del vehículo para identificar la moto
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Actualizar Moto: "+ex);
        }
    }
    
    // Elimina una moto de la base de datos
    public void eliminarMoto(int motoId) throws SQLException {
        String query = "DELETE FROM moto WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, motoId);
            stmt.executeUpdate();
        }
    }

}
