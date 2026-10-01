package com.example.exception;

public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException(){
        super("Veiculo nao encontrado");
    }
}
