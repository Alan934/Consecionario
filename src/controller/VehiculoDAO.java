package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Auto;
import model.Vehiculo;
import controller.AutoDAO;
import java.util.ArrayList;
import java.util.List;
import controller.bdConexion;
import java.sql.PreparedStatement;

public class VehiculoDAO {
    private Connection connection;
    private AutoDAO auto;
    
    public VehiculoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public int insertarVehiculo(Vehiculo vehiculo, String tipo) throws SQLException{
        String query = "INSERT INTO Vehiculo (marca, color, modelo, rodado, precio, tipo) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getColor());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getRodado());
            stmt.setDouble(5, vehiculo.getPrecio());
            stmt.setString(6, vehiculo.getTipo());
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    return generatedKeys.getInt(1);
                } else{
                    throw new SQLException("Error al insertar Vehiculo, No se genero ID");
                }
            }
        }
    }
    
    public List<Vehiculo> obtenerVehiculos() throws SQLException {
        String query = "SELECT v.*, a.patente, a.cantidadPuertas " +
                       "FROM vehiculo v " +
                       "LEFT JOIN auto a ON v.id = a.idVehiculo";
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehiculo vehiculo;
                if (rs.getString("tipo").equals("Auto")) {
                    vehiculo = new Auto(
                        rs.getString("patente"),
                        rs.getString("cantidadPuertas"),
                        rs.getString("marca"),
                        rs.getString("color"),
                        rs.getString("modelo"),
                        rs.getInt("rodado"),
                        rs.getDouble("precio"),
                        rs.getString("tipo")
                    );
                    vehiculo.setId(rs.getInt("id"));
                } else {
                    vehiculo = new Vehiculo(
                        rs.getString("marca"),
                        rs.getString("color"),
                        rs.getString("modelo"),
                        rs.getInt("rodado"),
                        rs.getDouble("precio"),
                        rs.getString("tipo")
                    );
                    vehiculo.setId(rs.getInt("id"));
                }
                vehiculos.add(vehiculo);
            }
        }
        return vehiculos;
    }
    
    public void eliminarVehiculo(int vehiculoId) throws SQLException {
        String query = "DELETE FROM Vehiculo WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, vehiculoId);
            stmt.executeUpdate();
        }
    }
    
    public void actualizarVehiculo(Vehiculo vehiculo) throws SQLException {
        String query = "UPDATE Vehiculo SET marca = ?, color = ?, modelo = ?, rodado = ?, precio = ?, tipo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getColor());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getRodado());
            stmt.setDouble(5, vehiculo.getPrecio());
            stmt.setString(6, vehiculo.getTipo());
            stmt.setInt(7, vehiculo.getId());
            stmt.executeUpdate();
        }
    }
}
