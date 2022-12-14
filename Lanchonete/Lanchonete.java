package Lanchonete;

import java.util.HashMap;

public class Lanchonete {
    private int quantCoxinha;
    private int quantItaliano;
    private int quantEnroladinhaSalsicha;
    private int quantHamburguer;

    public Lanchonete(){
        this.quantCoxinha=0;
        this.quantItaliano=0;
        this.quantEnroladinhaSalsicha=0;
        this.quantHamburguer=0;
    }

    public void fazerCoxinha(HashMap ingredientes) {
        boolean possivel = true;
        if(ingredientes.get("oleo")==null){
            possivel=false;
        } else if (ingredientes.get("frango")==null){
            possivel=false;
        } else if (ingredientes.get("molho de tomate")==null){
            possivel=false;
        } else if (ingredientes.get("farinha")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("oleo");
            ingredientes.put("oleo", quant-1);
            quant = (Integer) ingredientes.get("frango");
            ingredientes.put("frango", quant-1);
            quant = (Integer) ingredientes.get("molho de tomate");
            ingredientes.put("molho de tomate", quant-1);
            quant = (Integer) ingredientes.get("farinha");
            ingredientes.put("farinha", quant-1);
            this.quantCoxinha++;
            System.out.print("Nova coxinha pronta!");
        } else naoHaIngrediente();
    }
    public void servirCoxinha(){
        if (quantCoxinha>0){
            this.quantCoxinha--;
        } else System.out.print("\nEstamos sem coxinha no momento\n");
    }

    public void fazerItaliano(HashMap ingredientes) {
        boolean possivel = true;
        if(ingredientes.get("presunto")==null){
            possivel=false;
        } else if (ingredientes.get("queijo")==null){
            possivel=false;
        } else if (ingredientes.get("cebola")==null){
            possivel=false;
        } else if (ingredientes.get("farinha")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("presunto");
            ingredientes.put("presunto", quant-1);
            quant = (Integer) ingredientes.get("queijo");
            ingredientes.put("queijo", quant-1);
            quant = (Integer) ingredientes.get("cebola");
            ingredientes.put("cebola", quant-1);
            quant = (Integer) ingredientes.get("farinha");
            ingredientes.put("farinha", quant-1);
            this.quantItaliano++;
            System.out.print("Novo italiano pronto!");
        } else naoHaIngrediente();
    }
    public void servirItaliano(){
        if (quantItaliano>0){
            this.quantItaliano--;
        } else System.out.print("\nEstamos sem italiano no momento\n");
    }

    public void fazerEnroladinhaSalsicha(HashMap ingredientes) {
        boolean possivel = true;
        if(ingredientes.get("oleo")==null){
            possivel=false;
        } else if (ingredientes.get("salsicha")==null){
            possivel=false;
        } else if (ingredientes.get("farinha")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("oleo");
            ingredientes.put("oleo", quant-1);
            quant = (Integer) ingredientes.get("salsicha");
            ingredientes.put("salsicha", quant-1);
            quant = (Integer) ingredientes.get("farinha");
            ingredientes.put("farinha", quant-1);
            this.quantEnroladinhaSalsicha++;
            System.out.print("Novo enroladinho de salsicha pronto!");
        } else naoHaIngrediente();
    }
    public void servirEnroladinhaSalsicha(){
        if (quantEnroladinhaSalsicha>0){
            this.quantEnroladinhaSalsicha--;
        } else System.out.print("\nEstamos sem enroladinho do salsicha no momento\n");
    }

    public void fazerHamburguer(HashMap ingredientes) {
        boolean possivel = true;
        if(ingredientes.get("pão")==null){
            possivel=false;
        } else if (ingredientes.get("carne moída")==null){
            possivel=false;
        } else if (ingredientes.get("queijo")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("pão");
            ingredientes.put("pão", quant-1);
            quant = (Integer) ingredientes.get("carne moída");
            ingredientes.put("carne moída", quant-1);
            quant = (Integer) ingredientes.get("queijo");
            ingredientes.put("queijo", quant-1);
            this.quantHamburguer++;
            System.out.print("Novo hámburguer pronto!");
        } else naoHaIngrediente();
    }
    public void servirHamburguer(){
        if (quantHamburguer>0){
            this.quantHamburguer--;
        } else System.out.print("\nEstamos sem hámburguer no momento\n");
    }

    private void naoHaIngrediente(){
        System.out.print("\n\nPerdão, mas não temos ingredientes suficientes para fazer esse item\n\n");
    }
}
