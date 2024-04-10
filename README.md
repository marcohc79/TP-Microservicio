# TP-Microservicio
# Proyecto Integrador Final

## Objetivo
El objetivo de este proyecto integrador final es validar los conocimientos prácticos y técnicos relacionados con el desarrollo de Microservicios en el lenguaje de programación Java utilizando Spring Cloud y otras herramientas, implementando diferentes patrones de diseño para el curso "Microservicios con Spring Cloud" de la TodoCode Academy. Además, este proyecto busca ser desarrollado para formar parte del futuro portafolio del estudiante, sirviendo como herramienta de presentación y demostración de conocimientos y habilidades ante posibles oportunidades laborales.

## Escenario
Imagina que estás trabajando en un proyecto de una tienda de electrodomésticos online. El encargado de la tienda te ha asignado la tarea de desarrollar tres microservicios que se encargarán de diferentes aspectos del sistema. Estos microservicios se comunicarán entre sí para proporcionar una experiencia de compra fluida a los usuarios.

Basado en las especificaciones técnicas relevadas por un Analista Funcional, los servicios a desarrollar son los siguientes:

### Microservicio de Productos:
Este servicio se encargará de gestionar la información de los electrodomésticos disponibles en la plataforma. Debe ser capaz de listar los productos y proporcionar detalles como el código, nombre, marca y precio individual de cada uno.

### Microservicio de Carrito de Compras:
Este microservicio maneja el carrito de compras de los usuarios. Los usuarios podrán agregar y quitar artículos de su carrito de compras utilizando este servicio. Cada carrito tiene un número de identificación único (id) y un campo para almacenar el precio total de la suma de todos los productos en el carrito.

### Microservicio de Ventas:
Este servicio se encarga de registrar cada venta mediante un número de identificación y una fecha. Cada venta está asociada a un carrito de compras. Al guardar una nueva venta, se asigna un carrito de compras. A través de esta asociación, la venta puede conocer el monto total (consultando el carrito de compras) y la lista de productos (consultando el servicio de carrito de compras que a su vez consume el servicio de productos).

Este proyecto integrador final permitirá demostrar la implementación de una arquitectura de microservicios eficiente y escalable para satisfacer las necesidades del negocio de la tienda de electrodomésticos online.
