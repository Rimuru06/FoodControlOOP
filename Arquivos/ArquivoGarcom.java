package Arquivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import Funcionario.Garcom;

public class ArquivoGarcom {
    public List<Garcom> ler(String nome){
        List<Garcom> garcons = new ArrayList<>();
        try {
            File arq = new File(nome);
            FileInputStream fileInput = new FileInputStream(arq);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            boolean fim = false;
            while (!fim){
                try {
                    Garcom aux = (Garcom) objectInput.readObject();
                    garcons.add(aux);
                } catch(Exception e){
                    fim = true;
                }
            }
            objectInput.close();
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();   
        }
        return garcons;
    }
    public void escrever(String nome, List<Garcom> garcons){
        try {
            FileOutputStream fileOutput = new FileOutputStream(nome);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            for (Garcom func : garcons){
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
