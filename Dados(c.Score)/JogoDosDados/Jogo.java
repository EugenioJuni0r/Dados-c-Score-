package JogoDosDados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jogo{
    Scanner ler = new Scanner(System.in);
    String vencedor = null;
    String path = "ranking.csv";
    ArrayList<Jogador> jogadores = new ArrayList<>();
    Dados dado1 = new Dados();
    Dados dado2 = new Dados();
    int novaVitoriaCSV;

    public void inserirJogadores() {
        boolean continuar = false;
        int op;
        do{
            Jogador jogador = new Jogador();
            int idNovoJogador;
            System.out.print("Digite o nome do jogador: ");
            jogador.setName(ler.nextLine());
            do{
                System.out.print("Digite um ID, que ainda nao foi utilizado, para um jogador: ");
                idNovoJogador = ler.nextInt();
                jogador.setId(idNovoJogador);
            }while(verificadorDeId(idNovoJogador));
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
        for (Jogador jogador : jogadores){
            System.out.print("Digite a aposta de " + jogador.getName() + "(2 a 12): ");
            int aposta;
            do{
                aposta = ler.nextInt();
                jogador.setValorDaAposta(aposta);
            }while(aposta > 12 || 2 > aposta);
            ler.nextLine();
        }
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
                if(verificadorDeId(jogador.getId())){
                    vencedor = jogador.getId() + jogador.getName() + ++novaVitoriaCSV;
                }else{
                    vencedor =  jogador.getId() + jogador.getName() + jogador.getVitorias() + "\n";
                }
                MyFileHandle.write(path, vencedor ,true);
            }
        }
        if(contWin == 0){
            System.out.println("Não houveram ganhadores...");
        }
    }
    public boolean verificadorDeId(int idBusca){
        String idBuscaS = Integer.toString(idBusca);
        MyFileHandle.read(path);
        String[] line;
        boolean flag = false;
        for(int i = 0; i < MyFileHandle.lines.size(); i++){
            line = MyFileHandle.lines.get(i).split(";");
            if(idBuscaS == line[0]){
                novaVitoriaCSV = Integer.parseInt(line[2]);
                return true;
            }
        } 
        return false;
    }
}
