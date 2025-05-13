import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void criarGuiche(int numeroGuiche){
        Guiche guiche = new Guiche(numeroGuiche);
        Guiches.adicionarGuiche(guiche);
    }

    public static void main(String[] args) {




        while (true) {
            Scanner entrada = new Scanner(System.in);

            System.out.println("0- criar guiche\n" +
                    "1- criar cliente \n" +
                    "2- atender cliente \n" +
                    "3- cliente atendido\n" +
                    "4- sair ");


            if(entrada.hasNextInt()){ // verifica se é inteiro
                int opcao = entrada.nextInt();
                entrada.nextLine(); // recebe o enter
                if (opcao == 0) {
                    System.out.println("qual o numero do guiche q voce vai criar ?");
                    while (!entrada.hasNextInt()){
                        System.out.println("Digite um numero para o guiche !!!");
                        entrada.next();// é necessario consumir oq foi digitado para n ficar preso no digito anterior
                    }
                    int numerodoGuiche = entrada.nextInt();
                    Main.criarGuiche(numerodoGuiche);

                } else if (opcao == 1) {
                    // criar cliente
                    System.out.println("digite o nome");
                    while (!entrada.hasNext("[a-zA-Z ]+") ){ //so pode letras e espaço expresso regualr
                        System.out.println("digite um nome");
                        entrada.next();
                    }
                    String nome = entrada.nextLine();


                    Cliente cliente = new Cliente();
                    cliente.setNome(nome);

                    // criar senha do cliente
                    cliente.gerarSenha();

                    // adicionar o cliente na fila
                    Fila.adicionarFila(cliente);
                    System.out.println("cliente na fila ");

                } else if (opcao == 2) {
                    if (Fila.proximoFila() != null) {
                        // atender o cliente
                        Cliente proximoFila = Fila.proximoFila();
                        //aqui eu vou ter q mudar e pegar o guiche q esta fazendo o atendimento

                        // o numero tem q ser interiro e igual o id do guiche
                        while (true){
                            int numero;
                            System.out.println("digite o numero do guiche ");

                            if(entrada.hasNextInt()){
                                numero = entrada.nextInt();
                                if (numero <= Guiches.quantidadeGuiches() && numero > 0 ){
                                    if(Guiches.guicheEscolhido(numero - 1).id == numero && Guiches.guicheEscolhido(numero -1 ) != null ){
                                        Guiche guicheEscolhido =  Guiches.guicheEscolhido(numero - 1);
                                        guicheEscolhido.atendendo(proximoFila,numero - 1);
                                        Fila.removerFila(proximoFila);
                                        break;
                                    }else {
                                        System.out.println("Nao existe esse guiche");
                                    }
                                }
                            }else {
                                System.out.println("digite apenas um numero ");
                                entrada.next();
                            }

                        }
                    } else {
                        System.out.println("n tem cliente ");
                    }

                } else if (opcao == 3) {

                    int numero;
                    do {
                        System.out.println("Numero do guiche q vai finalizar o atendimento ? ");
                        while (!entrada.hasNextInt()) {
                            System.out.println("digite um numero apenas");
                            entrada.next(); // pra consumir o digito errado
                        }

                        numero = entrada.nextInt();
                        if(numero <= Guiches.quantidadeGuiches()){
                            break;
                        }else {
                            System.out.println("nao tem esse guiche, digite novamente");
                        }


                    }while(true);

                    Guiche guiche = Guiches.guicheEscolhido(numero - 1);
                    if (guiche.pegarClienteDoGuiche() != null) {
                        // remover o cliente da fila
                        guiche.naoAtendendo();
                    } else {
                        System.out.println(" n tem cliente ");
                    }

                } else if(opcao == 4){
                    break;
                }else {
                    System.out.println("opcao invalid");
                }
            }else {
                System.out.println("nao é um numero");
            }

        }
    }
}