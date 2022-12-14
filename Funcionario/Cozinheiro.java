package Funcionario;

import java.io.Serializable;

public class Cozinheiro extends Funcionario implements CLT, Serializable {

    EspecialidadeCozinha especialidade;

    public Cozinheiro(String nome, int CPF, String endereco, String cargo, int CLTserie, String especialidade) {
        super(nome, CPF, endereco, cargo);
        this.CLTserie = CLTserie;
        switch (especialidade) {
            case "bebidas" -> this.especialidade = EspecialidadeCozinha.BEBIDAS;
            case "carnes" -> this.especialidade = EspecialidadeCozinha.CARNES;
            case "japonesa" -> this.especialidade = EspecialidadeCozinha.JAPONESA;
            case "massas" -> this.especialidade = EspecialidadeCozinha.MASSAS;
            case "salgados" -> this.especialidade = EspecialidadeCozinha.SALGADOS;
            default -> this.especialidade = EspecialidadeCozinha.SEM_ESPECIALIDADDE_DEFINIDA;
        }
    }

    @Override
    public void tirarFerias() {
        this.deFerias = !deFerias;
    }

    @Override
    public void ficha(){
        super.ficha();
        System.out.print("Número da CLT: " + this.CLTserie + "\n");
        System.out.print("Especialidadena cozinha: " + this.especialidade + "\n");
    }
}
