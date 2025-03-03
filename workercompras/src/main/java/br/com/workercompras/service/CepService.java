package br.com.workercompras.service;

import br.com.workercompras.model.Endereco;
import br.com.workercompras.repository.CepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    public Endereco getEndereco(String cep) {
        return cepRepository.buscarPorcep(cep);
    }
}