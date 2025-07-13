import java.util.Scanner;

public class Main{
    public static void main(String[]args) {
        
        //INICIALIZAÇÃO E INSTANCIAMENTO DE Scanner e GerenciadorDeArtistas
        Scanner ler = new Scanner(System.in);
        GerenciadorDeArtistas gerenciador = new GerenciadorDeArtistas(ler);

        int opcao;
        
        do {
            System.out.println("\n-- Sporiphi--");
            System.out.println("1 - Criar Artista");
            System.out.println("2 - Selecionar Artista");
            System.out.println("3. Exibir Artistas");
            System.out.println("4. Exibir Musicas");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            //VERIFICA SE O VALOR É INTEIRO
            if (ler.hasNextInt()) {
                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        gerenciador.criarArtista();
                        break;
                    case 2:
                        Artista artistaSelecionado = gerenciador.selecionarArtista();

                        //VERIFICA SE artistaSELECIONADO NÃO É IGUAL NULO
                        if (artistaSelecionado != null) {
                            int continuarUpload = 1;
                            while (continuarUpload == 1) {
                                System.out.println("Digite o Nome da Musica:");
                                String nomeMusica = ler.nextLine();
                                artistaSelecionado.upload(nomeMusica);
                                System.out.println("Deseja fazer mais um upload para " + artistaSelecionado.getNome() + "? (1 para sim / 0 para não): ");

                                //VERIFICA SE O VALOR É INTEIRO
                                if (ler.hasNextInt()) {
                                    continuarUpload = ler.nextInt();
                                    ler.nextLine();
                                } else {
                                    System.out.println("Entrada invalida");
                                    ler.nextLine();
                                    continuarUpload = 0;
                                }
                                System.out.println("\n--- Músicas de " + artistaSelecionado.getNome() + " ---");
                                artistaSelecionado.exibirMusica();
                            }
                        }
                        break;
                    case 3:
                        gerenciador.exibirArtistas();
                        break;
                    case 4:
                        Artista exibirMusica = gerenciador.selecionarArtista();
                        if (exibirMusica != null) {
                            System.out.println("\n-- Musicas de " + exibirMusica.getNome() + "--");
                            exibirMusica.exibirMusica();
                        }
                    case 0:
                        System.out.println("Saindo do Sporiphi.");
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada invalida. Digite um número.");
                ler.nextLine();
                opcao =-1;
            }
        } while (opcao !=0);

        ler.close();
    }
}