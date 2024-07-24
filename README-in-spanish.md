[![English Language](doc/images/English-Language.png)](README.md)
# Aplicación CRUD de gestión de clientes

## Comentarios, Sugerencias y Contribuciones

Soy un estudiante autodidacta que está dando sus primeros pasos en el mundo de la programación. Esta aplicación forma parte de mi proceso de aprendizaje y práctica para desarrollar habilidades en Java, diseño de interfaces gráficas, manejo de bases de datos y aplicación de buenas prácticas de programación.

Mi objetivo al publicar este proyecto en GitHub es recibir retroalimentación y orientación de la comunidad de desarrolladores para mejorar mis habilidades y conocimientos. Estoy abierto a **comentarios, sugerencias y contribuciones** sobre la implementación de mejores prácticas, principios, patrones de diseño y arquitectura. Tu retroalimentación es invaluable para mejorar la calidad del código y la aplicación en general.

Agradezco de antemano la paciencia y el apoyo de la comunidad mientras continúo mi viaje de aprendizaje autodidacta. Espero que este proyecto sea el primero de muchos más a medida que avanzo en mi carrera como desarrollador de software.

## Descripción General

La **CRUD-Customer-Management-App** es una aplicación de escritorio desarrollada con fines educativos que permite a
los usuarios gestionar una tabla de clientes en una base de datos MySQL a través de una interfaz gráfica de usuario (GUI) creada con Swing.

## Objetivos

- **Proporcionar una interfaz fácil de usar** para la gestión de registros de clientes.
- **Implementar las operaciones CRUD** (Crear, Leer, Actualizar, Eliminar) para los registros de clientes.
- **Demostrar buenas prácticas de programación orientada a objetos en Java.**
- **Aplicar los principios SOLID** para asegurar un código limpio, mantenible y escalable.
- **Utilizar un framework de logging maduro** para el seguimiento y depuración de eventos.

## Principales Características

- **Agregar Nuevos Registros:** Permite a los usuarios añadir nuevos clientes a la base de datos, ingresando información como nombre, email y teléfono.
- **Ver Lista de Registros:** Muestra una lista completa de los clientes existentes almacenados en la base de datos, con la opción de revisar detalles de cada cliente.
- **Editar Información de Registros:** Facilita la actualización de la información de clientes existentes, permitiendo modificar datos como nombre, email y teléfono.
- **Eliminar Registros:** Permite eliminar registros de clientes de la base de datos, eliminando completamente los datos asociados.
- **Buscar Registros por Identificador (ID):** Utiliza un campo de búsqueda para encontrar un cliente específico ingresando su ID único, lo que permite localizar rápidamente un cliente en la base de datos.
- **Interfaz Gráfica de Usuario (GUI):** Una GUI intuitiva y fácil de usar diseñada con Swing, proporcionando una experiencia de usuario amigable y accesible.
- **Conexión a MySQL:** Manejo de la persistencia de datos utilizando una base de datos MySQL, asegurando que la información de los clientes se almacene y recupere de manera eficiente.

## Tecnologías Utilizadas

- **Maven:** Herramienta de gestión de dependencias y construcción del proyecto.
- **Java:** Lenguaje de programación principal para la lógica de la aplicación.
- **Swing:** Biblioteca de Java para la creación de la GUI.
- **MySQL:** Base de datos relacional para almacenamiento de datos.
- **SLF4J:** Interfaz de logging que permite a la aplicación utilizar diferentes frameworks de logging mediante una API común.
- **Logback:** Implementación avanzada de logging compatible con SLF4J, utilizada para la gestión y configuración del logging en la aplicación.

## Principios y Prácticas

Para el desarrollo de esta aplicación, se han seguido los siguientes principios y prácticas para asegurar un código limpio, mantenible y escalable:

1. **Código limpio:** Uso de nombres descriptivos, estructura organizada y buenas prácticas de indentación y formato.
2. **Principios SOLID:**
    - **Responsabilidad Única:** Cada clase tiene una única responsabilidad.
    - **Abierto/Cerrado:** Las clases están abiertas para extensión pero cerradas para modificación.
    - **Sustitución de Liskov:** Las clases derivadas pueden sustituir a las clases base sin problemas.
    - **Segregación de Interfaces:** Las interfaces están segregadas adecuadamente.
    - **Inversión de Dependencias:** Las dependencias se invierten para depender de abstracciones.
3. **Programación contra Interfaces:** Uso de interfaces en lugar de clases concretas para mayor flexibilidad.
4. **Interfaces Genéricas:** Se utilizan interfaces genéricas para aumentar la reutilización y flexibilidad del código.
5. **Cohesión y Bajo Acoplamiento:** Alta cohesión y bajo acoplamiento entre los componentes del sistema.
6. **Gestión y Registro de Eventos de Logging:** Uso de un framework de logging maduro como SLF4J con Logback para una gestión eficiente de los registros.

## Instalación

### Requisitos Previos

Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas:

- **JDK (versión mínima 1.8):** El entorno de desarrollo necesario para compilar y ejecutar la aplicación Java.
- **MySQL (versión mínima 8.0):** Base de datos relacional utilizada para almacenar la información de los clientes.
- **SLF4J (Simple Logging Facade for Java):** Interfaz de logging que permite a la aplicación utilizar diferentes frameworks de logging mediante una API común.
- **Logback:** Implementación avanzada de logging compatible con SLF4J, utilizada para la gestión y configuración del logging en la aplicación.
- **Maven (opcional):** Herramienta de gestión de dependencias y construcción del proyecto, utilizada para manejar las librerías necesarias, incluyendo SLF4J y Logback.

Si utilizas Maven, las dependencias necesarias están incluidas en el archivo `pom.xml` del proyecto.

### Configuración del Entorno

1. Clona este repositorio:
   ```bash
   git clone https://github.com/jmsanchez3142/CRUD-Customer-Management-App.git
   ```

2. Configura la base de datos MySQL:

   Ejecuta el siguiente script SQL en tu servidor MySQL para crear la base de datos y la tabla necesaria:

   ```sql
   -- Crear la base de datos
   CREATE DATABASE IF NOT EXISTS db_customer_management;

   -- Seleccionar la base de datos
   USE db_customer_management;

   -- Crear la tabla 'customers'
   CREATE TABLE IF NOT EXISTS customers (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       email VARCHAR(100) NOT NULL UNIQUE,
       phone VARCHAR(15)
   );

   -- Insertar registros de ejemplo
   INSERT INTO customers (name, email, phone) VALUES
       ('Juan Pérez', 'juanperez@example.com', '+34612345678'),
       ('María García', 'mariagarcia@example.com', '+34987654321'),
       ('José Martínez', 'josemartinez@example.com', '+34678901234');
   ```

3. Modifica el archivo `config.properties` con los detalles de tu base de datos.

### Instalación

1. Navega al directorio del proyecto:
   ```bash
   cd CRUD-Customer-Management-App
   ```

2. Compila el proyecto usando Maven:
   ```bash
   mvn clean install
   ```

3. Ejecuta la aplicación:
   ```bash
   java -cp target/CRUD-Customer-Management-App.jar com.ejemplo.Main
   ```

## Uso

1. Abre la aplicación.
2. Usa la interfaz gráfica para:
    - **Agregar nuevos registros** de clientes.
    - **Ver la lista de registros** existentes.
    - **Editar la información** de clientes existentes.
    - **Eliminar registros** de clientes.
    - **Buscar un registro específico** por el identificador (ID).

## Cómo Contribuir

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad o corrección:
   ```bash
   git checkout -b nueva-funcionalidad
   ```
3. Realiza tus cambios y haz commit:
   ```bash
   git commit -am 'Añadida nueva funcionalidad'
   ```
4. Haz push a tu rama:
   ```bash
   git push origin nueva-funcionalidad
   ```
5. Abre un Pull Request.

## Reportar Problemas

Si encuentras algún problema, por favor abre un [issue](https://github.com/jmsanchez3142/CRUD-Customer-Management-App/issues) en GitHub.

## Contacto

Para cualquier consulta, contacta a [jmsanchez3142@users.noreply.github.com](mailto:167488744+jmsanchez3142@users.noreply.github.com).
