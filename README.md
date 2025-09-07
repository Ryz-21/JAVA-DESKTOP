# 🏥 Sistema de Atenciones Médicas - Municipalidad de Comas

Aplicación de escritorio desarrollada en **Java Swing** con **Maven** y **MySQL**, orientada a la gestión de atenciones médicas de los colaboradores de la Municipalidad de Comas.  

Este sistema permite registrar y administrar **pacientes, doctores, trabajadoras sociales y atenciones médicas**, además de generar reportes en base a los datos registrados.  

---

## 📌 Características principales

### ✅ Requerimientos Funcionales

1. **Gestión de Pacientes**
   - Crear, editar, eliminar y listar pacientes.
   - Código único generado automáticamente.
   - Datos: nombres, apellidos, DNI, teléfono, email, dirección, gerencia, condición laboral, diagnóstico, seguro, fecha de nacimiento, fecha y hora de registro.
   - Gerencia, Condición Laboral y Seguro se seleccionan en cuadros combinados.
   - Fechas en formato estándar `YYYY-MM-DD`.

2. **Gestión de Doctores**
   - CRUD completo (crear, editar, eliminar, listar).
   - Código único autogenerado.
   - Datos: nombres, apellidos, DNI, teléfono, email, especialidad (Medicina General, Cirugía, Traumatología), fecha y hora de registro.

3. **Gestión de Trabajadoras Sociales**
   - CRUD completo (crear, editar, eliminar, listar).
   - Código único autogenerado.
   - Datos: nombres, apellidos, DNI, teléfono, email, fecha y hora de registro.

4. **Registro de Atenciones Médicas**
   - Registro de atención médica de un paciente.
   - Código generado automáticamente mediante procedimientos almacenados.
   - Selección de **Paciente**, **Doctor** y **Trabajadora Social** desde cuadros combinados.
   - Registro de fecha, hora y situación del paciente.

5. **Reportes**
   - Reporte de Atenciones registradas.
   - Reporte de lista de pacientes (nombres, apellidos, DNI, gerencia y condición laboral).

---

### ⚙️ Requerimientos No Funcionales
- **UI**: Interfaz intuitiva y fácil de usar, con menús y formularios claros.  
- **Tecnología**:  
  - Lenguaje: **Java 17+**  
  - Framework: **Swing** (UI)  
  - Gestión de dependencias: **Maven**  
  - Base de datos: **MySQL 8.x**  
- **Seguridad**:  
  - Prevención de inyecciones SQL mediante **procedimientos almacenados**.

---

## 🗂️ Estructura del proyecto

```
📂 proyecto-atenciones-medicas
├── 📂 src/main/java
│ ├── ui/ → Formularios Swing (Pacientes, Doctores, Atenciones, etc.)
│ ├── dao/ → Acceso a datos (procedimientos almacenados)
│ ├── model/ → Entidades: Paciente, Doctor, TrabajadoraSocial, Atencion
│ └── util/ → Conexión a BD, helpers
│
├── 📂 src/main/resources → Archivos de configuración
├── pom.xml → Configuración Maven
└── README.md → Documentación
```


---

## 🗄️ Base de Datos (MySQL)

### Tablas principales
- **pacientes**  
- **doctores**  
- **trabajadoras_sociales**  
- **atenciones**  

👉 Todos los códigos son generados automáticamente (AUTO_INCREMENT o procedimientos).  
👉 Se utilizan **Stored Procedures** para CRUD y seguridad contra inyección SQL.  

---

## 🚀 Ejecución del Proyecto

### 1. Clonar el repositorio
```bash
git clone https://github.com/tuusuario/proyecto-atenciones-medicas.git
cd proyecto-atenciones-medicas
```


2. Configurar la base de datos
```
Crear una base de datos en MySQL:

CREATE DATABASE atenciones_medicas;

Importar el script de tablas y procedimientos almacenados (script.sql).
```
3. Configurar conexión en Java

En el archivo de configuración (util/Conexion.java), actualizar con tus credenciales:
```
private static final String URL = "jdbc:mysql://localhost:3306/atenciones_medicas";
private static final String USER = "root";
private static final String PASSWORD = "tu_password";
```
4. Ejecutar la aplicación
 ```
mvn clean install
mvn exec:java -Dexec.mainClass="com.muni.comas.Main"
```
