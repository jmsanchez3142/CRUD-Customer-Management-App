package utility.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz para manejar la conexión a la base de datos.
 * Proporciona métodos para obtener y cerrar conexiones a la base de datos.
 */
public interface DatabaseConnection {

    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar obtener la conexión.
     */
    Connection getConnection() throws SQLException;

    /**
     * Cierra la conexión a la base de datos.
     *
     * @param connection La conexión a la base de datos que se va a cerrar.
     * @throws SQLException Si ocurre un error al intentar cerrar la conexión.
     */
    void closeConnection(Connection connection) throws SQLException;
}
