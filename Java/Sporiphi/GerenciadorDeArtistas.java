import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeArtistas {
    private ArrayList<Artista> artistas;
    private Scanner ler;

    public GerenciadorDeArtistas(Scanner ler) {
        this.artistas = new ArrayList<>();
        this.ler = ler;
    }

    public void criarArtista() {
        System.out.println("Digite o Nome do Artista: ");
        String nomeArtista = ler.nextLine();
        Artista novoArtista = new Artista(nomeArtista, 0);
        artistas.add(novoArtista);
        System.out.println("Artista: " + nomeArtista + "criado com sucesso!");
    }

    public Artista selecionarArtista() {
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
            return null;
        }

        System.out.println("Selecione um Artista");

        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + artistas.get(i).getNome());
        }

        int escolha;

        do {
            System.out.println("Digite o numero do artista: ");
            if (ler.hasNextInt()) {
                escolha = ler.nextInt();
                ler.nextLine();
                if (escolha >= 1 && escolha <= artistas.size()) {
                    return artistas.get(escolha - 1);
                } else {
                    System.out.println("Numero inválido");
                }
            } else {
                System.out.println("Entrada invalida. Digite um numero.");
                ler.nextLine();
                escolha = -1;
            }
        } while (true);
    }

    public void exibirArtistas() {
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista encontrado.");
        } else {
            System.out.println("-- Lista de Artistas --");
            for (Artista artista : artistas) {
                System.out.println("- " + artista.getNome() + " (Seguidores: " + artista.getSeguidor() + ")");
            }
        }

    }
}
