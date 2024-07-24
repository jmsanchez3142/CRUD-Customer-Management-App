package utility.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementación de la interfaz {@link PropertiesLoader} para cargar propiedades desde un archivo.
 *
 * <p>Esta implementación incluye un mecanismo de caché para optimizar el rendimiento. Almacena los archivos de
 * propiedades cargados en un mapa concurrente, lo que permite un acceso rápido y seguro a las propiedades ya
 * cargadas, haciendo que la clase sea más eficiente en escenarios de uso frecuente.</p>
 */
public class PropertiesLoaderImpl implements PropertiesLoader {

    // Logger para registrar eventos y errores.
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLoaderImpl.class);

    // Caché para almacenar archivos de propiedades cargados.
    private final Map<String, Properties> propertiesCache = new ConcurrentHashMap<>();

    /**
     * Carga y devuelve las propiedades desde el archivo especificado.
     *
     * <p>Si las propiedades del archivo ya se han cargado anteriormente, se recuperan de la caché en lugar de
     * volver a cargarlas desde el archivo, lo que mejora el rendimiento en escenarios donde se requiere acceder a
     * los mismos archivos de propiedades repetidamente.</p>
     *
     * @param propertiesFile El nombre del archivo de propiedades.
     * @return Un objeto {@link Properties} que contiene las propiedades cargadas desde el archivo.
     * @throws IllegalArgumentException si no se puede encontrar el archivo de propiedades.
     * @throws RuntimeException si ocurre un error al cargar el archivo de propiedades.
     */
    @Override
    public Properties loadProperties(String propertiesFile) {
        // Verifica si las propiedades ya están en caché.
        if (propertiesCache.containsKey(propertiesFile)) {
            return propertiesCache.get(propertiesFile);
        }

        Properties properties = new Properties();

        // Intenta cargar el archivo de propiedades.
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (inputStream == null) {
                String errorMsg = "No se pudo encontrar el archivo de propiedades: " + propertiesFile;
                LOGGER.error(errorMsg);
                throw new IllegalArgumentException(errorMsg);
            }
            properties.load(inputStream);
            // Almacena las propiedades en la caché.
            propertiesCache.put(propertiesFile, properties);
        } catch (IOException e) {
            String errorMsg = "Error al cargar el archivo de propiedades: " + propertiesFile;
            LOGGER.error(errorMsg, e);
            throw new RuntimeException(errorMsg, e);
        }

        return properties;
    }
}
