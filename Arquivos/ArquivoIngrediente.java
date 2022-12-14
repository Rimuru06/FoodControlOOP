package Arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import Alimento.Ingrediente;

public class ArquivoIngrediente{
    public HashMap<String, Integer> ler(String nome){
        HashMap<String,Integer> ingredientes = new HashMap<String,Integer>();
        try {
            FileInputStream fileInput = new FileInputStream(nome);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            boolean fim = false;
            while (!fim){
                try {
                    Ingrediente aux = (Ingrediente) objectInput.readObject();
                    ingredientes.put(aux.getNome(), aux.getQuantidade());
                } catch (Exception e) {
                    fim = true;
                }
            }
            objectInput.close();
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }
    public void escrever(String nome, HashMap<String, Integer> ingredientes2){
        try {
            FileOutputStream fileOutput = new FileOutputStream(nome);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            for(HashMap.Entry<String,Integer> set: ingredientes2.entrySet()){
                Ingrediente aux = new Ingrediente(set.getKey(),set.getValue());
                objectOutput.writeObject(aux);
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
