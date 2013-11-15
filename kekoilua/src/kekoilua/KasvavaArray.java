package kekoilua;

import java.util.List;

public class KasvavaArray<T> {

    T[] lista;

    public KasvavaArray(T tyyppi) {
        lista = new tyyppi[100];
    }

    public void add(T alkio) {
        T[] kopio = new T[lista.length + 1];
        kopio = lista.clone();
        kopio[kopio.length] = alkio;
        this.lista = kopio;
    }

    public void delete(T alkio) {
        T[] kopio = new T[lista.length-1];
        for (int j = 0; j <= lista.length; j++) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == alkio) {
                    j++; //ei kopioida kopioon tätä
                }
                kopio[i] = lista[j];
            }
        }
        this.lista = kopio;
    }

    public int length() {
        int summa = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                summa++;
            }
        }
        return summa;
    }
}