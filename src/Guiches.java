import java.util.ArrayList;


public class Guiches {
    static ArrayList<Guiche> arrayGuiche = new ArrayList<>();

    public static void adicionarGuiche(Guiche numeroGuiche){
         arrayGuiche.add(numeroGuiche);
    }
    public static Guiche guicheEscolhido(int numeroGuiche){
        return arrayGuiche.get(numeroGuiche);
    }
    public static int quantidadeGuiches(){ return arrayGuiche.size();}

    public static Guiche guichePorId(int id) {
        for (Guiche guiche : arrayGuiche) {
            if (guiche.id == id) {
                return guiche;
            }
        }
        return null;
    }

}
