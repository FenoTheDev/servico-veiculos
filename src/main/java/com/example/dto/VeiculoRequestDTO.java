package com.example.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class VeiculoRequestDTO {
    @Id 
    @Positive 
    public Long id;
    @NotBlank (message = "Escolha a placa")
    public String placa;
    @NotBlank (message = "Modelo é obrigatório")
    public String modelo;
    @Positive 
    public Integer anoFabricacao;
    @NotBlank 
    public String tipo; //carros, motos, caminhão, barco
    @NotBlank 
    public String nomeProprietario;
}
