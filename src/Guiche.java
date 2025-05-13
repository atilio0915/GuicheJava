import java.util.ArrayList;

 public class Guiche {

     ArrayList<Cliente> clientesGuiche = new ArrayList<>();

     int id;
     int tamanho = clientesGuiche.size();

     public Guiche(int numeroGuiche){
         this.id = numeroGuiche;
     }

     public ArrayList<Cliente> clienteDoGuiche() {
         int tamanho = clientesGuiche.size();
         System.out.println(tamanho);
         return clientesGuiche;

     }
     public Cliente pegarClienteDoGuiche(){
         Cliente cliente = clientesGuiche.get(0);
         return cliente != null ? cliente : null ;
     }



     public void atendendo(Cliente cliente, int numeroGuiche ) {

         String nome = cliente.getNome();
         System.out.println("cliente "+ nome);
         String senha = cliente.getSenha();
         System.out.println("Senha: "+ senha);
         System.out.println(" caixa " + Guiches.guicheEscolhido(numeroGuiche).id);
         clientesGuiche.add(cliente);
         System.out.println(clientesGuiche.size());
     }

     public void naoAtendendo() {
         if (clientesGuiche.size() > 0) {

             String nome = clientesGuiche.get(0).getNome();
             clientesGuiche.remove(clientesGuiche.get(0)); // remover o cliente do guiche
             System.out.println("cliente " + nome + " foi atendido");
         } else {
             System.out.println("nao tem cliente sendo atendido ");
         }
     }
 }
