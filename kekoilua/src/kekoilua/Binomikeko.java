package kekoilua;

import java.util.LinkedList;

public class Binomikeko implements Keko {
    
    private TreeNode nykyinenPuu;
    private LinkedList<TreeNode> rootList; 
    
    public Binomikeko(){
        rootList = new LinkedList<>();
        nykyinenPuu = rootList.getFirst();
    }
    
    private void lisaaJuurilistaan(TreeNode juuri){
        rootList.add(juuri);
    }
    
    private void yhdistaKeot(Binomikeko a, Binomikeko b){
        while(a != null && b != null){
            TreeNode tree = a.nykyinenPuu.Yhdista(b.nykyinenPuu);
            if(this.nykyinenPuu.onkoTyhja()){
                tree = tree.Yhdista(this.nykyinenPuu);
            }
            this.lisaaPuu(tree);
            this.seuraava();
            a.seuraava();
            b.seuraava();
        }
    }
    
    private void seuraava(){ //tarkottaakohan tätä?
       nykyinenPuu = annaJuuriSisar(nykyinenPuu);
    }  
    
    private void lisaaPuu(TreeNode tree){
        rootList.add(tree);
    }
    
    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insert(int a) {
        Binomikeko uusikeko = new Binomikeko();
        TreeNode keonEkapuu = new TreeNode(a, 0); //onhan aste 0?
        uusikeko.lisaaPuu(keonEkapuu);
        uusikeko.lisaaJuurilistaan(keonEkapuu);
        yhdistaKeot(this, uusikeko);
    }
    
    private TreeNode annaJuuriSisar(TreeNode node){
        int nykIndeksi = rootList.indexOf(node);
        return rootList.get(nykIndeksi+1); //
    }

    @Override
    public int getYlin() {
        return getMinimiNode().getArvo();
    }
    
    private TreeNode getMinimiNode(){
        TreeNode x = null;
        TreeNode y = rootList.getFirst(); //head
        int min = Integer.MAX_VALUE;
        while(x != null){
            if(x.getArvo() < min){
                min = x.getArvo();
                y = x;
            }
            x = annaJuuriSisar(x);
        }
        return y;
    }
    
       
    
}