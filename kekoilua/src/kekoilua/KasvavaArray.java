package kekoilua;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class KasvavaArray<T> implements List {

    int viimeisenIndeksi;
    T[] lista;
    Class<T> cc;

    public KasvavaArray() {
        @SuppressWarnings("unchecked")
        T[] a = (T[]) Array.newInstance(cc, 100);
        lista = a;
        viimeisenIndeksi = -1;
    }

    @Override
    public int size() {
        int pituus = 0;
        for (int i = 0; i <= lista.length; i++) {
            if (lista[i] != null) {
                pituus++;
            }
        }
        return pituus;
    }

    @Override
    public boolean isEmpty() {
        if (lista[0] == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < lista.length; i++){
            if(lista[i] == (T)o){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object o) {
        if (viimeisenIndeksi == lista.length - 1) {
            T[] kopio = Arrays.copyOf(lista, lista.length * 2);
            kopio[kopio.length] = (T) o;
            this.lista = kopio;
        } else {
            lista[viimeisenIndeksi + 1] = (T) o;
            viimeisenIndeksi = viimeisenIndeksi + 1;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        T[] kopio = Arrays.copyOf(lista, lista.length * 2);
        for (int j = 0; j <= lista.length; j++) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == (T) o) {
                    j++; //ei kopioida kopioon tätä
                }
                kopio[i] = lista[j];
            }
        }
        this.lista = kopio;
        return true;
    }

    @Override
    public boolean containsAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object set(int i, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int i, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object remove(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
