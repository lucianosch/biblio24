import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws FileNotFoundException{
        Catalogo catalogo = new Catalogo();
        File dati = new File("bibliografia.txt");
        Scanner origine = new Scanner(dati);
        Autore autore = null;
        while (origine.hasNextLine()){
            String riga = origine.nextLine();
            String tokens[] = riga.split(",");
            if (tokens[0].equals("A")){
                autore = new Autore(tokens[1],tokens[2],tokens[3]);
                catalogo.addAutore(autore);
            }
            else if (tokens[0].equals("L")){
                Libro libro = new Libro(tokens[1],Integer.parseInt(tokens[2].trim()),Integer.parseInt(tokens[3].trim()));
                libro.setAutore(autore);
                catalogo.addLibro(libro);
                autore.addLibro(libro);
            }
        }
        origine.close();
        System.out.println(catalogo.getAutori());
        System.out.println(catalogo.getAutore(2).getLibri());
        System.out.println(catalogo.getAutore("Sciascia").getLibri());
        System.out.println(catalogo.getLibri());
    }
}
