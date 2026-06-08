# Veterinaria

###### Descripción del Proyecto



Veterinaria es una aplicación desarrollada para facilitar la gestión de clientes y citas dentro de una clínica veterinaria. El sistema permite registrar dueños y mascotas, administrar perfiles, programar citas y consultar información detallada de cada paciente de manera rápida y eficiente.



###### Objetivos

* Digitalizar el registro de clientes y mascotas.
* Facilitar la programación y administración de citas veterinarias.
* Centralizar la información de pacientes y dueños.
* Mejorar la organización y eficiencia de la clínica veterinaria.



###### Funcionalidades Principales



Gestión de Usuarios:

* Inicio de sesión.



Gestión de Clientes:

* Registro de dueños.
* Registro de mascotas.
* Edición de información de dueños y pacientes.



Gestión de Citas:

* Agendar citas.
* Consultar detalles de una cita.
* Editar citas existentes.
* Ver pagos de cada cliente.



Gestión de medicamentos:

* Agregar o editar medicamentos existentes.



###### Tecnologías Utilizadas



Diseño

* Figma



Desarrollo

* Java
* Java Swing
* MySQL



###### 

###### Software Requerido

* Java JDK 17 o superior
* Eclipse IDE 
* Heidi MySQL
* Conector JDBC para MySQL
* Librería itextpdf



###### Link que contiene base de datos:

https://github.com/diegogo-maker/Veterinaria/commit/6c4c42cb4f03cd44b524f9ec1a00a69beaa02b96#diff-afa45fec265b0c1dda1981f39dcea736a25a99465b25a6142353dc6da22600e6



###### Instalación:



Abrir Eclipse:

Seleccionar

File\_\_\_Import\_\_\_Existing Projects into Workspace.

Seleccionar la carpeta del proyecto.

Finalizar la importación.



Configurar la Base de Datos

Crear una base de datos en Heidi MySQL.

Importar el archivo SQL proporcionado:

DATABASE.sql



Configurar las credenciales de conexión en el proyecto:



private static final String URL\_BASE = "jdbc:mysql://localhost:3306/";

private static final String URL = "jdbc:mysql://localhost:3306/veterinaria\_system";

private static final String USER = "root";

private static final String PASSWORD = "tu\_password";







###### Equipo de Desarrollo



Diseñador UI/UX, Programador Backend y Programador Frontend



* Diego Ernesto Navarro Aguilar



QA y Asistente de Backend y Frontent



* Edgar Misael Escobedo Pérez























