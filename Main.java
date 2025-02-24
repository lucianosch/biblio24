import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        File dati = null;
        Scanner origine;
        Catalogo catalogo;
        try{
            dati = new File("bibliografia.txt");
            origine = new Scanner(dati);
            catalogo = new Catalogo();   
            leggiDati(origine,catalogo); 
            stampaAutori(catalogo);
            stampaLibri(catalogo);
            stampaLibri(catalogo, 2);
            stampaLibri(catalogo, "Sciascia");
            File elenco = new File("Catalogo.dat");
            FileOutputStream fos = new FileOutputStream(elenco);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(catalogo);
            oos.close();

        } catch (FileNotFoundException fnfe){
            catalogo = leggiDati();   
            //stampaAutori(catalogo);
            //stampaLibri(catalogo);
            stampaLibri(catalogo, 2);
            stampaLibri(catalogo, "Sciascia");       
            //fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private static Catalogo leggiDati(){
        Catalogo c = null;
        try{
            File elenco = new File("Catalogo.dat");
            FileInputStream fis = new FileInputStream(elenco);
            ObjectInputStream ois = new ObjectInputStream(fis);
            c = (Catalogo)ois.readObject();
            ois.close();
        } catch (IOException ioe){}
        catch(ClassNotFoundException cnfe){}
        return c;
    }

    private static void leggiDati(Scanner s, Catalogo c){
        Autore autore = null;
        while (s.hasNextLine()){
            String riga = s.nextLine();
            String tokens[] = riga.split(",");
            if (tokens[0].equals("A")){
                autore = new Autore(tokens[1],tokens[2],tokens[3]);
                c.addAutore(autore);
            }
            else if (tokens[0].equals("L")){
                Libro libro = new Libro(tokens[1],Integer.parseInt(tokens[2].trim()),Integer.parseInt(tokens[3].trim()));
                libro.setAutore(autore);
                c.addLibro(libro);
                autore.addLibro(libro);
            }
        }
        s.close();
    }
        
    private static void stampaAutori(Catalogo c){
        System.out.println(c.getAutori());
    }

    private static void stampaLibri(Catalogo c){
        System.out.println(c.getLibri());
    }
     
    private static void stampaLibri(Catalogo c, int k){
        System.out.println(c.getAutore(k).getLibri());
    }

    private static void stampaLibri(Catalogo c, String a){
        System.out.println(c.getAutore(a).getLibri());
    }    
}
