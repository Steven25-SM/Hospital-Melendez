# Sistema Web de Gestión Hospitalaria

Plataforma web para la gestión integral de operaciones hospitalarias, administración de expedientes médicos, citas, hospitalizaciones y facturación, desarrollada con tecnologías Java empresarial.

---

## Tabla de Contenidos

- [Descripción General](#descripción-general)
- [Funcionalidades](#funcionalidades)
  - [Administrador](#administrador)
  - [Paciente](#paciente)
- [Autenticación y Roles](#autenticación-y-roles)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Requisitos Previos](#requisitos-previos)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Datos Iniciales de Prueba](#datos-iniciales-de-prueba)
- [Estado del Proyecto](#estado-del-proyecto)
- [Licencia](#licencia)

---

## Descripción General

El **Sistema Web de Gestión Hospitalaria** es una solución informática diseñada para automatizar y optimizar los procesos operativos y administrativos de un centro médico. Permite controlar el flujo completo de atención al paciente: desde el registro e historial clínico hasta el agendamiento de citas, control de habitaciones en hospitalización y la gestión de comprobantes de pago.

---

## Funcionalidades

### Administrador
El usuario administrador cuenta con acceso global y permisos para la gestión completa (**CRUD**) de los módulos del sistema:

* **Gestión de Pacientes:** Registro, consulta, actualización y eliminación de expedientes.
* **Gestión de Médicos:** Administración de la información del personal médico y especialidades.
* **Gestión de Citas:** Programación, modificación y control de citas médicas.
* **Gestión de Hospitalizaciones:** Asignación de habitaciones y seguimiento del estado del paciente.
* **Gestión de Facturación:** Control y generación de liquidaciones por servicios médicos.
* **Monitoreo Global:** Visualización consolidada de toda la información registrada.

### Paciente
Los pacientes disponen de una interfaz orientada a la autogestión de sus servicios:

* **Registro e Inicio de Sesión:** Creación de cuenta con vinculación automática a su expediente médico.
* **Directorio Médico:** Consulta de especialistas disponibles.
* **Agendamiento de Citas:** Reserva y visualización del historial de citas propias.
* **Consulta de Facturas:** Acceso al estado de cuenta y facturas generadas.
* **Control de Seguridad:** Restricción estricta de acceso a datos y funciones administrativas.

---

## Autenticación y Roles

El control de acceso está gestionado mediante **Spring Security**, asegurando la privacidad de la información y la restricción de operaciones según el perfil asignado:

| Rol | Descripción de Accesos y Permisos |
| :--- | :--- |
| **`ADMIN`** | Acceso completo a la administración operativa, configuración del sistema y módulos CRUD. |
| **`PACIENTE`** | Acceso restringido exclusivamente a su información personal, citas y facturas. |

> **Nota:** Los pacientes que se registran desde el formulario público quedan automáticamente vinculados con su cuenta de usuario correspondiente.

---

## Tecnologías Utilizadas

* **Lenguaje de Programación:** Java 17+
* **Framework Principal:** Spring Boot 3.5.6
* **Componentes de Spring:** Spring MVC, Spring Security, Spring Data JPA
* **Persistencia / ORM:** Hibernate
* **Motor de Plantillas:** Thymeleaf
* **Base de Datos:** MySQL / MariaDB
* **Gestor de Dependencias:** Apache Maven
* **Diseño Frontend:** Bootstrap 5

---

## Estructura del Proyecto

La aplicación sigue una **arquitectura basada en capas**:  
`Controller → Service → Repository → Database`

```text
src/main/java/com/hospital
├── config/           # Configuraciones generales del sistema
├── controller/       # Controladores HTTP (Spring MVC)
├── entity/           # Entidades JPA (Mapeo relacional)
├── repository/       # Interfaces de acceso a base de datos (Spring Data JPA)
├── security/         # Configuración de seguridad y roles (Spring Security)
└── service/          # Interfaces de lógica de negocio
    └── impl/         # Implementaciones de la lógica de negocio

src/main/resources
├── static/           # Recursos estáticos públicos
│   ├── css/          # Hojas de estilo
│   └── images/       # Recursos gráficos
└── templates/        # Vistas dinámicas renderizadas por Thymeleaf
Requisitos Previos
Antes de ejecutar la aplicación en su entorno local, asegúrese de contar con:

Java Development Kit (JDK): Versión 17 o superior.

Apache Maven: Para la gestión de dependencias y compilación.

Servidor de Base de Datos: MySQL 8.0+ o MariaDB (ej. ejecutable vía XAMPP).

