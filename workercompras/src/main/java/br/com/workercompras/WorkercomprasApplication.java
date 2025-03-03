package br.com.workercompras;

import br.com.workercompras.model.Endereco;
import br.com.workercompras.service.CepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableRabbit
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class WorkercomprasApplication implements CommandLineRunner {

	@Autowired
	private CepService cepService;
	public static void main(String[] args) {
		SpringApplication.run(WorkercomprasApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Endereco endereco = cepService.getEndereco("31210470");
		log.info(endereco.toString());
	}
}
