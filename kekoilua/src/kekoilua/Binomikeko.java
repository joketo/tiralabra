package kekoilua;

public class Binomikeko implements Keko {
    
    public Binomikeko(){
        
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insert(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getYlin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //kaikki täällä on rikki, älkää katsoko tänne!
/*
    private Node juuri;
    private Binomikeko(){
        this.juuri = null;
    }

    private void Merge(Node toka) {
         while(juuri != null && toka != null){
             Node tree = MergeTree(juuri, toka);
             if(juuri != null){
                 tree = MergeTree(tree, );
             }
         }
        /*
         * while not (p.end() and q.end())
         tree = mergeTree(p.currentTree(), q.currentTree())
        
         if not heap.currentTree().empty()
         tree = mergeTree(tree, heap.currentTree())
        
         heap.addTree(tree)
         heap.next(); p.next(); q.next()
         * 
         * 
         */
       /* 
    }
    
    private Node addSubTree(Node eka, Node toka){
        eka.setNext(toka);
        return eka;
    }

    private Node MergeTree(Node toka) {
        if(eka.getValue() <= toka.getValue()){
            return addSubTree(juuri, toka);
        }else{
            return addSubTree(toka, juuri);
        }
    }

    @Override
    public void Delete() {
        
        /*
         * function deleteMin(heap)
         min = heap.trees().first()
         for each current in heap.trees()
         if current.root < min then min = current
         for each tree in min.subTrees()
         tmp.addTree(tree)
         heap.removeTree(min)
         merge(heap, tmp)
         */
  /*  }

    @Override
    public void Insert(int a) {
        Node uusiNodejuuri = new Node(a);
        Node[] uusiKeko = {uusiNodejuuri};
        Merge(uusiKeko);
    }

    @Override
    public int getYlin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

*/
}
