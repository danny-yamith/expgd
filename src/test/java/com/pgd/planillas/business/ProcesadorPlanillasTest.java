package com.pgd.planillas.business;

import com.pgd.planillas.model.Empleado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.IllegalArgumentException;

public class ProcesadorPlanillasTest {

    private ProveedorMiembrosPlanilla mockProveedor;
    private void configurarProveedor(List<Empleado> empleados) {
        mockProveedor = mock(ProveedorMiembrosPlanilla.class);
        when(mockProveedor.obtenerEmpleados()).thenReturn(empleados);
    }

    private ProcesadorPlanillas crearProcesador() {
        return new ProcesadorPlanillas(mockProveedor);
    }

    @Test
    public void testObtenerMontoTotalPlanilla() {
        configurarProveedor(List.of(
                new Empleado(1, "Juan", 2500, true),
                new Empleado(2, "María", 3000, true)
        ));
        ProcesadorPlanillas procesador = crearProcesador();;
        float montoTotal = procesador.obtenerMontoTotalPlanilla();
        assertEquals(5500, montoTotal);
    }

    @Test
    public void testMontoMensualNegativo() {
        configurarProveedor(
                Collections.singletonList(new Empleado(1, "Empleado1", -2000, true))
        );
        ProcesadorPlanillas procesador = crearProcesador();
        assertThrows(IllegalArgumentException.class, procesador::obtenerMontoTotalPlanilla);
    }

    @Test
    public void testIDCero() {
        configurarProveedor(
                Collections.singletonList(new Empleado(0, "Empleado1", 2000, true))
        );
        ProcesadorPlanillas procesador = crearProcesador();
        assertThrows(IllegalArgumentException.class, procesador::obtenerMontoTotalPlanilla);
    }

    @Test
    public void testNombreVacio() {
        configurarProveedor(
                Collections.singletonList(new Empleado(1, "", 2000, true))
        );
        ProcesadorPlanillas procesador = crearProcesador();
        assertThrows(IllegalArgumentException.class, procesador::obtenerMontoTotalPlanilla);
    }

    @Test
    public void testEmpleadoInactivo() {
        configurarProveedor(List.of(
                new Empleado(1, "Juan", 2500, true),
                new Empleado(2, "María", 3000, false),
                new Empleado(3, "Pedro", 2000, true)
        ));
        ProcesadorPlanillas procesador = crearProcesador();
        float montoTotal = procesador.obtenerMontoTotalPlanilla();
        assertEquals(4500, montoTotal);  // Solo se suman los montos de los empleados activos
    }

}
