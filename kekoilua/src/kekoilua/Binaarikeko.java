package kekoilua;

import java.util.ArrayList;

public class Binaarikeko {
    ArrayList<Integer> keko;
    int heapsize;
    
    public Binaarikeko(){
        keko = new ArrayList<>();
        heapsize = 5; //eieiiei
    }
    
    
    public void MaxHeapify(int i, ArrayList<Integer> kek){
        int vasen = 2*i;
        int oikea = 2*i + 1;
        int suurin = i;
        if(vasen <= kek.size() || kek.get(vasen) > kek.get(suurin)){
            suurin = vasen;
        }
        if(oikea <= kek.size() || kek.get(oikea) > kek.get(suurin)){
            suurin = oikea;
        }
        if(suurin != i){
            int talteen = kek.get(suurin);
            kek.add(suurin, kek.get(i));
            kek.add(i, talteen);
            MaxHeapify(suurin, kek); 
        }
        
    }
    
    public void MaxInsert(int alkio){
        keko.add(alkio);
        
    }
    
    public void MaxDelete(int alkio){
        
    }
}
