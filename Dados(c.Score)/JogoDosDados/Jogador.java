package JogoDosDados;

public class Jogador implements Comparable<Jogador>{    /*Comparable é uma interface que compara objetos de uma classe*/

    private String name;
    private int valorDaAposta;
    private int vitorias = 0;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getValorDaAposta(){
        return valorDaAposta;
    }
    public void setValorDaAposta(int valorDaAposta){
        this.valorDaAposta = valorDaAposta;
    }
    public void adicionarVitoria(){
        vitorias++;
    }
    public int getVitorias(){
        return vitorias;
    }
    @Override /*Sobre escrita de "Comparable" que coloca a Lista de Jogador em ordem decrecente*/
    public int compareTo(Jogador outro){
        return Integer.compare(outro.getVitorias(), this.getVitorias());
    }
}
