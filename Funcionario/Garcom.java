package Funcionario;

import java.io.Serializable;

public class Garcom extends Funcionario implements CLT, Serializable {
    public Garcom(String nome, int CPF, String endereco, String cargo, int CLTserie) {
        super(nome, CPF, endereco, cargo);
        this.CLTserie = CLTserie;
    }
    @Override
    public void ficha (){
        super.ficha();
        System.out.print("Número da CLT: " + this.CLTserie + "\n");
    }

    @Override
    public void tirarFerias() {
        this.deFerias = !deFerias;
    }
}
