package kekoilua;

import java.lang.reflect.Array;
import java.util.List;

public class KasvavaArray<T> {

    int viimeinen;
    T[] lista;
    Class<T> cc;

    public KasvavaArray(Class<T> c) {
        @SuppressWarnings("unchecked")
        T[] a = (T[]) Array.newInstance(c, 100);
        cc = c;
        lista = a;
    }

    public void add(T alkio) {
        if (viimeinen == lista.length - 1) {
            @SuppressWarnings("unchecked")
            T[] kopio = (T[]) Array.newInstance(cc, lista.length + 1);
            kopio = lista.clone();
            kopio[kopio.length] = alkio;
            this.lista = kopio;
        } else {
            lista[viimeinen + 1] = alkio;
            viimeinen = viimeinen + 1;
        }

    }

    public void delete(T alkio) {
        @SuppressWarnings("unchecked")
        T[] kopio = (T[]) Array.newInstance(cc, lista.length - 1);
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
        int pituus = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                pituus++;
            }
        }
        return pituus;
    }
}
