# Java JDBC CRUD - PostgreSQL

Este proyecto es un CRUD básico hecho en Java usando JDBC y PostgreSQL.

Permite crear, listar, actualizar y eliminar usuarios desde consola.

---

## 🚀 Tecnologías

- Java
- JDBC
- PostgreSQL
- IntelliJ IDEA

---

## 📦 Funcionalidades

- Crear usuario
- Listar usuarios
- Actualizar usuario
- Eliminar usuario
- Menú en consola

---

## 🗄️ Base de datos

Crear base de datos:

```sql
CREATE DATABASE crud_java;
Crear tabla:

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);
⚙️ Configuración

Editar en:

DatabaseConnection.java

String url = "jdbc:postgresql://localhost:5432/crud_java";
String user = "postgres";
String password = "tu contraseña";

▶️ Ejecución

Ejecutar Main.java

📌 Menú del sistema
1. Crear usuario
2. Listar usuarios
3. Actualizar usuario
4. Eliminar usuario
0. Salir

🧠 Aprendizaje
JDBC
SQL
CRUD
PreparedStatement
ResultSet
Arquitectura DAO

👨‍💻 Autor

WilDev