package business.service;

import repository.CustomerDAO;
import business.entity.Customer;
import business.validation.CustomerValidator;

import java.util.List;

/**
 * Implementación del servicio para la entidad Customer, que proporciona operaciones CRUD y validación.
 */
public class CustomerServiceImpl implements CustomerService {

    // DAO para la persistencia de Customer.
    private final CustomerDAO customerDAO;

    // Validador para validar entidades de tipo Customer.
    private final CustomerValidator customerValidator;

    /**
     * Constructor que inicializa el DAO y el validador para Customer.
     *
     * @param customerDAO        La instancia de CustomerDAO para la persistencia de datos.
     * @param customerValidator  La instancia de CustomerValidator para la validación de datos.
     */
    public CustomerServiceImpl(CustomerDAO customerDAO, CustomerValidator customerValidator) {
        this.customerDAO = customerDAO;
        this.customerValidator = customerValidator;
    }

    /**
     * Añade un nuevo Customer después de validarlo.
     *
     * @param customer El cliente a añadir.
     */
    @Override
    public void add(Customer customer) {
        customerValidator.validate(customer);
        customerDAO.add(customer);
    }

    /**
     * Actualiza un Customer existente después de validarlo.
     *
     * @param customer El cliente a actualizar.
     */
    @Override
    public void update(Customer customer) {
        customerValidator.validate(customer);
        customerDAO.update(customer);
    }

    /**
     * Elimina un Customer dado su ID.
     *
     * @param customerId El ID del cliente a eliminar.
     */
    @Override
    public void delete(String customerId) {
        customerDAO.delete(customerId);
    }

    /**
     * Obtiene un Customer dado su ID.
     *
     * @param customerId El ID del cliente a obtener.
     * @return El cliente con el ID especificado, o null si no se encuentra.
     */
    @Override
    public Customer get(String customerId) {
        return customerDAO.get(customerId);
    }

    /**
     * Obtiene todos los Customers.
     *
     * @return Una lista con todos los clientes.
     */
    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }
}
