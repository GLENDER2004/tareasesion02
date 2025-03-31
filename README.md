# Microservicio de Gestión de Pedidos

## Descripción General

El **Microservicio de Gestión de Pedidos** tiene como objetivo gestionar todos los aspectos relacionados con los pedidos dentro de un sistema de ventas o comercio electrónico. Este microservicio se encarga de registrar pedidos, asociar productos a esos pedidos y gestionar la información de los clientes que los realizan.

El sistema está diseñado para ser **escalable** y **modular**, permitiendo gestionar de manera eficiente los productos, pedidos y clientes asociados, y a la vez proporciona una interfaz clara para la integración con otros servicios del sistema.

---

## Propósito y Objetivo del Microservicio

Este microservicio tiene la capacidad de realizar las siguientes tareas:

### 🚀 **1. Crear y Actualizar Pedidos**

- Permite la creación de nuevos pedidos.
- Permite la actualización de la información de pedidos existentes.
- Consultar los detalles de un pedido específico.

### 🛒 **2. Gestionar Productos**

- Permite crear y actualizar productos.
- Los productos se asocian a los pedidos mediante los **detalles del pedido** (relación muchos a muchos).
- Gestiona el inventario de productos disponibles para los pedidos.

### 👤 **3. Gestionar Clientes**

- Cada pedido se asocia a un **cliente** específico.
- Permite la consulta y actualización de la información de clientes (nombre, dirección, contacto).
- Facilita la integración de la gestión de clientes con otros sistemas relacionados.

---

## ¿Cómo Funciona?

### Funcionalidades Clave

- **Crear Pedido**: El cliente envía una solicitud `POST` al endpoint `/pedidos` con los datos del cliente y los productos a comprar.
- **Consultar Pedido**: Puedes consultar los detalles de un pedido específico con una solicitud `GET` a `/pedidos/{id}`.
- **Actualizar Pedido**: Se puede actualizar el estado de un pedido o modificar los detalles de los productos en un pedido mediante una solicitud `PUT` o `PATCH` a `/pedidos/{id}`.
- **Eliminar Pedido**: El pedido puede ser eliminado con una solicitud `DELETE` a `/pedidos/{id}`.

---

## Estructura del Proyecto

Este microservicio está organizado en diferentes paquetes para mantener el código limpio y modular.

### 🗂️ **Paquete `domain`**
Contiene las entidades que representan el modelo de datos del microservicio:
- `Producto`
- `DetallePedido`
- `Pedido`
- `Cliente`

### 🛠️ **Paquete `services`**
Contiene la lógica de negocio del microservicio, como la creación, actualización y consulta de pedidos, productos y clientes.

### 💾 **Paquete `repositories`**
Contiene las interfaces de acceso a datos (repositorios), que extienden de `JpaRepository` o `CrudRepository` para cada entidad:
- `ProductoRepository`
- `DetallePedidoRepository`
- `PedidoRepository`
- `ClienteRepository`

### 📡 **Paquete `controllers`**
Contiene los controladores REST que exponen las API del microservicio para ser consumidas por otros servicios o clientes.

---

## Arquitectura

Este microservicio está basado en una arquitectura **RESTful** utilizando **Spring Boot**, y se comunica con la base de datos a través de **JPA (Java Persistence API)**. La persistencia de los datos se maneja mediante **H**
