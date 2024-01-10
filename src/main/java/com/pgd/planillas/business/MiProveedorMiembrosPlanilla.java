package com.pgd.planillas.business;

import com.pgd.planillas.model.Empleado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MiProveedorMiembrosPlanilla implements ProveedorMiembrosPlanilla {
    @Override
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = List.of(
                new Empleado(1, "Juan", 2500, true),
                new Empleado(2, "María", 3000, true),
                new Empleado(3, "Pedro", 2000, false)
        );
        return empleados;
    }
}