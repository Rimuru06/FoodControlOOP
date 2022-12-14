package Restaurante;

import java.util.HashMap;

public class Buffet {
    private int quantArroz;
    private int quantFeijao;
    private int quantBatataFrita;
    private int quantFarofa;
    private int quantVinagrete;

    public Buffet (){
        this.quantArroz=0;
        this.quantFeijao=0;
        this.quantBatataFrita=0;
        this.quantFarofa=0;
        this.quantVinagrete=0;
    }

    public void fazerArroz(HashMap ingredientes){
        boolean possivel = true;
        if(ingredientes.get("arroz")==null){
            possivel=false;
        } else if (ingredientes.get("óleo")==null){
            possivel=false;
        } else if (ingredientes.get("alho")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("arroz");
            ingredientes.put("arroz", quant-1);
            quant = (Integer) ingredientes.get("óleo");
            ingredientes.put("óleo", quant-1);
            quant = (Integer) ingredientes.get("alho");
            ingredientes.put("alho", quant-1);
            this.quantArroz++;
        } else System.out.print("Não é possível realizar este pedido\n");
    }

    public void fazerFeijao(HashMap ingredientes){
        boolean possivel = true;
        if(ingredientes.get("feijão")==null){
            possivel=false;
        } else if (ingredientes.get("alho")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("feijão");
            ingredientes.put("feijão", quant-1);
            quant = (Integer) ingredientes.get("alho");
            ingredientes.put("alho", quant-1);
            this.quantFeijao++;
        } else System.out.print("Não é possível realizar este pedido\n");
    }

    public void fazerBatataFrita(HashMap ingredientes){
        boolean possivel = true;
        if(ingredientes.get("batata")==null){
            possivel=false;
        } else if (ingredientes.get("óleo")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("batata");
            ingredientes.put("batata", quant-1);
            quant = (Integer) ingredientes.get("óleo");
            ingredientes.put("óleo", quant-1);
            this.quantBatataFrita++;
        } else System.out.print("Não é possível realizar este pedido\n");
    }

    public void fazerFarofa(HashMap ingredientes){
        boolean possivel = true;
        if(ingredientes.get("farinha")==null){
            possivel=false;
        } else if (ingredientes.get("manteiga")==null){
            possivel=false;
        } else if (ingredientes.get("cebola")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("farinha");
            ingredientes.put("farinha", quant-1);
            quant = (Integer) ingredientes.get("manteiga");
            ingredientes.put("manteiga", quant-1);
            quant = (Integer) ingredientes.get("cebola");
            ingredientes.put("cebola", quant-1);
            this.quantFarofa++;
        } else System.out.print("Não é possível realizar este pedido\n");
    }

    public void fazerVinagrete(HashMap ingredientes){
        boolean possivel = true;
        if(ingredientes.get("tomate")==null){
            possivel=false;
        } else if (ingredientes.get("cebola")==null){
            possivel=false;
        } else if (ingredientes.get("pimentão")==null){
            possivel=false;
        }
        if (possivel){
            Integer quant = (Integer) ingredientes.get("tomate");
            ingredientes.put("tomate", quant-1);
            quant = (Integer) ingredientes.get("cebola");
            ingredientes.put("cebola", quant-1);
            quant = (Integer) ingredientes.get("pimentão");
            ingredientes.put("pimentão", quant-1);
            this.quantVinagrete++;
        } else System.out.print("Não é possível realizar este pedido\n");
    }

    public void servir(String item, int quantos){
        switch(item) {
            case "arroz" -> {if (this.quantArroz>=quantos){
                this.quantArroz -= quantos;
                } else System.out.print("\nNão há tal quantidade de arroz a servir\n");
            }
            case "feijão" -> {if (this.quantFeijao>=quantos){
                this.quantFeijao -= quantos;
            } else System.out.print("\nNão há tal quantidade de feijão a servir\n");
            }
            case "batata frita" -> {if (this.quantBatataFrita>=quantos){
                this.quantArroz -= quantos;
            } else System.out.print("\nNão há tal quantidade de batata frita a servir\n");
            }
            case "farofa" -> {if (this.quantFarofa>=quantos){
                this.quantFarofa -= quantos;
            } else System.out.print("\nNão há tal quantidade de farofa a servir\n");
            }
            case "vinagrete" -> {if (this.quantVinagrete>=quantos){
                this.quantVinagrete -= quantos;
            } else System.out.print("\nNão há tal quantidade de arroz a servir\n");
            }
        }
    }
}
