package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Arquivos.*;
import Funcionario.Cozinheiro;
import Funcionario.Entregador;
import Funcionario.Garcom;
import Lanchonete.Lanchonete;
import Restaurante.*;

public class Main {
    public static void main (String[] args) throws IOException {
        ArquivoIngrediente arquivoIngrediente = new ArquivoIngrediente();
        ArquivoCozinheiro arquivoCozinheiro = new ArquivoCozinheiro();
        ArquivoGarcom arquivoGarcom = new ArquivoGarcom();
        ArquivoEntregador arquivoEntregador = new ArquivoEntregador();

        HashMap<String, Integer> ingredientes = new HashMap<String,Integer>();
        ingredientes = arquivoIngrediente.ler("ingredientes.dat");
        List<Cozinheiro> cozinheiros = arquivoCozinheiro.ler("cozinheiros.dat");
        List<Garcom> garcons = arquivoGarcom.ler("garcons.dat");
        ArrayList<Entregador> entregadores = arquivoEntregador.ler("entregadores.dat");

        Lanchonete lanchonete = new Lanchonete();
        Chapa chapa = new Chapa();
        Buffet buffet = new Buffet();

        Scanner teclado = new Scanner(System.in);
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        System.out.print("\n\n\n----------------------------------------------------------\n");
        System.out.print("\n----------------------------------------------------------\n");
        System.out.print("\nBEM-VINDO AO SOFTWARE FOODCONTROL\n\nProduzido por: Felipe Nunes Macario De Faria & Thiago Ribeiro Aragão\n");
        int etapaMenu = 0;

        do {
            System.out.print("\n----------------------------------------------------------\n");
            System.out.print("\n\nSISTEMA PRINCIPAL\n1 - Sistema interno\n2 - Restaurante\n3 - Lanchonete\n4 - Estoque\n5 - Sair do sistema\nDigite a opção da onde deseja: ");
            etapaMenu = teclado.nextInt();
            if (etapaMenu<1 || etapaMenu>5){
                System.out.print("\nDesculpe, mas essa opção é inválida");
            }

            if (etapaMenu == 1){
                //Sistema interno
                int menuInterno;
                System.out.print("\n----------------------------------------------------------\n");
                System.out.print("\n\nSISTEMA INTERNO\n1 - Adicionar funcionário\n2 - Ver ficha de funcionários\n3 - Mudar status de férias de funcionário\n4 - Mudar endereço de funcionário\n5 - Retornar ao sistema principal\nDigite a opção da onde deseja: ");
                menuInterno = teclado.nextInt();

                if (menuInterno == 1){
                    //Adicionando funcionário
                    System.out.print("\n\nDigite o cargo do funcionário (1) cozinheiro,(2) garçom ou (3) entregador: ");
                    int cargo = teclado.nextInt();
                    System.out.print("\nDigite o nome do funcionário: ");
                    String nome = reader.readLine();
                    System.out.print("\nDigite o endereco do funcionário: ");
                    String endereco = reader.readLine();
                    System.out.print("\nDigite o CPF do funcionário (sem traços ou pontos): ");
                    int CPF = teclado.nextInt();
                    if (cargo == 1){
                        System.out.print("\nDigite o número CLT: ");
                        int CLT = teclado.nextInt();
                        System.out.print("\nDigite a especialidade culinária (bebidas / carnes / japonesa / massas / salgados / nenhuma): ");
                        String especialidade = teclado.next();
                        Cozinheiro novoFunccionario = new Cozinheiro (nome, CPF, endereco, "cozinheiro", CLT, especialidade);
                        cozinheiros.add(novoFunccionario);
                    } else if (cargo == 2){
                        System.out.print("\nDigite o número CLT: ");
                        int CLT = teclado.nextInt();
                        Garcom novoFunccionario = new Garcom (nome, CPF, endereco, "garçom", CLT);
                        garcons.add(novoFunccionario);
                    } else if (cargo == 3){
                        System.out.print("\nDigite o número CLT: ");
                        int CLT = teclado.nextInt();
                        System.out.print("\nDigite o status da CNH (valido / invalido): ");
                        String CNH = teclado.next();
                        Entregador novoFunccionario = new Entregador (nome, CPF, endereco, "entregador", CNH);
                        entregadores.add(novoFunccionario);
                    }
                    menuInterno = 0;
                }

                if (menuInterno == 2){
                    //Ficha dos funcionários
                    try{
                        for (Cozinheiro funcionario : cozinheiros) {
                            funcionario.ficha();
                        }
                    } catch (Exception e){
                        System.out.print("\nNão há cozinheiros trabalhando ainda\n");
                    }
                    try{
                        for (Garcom funcionario : garcons){
                            funcionario.ficha();
                        }
                    } catch (Exception e){
                        System.out.print("\nNão há garçons trabalhando ainda\n");
                    }
                    try{
                        for (Entregador funcionario : entregadores){
                            funcionario.ficha();
                        }
                    } catch (Exception e){
                        System.out.print("\nNão há entregadores trabalhando ainda\n");
                    }
                    menuInterno = 0;
                }

                if (menuInterno == 3){
                    System.out.print("\n\nDeseja dar férias, ou retornar de férias, um (1) cozinheiro ou (2) garçom: ");
                    int funFerias = teclado.nextInt();
                    System.out.print("\nQual o CPF do funcionário: ");
                    int CPF = teclado.nextInt();
                    if (funFerias==1){
                        for (Cozinheiro aux : cozinheiros){
                            if (CPF == aux.getCPF()){
                                aux.tirarFerias();
                            }
                        }
                    } else if (funFerias==2){
                        for (Garcom aux : garcons){
                            if (CPF == aux.getCPF()){
                                aux.tirarFerias();
                            }
                        }
                    }
                    menuInterno = 0;
                }

                if (menuInterno == 4){
                    //Mudar endereço
                    System.out.print("\n\nDeseja mudar o endereço de um (1) cozinheiro, (2) garçom ou (3) entregador: ");
                    int funEnde = teclado.nextInt();
                    System.out.print("\nQual o CPF do funcionário: ");
                    int CPF = teclado.nextInt();
                    System.out.print("\nQual novo endereço do funcionário: ");
                    String endereco = reader.readLine();
                    if (funEnde==1){
                        for (Cozinheiro aux : cozinheiros){
                            if (CPF == aux.getCPF()){
                                aux.mudarEndereco(endereco);
                            }
                        }
                    } else if (funEnde==2){
                        for (Garcom aux : garcons){
                            if (CPF == aux.getCPF()){
                                aux.mudarEndereco(endereco);
                            }
                        }
                    } else if (funEnde==3){
                        for (Entregador aux : entregadores){
                            if (CPF == aux.getCPF()){
                                aux.mudarEndereco(endereco);
                            }
                        }
                    }
                    menuInterno = 0;
                }

                if (menuInterno == 5){
                    menuInterno = 0;
                }
                etapaMenu = 0;
            }

            if (etapaMenu == 2){
                //Restaurante
                int menuRestaurante;
                System.out.print("\n----------------------------------------------------------\n");
                System.out.print("\n\nSISTEMA DO RESTAURANTE\n1 - Chapa\n2 - Buffet\n3 - Retornar ao sistema principal\nDigite a opção da onde deseja: ");
                menuRestaurante = teclado.nextInt();
                int quantos;
                if (menuRestaurante==1){
                    String carne;
                    System.out.print("\nDeseja adicionar quantas carnes a chapa (digite 0 se não quiser adicionar carne a chapa): ");
                    quantos = teclado.nextInt();
                    if (quantos != 0){
                        System.out.print("\nDeseja qual carne a chapa:\nfilé de frango\nlinguiça\nalcatra\ncoração\n");
                        carne = reader.readLine();
                        chapa.adicionarAChapa(ingredientes, carne, quantos);
                    }
                    System.out.print("\nDeseja servir quantas carnes a (digite 0 se não quiser servir nenhuma carne da chapa): ");
                    quantos = teclado.nextInt();
                    if (quantos != 0){
                        System.out.print("\nDeseja qual carne a chapa:\nfilé de frango\nlinguiça\nalcatra\ncoração\n");
                        carne = reader.readLine();
                        chapa.servir(carne, quantos);
                    }
                    menuRestaurante = 0;
                } else if (menuRestaurante==2){
                    int comidaBuffet=0;
                    do {
                        System.out.print("\nPreparar qual comida para o buffet:\n1 - Arroz\n2 - Feijão\n3 - Batata frita\n4 - farofa\n5 - Farofa\n6 - Não desejo preparar algo para o buffet agora\n");
                        comidaBuffet = teclado.nextInt();
                        if (comidaBuffet == 1) {
                            buffet.fazerArroz(ingredientes);
                        } else if (comidaBuffet == 2) {
                            buffet.fazerFeijao(ingredientes);
                        } else if (comidaBuffet == 3) {
                            buffet.fazerBatataFrita(ingredientes);
                        } else if (comidaBuffet == 4) {
                            buffet.fazerFarofa(ingredientes);
                        } else if (comidaBuffet == 5) {
                            buffet.fazerFarofa(ingredientes);
                        }
                    } while (comidaBuffet!=6);
                    System.out.print("\nDeseja servir quantos itens do buffet (digite 0 se não quiser adicionar carne a chapa): ");
                    quantos = teclado.nextInt();
                    String item;
                    if (quantos != 0){
                        System.out.print("\nDeseja qual item a buffet:\narroz\nfeijão\nbatata frita\nfarofa\nvinagrete\n");
                        item = reader.readLine();
                        buffet.servir(item, quantos);
                    }
                    menuRestaurante = 0;
                } else if (menuRestaurante==3){
                    menuRestaurante = 0;
                }
                etapaMenu = 0;
            }

            if (etapaMenu == 3){
                //Lanchonete AQUI
                int fazerouservir;
                int salgado=0;
                System.out.print("\n----------------------------------------------------------\n");
                System.out.print("SISTEMA DA LANCHONETE\nDeseja fazer ou servir um salgado:\n1 - Fazer\n2 - Servir\n3 - Voltar\n");
                fazerouservir = teclado.nextInt();
                if (fazerouservir==1){
                    System.out.print("\nQual salgado deseja fazer:\n");
                } else if (fazerouservir==2) {
                    System.out.print("\nQual salgado deseja servir:\n");
                }
                if (fazerouservir!=3){
                    System.out.print("1 - Coxinha\n2 - Italiano\n3 - Enroladinho de salsicha\n4 - Hámburguer\n");
                    salgado = teclado.nextInt();
                }
                if (fazerouservir==1){
                    switch (salgado){
                        case 1 -> lanchonete.fazerCoxinha(ingredientes);
                        case 2 -> lanchonete.fazerItaliano(ingredientes);
                        case 3 -> lanchonete.fazerEnroladinhaSalsicha(ingredientes);
                        case 4 -> lanchonete.fazerHamburguer(ingredientes);
                    }
                } else if (fazerouservir==2) {
                    switch (salgado){
                        case 1 -> lanchonete.servirCoxinha();
                        case 2 -> lanchonete.servirItaliano();
                        case 3 -> lanchonete.servirEnroladinhaSalsicha();
                        case 4 -> lanchonete.servirHamburguer();
                    }
                }
                etapaMenu = 0;
            }

            if (etapaMenu == 4){
                //Estoque
                System.out.print("\n----------------------------------------------------------\n");
                int estoque = 0;
                do{
                    System.out.print("\nSISTEMA DO ESTOQUE\n1 - Adicionar ingrediente\n2 - Ver lista de ingredientes\n3 - Voltar\n");
                    estoque = teclado.nextInt();
                    if(estoque == 1){
                        String nomeIngrediente;
                        System.out.print("\nQual ingrediente deseja adicionar ?\n");
                        nomeIngrediente = reader.readLine();
                        int quantidade;
                        System.out.print("\nQual a quantidade deseja adicionar ?\n");
                        quantidade = teclado.nextInt();
                        ingredientes.put(nomeIngrediente, quantidade);
                    }
                    if(estoque == 2){
                        if(ingredientes.isEmpty() == true){
                            System.out.print("\nSem ingredientes no estoque\n");
                        }
                        for(HashMap.Entry<String,Integer> set: ingredientes.entrySet()){
                            System.out.print("\n\nIngrediente: ");
                            System.out.print(set.getKey());
                            System.out.print("\nQuantidade: ");
                            System.out.print(set.getValue());
                        }
                    }

                }while(estoque != 3);
                etapaMenu = 0;
            }
        } while (etapaMenu!=5);

        teclado.close();
        arquivoIngrediente.escrever("ingredientes.dat", ingredientes);
        arquivoCozinheiro.escrever("cozinheiros.dat", cozinheiros);
        arquivoGarcom.escrever("garcons.dat", garcons);
        arquivoEntregador.escrever("entregadores.dat", entregadores);

    }

}
