## Sistema di gestione biblioteca

L'applicazione gestisce il catalogo di una biblioteca. Il catalogo contiene una lista di Libri e una lista di Autori; il catalogo deve consentire l’inserimento di un nuovo autore, la stampa dell’elenco degli autori in ordine alfabetico e la stampa dei libri di un dato autore in ordine cronologico: dal più recente al più vecchio.
Definire:

1. le classi **Libro** *(Titolo, Autore, Anno di pubblicazione, numero di pagine)*, **Autore** *(Nome, Cognome, nazionalità, lista di libri)* e **Catalogo** *(lista di libri e lista di autori)*;
  
2. La classe **Catalogo** dovrà esporre un metodo **addAutore**(Autore nuovo), **getAutori()** che restituisce una stringa contenente l’elenco degli autori in ordine alfabetico e un metodo **getLibri**(Autore autore) che restituisca l’elenco dei libri scritti dall’autore (in ordine cronologico);
  
3. La classe Autore dovrà esporre un metodo **addLibro**(Libro nuovo) che aggiunge un libro all’elenco dei libri scritti da quell’autore e **getLibri()** che restituisce l’elenco dei libri in ordine cronologico;
  
4. Una classe **Main** che legga le informazioni relative ad un certo numero di autori e di libri da un file CSV le cui righe conterranno un primo carattere per identificare il tipo di informazioni (A per un autore e L per un libro) per popolare le liste di libri e di autori.
  
5. Tutti i libri che seguono un autore si riferiscono a quell’autore.
  

> Esempio:
> A, Manzoni, Alessandro, Italia
> 
> L, I promessi sposi,1845, 344
>
> L, Adelchi, 1837, 220
>
> A, Pirandello, Luigi, Italia
>
> L, Il fu Mattia Pascal, 1925, 234
>
> L, Novelle, 1928, 345
>
> ...
