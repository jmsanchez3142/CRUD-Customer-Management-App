package business.service;

import business.entity.Customer;

/**
 * Interfaz específica para definir operaciones de servicio relacionadas con entidades de Customer.
 * Extiende la interfaz {@link GenericService} parametrizada con {@link Customer}.
 */
public interface CustomerService extends GenericService<Customer> {

    /**
     * Esta interfaz no define métodos adicionales específicos para la entidad Customer en este momento.
     * Se utiliza para proporcionar operaciones estándar CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad Customer.
     */

}
