package br.com.workercompras.repository;


import br.com.workercompras.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name ="viacep", url ="${viacep}")
public interface CepRepository {
    @GetMapping("/{cep}/json/")
    Endereco buscarPorcep(@PathVariable("cep") String cep);
}
