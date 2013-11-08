package kekoilua;

import java.util.ArrayList;

public class Binaarikeko implements Keko{

    ArrayList<Integer> keko;

    public Binaarikeko() {
        keko = new ArrayList<>();
    }
    private void Tulosta(){ //testailua varten
        for(int i : keko){
            System.out.print(i);
        }
        System.out.println();
    }

    private void Heapify(int i) {
        int vasenI = (2 * i) +1;
        int oikeaI = (2 * i) +2;
        int suurin = i;

        if (vasenI < keko.size() && keko.get(vasenI) > keko.get(suurin)) {
            suurin = vasenI;
        }
        if (oikeaI < keko.size() && keko.get(oikeaI) > keko.get(suurin)) {
            suurin = oikeaI;
        }
        if (suurin != i) {
            VaihdaArvotKeskenaan(suurin, i);
            Heapify(suurin);
        }
    }

    private void VaihdaArvotKeskenaan(int a, int b) {
        int talteen = keko.get(a);
        keko.set(a, keko.get(b));
        keko.set(b, talteen);
    }

    @Override
    public void Insert(int alkio) {
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
    @Override
    public int getYlin(){
        if(keko.isEmpty()){
            return -1;
        }
        return keko.get(0);
    }

    @Override
    public void Delete() { //poistaa keon huipun
        if(keko.isEmpty()){
            return;
        }
        if(keko.size() == 1){
            keko.remove(0);
            return;
        }
        VaihdaArvotKeskenaan(0, (keko.size()-1));
        keko.remove(keko.size()-1); //huippu nyt viimeisenä, poistetaan
        Heapify(0);
        
    }
}
