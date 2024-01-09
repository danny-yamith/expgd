# Ejercicio Programado

Este proyecto contiene una solución para el ejercicio de un procesador de planillas. El objetivo principal es calcular el monto total a pagar para una planilla de empleados.

## Descripción

La clase `ProcesadorPlanillas` implementa un método para obtener el monto total a pagar en una planilla. Esta clase tiene una dependencia hacia `ProveedorMiembrosPlanilla`, que es una dependencia externa utilizada para obtener la lista de empleados. El procesador suma el pago mensual de cada empleado activo y devuelve el total como resultado.

### Estructura del empleado:

- ID (entero)
- Nombre (cadena de texto)
- MontoMensual (flotante)
- Activo (booleano)

El proveedor de miembros de la planilla es abstracto, lo que significa que la implementación del proveedor no es parte de este ejercicio.

## Pruebas Unitarias

Se incluyen pruebas unitarias para cubrir todos los escenarios, incluyendo casos de excepción como:

- Monto mensual negativo
- ID igual a 0
- Nombre vacío

## Diferentes Implementaciones del Proveedor de Planilla

El diseño permite la implementación de diferentes proveedores de planilla sin modificar el código existente. Esto se logra mediante el uso de la abstracción `ProveedorMiembrosPlanilla` como interfaz, permitiendo así una inyección de dependencias flexible.

## Ejecución del Proyecto

1. Clona este repositorio.
2. Compila el código.
3. Ejecuta la clase principal `PlanillasApplication`.
4. Observa el monto total a pagar en la planilla.

**Compartir Solución:** https://github.com/danny-yamith/expgd)https://github.com/danny-yamith/expgd

