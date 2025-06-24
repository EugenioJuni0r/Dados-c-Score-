import JogoDosDados.*;
import java.io.IOException;
public class main{
    public static void main(String[] args) throws Exception{
        Jogo run = new Jogo();
        run.inserirJogadores();
        run.inserirApostas();
        run.lancarDados();
        run.mostrarDados();
        run.mostrarVencedores();
        try{
            run.salvarRankingCSV("ranking.csv");
            System.out.println("Ranking salvo em 'ranking.csv'");
        }catch(IOException e){
            System.out.println("Erro ao salvar o ranking: " + e.getMessage());
        }
        System.out.println("Ranking Geral!:");
        run.mostrarRanking();
    }
}
