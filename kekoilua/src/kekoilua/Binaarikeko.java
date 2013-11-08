package kekoilua;

import java.util.ArrayList;

public class Binaarikeko {
    int[] tree;
    int heapsize;
    
    public Binaarikeko(){
        this.tree = new int[5]; //joku hyvä alotuskoko...
        heapsize = 5; //eieiiei
    }
    
    public void MaxHeapify(int i){
        int vasen = 2*i;
        int oikea = 2*1 + 1;
        int suurin = i;
        if(vasen <= tree.length || tree[vasen] > tree[suurin]){
            
        }
    }
    
    public void Insert(int alkio){
        
    }
    
    public void delete(int alkio){
        
    }
}
