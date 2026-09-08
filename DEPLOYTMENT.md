## Requisitos del Sistema

Antes de ejecutar el proyecto, asegúrese de contar con las siguientes herramientas configuradas en su entorno:

* **Java Development Kit (JDK):** Versión 17 o superior.
* **Apache Maven:** Para la gestión de dependencias y compilación del proyecto.
* **Entorno Servidor Local:** **XAMPP** (u otro entorno similar) para ejecutar el servidor de base de datos **MySQL** o **MariaDB**.
* **Entorno de Desarrollo (IDE):** **IntelliJ IDEA** (recomendado), Eclipse o VS Code.

---

## Guía de Instalación y Ejecución

Siga los siguientes pasos para poner en marcha la aplicación en su entorno local:

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/tu-usuario/hospital-management-system.git](https://github.com/tu-usuario/hospital-management-system.git)
   cd hospital-management-system

```

2. **Iniciar la Base de Datos:**
* Abra el panel de control de **XAMPP** e inicie el servicio de **MySQL**.
* Acceda a phpMyAdmin o su gestor de base de datos preferido y cree la base de datos:
```sql
CREATE DATABASE hospital_db;

```




3. **Configurar las credenciales:**
Edite el archivo `src/main/resources/application.properties` para adaptar la conexión a su configuración de XAMPP / MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

```


4. **Ejecutar el proyecto:**
* **Desde IntelliJ IDEA (u otro IDE):** Importe el proyecto como un proyecto Maven existente, espere a que se descarguen las dependencias y ejecute la clase principal (`Application.java`).
* **Desde la consola mediante Maven:**
```bash
mvn spring-boot:run

```




5. **Acceso a la aplicación:**
Una vez desplegado el servidor local, la interfaz estará disponible en:
👉 `http://localhost:8080`

---

## Datos Iniciales de Prueba

Para facilitar las pruebas funcionales sin necesidad de registrar la información de forma manual, la aplicación ejecuta la clase `DataInitializer` al arrancar, generando automáticamente los siguientes registros iniciales:

* Usuario con rol de administrador
* Perfiles de pacientes de prueba
* Perfiles de médicos de prueba
* Habitaciones hospitalarias registradas

### Credenciales de Administrador Predeterminadas

| Parámetro | Credencial |
| --- | --- |
| **Usuario** | `admin` |
| **Contraseña** | `admin123` |

> **Nota de seguridad:** Estas credenciales han sido provistas exclusivamente para entornos de desarrollo y pruebas locales.

```

```
