package presentation.controller;

/**
 * Interfaz que define los métodos de escucha de eventos para la vista de clientes.
 * Implementada por el controlador para manejar los eventos de la interfaz de usuario.
 */
public interface EntityController {

    /**
     * Maneja el evento cuando se hace clic en el botón "Agregar".
     */
    void onAddButtonClicked();

    /**
     * Maneja el evento cuando se hace clic en el botón "Actualizar".
     */
    void onUpdateButtonClicked();

    /**
     * Maneja el evento cuando se hace clic en el botón "Eliminar".
     */
    void onDeleteButtonClicked();

    /**
     * Maneja el evento cuando se hace clic en el botón "Buscar".
     */
    void onSearchButtonClicked();

    /**
     * Maneja el evento cuando se hace clic en el botón "Aceptar".
     */
    void onAcceptButtonClicked();

    /**
     * Maneja el evento cuando se hace clic en el botón "Cancelar".
     */
    void onCancelButtonClicked();

    /**
     * Maneja el evento cuando se selecciona una fila en la tabla de clientes.
     */
    void onTableRowSelected();
}
