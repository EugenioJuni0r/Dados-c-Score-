import JogoDosDados.*;

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
