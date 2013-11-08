package kekoilua;

import java.util.ArrayList;

public class Binaarikeko {

    ArrayList<Integer> keko;
    int heapsize;

    public Binaarikeko() {
        keko = new ArrayList<>();
    }

    public void MaxHeapify(int i) {
        int vasen = 2 * i;
        int oikea = 2 * i + 1;
        int suurin = i;
        if (vasen <= keko.size() && keko.get(vasen) > keko.get(suurin)) {
            suurin = vasen;
        }
        if (oikea <= keko.size() && keko.get(oikea) > keko.get(suurin)) {
            suurin = oikea;
        }
        if (suurin != i) {
            VaihdaArvotKeskenaan(suurin, i);
            MaxHeapify(suurin);
        }

    }

    private void VaihdaArvotKeskenaan(int a, int b) {
        int talteen = keko.get(a);
        keko.add(a, keko.get(b));
        keko.add(b, talteen);
    }

    public void MaxInsert(int alkio) {
        keko.add(alkio);
        if(keko.size() == 1){
            return;
        }
        int vanhemmanIndeksi = (keko.size()-2) /2;
        int alkionIndeksi = keko.size()-1;
        while (keko.get(vanhemmanIndeksi) < alkio && vanhemmanIndeksi >= 0) { //vanhemman kuuluisi olla lasta suurempi
            VaihdaArvotKeskenaan(vanhemmanIndeksi, alkionIndeksi);
            alkionIndeksi = vanhemmanIndeksi;
            vanhemmanIndeksi = (vanhemmanIndeksi-1)/2;
            
        }
    }
    public int getYlin(){
        return keko.get(0);
    }

    public void MaxDelete(int alkio) {
    }
}
