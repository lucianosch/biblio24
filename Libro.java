import java.io.Serializable;

public class Libro implements Serializable{ //implements Comparable<Libro> {
    private String titolo;
    private Autore autore;
    private int annoPubblicazione;
    private int nPagine;

    public Libro(String titolo, int annoPubblicazione, int nPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.nPagine = nPagine;
    }

    public void setAutore(Autore autore){
        this.autore = autore;
    }

    @Override
    public String toString() {
        return String.format("[%s] - %s, %d pagine [%d]",autore.getCognome(),titolo,nPagine,annoPubblicazione);
    }
    /*
    public int compareTo(Libro libro){
        return annoPubblicazione - libro.annoPubblicazione;
    }
    */
    public int getAnno(){
        return annoPubblicazione;
    }
}