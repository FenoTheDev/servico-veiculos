package com.example.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VeiculoRequestDTO {
    @Id 
    @Positive 
    public Long id;
    @NotBlank (message = "Escolha a placa")
    public String placa;
    @NotBlank (message = "Modelo é obrigatório")
    public String modelo;
    @Positive 
    @NotNull 
    public Integer anoFabricacao;
    @NotBlank 
    public String tipo; //carros, motos, caminhão, barco
    @NotBlank 
    public String nomeProprietario;
}
