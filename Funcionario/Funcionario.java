package Funcionario;

import java.io.Serializable;

public abstract class Funcionario implements Serializable {
    protected String nome;
    protected int CPF;
    protected String endereco;

    protected int CLTserie;

    protected String cargo;

    protected boolean deFerias;


    public int getCPF() {
        return CPF;
    }

    public Funcionario(String nome, int CPF, String endereco, String cargo) {
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.cargo = cargo;
        this.deFerias = false;
    }

    public void mudarEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void ficha(){
        System.out.print("\nFicha do funcionário\nNome: " + this.nome + "\nFunção: " + this.cargo + "\nCPF: " + this.CPF + "\nEndereço: " + this.endereco + "\nFérias: ");
        if (!this.deFerias){
            System.out.print("NÃO\n");
        } else System.out.print("SIM\n");
    }

}
