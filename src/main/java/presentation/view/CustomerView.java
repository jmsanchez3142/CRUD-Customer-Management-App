package presentation.view;

import business.entity.Customer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;

/**
 * Clase que gestiona la vista de clientes, incluyendo campos de entrada, botones y una tabla para mostrar datos.
 */
public class CustomerView extends JFrame {
    private static final String[] COLUMN_NAMES = {"ID", "Name", "Email", "Teléfono"};

    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton acceptButton;
    private JButton cancelButton;
    private JTable customerTable;
    private JScrollPane customerScrollPane;
    private DefaultTableModel tableModel;

    /**
     * Método constructor para inicializar los componentes y configurar el marco.
     */
    public CustomerView() {
        initializeComponents();
        configureFrame();
    }

    /**
     * Inicializa los componentes necesarios para la vista del cliente.
     */
    private void initializeComponents() {
        initializeTableModel();
        // Otras configuraciones de componentes pueden ir aquí.
    }

    /**
     * Inicializa el modelo de la tabla de clientes y lo asigna a la tabla.
     */
    private void initializeTableModel() {
        tableModel = new DefaultTableModel(COLUMN_NAMES, 0);
        customerTable.setModel(tableModel);
    }

    /**
     * Configura las propiedades del marco (JFrame).
     */
    private void configureFrame() {
        setTitle("Gestión de Restaurantes");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Obtiene la tabla de clientes.
     * @return JTable de clientes.
     */
    public JTable getCustomerTable() {
        return customerTable;
    }

    /**
     * Obtiene el campo de ID.
     * @return JTextField de ID.
     */
    public JTextField getIdField() {
        return idField;
    }

    /**
     * Obtiene el campo de nombre.
     * @return JTextField de nombre.
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * Obtiene el campo de email.
     * @return JTextField de email.
     */
    public JTextField getEmailField() {
        return emailField;
    }

    /**
     * Obtiene el campo de teléfono.
     * @return JTextField de teléfono.
     */
    public JTextField getPhoneField() {
        return phoneField;
    }

    /**
     * Obtiene el botón de agregar.
     * @return JButton de agregar.
     */
    public JButton getAddButton() {
        return addButton;
    }

    /**
     * Obtiene el botón de actualizar.
     * @return JButton de actualizar.
     */
    public JButton getUpdateButton() {
        return updateButton;
    }

    /**
     * Obtiene el botón de eliminar.
     * @return JButton de eliminar.
     */
    public JButton getDeleteButton() {
        return deleteButton;
    }

    /**
     * Obtiene el botón de buscar.
     * @return JButton de buscar.
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * Obtiene el botón de aceptar.
     * @return JButton de aceptar.
     */
    public JButton getAcceptButton() {
        return acceptButton;
    }

    /**
     * Obtiene el botón de cancelar.
     * @return JButton de cancelar.
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    /**
     * Agrega un cliente a la tabla de clientes.
     * @param customer Cliente a agregar.
     */
    public void addCustomerToTable(Customer customer) {
        tableModel.addRow(new Object[]{
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone()
        });
    }

    /**
     * Limpia todos los datos de la tabla de clientes.
     */
    public void clearTable() {
        tableModel.setRowCount(0);
    }

    /**
     * Puebla los campos de entrada con la información del cliente proporcionada.
     * @param customer Cliente para poblar los campos.
     */
    public void populateFields(Customer customer) {
        idField.setText(customer.getId());
        nameField.setText(customer.getName());
        emailField.setText(customer.getEmail());
        phoneField.setText(customer.getPhone());
    }

    /**
     * Limpia todos los campos de entrada de datos.
     */
    public void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }

    /**
     * Establece la editabilidad de los campos de entrada.
     * @param id Si el campo de ID debe ser editable.
     * @param name Si el campo de nombre debe ser editable.
     * @param email Si el campo de email debe ser editable.
     * @param phone Si el campo de teléfono debe ser editable.
     */
    public void setFieldsEditable(boolean id, boolean name, boolean email, boolean phone) {
        idField.setEditable(id);
        nameField.setEditable(name);
        emailField.setEditable(email);
        phoneField.setEditable(phone);
    }

    /**
     * Establece el estado de los botones en la vista.
     * @param add Estado del botón Agregar.
     * @param update Estado del botón Actualizar.
     * @param delete Estado del botón Eliminar.
     * @param search Estado del botón Buscar.
     * @param accept Estado del botón Aceptar.
     * @param cancel Estado del botón Cancelar.
     */
    public void setButtonsState(boolean add, boolean update, boolean delete, boolean search, boolean accept, boolean cancel) {
        addButton.setEnabled(add);
        updateButton.setEnabled(update);
        deleteButton.setEnabled(delete);
        searchButton.setEnabled(search);
        acceptButton.setEnabled(accept);
        cancelButton.setEnabled(cancel);
    }

    /**
     * Restablece los campos y botones a su estado por defecto.
     */
    public void resetToDefaultState() {
        setFieldsEditable(false, false, false, false);
        setButtonsState(true, false, false, true, false, false);
    }

    /**
     * Restablece los campos para búsqueda de cliente o fila seleccionada.
     */
    public void resetSearchCustomerOrSelectedRow() {
        setFieldsEditable(false, true, true, true);
        setButtonsState(false, true, true, false, false, true);
    }

    /**
     * Prepara la vista para agregar o buscar cliente.
     * @param isAddMode True si es modo de agregar, false si es búsqueda.
     */
    public void resetPrepareForAddOrSearchCustomer(boolean isAddMode) {
        setFieldsEditable(!isAddMode, isAddMode, isAddMode, isAddMode);
        setButtonsState(false, false, false, false, true, true);
    }

    /**
     * Método principal para iniciar la aplicación.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerView().setVisible(true));
    }

    /**
     * Obtiene un cliente de la fila seleccionada en la tabla.
     *
     * @param selectedRow La fila seleccionada en la tabla.
     * @return El cliente correspondiente a la fila seleccionada.
     */
    public Customer getCustomerFromSelectedRow(int selectedRow) {
        String id = (String) this.getCustomerTable().getValueAt(selectedRow, 0);
        String name = (String) this.getCustomerTable().getValueAt(selectedRow, 1);
        String email = (String) this.getCustomerTable().getValueAt(selectedRow, 2);
        String phone = (String) this.getCustomerTable().getValueAt(selectedRow, 3);
        return new Customer(id, name, email, phone);
    }

    /**
     * Obtiene un cliente de los campos de la vista.
     *
     * @return El cliente con los datos ingresados en la vista.
     */
    public Customer getCustomerFromView() {
        return new Customer(
                this.getIdField().getText(),
                this.getNameField().getText(),
                this.getEmailField().getText(),
                this.getPhoneField().getText()
        );
    }
}
