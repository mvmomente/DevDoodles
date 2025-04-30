import java.util.Scanner;

public class Main{
    public static void main(String[]args) {
        
        Scanner ler = new Scanner(System.in);
        System.out.println("--Spotify--");

        Artista artista1 = new Artista("Marcos", 0);
        System.out.println("Artista: " + artista1.getNome() + "Seguidores: " + artista1.getSeguidor());

        int i = 1;

        while (i == 1) {
            System.out.println("Digite o nome da musica: ");
            String nomeMusica = ler.nextLine();
            artista1.upload(nomeMusica);
            System.out.println("Deseja realizar mais 1 upload ?");

            if (ler.hasNextInt()) {
                i = ler.nextInt();
                ler.nextLine();
            } else {
                System.out.println("Entrada inválida. Continuando como se fosse 'não'.");
                i = 0; // Assume 'não' em caso de entrada inválida
                ler.nextLine();
            }
        }

        System.out.println("\n--- Lista de Músicas ---");
        artista1.exibirMusica();

    }
}