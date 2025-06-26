package JogoDosDados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jogo{

    Scanner ler = new Scanner(System.in);
    ArrayList<Jogador> jogadores = new ArrayList<>();
    Dados dado1 = new Dados();
    Dados dado2 = new Dados();

    public void inserirJogadores() {
        boolean continuar = false;
        int op;
        do{
            Jogador jogador = new Jogador();
            System.out.print("Digite o nome do jogador: ");
            jogador.setName(ler.nextLine());
            System.out.println("Digite o ID desse usuario: ");
            jogador.setId(ler.nextInt());
            jogadores.add(jogador);
            System.out.print("Deseja adicionar mais alguém? (1-SIM): ");
            op = ler.nextInt();
            if(op == 1){
                continuar = true;
            } else {
                continuar = false;
            }
            ler.nextLine();
        }while(continuar);
    }
    public void inserirApostas(){
        for (Jogador jogador : jogadores) {
            System.out.print("Digite a aposta de " + jogador.getName() + ": ");
            int aposta = ler.nextInt();
            jogador.setValorDaAposta(aposta);
        }
        ler.nextLine();
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
            if(jogador.getValorDaAposta() == (dado1.getValorFace() + dado2.getValorFace())){
                if(contWin == 0){
                    System.out.println("Houveram vencedores no jogo!");
                }
                jogador.adicionarVitoria();
                System.out.println("Nome " + ++contWin + "° vencedor: " + jogador.getName());
            }
        }
        if(contWin == 0){
            System.out.println("Não houveram ganhadores...");
        }
    }
    public void mostrarRanking(){
        
        int posicao = 1;

        Collections.sort(jogadores);
        System.out.println("Ranking de Vitorias!: ");
        for(Jogador jogador: jogadores){
            System.out.println( posicao++ + "° lugar: " + jogador.getName() + "-" + jogador.getVitorias() + "vitoria(s).");
        }
    }
    public void salvarRankingCSV(String nomeArquivo) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));
        writer.println("Nome,Vitorias");
        for (Jogador jogador : jogadores){
            writer.println(jogador.getName() + "," + jogador.getVitorias());
        }
        writer.close();
        System.out.println("Ranking salvo no arquivo: " + nomeArquivo);
    }
}
    public void mostrarDados(){
        System.out.println("Dado 1: " + dado1.getValorFace());
        System.out.println("Dado 2: " + dado2.getValorFace());
        System.out.println("E a soma dos dados deu: " + (dado1.getValorFace() + dado2.getValorFace()));
    }
    public void mostrarVencedores(){
        int contWin = 0;
        for(Jogador jogador: jogadores){
            if(jogador.getValorDaAposta() == 3){
                if(contWin == 0){
                    System.out.println("Houveram vencedores no jogo!");
                }
                jogador.adicionarVitoria();
                System.out.println("Nome " + ++contWin + "° vencedor: " + jogador.getName());
            }
        }
        if(contWin == 0){
            System.out.println("Não houveram ganhadores...");
        }
    }
    public void mostrarRanking(){
        
        int posicao = 1;

        Collections.sort(jogadores);
        System.out.println("Ranking de Vitorias!: ");
        for(Jogador jogador: jogadores){
            System.out.println( posicao++ + "° lugar: " + jogador.getName() + "-" + jogador.getVitorias() + "vitoria(s).");
        }
    }
    public void salvarRankingCSV(String nomeArquivo) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));
        writer.println("Nome,Vitorias");
        for (Jogador jogador : jogadores){
            writer.println(jogador.getName() + "," + jogador.getVitorias());
        }
        writer.close();
        System.out.println("Ranking salvo no arquivo: " + nomeArquivo);
    }
}
