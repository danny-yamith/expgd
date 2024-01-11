# Ejercicio Programado

Este proyecto implementa un procesador de planillas para calcular el monto total a pagar en una planilla de empleados.

## Descripción

El proyecto está escrito en Java 17, Junit, Mockito y utiliza Spring Boot y Lombok para facilitar el desarrollo. La clase `ProcesadorPlanillas` realiza el cálculo del monto total a pagar en una planilla, basándose en el pago mensual de los empleados activos.

### Estructura del empleado

- ID (entero)
- Nombre (cadena de texto)
- MontoMensual (flotante)
- Activo (booleano)

El proyecto incluye pruebas unitarias para cubrir diversos casos, incluyendo casos de excepción como montos mensuales negativos, ID igual a 0 y nombres vacíos.

## Ejecución del Proyecto

### Requisitos

- Java 17
- Maven
- Spring Boot (dependencia de lombok)

### Pasos para Ejecutar

1. Clona este repositorio.
   ```bash
   git clone https://github.com/danny-yamith/expgd.git
   cd expgd

## Ejecución de Pruebas
   mvn test 