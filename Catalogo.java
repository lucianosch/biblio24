import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

public class Catalogo implements Serializable{
    private List<Libro> libri;
    private List<Autore> autori;

    public Catalogo() {
        libri = new ArrayList<>();
        autori = new ArrayList<>();
    }

    public void addLibro(Libro l){
        libri.add(l);
    }

    public void addAutore(Autore a){
        autori.add(a);
    }
    
    public String getAutori(){
        //autori.sort(null);
        autori.sort((a1,a2) -> a1.getCognome().compareTo(a2.getCognome()));
        String result = new String();
        for (Autore a : autori){
            result += a + "\n";
        }
        return result;
    }
    

    public String getLibri(){
        //libri.sort(Collections.reverseOrder());
        //libri.sort(Comparator.comparingInt(Libro::getAnno).reversed());
        libri.sort((l1,l2)->(-l1.getAnno() + l2.getAnno()));
        String result = new String();
        for (Libro l: libri){
            result += l + "\n";
        }
        return result;
    }

    public Autore getAutore(int n){
        return autori.get(n);
    }

    public Autore getAutore(String cognome){
        for (Autore a: autori)
            if (a.getCognome().equals(cognome))
                return a;
        return null;
    }
}
