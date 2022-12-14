package Restaurante;

import java.util.HashMap;

public class Chapa {
    private int quantFileFrango;
    private int quantLinguica;
    private int quantAlcatra;
    private int quantCoracao;

    public Chapa (){
        this.quantFileFrango=0;
        this.quantLinguica=0;
        this.quantAlcatra=0;
        this.quantCoracao=0;
    }

    public void servir(String carne, int quantos){
        switch(carne) {
            case "filé de frango" -> {
                if (quantFileFrango>=quantos){
                    this.quantFileFrango -= quantos;
                } else System.out.print("\nNão há quantidade suficiente de filé de frango de deseja\n\n");
            }
            case "linguiça" -> {
                if (quantLinguica>=quantos){
                    this.quantLinguica -= quantos;
                } else System.out.print("\nNão há quantidade suficiente de linguiça de deseja\n\n");
            }
            case "alcatra" -> {
                if (quantAlcatra>=quantos){
                    this.quantAlcatra -= quantos;
                } else System.out.print("\nNão há quantidade suficiente de alcatra de deseja\n\n");
            }
            case "coração" -> {
                if (quantCoracao>=quantos){
                    this.quantCoracao -= quantos;
                } else System.out.print("\nNão há quantidade suficiente de coração de deseja\n\n");
            }
        }
    }

    public void adicionarAChapa(HashMap ingredientes, String carne, int quantos) {
        boolean possivel = true;
        if((Integer)ingredientes.get(carne)<quantos){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get(carne);
            ingredientes.put(carne, quant-quantos);
            System.out.print("\n" + carne + " pronto!\n");
            switch(carne){
                case "filé de frango" -> {
                    if ((Integer)ingredientes.get(carne)>=quantos){
                        this.quantFileFrango+=quantos;
                        ingredientes.put(carne, (Integer)ingredientes.get(carne)-quantos);
                    } else System.out.print("\nNão há ingredientes suficientes em estoque\n");
                }
                case "linguiça" -> {
                    if ((Integer)ingredientes.get(carne)>=quantos){
                        this.quantLinguica+=quantos;
                        ingredientes.put(carne, (Integer)ingredientes.get(carne)-quantos);
                    } else System.out.print("\nNão há ingredientes suficientes em estoque\n");
                }
                case "alcatra" -> {
                    if ((Integer)ingredientes.get(carne)>=quantos){
                        this.quantAlcatra+=quantos;
                        ingredientes.put(carne, (Integer)ingredientes.get(carne)-quantos);
                    } else System.out.print("\nNão há ingredientes suficientes em estoque\n");
                }
                case "coração" -> {
                    if ((Integer)ingredientes.get(carne)>=quantos){
                        this.quantCoracao+=quantos;
                        ingredientes.put(carne, (Integer)ingredientes.get(carne)-quantos);
                    } else System.out.print("\nNão há ingredientes suficientes em estoque\n");
                }
            }
        } else System.out.print("Não é possível realizar este pedido, pois, falta " + carne + " suficiente\n");
    }
}
