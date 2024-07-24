package repository;

import business.entity.Customer;
import utility.connection.DatabaseConnection;
import utility.logging.LogMessages;
import utility.logging.MessageType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase concreta que implementa la interfaz CustomerDAO para la entidad Customer.
 */
public class CustomerDAOImpl implements CustomerDAO {

    // Logger para registrar eventos y errores.
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDAOImpl.class);

    // Instancia de DatabaseConnection para gestionar las conexiones a la base de datos.
    private final DatabaseConnection dbConnection;

    // Instancia de LogMessages para manejar mensajes de log.
    private final LogMessages<Customer> logMessages;

    /**
     * Construye una instancia de {@link CustomerDAOImpl} con una conexión a la base de datos y un manejador de mensajes de log.
     *
     * @param dbConnection La instancia de {@link DatabaseConnection} utilizada para gestionar las conexiones a la base de datos.
     * @param logMessages  La instancia de {@link LogMessages} utilizada para manejar los mensajes de log.
     */
    public CustomerDAOImpl(DatabaseConnection dbConnection, LogMessages<Customer> logMessages) {
        this.dbConnection = dbConnection;
        this.logMessages = logMessages;
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param customer El objeto {@link Customer} a agregar.
     * @throws IllegalStateException Si ocurre un error durante la operación de inserción.
     */
    @Override
    public void add(Customer customer) {
        String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.executeUpdate();
            LOGGER.info(logMessages.getMessage(MessageType.SUCCESS_ADD, customer));
        } catch (SQLException e) {
            LOGGER.error(logMessages.getMessage(MessageType.ERROR_ADD, customer), e);
            throw new IllegalStateException(logMessages.getMessage(MessageType.ERROR_ADD, customer), e);
        }
    }

    /**
     * Obtiene un cliente de la base de datos por su ID.
     *
     * @param id El ID del cliente a buscar.
     * @return El objeto {@link Customer} correspondiente al ID especificado, o null si no se encuentra.
     * @throws IllegalStateException Si ocurre un error durante la operación de consulta.
     */
    @Override
    public Customer get(String id) {
        String sql = "SELECT * FROM customers WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone")
                    );
                    LOGGER.info(logMessages.getMessage(MessageType.SUCCESS_GET, customer));
                    return customer;
                }
            }
        } catch (SQLException e) {
            LOGGER.error(logMessages.getMessage(MessageType.ERROR_GET_BY_ID, id), e);
            throw new IllegalStateException(logMessages.getMessage(MessageType.ERROR_GET_BY_ID, id), e);
        }

        LOGGER.warn(logMessages.getMessage(MessageType.WARNING_NOT_FOUND, id));
        return null;
    }

    /**
     * Obtiene todos los clientes almacenados en la base de datos.
     *
     * @return Una lista de objetos {@link Customer} que representan todos los clientes almacenados.
     * @throws IllegalStateException Si ocurre un error durante la operación de consulta.
     */
    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                ));
            }
            LOGGER.info(logMessages.getMessage(MessageType.SUCCESS_GET_ALL));
        } catch (SQLException e) {
            LOGGER.error(logMessages.getMessage(MessageType.ERROR_GET_ALL), e);
            throw new IllegalStateException(logMessages.getMessage(MessageType.ERROR_GET_ALL), e);
        }

        return customers;
    }

    /**
     * Actualiza la información de un cliente en la base de datos.
     *
     * @param customer El objeto {@link Customer} con la información actualizada.
     * @throws IllegalStateException Si ocurre un error durante la operación de actualización.
     */
    @Override
    public void update(Customer customer) {
        String sql = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getId());
            stmt.executeUpdate();
            LOGGER.info(logMessages.getMessage(MessageType.SUCCESS_UPDATE, customer));
        } catch (SQLException e) {
            LOGGER.error(logMessages.getMessage(MessageType.ERROR_UPDATE, customer), e);
            throw new IllegalStateException(logMessages.getMessage(MessageType.ERROR_UPDATE, customer), e);
        }
    }

    /**
     * Elimina un cliente de la base de datos por su ID.
     *
     * @param id El ID del cliente a eliminar.
     * @throws IllegalStateException Si ocurre un error durante la operación de eliminación.
     */
    @Override
    public void delete(String id) {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            LOGGER.info(logMessages.getMessage(MessageType.SUCCESS_DELETE, id));
        } catch (SQLException e) {
            LOGGER.error(logMessages.getMessage(MessageType.ERROR_DELETE, id), e);
            throw new IllegalStateException(logMessages.getMessage(MessageType.ERROR_DELETE, id), e);
        }
    }
}
