package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Veiculo;
import com.example.repository.VeiculoRepository;

@Service 
public class VeiculoService {
    private final VeiculoRepository repository;


    public VeiculoService(VeiculoRepository repository){
        this.repository = repository;
    }


    public List<Veiculo> listarVeiculos(){
        return repository.findAll();
    }

    //esboçando a regra de negócio
    public Veiculo cadastrarVeiculo(Long id){
        Veiculo veiculo = new Veiculo();

        veiculo.setId(id);//Vai receber DTOS
        veiculo.setModelo(null); //Vai receber DTOS
        veiculo.setPlaca(null);//Vai receber DTOS
        veiculo.setTipo(null);//Vai receber DTOS
        veiculo.setNomeProprietario(null);//Vai receber DTOS

        return repository.save(null);//Vai receber DTOS
    }

    public Veiculo buscarCarroPorId(Long id){
        return repository.findById(id)
        .orElseThrow(() -> //exception
        )
    }

    public Veiculo alterarVeiculos(Long id){
        Veiculo veiculoExistente = repository.findById(id)
        .orElseThrow(() -> //novamente um exception
        )

        return repository.save(veiculoExistente);
    }

    public void deletarVeiculo(Long id){
        repository.deleteById(id);
    }
    
}
