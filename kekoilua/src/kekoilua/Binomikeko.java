package kekoilua;

import java.util.LinkedList;

public class Binomikeko implements Keko {
    
    private TreeNode nykyinenPuu;
    private LinkedList<TreeNode> rootList; 
    
    public Binomikeko(){
         nykyinenPuu = null;
    }
    

    private TreeNode yhdistaPuut(TreeNode a, TreeNode b){
        if(a.getArvo() <= b.getArvo()){ //halutaanko tähän aste vai arvo?
            a.lisaaLapsi(b);
            return a;
        }
        else{
            b.lisaaLapsi(a);
            return b;
        }
    }
    
    private void yhdistaKeot(Binomikeko a, Binomikeko b){
        while(a != null && b != null){
            TreeNode tree = yhdistaPuut(a.nykyinenPuu, b.nykyinenPuu);
            if(this.nykyinenPuu.onkoTyhja()){
                tree = yhdistaPuut(tree, this.nykyinenPuu);
            }
            this.lisaaPuu(tree);
            this.seuraava();
            a.seuraava();
            b.seuraava();
        }
    }
    
    private void seuraava(){ //tarkottaakohan tätä?
        this.nykyinenPuu.seuraava();
    }
        
    
    /*
     * function merge(p, q)
       while not (p.end() and q.end())
         tree = mergeTree(p.currentTree(), q.currentTree())
        
         if not heap.currentTree().empty()
            tree = mergeTree(tree, heap.currentTree())
         
         heap.addTree(tree)
         heap.next(); p.next(); q.next()
     */
    
    private void lisaaPuu(TreeNode tree){//nykyinenPuu saa lapsia?
        this.nykyinenPuu.lisaaLapsi(tree);
    }
    
    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insert(int a) {
        Binomikeko uusikeko = new Binomikeko();
        TreeNode keonEkapuu = new TreeNode(a, 0); //mikä on tyjän puun ainoan alkion aste?
        uusikeko.lisaaPuu(keonEkapuu);
        yhdistaKeot(this, uusikeko);
    }
    
    private TreeNode annaJuuriSisar(TreeNode node){
        int indeksi = rootList.indexOf(node);
        return rootList.get(indeksi+1); //
    }

    @Override
    public int getYlin() {
        TreeNode x = null;
        TreeNode y = nykyinenPuu;
        int min = Integer.MAX_VALUE;
        while(x != null){
            if(x.getArvo() < min){ //arvo vai aste?
                min = x.getArvo();
                y = x;
            }
            x = annaJuuriSisar(x);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       
    
}