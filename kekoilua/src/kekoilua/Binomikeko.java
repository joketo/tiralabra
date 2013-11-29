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

    private TreeNode annaJuuriSisar(TreeNode node) {
        int nykIndeksi = rootList.indexOf(node);
        return rootList.get(nykIndeksi + 1);
    }

    private void lisaaPuu(TreeNode tree) {
        rootList.add(tree);
    }

    private void yhdistaKeot(Binomikeko b) {
        Iterator<TreeNode> aIt = this.rootList.iterator();
        Iterator<TreeNode> bIt = b.rootList.iterator();

        while (aIt.hasNext() && bIt.hasNext()) {
            TreeNode tree = aIt.next().Yhdista(bIt.next());
            if (!aIt.next().onkoTyhja()) {
                tree = tree.Yhdista(aIt.next());
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
        TreeNode keonEkapuu = new TreeNode(a, 0); //onhan aste 0?
        rootList.add(keonEkapuu);
        yhdistaKeot(uusikeko);
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

    public String toString() {
        String ret = "";
        for (TreeNode i : rootList) {
            ret += i.toString();
        }
        return ret;
    }
}