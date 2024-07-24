[![Spanish Language](doc/images/Spanish-Language.png)](README-in-spanish.md)
# CRUD Customer Management App

## Comments, Suggestions, and Contributions

I am a self-taught student taking my first steps into the world of programming. This application is part of my learning process and practice to develop skills in Java, GUI design, database management, and the application of good programming practices.

My goal in publishing this project on GitHub is to receive feedback and guidance from the developer community to improve my skills and knowledge. I am open to **comments, suggestions, and contributions** on the implementation of best practices, principles, design patterns, and architecture. Your feedback is invaluable to improve the quality of the code and the application in general.

I appreciate in advance the patience and support of the community as I continue my self-taught learning journey. I hope this project is the first of many more as I advance in my career as a software developer.

## General Description

The **CRUD-Customer-Management-App** is a desktop application developed for educational purposes that allows users to manage a customer table in a MySQL database through a graphical user interface (GUI) created with Swing.

## Objectives

- **Provide an easy-to-use interface** for managing customer records.
- **Implement CRUD operations** (Create, Read, Update, Delete) for customer records.
- **Demonstrate good object-oriented programming practices in Java.**
- **Apply SOLID principles** to ensure clean, maintainable, and scalable code.
- **Utilize a mature logging framework** for event tracking and debugging.

## Key Features

- **Add New Records:** Allows users to add new customers to the database, entering information such as name, email, and phone.
- **View Records List:** Displays a complete list of existing customers stored in the database, with the option to review details of each customer.
- **Edit Records Information:** Facilitates the update of existing customer information, allowing modification of data such as name, email, and phone.
- **Delete Records:** Allows deleting customer records from the database, completely removing the associated data.
- **Search Records by Identifier (ID):** Uses a search field to find a specific customer by entering their unique ID, allowing for quick location of a customer in the database.
- **Graphical User Interface (GUI):** An intuitive and easy-to-use GUI designed with Swing, providing a user-friendly and accessible experience.
- **Connection to MySQL:** Persistence data management using a MySQL database, ensuring that customer information is efficiently stored and retrieved.

## Technologies Used

- **Maven:** Dependency management and project build tool.
- **Java:** Main programming language for application logic.
- **Swing:** Java library for GUI creation.
- **MySQL:** Relational database for data storage.
- **SLF4J:** Logging facade that allows the application to use different logging frameworks through a common API.
- **Logback:** Advanced logging implementation compatible with SLF4J, used for logging management and configuration in the application.

## Principles and Practices

For the development of this application, the following principles and practices have been followed to ensure clean, maintainable, and scalable code:

1. **Clean Code:** Use of descriptive names, organized structure, and good indentation and formatting practices.
2. **SOLID Principles:**
    - **Single Responsibility:** Each class has a single responsibility.
    - **Open/Closed:** Classes are open for extension but closed for modification.
    - **Liskov Substitution:** Derived classes can substitute base classes without issues.
    - **Interface Segregation:** Interfaces are adequately segregated.
    - **Dependency Inversion:** Dependencies are inverted to depend on abstractions.
3. **Programming against Interfaces:** Use of interfaces instead of concrete classes for greater flexibility.
4. **Generic Interfaces:** Generic interfaces are used to increase code reuse and flexibility.
5. **Cohesion and Low Coupling:** High cohesion and low coupling between system components.
6. **Logging Events Management:** Use of a mature logging framework like SLF4J with Logback for efficient logging management.

## Installation

### Prerequisites

Before you begin, make sure you have the following tools installed:

- **JDK (minimum version 1.8):** The development environment needed to compile and run the Java application.
- **MySQL (minimum version 8.0):** Relational database used to store customer information.
- **SLF4J (Simple Logging Facade for Java):** Logging facade that allows the application to use different logging frameworks through a common API.
- **Logback:** Advanced logging implementation compatible with SLF4J, used for logging management and configuration in the application.
- **Maven (optional):** Dependency management and project build tool, used to handle the necessary libraries, including SLF4J and Logback.

If you use Maven, the required dependencies are included in the project's `pom.xml` file.

### Environment Setup

1. Clone this repository:
   ```bash
   git clone https://github.com/jmsanchez3142/CRUD-Customer-Management-App.git
   ```

2. Set up the MySQL database:

   Run the following SQL script on your MySQL server to create the necessary database and table:

   ```sql
   -- Create the database
   CREATE DATABASE IF NOT EXISTS db_customer_management;

   -- Select the database
   USE db_customer_management;

   -- Create the 'customers' table
   CREATE TABLE IF NOT EXISTS customers (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       email VARCHAR(100) NOT NULL UNIQUE,
       phone VARCHAR(15)
   );

   -- Insert sample records
   INSERT INTO customers (name, email, phone) VALUES
       ('Juan Pérez', 'juanperez@example.com', '+34612345678'),
       ('María García', 'mariagarcia@example.com', '+34987654321'),
       ('José Martínez', 'josemartinez@example.com', '+34678901234');
   ```

3. Modify the `config.properties` file with your database details.

### Installation

1. Navigate to the project directory:
   ```bash
   cd CRUD-Customer-Management-App
   ```

2. Compile the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   java -cp target/CRUD-Customer-Management-App.jar com.example.Main
   ```

## Usage

1. Open the application.
2. Use the graphical interface to:
    - **Add new customer records.**
    - **View the list of existing records.**
    - **Edit information** of existing customers.
    - **Delete customer records.**
    - **Search for a specific record** by identifier (ID).

## How to Contribute

1. Fork the repository.
2. Create a branch for your feature or fix:
   ```bash
   git checkout -b new-feature
   ```
3. Make your changes and commit:
   ```bash
   git commit -am 'Added new feature'
   ```
4. Push to your branch:
   ```bash
   git push origin new-feature
   ```
5. Open a Pull Request.

## Report Issues

If you find any issues, please open an [issue](https://github.com/jmsanchez3142/CRUD-Customer-Management-App/issues) on GitHub.

## Contact

For any inquiries, contact [jmsanchez3142@users.noreply.github.com](mailto:167488744+jmsanchez3142@users.noreply.github.com).
