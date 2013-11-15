package kekoilua;


public class Binomikeko implements Keko{
    
    private void merge(int[]eka, int[]toka){
        /*
         * while not (p.end() and q.end())
        tree = mergeTree(p.currentTree(), q.currentTree())
        
        if not heap.currentTree().empty()
            tree = mergeTree(tree, heap.currentTree())
        
        heap.addTree(tree)
        heap.next(); p.next(); q.next()
         */
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
    }

    @Override
    public void Insert(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getYlin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
