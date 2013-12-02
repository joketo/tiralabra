package kekoilua;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Binomikeko implements Keko {

    private LinkedList<TreeNode> rootList;

    public Binomikeko() {
        rootList = new LinkedList<>();

    }
    public void setRootList(LinkedList<TreeNode> nRootList){
        this.rootList = nRootList;
    }

    private TreeNode annaJuuriSisar(TreeNode node) {
        int nykIndeksi = rootList.indexOf(node);
        return rootList.get(nykIndeksi + 1);
    }

    private void lisaaPuu(TreeNode tree) {
        System.out.println(this.toString());
        if (rootList.isEmpty()) {
            rootList.add(tree);
        } else if (tree.getAste() < rootList.getFirst().getAste()) {
            rootList.addFirst(tree);
        }
    }

    private LinkedList<TreeNode> yhdistaRootListit(Binomikeko a, Binomikeko b) {
        LinkedList<TreeNode> yhdiste = new LinkedList<>();
        Iterator<TreeNode> aIt = a.rootList.iterator();
        Iterator<TreeNode> bIt = b.rootList.iterator();
        TreeNode aa;
        TreeNode bb;
        if (!aIt.hasNext()) { //jos a.rootlist on tyhjä
            if (!bIt.hasNext()) { //jos myös b.rootlist on tyhjä
                return yhdiste;
            } else if (bIt.hasNext()) { //jos a.rootlist on tyhjä mutta b.rootlist ei ole tyhjä
                yhdiste.addAll(b.rootList);
                return yhdiste;
            }
        } else if (!bIt.hasNext()) { //jos b.rootlist on tyhjä mutta a.rootlist ei ole tyhjä
            yhdiste.addAll(a.rootList);
            return yhdiste;
        }
        aa = aIt.next();
        bb = bIt.next();
        while (aIt.hasNext() || bIt.hasNext()) {
            if (!aIt.hasNext()) { //jos a loppuu
                yhdiste.add(bb);
                bb = bIt.next();
            } else if (!bIt.hasNext()) { //jos b loppuu                
                yhdiste.add(aa);
                aa = aIt.next();
            } else if (aIt.hasNext() && bIt.hasNext()) {
                if (aa.getAste() < bb.getAste()) {
                    yhdiste.add(aa);
                    aa = aIt.next();
                } else {
                    yhdiste.add(bb);
                    bb = bIt.next();
                }
            }
        }
        if(aa.getAste()< bb.getAste()){
            yhdiste.add(aa);
            yhdiste.add(bb);
        }else{
            yhdiste.add(bb);
            yhdiste.add(aa);
        }
        return yhdiste;
    }
    
    
    private Binomikeko uusiyhdistaKeot(Binomikeko a, Binomikeko b){
        Binomikeko B = new Binomikeko();
        B.setRootList(yhdistaRootListit(a, b));
        if(B.rootList.isEmpty()){
            return B;
        }
        Iterator<TreeNode> nykNode = B.rootList.iterator();
        while(nykNode != null){
            
        }
        
    }
    private void yhdistaKeot(Binomikeko b) { // tämä on rikki, tee kokonaan alusta?
        Iterator<TreeNode> aIt = this.rootList.iterator();
        Iterator<TreeNode> bIt = b.rootList.iterator();

        while (aIt.hasNext() && bIt.hasNext()) {
            TreeNode anyt = aIt.next();
            TreeNode bnyt = bIt.next();
            TreeNode tree = anyt.Yhdista(bnyt);
            if (!anyt.onkoTyhja()) {
                tree = tree.Yhdista(anyt);
            }
            this.lisaaPuu(tree);
        }
    }

    @Override
    public void Delete() {
        TreeNode min = rootList.getFirst();
        Binomikeko tmp = new Binomikeko();
        for (TreeNode i : rootList) {
            if (i.getArvo() < min.getArvo()) {
                min = i;
            }
        }
        for (TreeNode a : min.annaLapset()) {
            tmp.lisaaPuu(a);
        }
        this.poistaPuu(min);
        this.yhdistaKeot(tmp);
    }

    private void poistaPuu(TreeNode poistettava) {
        pienennaArvo(poistettava, Integer.MIN_VALUE);
        TreeNode min = rootList.getFirst();
        for (TreeNode i : rootList) {
            if (i.getArvo() < min.getArvo()) {
                min = i;
            }
        }
        rootList.remove(min);
        Binomikeko tmp = new Binomikeko();
        List<TreeNode> list = min.annaLapset();
        Collections.reverse(list); //reverse the order
        for (TreeNode i : list) {
            tmp.lisaaPuu(i); //meneehän tää nyt oikeessa järjestyksessä...
        }
        this.yhdistaKeot(tmp);
    }

    private void pienennaArvo(TreeNode x, int uusiArvo) {
        if (uusiArvo > x.getArvo()) {
            System.out.println("Uuden arvon tulee olla pienempi kuin nykyisen arvon");
            return;
        }
        x.setArvo(uusiArvo);
        TreeNode y = x;
        TreeNode z = y.getVanhempi();
        while (z != null && y.getArvo() < z.getArvo()) {

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
        TreeNode keonEkapuu = new TreeNode(a);
        uusikeko.rootList.add(keonEkapuu);
        if (rootList.isEmpty()) {
            rootList.add(keonEkapuu);
        } else {
            yhdistaKeot(uusikeko);
        }
    }

    @Override
    public int getYlin() {
        return getMinimiNode().getArvo();
    }

    private TreeNode getMinimiNode() {
        TreeNode y = null;
        TreeNode minNode = rootList.getFirst(); //head
        int min = Integer.MAX_VALUE;
        while (minNode != null) {
            if (minNode.getArvo() < min) {
                min = minNode.getArvo();
                y = minNode;
            }
            minNode = annaJuuriSisar(minNode);
        }
        return y;
    }

    public String toString() {
        String ret = "";
        for (TreeNode i : rootList) {
            ret += i.toString();
        }
        return ret;
    }
}