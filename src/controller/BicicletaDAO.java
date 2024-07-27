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
    
    public void insertarBicicleta(Bicicleta bici) throws SQLException{
        int biciId = vehiculoDAO.insertarVehiculo(bici, "Bicicleta");
        String query = "INSERT INTO bicicleta (idVehiculo, tipoBici) VALUES (?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, biciId);
            stmt.setString(2, bici.getTipoBici());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Insertar Bicicleta: "+ex);
        }
    }
    
    public void actualizarBicicleta(Bicicleta bici) throws SQLException {
        vehiculoDAO.actualizarVehiculo(bici);
        String query = "UPDATE bicicleta SET tipoBici = ? WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, bici.getTipoBici());
            stmt.setInt(2, bici.getId());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Actualizar Bicicleta: "+ex);
        }
    }
    
    public void eliminarBicicleta(int bicicletaId) throws SQLException {
        String query = "DELETE FROM bicicleta WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bicicletaId);
            stmt.executeUpdate();
        }
    }


}
