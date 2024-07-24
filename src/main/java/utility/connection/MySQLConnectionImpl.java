package utility.connection;

import utility.config.DatabaseConfigLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Implementación de la interfaz {@link DatabaseConnection} para manejar la conexión a una base de datos MySQL.
 */
public class MySQLConnectionImpl implements DatabaseConnection {

    // Logger para registrar eventos y errores.
    private static final Logger logger = LoggerFactory.getLogger(MySQLConnectionImpl.class);

    // Cargador de configuración de la base de datos para obtener los detalles necesarios para la conexión.
    private final DatabaseConfigLoader databaseConfigLoader;

    /**
     * Constructor que inicializa el cargador de configuración de la base de datos.
     *
     * @param databaseConfigLoader El cargador de configuración de la base de datos.
     */
    public MySQLConnectionImpl(DatabaseConfigLoader databaseConfigLoader) {
        this.databaseConfigLoader = databaseConfigLoader;
    }

    /**
     * Obtiene una conexión a la base de datos MySQL utilizando la configuración proporcionada.
     *
     * @return Una conexión a la base de datos MySQL.
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    @Override
    public Connection getConnection() throws SQLException {
        String url = databaseConfigLoader.getDatabaseUrl() + "?" + databaseConfigLoader.getDatabaseOptions();
        String username = databaseConfigLoader.getDatabaseUsername();
        String password = databaseConfigLoader.getDatabasePassword();
        String driverClassName = databaseConfigLoader.getDatabaseDriverClassName();

        try {
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            String errorMsg = "No se encontró el controlador JDBC: " + driverClassName;
            logger.error(errorMsg, e);
            throw new SQLException(errorMsg, e);
        } catch (SQLException e) {
            String errorMsg = "Error al obtener la conexión a la base de datos.";
            logger.error(errorMsg, e);
            throw new SQLException(errorMsg, e);
        }
    }

    /**
     * Cierra la conexión a la base de datos.
     *
     * @param connection La conexión a la base de datos que se va a cerrar.
     * @throws SQLException Si ocurre un error al cerrar la conexión.
     */
    @Override
    public void closeConnection(Connection connection) throws SQLException {
        if (connection == null || connection.isClosed()) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            String errorMsg = "Error al cerrar la conexión a la base de datos.";
            logger.error(errorMsg, e);
            throw new SQLException(errorMsg, e);
        }
    }
}
