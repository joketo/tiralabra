package kekoilua;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Binomikeko implements Keko {

    private TreeNode head;

    public Binomikeko() {
        head = null;
    }

    private TreeNode yhdistaRootListit(Binomikeko a, Binomikeko b) {
        System.out.println("test");
        TreeNode yhdiste = null;
        TreeNode aa = a.head;
        TreeNode bb = b.head;
        if (aa == null) {
            yhdiste = bb;
            return yhdiste;
        } else if (bb == null) {
            yhdiste = aa;
            return yhdiste;
        } else if (aa != null && bb != null) {
            if (aa.getAste() < bb.getAste()) {
                yhdiste = aa;
                aa = aa.getSisar();
            } else {
                yhdiste = bb;
                bb = bb.getSisar();
            }
        }
        while (aa != null || bb != null) {
            System.out.println("a ");
            if (aa == null) {
                yhdiste.setSisar(bb);
                bb = bb.getSisar();
            } else if (bb == null) {
                yhdiste.setSisar(aa);
                aa = aa.getSisar();
            } else if (aa.getAste() < bb.getAste()) {
                yhdiste.setSisar(aa);
                aa = aa.getSisar();
            } else {
                yhdiste.setSisar(bb);
                bb = bb.getSisar();
            }
        }
        return yhdiste;
    }
    /*
     * TreeNode a = this.head;
     * TreeNode b = hb.head;
     * 
     * a = head[H1]
     b = head[H2]
     head[H1] = Min-Degree(a, b)
     if head[H1] = NIL
     return
     if head[H1] = b
     then b = a
     a = head[H1]
     while b <> NIL
     do if sibling[a] = NIL
     then sibling[a] = b
     return
     else if degree[sibling[a]] < degree[b]
     then a = sibling[a]
     else c = sibling[b]
     sibling[b] = sibling[a]
     sibling[a] = b
     a = sibling[a]
     b = c
     */

    private void yhdistaKeot(Binomikeko a, Binomikeko b) {
        System.out.println("yhdistaKEot");
        this.head = (yhdistaRootListit(a, b));
        if (this.head == null) {
            return;
        }
        System.out.println(this.head);
        System.out.println(this.head.getSisar());
        if (head.getSisar() != null) {
            System.out.println(head.getSisar().getSisar());
        }

        TreeNode prevX = null;
        TreeNode x = this.head;
        TreeNode nextX = x.getSisar();
        while (nextX != null) {
            System.out.println("b ");
            if (x.getAste() != nextX.getAste() || (nextX.getSisar() != null && nextX.getSisar().getAste() == x.getAste())) {
                System.out.println("i");
                prevX = x;
                x = nextX;
            } else if (x.getArvo() <= nextX.getArvo()) {
                System.out.println("k");
                x.setSisar(nextX.getSisar());
                nextX.Yhdista(x);
            } else if (prevX == null) {
                System.out.println("e");
                this.head = nextX;
            } else {
                System.out.println("n");
                prevX.setSisar(nextX);
            }
            x.Yhdista(nextX);
            x = nextX;

            nextX = x.getSisar();
        }
    }

    public void Delete() {
    }
    /*
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
     }*/

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
        uusikeko.head = keonEkapuu;
        yhdistaKeot(this, uusikeko);
    }

    @Override
    public int getYlin() {
        return getMinimiNode().getArvo();
    }

    private TreeNode getMinimiNode() {
        TreeNode y = null;
        TreeNode minNode = this.head; //head
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
        TreeNode i = this.head;
        while (i != null) {
            ret += i.toString();
            i = i.getSisar();
        }
        return ret;
    }

    public static void main(String[] args) {
        Binomikeko keko = new Binomikeko();
        keko.Insert(4);
        keko.Insert(6);
        keko.Insert(1);
    }
}