package repository;

import business.entity.Customer;

/**
 * Interfaz para acceder a los datos de Customer en la capa de persistencia.
 * Extiende la interfaz {@link GenericDAO} parametrizada con {@link Customer}.
 */
public interface CustomerDAO extends GenericDAO<Customer> {

    /**
     * Esta interfaz no define métodos adicionales específicos para la entidad Customer en este momento.
     * Se utiliza para proporcionar operaciones estándar CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad Customer.
     */
}
