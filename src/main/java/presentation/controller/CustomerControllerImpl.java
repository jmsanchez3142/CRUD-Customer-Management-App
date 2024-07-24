package presentation.controller;

import presentation.view.CustomerView;
import business.entity.Customer;
import business.service.CustomerService;
import utility.logging.MessageType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.logging.LogMessages;

import javax.swing.JOptionPane;
import java.util.List;

/**
 * Controlador que maneja la lógica de negocio entre la vista (CustomerView) y el modelo (CustomerService).
 * Se encarga de gestionar los eventos de la interfaz de usuario y actualizar la vista según sea necesario.
 */
public class CustomerControllerImpl implements EntityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerImpl.class);

    private final CustomerService customerService;
    private final CustomerView customerView;
    private final LogMessages<Customer> logMessages;

    /**
     * Constructor que inicializa el servicio de clientes, la vista de clientes y los mensajes de log.
     *
     * @param customerService El servicio que maneja la lógica de negocio de los clientes.
     * @param customerView La vista que muestra la interfaz de usuario para los clientes.
     * @param logMessages Los mensajes de log específicos para la entidad Customer.
     */
    public CustomerControllerImpl(CustomerService customerService, CustomerView customerView, LogMessages<Customer> logMessages) {
        this.customerService = customerService;
        this.customerView = customerView;
        this.logMessages = logMessages;
        initializeController();
    }

    /**
     * Inicializa el controlador configurando los listeners y cargando los datos iniciales.
     */
    private void initializeController() {
        configureButtonListeners();
        configureTableListener();
        loadEntities();
        customerView.resetToDefaultState();
    }

    /**
     * Configura los listeners de los botones de la vista.
     */
    private void configureButtonListeners() {
        customerView.getAddButton().addActionListener(event -> onAddButtonClicked());
        customerView.getUpdateButton().addActionListener(event -> onUpdateButtonClicked());
        customerView.getDeleteButton().addActionListener(event -> onDeleteButtonClicked());
        customerView.getSearchButton().addActionListener(event -> onSearchButtonClicked());
        customerView.getAcceptButton().addActionListener(event -> onAcceptButtonClicked());
        customerView.getCancelButton().addActionListener(event -> onCancelButtonClicked());
    }

    /**
     * Configura el listener de la selección de filas en la tabla de clientes.
     */
    private void configureTableListener() {
        customerView.getCustomerTable().getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                onTableRowSelected();
            }
        });
    }

    /**
     * Carga los datos de los clientes desde el servicio y los muestra en la tabla de la vista.
     */
    private void loadEntities() {
        try {
            List<Customer> customers = customerService.getAll();
            customerView.clearTable();
            for (Customer customer : customers) {
                customerView.addCustomerToTable(customer);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.ERROR_GET_ALL) + ": " + e.getMessage());
        }
    }

    /**
     * Acción que ocurre cuando se hace clic en el botón "Agregar".
     * Limpia los campos y prepara la vista para agregar un nuevo cliente.
     */
    @Override
    public void onAddButtonClicked() {
        customerView.clearFields();
        customerView.resetPrepareForAddOrSearchCustomer(true);
    }

    /**
     * Acción que ocurre cuando se hace clic en el botón "Buscar".
     * Limpia los campos y prepara la vista para buscar un cliente.
     */
    @Override
    public void onSearchButtonClicked() {
        customerView.clearFields();
        customerView.resetPrepareForAddOrSearchCustomer(false);
    }

    /**
     * Acción que ocurre cuando se hace clic en el botón "Aceptar".
     * Determina si debe agregar o buscar un cliente basado en el estado de los campos.
     */
    @Override
    public void onAcceptButtonClicked() {
        if (customerView.getIdField().isEditable()) {
            searchCustomer();
        } else {
            addCustomer();
        }
    }

    /**
     * Acción que ocurre cuando se hace clic en el botón "Cancelar".
     * Limpia los campos y restablece la vista al estado predeterminado.
     */
    @Override
    public void onCancelButtonClicked() {
        customerView.clearFields();
        customerView.resetToDefaultState();

        if (!customerView.getIdField().isEditable()) {
            loadEntities();
        }
    }

    /**
     * Agrega un nuevo cliente a través del servicio y actualiza la vista.
     */
    private void addCustomer() {
        try {
            Customer customer = customerView.getCustomerFromView();
            customerService.add(customer);
            loadEntities();
            customerView.clearFields();
            customerView.resetToDefaultState();
            JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.SUCCESS_ADD, customer));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.ERROR_ADD, customerView.getCustomerFromView()) + ": " + e.getMessage());
        }
    }

    /**
     * Acción que ocurre cuando se hace clic en el botón "Actualizar".
     * Actualiza la información de un cliente existente a través del servicio y actualiza la vista.
     */
    @Override
    public void onUpdateButtonClicked() {
        try {
            Customer customer = customerView.getCustomerFromView();
            customerService.update(customer);
            loadEntities();
            customerView.clearFields();
            customerView.resetToDefaultState();
            JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.SUCCESS_UPDATE, customer));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.ERROR_UPDATE, customerView.getCustomerFromView()) + ": " + e.getMessage());
        }
    }

    /**
     * Acción que ocurre cuando se hace clic en el botón "Eliminar".
     * Elimina un cliente a través del servicio y actualiza la vista.
     */
    @Override
    public void onDeleteButtonClicked() {
        try {
            String customerId = customerView.getIdField().getText();
            customerService.delete(customerId);
            loadEntities();
            customerView.clearFields();
            customerView.resetToDefaultState();
            JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.SUCCESS_DELETE, customerId));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.ERROR_DELETE, customerView.getIdField().getText()) + ": " + e.getMessage());
        }
    }

    /**
     * Busca un cliente por su ID y actualiza la vista con los datos del cliente encontrado.
     */
    private void searchCustomer() {
        try {
            String customerId = customerView.getIdField().getText();
            Customer customer = customerService.get(customerId);
            if (customer != null) {
                customerView.clearTable();
                customerView.addCustomerToTable(customer);
                customerView.populateFields(customer);
                customerView.resetSearchCustomerOrSelectedRow();
                JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.SUCCESS_GET, customer));
            } else {
                JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.WARNING_NOT_FOUND, customerId));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(customerView, logMessages.getMessage(MessageType.ERROR_GET_BY_ID, customerView.getIdField().getText()) + ": " + e.getMessage());
        }
    }

    /**
     * Acción que ocurre cuando se selecciona una fila en la tabla.
     * Actualiza los campos de la vista con los datos del cliente seleccionado.
     */
    @Override
    public void onTableRowSelected() {
        int selectedRow = customerView.getCustomerTable().getSelectedRow();
        if (selectedRow >= 0) {
            Customer customer = customerView.getCustomerFromSelectedRow(selectedRow);
            customerView.populateFields(customer);
            customerView.resetSearchCustomerOrSelectedRow();
        }
    }
}
