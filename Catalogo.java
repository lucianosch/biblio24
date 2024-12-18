import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalogo {
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
        autori.sort(null);
        String result = new String();
        for (Autore a : autori){
            result += a + "\n";
        }
        return result;
    }

    public String getLibri(){
        libri.sort(Collections.reverseOrder());
        String result = new String();
        for (Libro l: libri){
            result += l + "\n";
        }
        return result;
    }

    public Autore getAutore(int n){
        return autori.get(n);
    }
}
