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
    
    public void insertarMoto(Moto moto) throws SQLException{
        int motoId = vehiculoDAO.insertarVehiculo(moto, "Moto");
        String query = "INSERT INTO moto (idVehiculo, patente, tipoMoto) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, motoId);
            stmt.setString(2, moto.getPatente());
            stmt.setString(3, moto.getTipoMoto());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Insertar Moto: "+ex);
        }
    }
    
    public void actualizarMoto(Moto moto) throws SQLException {
        vehiculoDAO.actualizarVehiculo(moto);
        String query = "UPDATE moto SET patente = ?, tipoMoto = ? WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, moto.getPatente());
            stmt.setString(2, moto.getTipoMoto());
            stmt.setInt(3, moto.getId());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Actualizar Moto: "+ex);
        }
    }
    
    public void eliminarMoto(int motoId) throws SQLException {
        String query = "DELETE FROM moto WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, motoId);
            stmt.executeUpdate();
        }
    }

}
