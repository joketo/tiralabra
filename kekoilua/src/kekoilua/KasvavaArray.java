package kekoilua;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class KasvavaArray<T> implements List {

    int viimeisenIndeksi;
    private Object[] lista;

    public KasvavaArray() {
        lista = new Object[100];
        viimeisenIndeksi = -1;
    }

    private T getT(int i) {
        @SuppressWarnings("unchecked")
        final T t = (T) lista[i];
        return t;
    }

    @Override
    public int size() {
        return viimeisenIndeksi + 1;
    }

    @Override
    public boolean isEmpty() {
        if (viimeisenIndeksi == -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i <= viimeisenIndeksi; i++) {
            if (lista[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object o) {
        if (viimeisenIndeksi == lista.length - 1) {
            Object[] kopio = Arrays.copyOf(lista, lista.length * 2);
            kopio[viimeisenIndeksi+1] = o;
            viimeisenIndeksi++;
            this.lista = kopio;
        } else {
            lista[viimeisenIndeksi + 1] = o;
            viimeisenIndeksi = viimeisenIndeksi + 1;
        }
        return true;
    }
    
    @Override
    public Object remove(int k) { 
        T alkio = getT(k);
        for(int i = k; i < viimeisenIndeksi; i++){
            lista[i] = lista[i+1];
        }
        viimeisenIndeksi--;
        return alkio;
    }
    
    @Override
    public Object get(int i) {
        return getT(i);
    }
    
    public String toString(){
        Object[] subarray = Arrays.copyOfRange(lista, 0, viimeisenIndeksi+1);
        return Arrays.toString(subarray);
    }
    
     @Override
    public int indexOf(Object o) {
        for(int i = 0; i <= viimeisenIndeksi; i++){
            if(lista[i] == o){
                return i;
            }
        }
        return -1;
    }
     
    @Override
    public Object set(int i, Object e) {
        lista[i] = e;
        return e;
    }
    
    //kaikkia allaolevia metodeita ei ole tarpeellista toteuttaa, toteuttejen jos tarvetta tulee
    
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void add(int i, Object e) {
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
