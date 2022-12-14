package Arquivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import Funcionario.Cozinheiro;

public class ArquivoCozinheiro {
    public List<Cozinheiro> ler(String nome){
        List<Cozinheiro> cozinheiros = new ArrayList<>();
        try {
            File arq = new File(nome);
            FileInputStream fileInput = new FileInputStream(arq);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            boolean fim = false;
            while (!fim){
                try {
                    Cozinheiro aux = (Cozinheiro) objectInput.readObject();
                    cozinheiros.add(aux);
                } catch(Exception e){
                    fim = true;
                }
            }
            objectInput.close();
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();   
        }
        return cozinheiros;
    }
    public void escrever(String nome, List<Cozinheiro> cozinheiros){
        try {
            FileOutputStream fileOutput = new FileOutputStream(nome);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            for (Cozinheiro func : cozinheiros){
                objectOutput.writeObject(func);
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
