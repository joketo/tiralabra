
package kekoilua;

import java.util.ArrayList;

//kaikki täällä on rikki, älkää katsoko tänne!

public class Node {
    
    private int value;
    private ArrayList<Node> nexts;
    private Node prev;
    
    public Node(int value){
        this.value = value;
        this.nexts = null;
        this.prev = null;
    }
    public Node(){
        this.nexts = null;
        this.prev = null;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void setNext(Node next){
        nexts.add(next);
    }
    public void setPrev(Node prev){
        this.prev = prev;
    }
    
    public int getValue(){
        return this.value;
    }
    public ArrayList<Node> getNext(){
        return nexts;
    }
    public Node getPrev(){
        return prev;
    }
    
      private void Merge(Node toka) {
         while(this.nexts != null && toka.nexts != null){
             Node tree = MergeTree(this, toka);
             if(this != null){
                 tree = MergeTree(tree, this);
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
        
    }
    
    private Node addSubTree(Node eka, Node toka){
        eka.setNext(toka);
        return eka;
    }

    private Node MergeTree(Node eka, Node toka) {
        if(eka.getValue() <= toka.getValue()){
            return addSubTree(eka, toka);
        }else{
            return addSubTree(toka, eka);
        }
    }

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


    public void Insert(int a) {
        Node uusiNodejuuri = new Node(a);
        Node[] uusiKeko = {uusiNodejuuri};
        Merge(uusiKeko);
    }
    
    
}
