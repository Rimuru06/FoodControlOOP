package Arquivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import Funcionario.Entregador;

public class ArquivoEntregador {
    public ArrayList<Entregador> ler(String nome) throws IOException{
        ArrayList<Entregador> entregadores = new ArrayList<Entregador>();
        try {
            FileInputStream fileInput = new FileInputStream(nome);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            boolean fim = false;
            while (!fim){
                try {
                    Entregador aux = (Entregador) objectInput.readObject();
                    entregadores.add(aux);
                } catch (Exception e) {
                    fim = true;
                }
            }
            objectInput.close();
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();   
        }
        return entregadores;
    }
    public void escrever(String nome, ArrayList<Entregador> entregador) throws IOException{
        try {
            FileOutputStream fileOutput = new FileOutputStream(nome);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            for(Entregador funcionario : entregador){
                objectOutput.writeObject(funcionario);
            }
            objectOutput.close();
            fileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
