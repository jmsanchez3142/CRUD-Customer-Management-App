package utility.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Implementación de la interfaz {@link PropertiesLoader} para cargar propiedades desde un archivo.
 */
public class PropertiesLoaderImplOld implements PropertiesLoader {

    // Logger para registrar eventos y errores.
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLoaderImplOld.class);

    /**
     * Carga y devuelve las propiedades desde el archivo especificado.
     *
     * @param propertiesFile El nombre del archivo de propiedades.
     * @return Un objeto {@link Properties} que contiene las propiedades cargadas desde el archivo.
     * @throws IllegalArgumentException si no se puede encontrar el archivo de propiedades.
     * @throws RuntimeException si ocurre un error al cargar el archivo de propiedades.
     */
    @Override
    public Properties loadProperties(String propertiesFile) {
        Properties properties = new Properties();

        // Intenta cargar el archivo de propiedades.
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (inputStream == null) {
                String errorMsg = "No se pudo encontrar el archivo de propiedades: " + propertiesFile;
                LOGGER.error(errorMsg);
                throw new IllegalArgumentException(errorMsg);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            String errorMsg = "Error al cargar el archivo de propiedades: " + propertiesFile;
            LOGGER.error(errorMsg, e);
            throw new RuntimeException(errorMsg, e);
        }

        return properties;
    }
}
