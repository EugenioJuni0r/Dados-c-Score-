package JogoDosDados;

public class Jogador implements Comparable<Jogador>{  
    private int id;
    private String name;
    private int valorDaAposta;
    private int vitorias = 0;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
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
    @Override 
    public int compareTo(Jogador outro){
        return Integer.compare(outro.getVitorias(), this.getVitorias());
    }
}
