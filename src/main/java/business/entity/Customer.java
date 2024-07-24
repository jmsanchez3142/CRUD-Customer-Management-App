package business.entity;

/**
 * Clase que representa a un cliente en el sistema.
 */
public class Customer {

    // Identificador único del cliente.
    private String id;

    // Nombre del cliente.
    private String name;

    // Correo electrónico del cliente.
    private String email;

    // Número de teléfono del cliente.
    private String phone;

    /**
     * Constructor que inicializa todos los atributos de un cliente.
     *
     * @param id    Identificador único del cliente.
     * @param name  Nombre del cliente.
     * @param email Correo electrónico del cliente.
     * @param phone Número de teléfono del cliente.
     */
    public Customer(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return El identificador único del cliente.
     */
    public String getId() {
        return id;
    }

    /**
     * Actualiza el identificador único del cliente.
     *
     * @param id El nuevo identificador único del cliente.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Actualiza el nombre del cliente.
     *
     * @param name El nuevo nombre del cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return El correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Actualiza el correo electrónico del cliente.
     *
     * @param email El nuevo correo electrónico del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return El número de teléfono del cliente.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Actualiza el número de teléfono del cliente.
     *
     * @param phone El nuevo número de teléfono del cliente.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Representa el objeto como una cadena de texto de forma legible.
     *
     * @return Una representación de cadena del objeto Cliente.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
