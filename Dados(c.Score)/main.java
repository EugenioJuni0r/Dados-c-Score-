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
    }
}
