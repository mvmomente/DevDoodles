import java.util.ArrayList;

public class Artista {

    private String nome;
    private int seguidor;
    private ArrayList<Musica> musicas;

    public Artista(String nome, int seguidor){
        this.nome = nome;
        this.seguidor = seguidor;
        this.musicas = new ArrayList<>();
    }

    //METODOS GETTER
    public String getNome() {
        return nome;
    }
    public int getSeguidor() {
        return seguidor;
    }


    //METODOS UPLOAD E EXIBIR
    public Musica upload(String nomeMusica) {
        Musica musica = new Musica(nomeMusica, 0, 0);
        this.musicas.add(musica);
        return musica;
    }

    public void exibirMusica() {
        if (musicas.isEmpty()) {
            System.out.println(nome + "Não possui nenhuma musica!");
        } else {
            System.out.println("---Musicas de" + nome + "---");
            for (Musica musica : musicas) {
                musica.exibirDetalhes();
            }
        }
    }
}
