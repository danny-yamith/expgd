package com.pgd.planillas.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EmpleadoTest {
    @Test
    public void testEmpleado() {
        Empleado empleado = Empleado.builder()
                .id(1)
                .nombre("Juan")
                .montoMensual(2500)
                .activo(true)
                .build();

        assertThat(empleado.getId()).isEqualTo(1);
        assertThat(empleado.getNombre()).isEqualTo("Juan");
        assertThat(empleado.getMontoMensual()).isEqualTo(2500);
        assertThat(empleado.isActivo()).isTrue();
    }
}