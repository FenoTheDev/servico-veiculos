package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Veiculo {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;
    public String placa;
    public String modelo;
    public Integer anoFabricacao;
    public String tipo; //carros, motos, caminhão, barco
    public String nomeProprietario;
}
