package utility.loader;

import java.util.Properties;

/**
 * Interfaz para cargar propiedades desde un archivo.
 * Proporciona un método para cargar un archivo de propiedades y devolverlo como un objeto {@link Properties}.
 */
public interface PropertiesLoader {

    /**
     * Carga las propiedades desde el archivo especificado.
     *
     * @param propertiesFile El nombre del archivo de propiedades.
     * @return Un objeto {@link Properties} que contiene las propiedades cargadas desde el archivo.
     * @throws IllegalArgumentException si no se puede encontrar el archivo de propiedades.
     * @throws RuntimeException si ocurre un error al cargar el archivo de propiedades.
     */
    Properties loadProperties(String propertiesFile);
}
