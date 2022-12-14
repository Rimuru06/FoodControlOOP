package Funcionario;

import java.io.Serializable;

public class Entregador extends Funcionario implements Serializable {
    private StatusCNH CNH;

    public Entregador (String nome, int CPF, String endereco, String cargo, String CNH){
        super(nome, CPF, endereco, cargo);
        switch (CNH){
            case "valido" -> this.CNH = StatusCNH.VALIDA;
            case "invalido" -> this.CNH = StatusCNH.INVALIDA;
        }
    }

    @Override
    public void ficha(){
        super.ficha();
        System.out.print("--Não é CLT--\nStatus da CNH: " + this.CNH + "\n");
    }
}
