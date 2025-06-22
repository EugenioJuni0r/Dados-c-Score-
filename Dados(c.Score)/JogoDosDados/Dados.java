package JogoDosDados;

public class Dados{

    private int valorFace;

    public int getValorFace(){
        return valorFace;
    }
    public void setValorFace(){
        valorFace = (int)(1+Math.random()*6);
    }
}
