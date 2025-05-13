import java.util.Random;
public class Cliente {
    private String nome;
    private String senha;

    public void gerarSenha (){
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder senha = new StringBuilder();

        for(int i = 0; i < 3; i++){
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }
        this.senha = senha.toString();
    }


    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    public String getNome() {
        return nome;
    }
    public String getSenha(){
        return senha;
    }
}
