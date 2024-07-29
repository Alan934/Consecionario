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
import model.Bicicleta;
import model.Camioneta;
import model.Cliente;
import model.Moto;

public class VehiculoDAO {
    private Connection connection;
    private AutoDAO auto;
    
    public VehiculoDAO(Connection connection) {
        this.connection = connection;
    }
    
    // Inserta un nuevo vehículo en la base de dato
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
             // clave para el nuevo vehículo
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    return generatedKeys.getInt(1);
                } else{
                    throw new SQLException("Error al insertar Vehiculo, No se genero ID");
                }
            }
        }
    }
    
    // Obtiene todos los vehículos de la base de datos, incluyendo detalles específicos de cada tipo
    public List<Vehiculo> obtenerVehiculos() throws SQLException {
        String query = "SELECT v.*, a.patente AS auto_patente, a.cantidadPuertas, " +
                       "m.patente AS moto_patente, m.tipoMoto, " +
                       "c.patente AS camioneta_patente, c.carga, " +
                       "b.tipoBici " +
                       "FROM vehiculo v " +
                       "LEFT JOIN auto a ON v.id = a.idVehiculo " +
                       "LEFT JOIN moto m ON v.id = m.idVehiculo " +
                       "LEFT JOIN camioneta c ON v.id = c.idVehiculo " +
                       "LEFT JOIN bicicleta b ON v.id = b.idVehiculo";

        List<Vehiculo> vehiculos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehiculo vehiculo;
                String tipo = rs.getString("tipo");

                // Crea el objeto Vehiculo según el tipo
                switch (tipo) {
                    case "Auto":
                        vehiculo = new Auto(
                            rs.getString("auto_patente"),
                            rs.getInt("cantidadPuertas"),
                            rs.getString("marca"),
                            rs.getString("color"),
                            rs.getString("modelo"),
                            rs.getInt("rodado"),
                            rs.getDouble("precio"),
                            tipo
                        );
                        break;
                    case "Moto":
                        vehiculo = new Moto(
                            rs.getString("moto_patente"),
                            rs.getString("tipoMoto"),
                            rs.getString("marca"),
                            rs.getString("color"),
                            rs.getString("modelo"),
                            rs.getInt("rodado"),
                            rs.getDouble("precio"),
                            tipo
                        );
                        break;
                    case "Camioneta":
                        vehiculo = new Camioneta(
                            rs.getString("camioneta_patente"),
                            rs.getDouble("carga"),
                            rs.getString("marca"),
                            rs.getString("color"),
                            rs.getString("modelo"),
                            rs.getInt("rodado"),
                            rs.getDouble("precio"),
                            tipo
                        );
                        break;
                    case "Bicicleta":
                        vehiculo = new Bicicleta(
                            rs.getString("tipoBici"),
                            rs.getString("marca"),
                            rs.getString("color"),
                            rs.getString("modelo"),
                            rs.getInt("rodado"),
                            rs.getDouble("precio"),
                            tipo
                        );
                        break;
                    default:
                        vehiculo = new Vehiculo(
                            rs.getString("marca"),
                            rs.getString("color"),
                            rs.getString("modelo"),
                            rs.getInt("rodado"),
                            rs.getDouble("precio"),
                            tipo
                        );
                }
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setEstado(rs.getString("estado"));
                vehiculos.add(vehiculo);
            }
        }
        return vehiculos;
    }
    
    // Elimina un vehículo de la base de datos según su ID
    public void eliminarVehiculo(int vehiculoId) throws SQLException {
        String query = "DELETE FROM vehiculo WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, vehiculoId);
            stmt.executeUpdate();
        }
    }
    
    // Actualiza los datos de un vehículo en la base de datos
    public void actualizarVehiculo(Vehiculo vehiculo) throws SQLException {
        String query = "UPDATE vehiculo SET marca = ?, color = ?, modelo = ?, rodado = ?, precio = ?, tipo = ?, estado = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getColor());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getRodado());
            stmt.setDouble(5, vehiculo.getPrecio());
            stmt.setString(6, vehiculo.getTipo());
            stmt.setString(7, vehiculo.getEstado());
            stmt.setInt(8, vehiculo.getId());
            stmt.executeUpdate();
        }
    }
    
    // Obtiene un vehículo por su ID
    public Vehiculo obtenerVehiculoPorId(int idVehiculo) {
        Vehiculo vehiculo = null;
        String query = "SELECT * FROM vehiculo WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVehiculo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tipo = resultSet.getString("tipo");
                String marca = resultSet.getString("marca");
                String color = resultSet.getString("color");
                String modelo = resultSet.getString("modelo");
                int rodado = resultSet.getInt("rodado");
                double precio = resultSet.getDouble("precio");

                switch (tipo) {
                    case "Auto":
                        vehiculo = obtenerAutoPorId(idVehiculo, marca, color, modelo, rodado, precio);
                        break;
                    case "Moto":
                        vehiculo = obtenerMotoPorId(idVehiculo, marca, color, modelo, rodado, precio);
                        break;
                    case "Bicicleta":
                        vehiculo = obtenerBicicletaPorId(idVehiculo, marca, color, modelo, rodado, precio);
                        break;
                    case "Camioneta":
                        vehiculo = obtenerCamionetaPorId(idVehiculo, marca, color, modelo, rodado, precio);
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Obtener Vehiculo Por ID: " + e);
        } 
        return vehiculo;
    }

    // Obtiene los datos de un auto específico por su ID
    private Auto obtenerAutoPorId(int idVehiculo, String marca, String color, String modelo, int rodado, double precio) throws SQLException {
        Auto auto = null;
        String query = "SELECT * FROM auto WHERE idVehiculo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVehiculo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String patente = resultSet.getString("patente");
                int cantidadPuertas = resultSet.getInt("cantidadPuertas");
                auto = new Auto(idVehiculo, patente, cantidadPuertas, marca, color, modelo, rodado, precio, "Auto");
            }
        } catch (SQLException e) {
            System.out.println("Obtener Auto Por ID: " + e);
        }
        return auto;
    }

    // Obtiene los datos de una moto específica por su ID
    private Moto obtenerMotoPorId(int idVehiculo, String marca, String color, String modelo, int rodado, double precio) throws SQLException {
        Moto moto = null;
        String query = "SELECT * FROM moto WHERE idVehiculo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVehiculo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String patente = resultSet.getString("patente");
                String tipoMoto = resultSet.getString("tipoMoto");
                moto = new Moto(idVehiculo, patente, tipoMoto, marca, color, modelo, rodado, precio, "Moto");
            }
        } catch (SQLException e) {
            System.out.println("Obtener Moto Por ID: " + e);
        }
        return moto;
    }

    // Obtiene los datos de una bicicleta específica por su ID
    private Bicicleta obtenerBicicletaPorId(int idVehiculo, String marca, String color, String modelo, int rodado, double precio) throws SQLException {
        Bicicleta bicicleta = null;
        String query = "SELECT * FROM bicicleta WHERE idVehiculo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVehiculo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tipoBici = resultSet.getString("tipoBici");
                bicicleta = new Bicicleta(idVehiculo, tipoBici, marca, color, modelo, rodado, precio, "Bicicleta");
            }
        } catch (SQLException e) {
            System.out.println("Obtener Bicicleta Por ID: " + e);
        }
        return bicicleta;
    }

    // Obtiene los datos de una camioneta específica por su ID
    private Camioneta obtenerCamionetaPorId(int idVehiculo, String marca, String color, String modelo, int rodado, double precio) throws SQLException {
        Camioneta camioneta = null;
        String query = "SELECT * FROM camioneta WHERE idVehiculo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVehiculo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String patente = resultSet.getString("patente");
                double carga = resultSet.getDouble("carga");
                camioneta = new Camioneta(idVehiculo, patente, carga, marca, color, modelo, rodado, precio, "Camioneta");
            }
        } catch (SQLException e) {
            System.out.println("Obtener Camioneta Por ID: " + e);
        }
        return camioneta;
    }
    
    // Marca un vehículo como vendido, asignándolo a un cliente
    public boolean venderVehiculo(int idVehiculo, int idCliente) {
        String query = "UPDATE vehiculo SET estado = 'Vendido', idCliente = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idVehiculo);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Error al vender el vehículo: " + e.getMessage());
            return false;
        }
    }
    
}
