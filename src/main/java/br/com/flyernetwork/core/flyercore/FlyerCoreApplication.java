package br.com.flyernetwork.core.flyercore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class FlyerCoreApplication {

	public static void main(String[] args) {

		log.info("TESTEEEE!!!");


		SpringApplication.run(FlyerCoreApplication.class, args);


	}

}
