package com.pgd.planillas;

import com.pgd.planillas.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ProcesadorPlanillas {
    private final ProveedorMiembrosPlanilla proveedor;

    @Autowired
    public ProcesadorPlanillas(ProveedorMiembrosPlanilla proveedor) {
        this.proveedor = proveedor;
    }

    public float obtenerMontoTotalPlanilla() {
        List<Empleado> empleados = proveedor.obtenerEmpleados();

        return (float)  empleados.stream()
                .filter(Empleado::isActivo)
                .peek(empleado -> {
                    if (empleado.getNombre().isEmpty()) {
                        throw new IllegalArgumentException("El nombre del empleado no puede estar vacío.");
                    }
                    if (empleado.getId() == 0) {
                        throw new IllegalArgumentException("El ID del empleado no puede ser cero.");
                    }
                    if (empleado.getMontoMensual() < 0) {
                        throw new IllegalArgumentException("El monto mensual no puede ser negativo.");
                    }
                })
                .mapToDouble(Empleado::getMontoMensual)
                .sum();
    }
}