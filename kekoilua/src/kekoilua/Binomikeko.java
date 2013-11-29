package kekoilua;

public class Binomikeko implements Keko {
    
    private TreeNode nykyinenPuu;
    public Binomikeko(){

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
    
    
    
    private void seuraava(){
        
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
    
    private void lisaaPuu(TreeNode tree){
        
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

    @Override
    public int getYlin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       
    
}