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
        if (vasen <= keko.size() || keko.get(vasen) > keko.get(suurin)) {
            suurin = vasen;
        }
        if (oikea <= keko.size() || keko.get(oikea) > keko.get(suurin)) {
            suurin = oikea;
        }
        if (suurin != i) {
            VaihdaArvotKeskenaan(suurin, i);
            //int talteen = keko.get(suurin); //vaihdetaan suurin ja i keskenään
            //keko.add(suurin, keko.get(i));
            //keko.add(i, talteen);
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
        while (keko.get(((keko.size()) - 1) / 2) < alkio) { //vanhemman kuuluisi olla lasta suurempi
            VaihdaArvotKeskenaan(((keko.size() - 1) / 2), alkio);
            //vaihdetaan arvot vanhemman kanssa päittäin
        }
    }

    public void MaxDelete(int alkio) {
    }
}
