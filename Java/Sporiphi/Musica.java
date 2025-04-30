public class Musica {

    private String nome;
    private int ouvintes;
    private int like;

    public Musica(String nome, int ouvintes, int like) {
        this.nome = nome;
        this.ouvintes = ouvintes;
        this.like = like;
    } 

    //METODOS GETTER
    public void Curtir(){
        this.like ++;
    }
    public void Ouvir(){
        this.ouvintes +=10;
    }

    public String getNome() {
        return nome;
    }

    public int getOuvintes() {
        return ouvintes;
    }

    public int getCurtidas() {
        return like;
    }

    //METODO PARA EXIBIR DETALHADAMENTE INFORMAÇÕES DA MUSICA
    public void exibirDetalhes() {
        System.out.println("NOME: " + nome + "| CURTIDAS: " + like + "|OUVINTES: " + ouvintes);
    }
    
}
