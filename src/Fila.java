import java.util.ArrayList;

public class Fila {
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void adicionarFila(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void removerFila(Cliente cliente) {
        clientes.remove(cliente);
    }

    public static Cliente proximoFila() { // esse cliente na frete é o tipo de retorn
        return clientes.size() > 0 ? clientes.get(0) : null;

    }
}