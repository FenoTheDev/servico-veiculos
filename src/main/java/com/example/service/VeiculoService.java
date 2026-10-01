package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.VeiculoRequestDTO;
import com.example.exception.VeiculoNaoEncontradoException;
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
    public Veiculo cadastrarVeiculo(VeiculoRequestDTO veiculoDto){
        Veiculo veiculo = new Veiculo();

        veiculo.setId(veiculoDto.getId());//Vai receber DTOS
        veiculo.setModelo(veiculoDto.getModelo()); //Vai receber DTOS
        veiculo.setPlaca(veiculoDto.getPlaca());//Vai receber DTOS
        veiculo.setTipo(veiculoDto.getTipo());//Vai receber DTOS
        veiculo.setNomeProprietario(veiculoDto.getNomeProprietario());//Vai receber DTOS

        return repository.save(veiculo);//Vai receber DTOS
    }

    public Veiculo buscarCarroPorId(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new VeiculoNaoEncontradoException());
    }

    public Veiculo alterarVeiculos(Long id){
        Veiculo veiculoExistente = repository.findById(id)
        .orElseThrow(() -> new VeiculoNaoEncontradoException());

        return repository.save(veiculoExistente);
    }

    public void deletarVeiculo(Long id){
        repository.deleteById(id);
    }
    
}
