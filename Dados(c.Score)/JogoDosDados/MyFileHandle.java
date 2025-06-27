package JogoDosDados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileHandle {

    public MyFileHandle() {

    }

    public static boolean write(String path, String texto, boolean replace) {
      try {
          FileWriter fw = new FileWriter(path, replace);
          BufferedWriter bw = new BufferedWriter(fw);
          bw.write(texto);
          bw.close();
          fw.close();
          return true;
      } catch (IOException e) {
            System.out.println(e.getMessage());
      }
      return false;
    }

    public static boolean write(String path, Integer num, boolean replace) {
      FileWriter fw = null;
      BufferedWriter bw = null; //gerencia memoria alocada para a leitura do arquivo
      try {
          fw = new FileWriter(path, replace);
          bw = new BufferedWriter(fw);
          bw.write(num.toString());
          fw.close();
          bw.close();
          return true;
      } catch (IOException e) {
            System.out.println(e.getMessage());
      }
      return false;
    }

    public static boolean read(String path) {
      FileReader fr = null;
      BufferedReader br = null; //gerencia memoria alocada para a leitura do arquivo
      try {
         fr = new FileReader(path);
         br = new BufferedReader(fr);
         //ler linha a linha
         String line = br.readLine();
         while (line != null) { //equivale ao EOF do Scanner
              System.out.println(line);
              line = br.readLine();
         }
         return true;
      } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
      } finally {
          try {
              br.close(); //o ato de fechar pode gerar excessão, então precisa tratar
              fr.close();
          } catch (IOException e) {
              e.printStackTrace();
          }   
      }
      return false;       
    }
}
