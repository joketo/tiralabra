package kekoilua;

import java.util.LinkedList;

public class Binomikeko implements Keko {

    private TreeNode nykyinenPuu; //periaatteessa tarpeeton, yhdistaKeot käyttää mutta voisi toteuttaa nätimminkin
    private LinkedList<TreeNode> rootList;

    public Binomikeko() {
        rootList = new LinkedList<>();
        nykyinenPuu = rootList.getFirst();
    }

    private void yhdistaKeot(Binomikeko a, Binomikeko b) {
        while (a != null && b != null) {
            TreeNode tree = a.nykyinenPuu.Yhdista(b.nykyinenPuu);
            if (this.nykyinenPuu.onkoTyhja()) {
                tree = tree.Yhdista(this.nykyinenPuu);
            }
            this.lisaaPuu(tree);
            this.seuraava();
            a.seuraava();
            b.seuraava();
        }
    }

    private void seuraava() {
        nykyinenPuu = annaJuuriSisar(nykyinenPuu);
    }

    private void lisaaPuu(TreeNode tree) {
        rootList.add(tree);
    }

    @Override
    public void Delete() {
        TreeNode min = rootList.getFirst();
        Binomikeko tmp = new Binomikeko();
        for (TreeNode i : rootList) {
            if (i.getArvo() < min.getArvo()) { //halutaanko nyt tosiaan vertailla arvoja?
                min = i;
            }
        }
        for (TreeNode a : min.annaLapset()) {
            tmp.lisaaPuu(a);
        }
        this.removeTree(min);
        this.yhdistaKeot(this, tmp);
    }

    private void removeTree(TreeNode poistettava) {
        
    }
    
    private void pienennaArvo(TreeNode x, int uusiArvo){
        if(uusiArvo > x.getArvo()){
            System.out.println("Uuden arvon tulee olla pienempi kuin nykyisen arvon");
            return;
        }
        x.setArvo(uusiArvo);
        TreeNode y = x;
        TreeNode z = y.getVanhempi();
        while(z != null && y.getArvo() < z.getArvo()){
            
            int yynArvo = y.getArvo(); //vaihdetaan arvot päittäin
            y.setArvo(z.getArvo());
            z.setArvo(yynArvo);
            
            y = z;
            z = y.getVanhempi();
        }
    }

    @Override
    public void Insert(int a) {
        Binomikeko uusikeko = new Binomikeko();
        TreeNode keonEkapuu = new TreeNode(a, 0); //onhan aste 0?
        uusikeko.lisaaPuu(keonEkapuu);
        yhdistaKeot(this, uusikeko);
    }

    private TreeNode annaJuuriSisar(TreeNode node) {
        int nykIndeksi = rootList.indexOf(node);
        return rootList.get(nykIndeksi + 1); 
    }

    @Override
    public int getYlin() {
        return getMinimiNode().getArvo();
    }

    private TreeNode getMinimiNode() {
        TreeNode x = null;
        TreeNode y = rootList.getFirst(); //head
        int min = Integer.MAX_VALUE;
        while (x != null) {
            if (x.getArvo() < min) {
                min = x.getArvo();
                y = x;
            }
            x = annaJuuriSisar(x);
        }
        return y;
    }
}