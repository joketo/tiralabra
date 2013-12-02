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

    public void setRootList(LinkedList<TreeNode> nRootList) {
        this.rootList = nRootList;
    }

    private TreeNode annaJuuriSisar(TreeNode node) {
        int nykIndeksi = rootList.indexOf(node);
        return rootList.get(nykIndeksi + 1);
    }

    private void lisaaPuu(TreeNode tree) {
        /*if (rootList.isEmpty()) {
         rootList.add(tree);
         } else if (tree.getAste() < rootList.getFirst().getAste()) {
         rootList.add(tree);
         }*/
        rootList.add(tree);
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
        if (aa.getAste() < bb.getAste()) {
            yhdiste.add(aa);
            yhdiste.add(bb);
        } else {
            yhdiste.add(bb);
            yhdiste.add(aa);
        }
        return yhdiste;
    }

    private void yhdistaKeot(Binomikeko a, Binomikeko b) {
        // Binomikeko uusiKeko = new Binomikeko();
        this.setRootList(yhdistaRootListit(a, b));
        if (this.rootList.isEmpty()) {
            return;
        }
        // Iterator<TreeNode> nykNode = B.rootList.iterator();
        TreeNode prevX = null;
        TreeNode x = this.rootList.getFirst();
        TreeNode nextX = x.getSisar();
        while (nextX != null) {
            if (x.getAste() != nextX.getAste() || (nextX.getSisar() != null && nextX.getSisar().getAste() == x.getAste())) {
                prevX = x;
                x = nextX;
            } else if (x.getArvo() <= nextX.getArvo()) {
                x.setSisar(nextX.getSisar());
                nextX.Yhdista(x);
            } else if (prevX == null) {
                this.rootList.removeFirst();
                this.rootList.addFirst(nextX); //tämä saattaa rikkoa jotain...
            } else {
                prevX.setSisar(nextX);
                x.Yhdista(nextX);
                x = nextX;
            }
            nextX = x.getSisar();
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
        this.yhdistaKeot(this, tmp);
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
        this.yhdistaKeot(this, tmp);
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
        System.out.println(uusikeko.toString());
        uusikeko.rootList.add(keonEkapuu);
        System.out.println(uusikeko.toString());
        yhdistaKeot(this, uusikeko);
        System.out.println(this.toString());
    }

    @Override
    public int getYlin() {
        return getMinimiNode().getArvo();
    }

    private TreeNode getMinimiNode() {
        TreeNode y = null;
        if (this.rootList.isEmpty()) {
            return y;
        }
        TreeNode minNode = rootList.getFirst(); //head
        int min = Integer.MAX_VALUE;
        while (minNode != null) {
            if (minNode.getArvo() < min) {
                min = minNode.getArvo();
                y = minNode;
            }
            minNode = minNode.getSisar();
        }
        return y;
    }

    public String toString() {
        String ret = "t ";
        for (TreeNode i : rootList) {
            ret += i.toString();
        }
        return ret;
    }
    public void testaarootlistyhdistetta(){ //omaa testausta varten
        LinkedList<TreeNode> a = new LinkedList<>();
        LinkedList<TreeNode> b = new LinkedList<>();
        TreeNode e = new TreeNode(7);
        TreeNode ei = new TreeNode(6);
        TreeNode ek = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        a.add(f); //4
        a.add(e); //7
        b.add(ek); //3
        b.add(ei); //6
        Binomikeko ai = new Binomikeko();
        Binomikeko bai = new Binomikeko();
        ai.setRootList(a);
        System.out.println("ai: " + ai.toString());
        bai.setRootList(b);
        System.out.println("bai: " + bai.toString());
        LinkedList<TreeNode> yh = this.yhdistaRootListit(ai, bai);
        ai.setRootList(yh);
        System.out.println(ai.toString());
    }

    public static void main(String[] args) {
        Binomikeko bi = new Binomikeko();
        bi.testaarootlistyhdistetta();
    }
}