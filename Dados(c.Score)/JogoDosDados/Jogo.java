package JogoDosDados;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo{

    Scanner ler = new Scanner(System.in);
    ArrayList<Jogador> jogadores = new ArrayList<>();
    Dados dado1 = new Dados();
    Dados dado2 = new Dados();

    public void inserirJogadores() {
        boolean continuar;
        do{
            System.out.print("Digite o nome do jogador: ");
            Jogador jogador = new Jogador();
            jogador.setName(ler.nextLine());
            jogadores.add(jogador);
            System.out.print("Deseja adicionar mais alguém? (1-SIM/0-NAO): ");
            continuar = ler.nextBoolean();
        }while(continuar);
    }
    public void inserirApostas(){
        for (Jogador jogador : jogadores) {
            System.out.print("Digite a aposta de " + jogador.getName() + ": ");
            int aposta = ler.nextInt();
            jogador.setValorDaAposta(aposta);
        }
        ler.nextLine(); // limpar buffer
    }
    public void lancarDados(){
        dado1.setValorFace();
        dado2.setValorFace();
    }
    public void mostrarDados(){
        System.out.println("Dado 1: " + dado1.getValorFace());
        System.out.println("Dado 2: " + dado2.getValorFace());
        System.out.println("E a soma dos dados deu: " + (dado1.getValorFace() + dado2.getValorFace()));
    }
    public void mostrarVencedores(){
        int contWin = 0;
        for(Jogador jogador: jogadores){
            if(jogador.getValorDaAposta() == (dado1.getValorFace()+dado2.getValorFace())){
                if(contWin == 0){
                    System.out.println("Houveram vencedores no jogo!");
                }
                System.out.println("Nome " + ++contWin + "° vencedor: " + jogador.getName());
            }
        }
        if(contWin == 0){
            System.out.println("Não houveram ganhadores...");
        }
    }
}
