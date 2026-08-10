# 💳 Billetera Virtual - Backend Core API

Una API RESTful robusta diseñada para simular el núcleo de transacciones financieras de una billetera virtual. Este proyecto maneja la creación de usuarios, gestión de cuentas y el procesamiento seguro de depósitos, extracciones y transferencias, garantizando la integridad de los datos mediante principios de atomicidad.

## 🎯 Sobre el Proyecto

Este sistema fue desarrollado como un MVP (Producto Mínimo Viable) para aplicar conceptos avanzados de la ingeniería de software en un entorno backend moderno. La aplicación implementa una arquitectura multicapa (Controller-Service-Repository), utilizando el patrón DTO para la transferencia de datos y estrategias de herencia en base de datos (`SINGLE_TABLE`) para el manejo polimórfico del historial de transacciones.

## 🛠️ Stack Tecnológico y Herramientas

* **Lenguaje:** Java 21
* **Framework Core:** Spring Boot 3
* **Persistencia de Datos:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL
* **Validaciones:** Jakarta Validation
* **Gestor de Dependencias:** Maven
* **Control de Versiones:** Git / GitHub
* **Testing de API:** Postman

## ✨ Características Principales

1. **Gestión de Usuarios y Cuentas:** Registro de nuevos clientes con validación estricta de datos y generación automática de CVU.
2. **Motor Transaccional Seguro:** Procesamiento de Depósitos, Extracciones y Transferencias. Implementación de `@Transactional` para prevenir pérdida de datos en operaciones interrumpidas.
3. **Manejo de Errores Global:** Implementación de `@RestControllerAdvice` para capturar excepciones de negocio (`SaldoInsuficienteException`, `RecursoNoEncontradoException`) y devolver respuestas HTTP coherentes y formateadas.
4. **Patrón DTO:** Aislamiento de las entidades de dominio (Model) de la capa de presentación (Controladores) para evitar exposición de datos sensibles y referencias circulares.

## 🚀 Endpoints Principales

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `POST` | `/usuarios` | Registra un nuevo usuario y le asigna una cuenta con CVU. |
| `GET` | `/usuarios/{dni}` | Consulta el perfil de un usuario existente. |
| `GET` | `/cuentas/{cvu}/saldo` | Retorna el saldo actual de una cuenta. |
| `GET` | `/cuentas/{cvu}/historial` | Lista de transacciones ordenadas cronológicamente. |
| `POST` | `/cuentas/{cvu}/depositos` | Ingresa dinero a una cuenta específica. |
| `POST` | `/cuentas/{cvu}/extracciones`| Retira fondos validando el saldo disponible. |
| `POST` | `/transferencias` | Transfiere fondos entre dos cuentas distintas. |

## 📸 Demostración (Postman)

**Demo Crear Usuario Exitosamente**

<img width="1087" height="660" alt="5b4e6981-4641-4b9f-bbff-ac763c17194c" src="https://github.com/user-attachments/assets/803586b9-260b-44cf-9e0c-3bad67c6e3cc" />

**Demo Transferencia Fallida**

<img width="1083" height="629" alt="b203349c-65e1-49c8-9fda-2dff5b8fbcb6" src="https://github.com/user-attachments/assets/9299639f-cffb-4260-89f1-89e5bb7c32e2" />


## 🚧 Próximos Pasos (Roadmap)

El desarrollo del proyecto continúa en evolución. Los próximos hitos arquitectónicos son:
- [ ] **Testing Unitario y de Integración:** Implementación de pruebas automatizadas para la capa de servicios (`BilleteraServicio`) utilizando **JUnit 5** y simulación de base de datos con **Mockito** para garantizar la fiabilidad del código.
- [ ] **Seguridad:** Implementación de Spring Security y autenticación mediante tokens JWT.

## 👨‍💻 Autor

**Alexis Ariel Rodriguez**

*Estudiante de Ingeniería en Sistemas de Información*

[LinkedIn](https://www.linkedin.com/in/alexisrodriguezar/) | [GitHub](https://github.com/alexisrodriguezar)
