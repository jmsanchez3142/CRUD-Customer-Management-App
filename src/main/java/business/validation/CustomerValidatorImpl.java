package business.validation;

import business.entity.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * Implementación concreta de CustomerValidator para validar entidades de tipo Customer.
 */
public class CustomerValidatorImpl implements CustomerValidator {

    // Logger para registrar eventos y errores.
    private static final Logger logger = LoggerFactory.getLogger(CustomerValidatorImpl.class);

    // Patrones para validar nombre, correo electrónico y teléfono.
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+( [a-zA-ZñÑáéíóúÁÉÍÓÚ]+)*$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+34|0034|34)?[6789]\\d{8}$");

    /**
     * Valida los datos de un cliente, verificando que el nombre, correo electrónico y teléfono cumplan con los formatos válidos.
     *
     * @param customer El cliente a validar.
     * @throws IllegalArgumentException Si alguno de los campos del cliente no cumple con el formato válido.
     */
    @Override
    public void validate(Customer customer) {
        validateName(customer.getName());
        validateEmail(customer.getEmail());
        validatePhone(customer.getPhone());
    }

    /**
     * Valida el nombre según el patrón NAME_PATTERN.
     *
     * @param name El nombre a validar.
     * @throws IllegalArgumentException Si el nombre no cumple con el formato válido.
     */
    private void validateName(String name) {
        validateField("nombre", name, NAME_PATTERN);
    }

    /**
     * Valida el correo electrónico según el patrón EMAIL_PATTERN.
     *
     * @param email El correo electrónico a validar.
     * @throws IllegalArgumentException Si el correo electrónico no cumple con el formato válido.
     */
    private void validateEmail(String email) {
        validateField("correo electrónico", email, EMAIL_PATTERN);
    }

    /**
     * Valida el teléfono según el patrón PHONE_PATTERN, permitiendo que sea opcional.
     *
     * @param phone El teléfono a validar.
     * @throws IllegalArgumentException Si el teléfono no cumple con el formato válido.
     */
    private void validatePhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            validateField("teléfono", phone, PHONE_PATTERN);
        }
    }

    /**
     * Valida un campo según un patrón específico y lanza una excepción si el campo no cumple con el formato válido.
     *
     * @param fieldName El nombre del campo a validar.
     * @param fieldValue El valor del campo a validar.
     * @param pattern    El patrón de validación.
     * @throws IllegalArgumentException Si el campo no cumple con el formato válido.
     */
    private void validateField(String fieldName, String fieldValue, Pattern pattern) {
        if (!pattern.matcher(fieldValue).matches()) {
            String errorMessage = getInvalidFieldErrorMessage(fieldName, fieldValue);
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Genera un mensaje de error personalizado para un campo inválido.
     *
     * @param fieldName  El nombre del campo inválido.
     * @param fieldValue El valor del campo inválido.
     * @return El mensaje de error personalizado.
     */
    private String getInvalidFieldErrorMessage(String fieldName, String fieldValue) {
        return String.format("El formato del %s es inválido: %s", fieldName, fieldValue);
    }
}