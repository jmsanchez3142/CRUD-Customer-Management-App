package business.validation;

import business.entity.Customer;

/**
 * Interfaz para validar entidades de tipo Customer.
 * Extiende la interfaz {@link GenericValidator} para proporcionar validación genérica para la entidad Customer.
 */
public interface CustomerValidator extends GenericValidator<Customer> {

    /**
     * Esta interfaz no define métodos adicionales específicos para la entidad Customer en este momento.
     * Se utiliza para proporcionar validación genérica para la entidad Customer.
     */
}
