package kekoilua;

import java.util.ArrayList;

public class Binaarikeko {

    ArrayList<Integer> keko;
    int heapsize;

    public Binaarikeko() {
        keko = new ArrayList<>();
        heapsize = 5; //eieiiei
    }

    public void MaxHeapify(int i, ArrayList<Integer> kek) {
        int vasen = 2 * i;
        int oikea = 2 * i + 1;
        int suurin = i;
        if (vasen <= kek.size() || kek.get(vasen) > kek.get(suurin)) {
            suurin = vasen;
        }
        if (oikea <= kek.size() || kek.get(oikea) > kek.get(suurin)) {
            suurin = oikea;
        }
        if (suurin != i) {
            kek = VaihdaArvotKeskenaan(kek, suurin, i);
            //int talteen = kek.get(suurin); //vaihdetaan suurin ja i keskenään
            //kek.add(suurin, kek.get(i));
            //kek.add(i, talteen);
            MaxHeapify(suurin, kek);
        }

    }

    private ArrayList<Integer> VaihdaArvotKeskenaan(ArrayList<Integer> k, int a, int b) {
        int talteen = k.get(a);
        k.add(a, k.get(b));
        k.add(b, talteen);
        return k;
    }

    public void MaxInsert(int alkio) {
        keko.add(alkio);
        while (keko.get(((keko.size()) - 1) / 2) < alkio) { //vanhemman kuuluisi olla lasta suurempi
            keko = VaihdaArvotKeskenaan(keko, ((keko.size() - 1) / 2), alkio);
            //vaihdetaan arvot vanhemman kanssa päittäin
        }
    }

    public void MaxDelete(int alkio) {
    }
}
