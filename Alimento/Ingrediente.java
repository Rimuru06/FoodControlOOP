package Alimento;

import java.io.Serializable;

public class Ingrediente implements Serializable {
    private String nome;
    private int quantidade;

    public Ingrediente(String nome){
        this.nome = nome;
        this.quantidade = 0;
    }
    public Ingrediente(String nome,int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }
    public String getNome(){
        return this.nome;
    }
    public int getQuantidade(){
        return this.quantidade;
    }
}
