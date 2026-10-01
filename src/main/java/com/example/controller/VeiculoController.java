package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.VeiculoRequestDTO;
import com.example.dto.VeiculoResponseDTO;
import com.example.model.Veiculo;
import com.example.service.VeiculoService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController 
@RequestMapping ("/veiculos")
public class VeiculoController {
    private final VeiculoService service;

    public VeiculoController(VeiculoService service){
        this.service = service;
    }


    @GetMapping("/veiculos")
    public List<Veiculo> listar(){
        return service.listarVeiculos();
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> criar(@Valid @RequestBody VeiculoRequestDTO dto){
        Veiculo salvo = service.cadastrarVeiculo(dto);
        
        VeiculoResponseDTO responseDTO = new VeiculoResponseDTO();
        responseDTO.setId(salvo.getId());
        responseDTO.setModelo(salvo.getModelo());
        responseDTO.setAnoFabricacao(salvo.getAnoFabricacao());
        responseDTO.setPlaca(salvo.getPlaca());
        responseDTO.setTipo(salvo.getTipo());
        responseDTO.setNomeProprietario(salvo.getNomeProprietario());

        var uri = URI.create("/veiculos/" + salvo.getId());
        return ResponseEntity.created(uri).body(responseDTO);
    }
    @GetMapping("/veiculos/{id}")
    public Veiculo buscarVeiculoID(@PathVariable Long id){
        return service.buscarCarroPorId(id);
    }

    @PutMapping("/veiculos/{id}")
    public Veiculo alterarVeiculo(@PathVariable Long id){
        return service.alterarVeiculos(id);
    }

    @DeleteMapping ("/veiculos/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id){
        service.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
