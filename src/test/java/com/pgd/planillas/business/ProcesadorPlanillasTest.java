package com.pgd.planillas.business;

import com.pgd.planillas.model.Empleado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.IllegalArgumentException;

public class ProcesadorPlanillasTest {

    @Test
    public void testObtenerMontoTotalPlanilla() {
        ProveedorMiembrosPlanilla mockProveedor = () -> {
            List<Empleado> empleados = List.of(
                    new Empleado(1, "Juan", 2500, true),
                    new Empleado(2, "María", 3000, true)
            );
            return empleados;
        };

        ProcesadorPlanillas procesador = new ProcesadorPlanillas(mockProveedor);
        float montoTotal = procesador.obtenerMontoTotalPlanilla();
        assertEquals(5500, montoTotal);
    }

    @Test
    public void testMontoMensualNegativo() {
        ProveedorMiembrosPlanilla mockProveedor = () -> {
            List<Empleado> empleados = Collections.singletonList(
                    new Empleado(1, "Empleado1", -2000, true)
            );
            return empleados;
        };

        ProcesadorPlanillas procesador = new ProcesadorPlanillas(mockProveedor);
        assertThrows(IllegalArgumentException.class, procesador::obtenerMontoTotalPlanilla);
    }

    @Test
    public void testIDCero() {
        // Mock con un proveedor que retorna un empleado con ID igual a 0
        ProveedorMiembrosPlanilla mockProveedor = () -> {
            return Collections.singletonList(
                    new Empleado(0, "Empleado1", 2000, true)
            );
        };

        ProcesadorPlanillas procesador = new ProcesadorPlanillas(mockProveedor);
        assertThrows(IllegalArgumentException.class, procesador::obtenerMontoTotalPlanilla);
    }

    @Test
    public void testNombreVacio() {
        // Mock con un proveedor que retorna un empleado con nombre vacío
        ProveedorMiembrosPlanilla mockProveedor = () -> {
            List<Empleado> empleados = Collections.singletonList(
                    new Empleado(1, "", 2000, true)
            );
            return empleados;
        };

        ProcesadorPlanillas procesador = new ProcesadorPlanillas(mockProveedor);
        assertThrows(IllegalArgumentException.class, procesador::obtenerMontoTotalPlanilla);
    }
}
