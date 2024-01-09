package com.pgd.planillas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado {
    private int id;
    private String nombre;
    private float montoMensual;
    private boolean activo;

}