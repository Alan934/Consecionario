package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Persona;
import model.Cliente;
import model.Empleado;
import javax.swing.JOptionPane;

public class PersonaDAO {
    private Connection connection;

    public PersonaDAO(Connection connection) {
        this.connection = connection;
    }
    
    // Inserta una nueva persona en la base de datos y retorna el ID generado. tipo: cliente o empleado
    public int insertarPersona(Persona persona, String tipo) throws SQLException {
        String query = "INSERT INTO Persona (nombre, apellido, dni, contrasena, tipo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getDni());
            stmt.setString(4, persona.getContrasena());
            stmt.setString(5, tipo);
            stmt.executeUpdate();
            
            // Obtiene la clave generada para la nueva persona
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Error al insertar la persona, no se generó ID.");
                }
            }
        }
    }
    
    // Inserta un nuevo empleado en la base de datos
    public void insertarEmpleado(Empleado empleado) throws SQLException {
        int personaId = insertarPersona(empleado, "Empleado");
        String query = "INSERT INTO Empleado (idPersona, sueldo) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, personaId);
            stmt.setDouble(2, empleado.getSueldo());
            stmt.executeUpdate();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    // Inserta un nuevo cliente en la base de datos
    public void insertarCliente(Cliente cliente) throws SQLException {
        int personaId = insertarPersona(cliente, "Cliente");
        String query = "INSERT INTO Cliente (idPersona) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, personaId);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    // Inicia sesión para una persona con el DNI y contraseña proporcionados
    public Persona iniciarSesion(String dni, String contrasena) throws SQLException {
            String query = "SELECT p.*, c.id AS cliente_id " +
                   "FROM persona p " +
                   "LEFT JOIN cliente c ON p.id = c.idPersona " +
                   "WHERE p.dni = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dni);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String contrasenaAlmacenada = rs.getString("contrasena");
                    // Verifica si la contraseña es correcta
                    if (contrasenaAlmacenada.equals(contrasena)) {
                        String tipo = rs.getString("tipo");
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String dniPersona = rs.getString("dni");
                        // Crea el objeto correspondiente según el tipo de persona
                        if ("Empleado".equals(tipo)) {
                            double sueldo = obtenerSueldo(rs.getInt("id"));
                            return new Empleado(nombre, apellido, dniPersona, sueldo, contrasena);
                        } else if ("Cliente".equals(tipo)) {
                            int idCliente = rs.getInt("cliente_id");
                            return new Cliente(idCliente, nombre, apellido, dniPersona, contrasena);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "DNI no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return null;
    }    
    
    // Obtiene el sueldo de un empleado por su ID de persona
    private double obtenerSueldo(int personaId) throws SQLException {
        String query = "SELECT sueldo FROM Empleado WHERE idPersona = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, personaId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("sueldo");
                } else {
                    throw new SQLException("Sueldo no encontrado para el empleado con ID: " + personaId);
                }
            }
        }
    }
}
