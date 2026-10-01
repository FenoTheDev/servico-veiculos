package com.example.exception;

public class PlacaJaEmUsoException extends RuntimeException {
    public PlacaJaEmUsoException(Long id){
        super("Placa já está em uso: " + id);
    }
}
