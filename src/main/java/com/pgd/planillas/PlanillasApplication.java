package com.pgd.planillas;

import com.pgd.planillas.business.ProcesadorPlanillas;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class PlanillasApplication implements CommandLineRunner {

	@Autowired
	private ProcesadorPlanillas procesadorPlanillas;

	public static void main(String[] args) {
		SpringApplication.run(PlanillasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		float montoTotal = procesadorPlanillas.obtenerMontoTotalPlanilla();
		System.out.println("El monto total a pagar es: " + montoTotal);
	}
}



