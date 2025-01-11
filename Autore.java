import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Autore{ //implements Comparable<Autore> {
    private String cognome;
    private String nome;
    private String nazione;
    private List<Libro> libri;

    public Autore(String cognome, String nome, String nazione) {
        this.cognome = cognome;
        this.nome = nome;
        this.nazione = nazione;
        libri = new ArrayList<>();
    }

    public String getCognome(){
        return cognome;
    }
    @Override
    public String toString() {
        return String.format("%s, %s - [%s]",cognome, nome, nazione);
    }
    /*
    public int compareTo(Autore autore){
        return cognome.compareTo(autore.cognome);
    }
    */
    public void addLibro(Libro l){
        libri.add(l);
    }

    public String getLibri(){
        //libri.sort(Collections.reverseOrder());

        libri.sort(Comparator.comparingInt(Libro::getAnno).reversed());
        String result = new String();
        for (Libro l: libri){
            result += l + "\n";
        }
        return result;
    }
}
