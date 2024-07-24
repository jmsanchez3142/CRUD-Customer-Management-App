import utility.config.AppConfig;
import utility.connection.DatabaseConnection;
import utility.connection.MySQLConnectionImpl;
import utility.loader.PropertiesLoader;
import utility.loader.PropertiesLoaderImpl;
import utility.config.DatabaseConfigLoader;
import utility.config.DatabaseConfigLoaderImpl;

import business.service.CustomerService;
import business.service.CustomerServiceImpl;
import business.entity.Customer;
import utility.logging.LogMessages;
import utility.logging.EntityLogMessagesImpl;
import repository.CustomerDAO;
import repository.CustomerDAOImpl;
import business.validation.CustomerValidator;
import business.validation.CustomerValidatorImpl;

import presentation.view.CustomerView;

import presentation.controller.CustomerControllerImpl;

import javax.swing.SwingUtilities;

/**
 * Clase principal que inicializa y configura la aplicación de gestión de clientes.
 *
 * Características:
 * 1. Diseño de programación orientado a objetos.
 * 2. La lógica de inicialización y configuración se separa en el constructor de la clase `AppMain` y en métodos
 * auxiliares.
 * 3. Las dependencias se inyectan en el constructor de AppMain, mejorando la testabilidad y flexibilidad.
 * 4. El método `main` se encarga únicamente de crear una instancia de AppMain y llamar al método `setupAndShowGUI()`.
 * 5. La separación de responsabilidades entre el método main y los demás métodos sigue mejor el Principio de
 * Responsabilidad Única (SRP).
 * 6. La estructura del código es más modular y fácil de mantener a medida que la aplicación crece.
 */
public class AppMain {
    /**
     * Conexión a la base de datos utilizada por la aplicación.
     */
    private final DatabaseConnection dbConnection;

    /**
     * Servicio de cliente que maneja la lógica de negocio relacionada con los clientes.
     */
    private final CustomerService customerService;

    /**
     * Vista de cliente que maneja la interfaz de usuario.
     */
    private final CustomerView customerView;

    /**
     * Constructor que inicializa la configuración de la aplicación.
     * Crea la conexión a la base de datos, el servicio de cliente y la vista de cliente.
     */
    public AppMain() {
        String propertiesFileName = AppConfig.DATABASE_PROPERTIES_FILE;
        dbConnection = createDatabaseConnection(propertiesFileName);
        customerService = initializeCustomerService(dbConnection);
        customerView = initializeCustomerView();
    }

    /**
     * Punto de entrada principal de la aplicación.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppMain appMain = new AppMain();
            appMain.setupAndShowGUI();
        });
    }

    /**
     * Método para crear y devolver una conexión a la base de datos MySQL.
     *
     * @param propertiesFileName Nombre del archivo de propiedades para la configuración de la base de datos.
     * @return Una instancia de DatabaseConnection que representa la conexión a la base de datos MySQL.
     */
    private DatabaseConnection createDatabaseConnection(String propertiesFileName) {
        PropertiesLoader propertiesLoader = new PropertiesLoaderImpl();
        DatabaseConfigLoader configLoader = new DatabaseConfigLoaderImpl(propertiesLoader, propertiesFileName);
        return new MySQLConnectionImpl(configLoader);
    }

    /**
     * Método para inicializar el servicio de cliente.
     *
     * @param dbConnection La conexión a la base de datos a utilizar por el servicio de cliente.
     * @return Una instancia de CustomerService inicializada y lista para su uso.
     */
    private CustomerService initializeCustomerService(DatabaseConnection dbConnection) {
        LogMessages<Customer> daoLogMessages = new EntityLogMessagesImpl<>();
        CustomerDAO customerDAO = new CustomerDAOImpl(dbConnection, daoLogMessages);
        CustomerValidator customerValidator = new CustomerValidatorImpl();
        return new CustomerServiceImpl(customerDAO, customerValidator);
    }

    /**
     * Método para inicializar la vista de cliente.
     *
     * @return Una instancia de CustomerView inicializada y lista para su uso.
     */
    private CustomerView initializeCustomerView() {
        return new CustomerView();
    }

    /**
     * Método para configurar y mostrar la interfaz de usuario.
     */
    private void setupAndShowGUI() {
        LogMessages<Customer> logMessages = new EntityLogMessagesImpl<>();
        new CustomerControllerImpl(customerService, customerView, logMessages);
        customerView.setVisible(true);
    }
}
