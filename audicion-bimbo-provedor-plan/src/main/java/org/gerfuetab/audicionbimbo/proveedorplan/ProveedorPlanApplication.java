package org.gerfuetab.audicionbimbo.proveedorplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProveedorPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProveedorPlanApplication.class, args);
	}

}
