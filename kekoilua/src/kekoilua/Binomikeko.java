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

    private TreeNode minAste(TreeNode a, TreeNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else if (a.getAste() < b.getAste()) {
            return a;
        } else {
            return b;
        }
    }

    private TreeNode BinomiMerge(Binomikeko ha, Binomikeko hb) {
        TreeNode a = ha.head;
        TreeNode b = hb.head;
        ha.head = minAste(a, b);
        if (ha.head == null) {
            return null;
        }
        if (ha.head == b) {
            b = a;
        }
        a = ha.head;
        while (b != null) {
            if (a.getSisar() == null) {
                a.setSisar(b);
                return b;
            } else if (a.getSisar().getAste() < b.getAste()) {
                a = a.getSisar();
            } else {
                TreeNode c = b.getSisar();
                b.setSisar(a.getSisar());
                a.setSisar(b);
                a = a.getSisar();
                b = c;
            }
        }
        return b;
    }

    private void yhdistaKeot(Binomikeko a, Binomikeko b) {
        BinomiMerge(a, b);
        //this.head = BinomiMerge(b);
        if (this.head == null) {
            return;
        }
        TreeNode prevX = null;
        TreeNode x = this.head;
        TreeNode nextX = x.getSisar();
        while (nextX != null) {
            if (x.getAste() != nextX.getAste() || (nextX.getSisar() != null && nextX.getSisar().getAste() == x.getAste())) {
                prevX = x;
                x = nextX;
            } else if (x.getArvo() <= nextX.getArvo()) {
                x.setSisar(nextX.getSisar());
                nextX.Yhdista(x);
            } else {
                if (prevX == null) {
                    this.head = nextX;
                } else {
                    prevX.setSisar(nextX);
                }
                x.Yhdista(nextX);
                x = nextX;
            }
            nextX = x.getSisar();
        }
    }

    @Override
    public void Delete(){
    //    pienennaArvo(this.getMinimiNode(), Integer.MIN_VALUE);
        extractMin();
       // this.poistaNode(this.getMinimiNode());
    }
    
    private void extractMin(){ //extract-Min
        TreeNode min = new TreeNode(Integer.MAX_VALUE);
        Binomikeko tmp = new Binomikeko();
        TreeNode edellinen = null;
        TreeNode i = this.head;
        while (i != null) {
            if (i.getArvo() <= min.getArvo()) {
                min = i;
            }
            edellinen = i;
            i = i.getSisar();
        }
        System.out.println("MIN:" + min);
        edellinen.setSisar(min.getSisar());
        TreeNode x = min.getlapsi();
        System.out.println("loo?");
        if(x == null){
            return;
        }
        while(x.getSisar() != null){
            System.out.println("LOOP");
            TreeNode next = x.getSisar();
            x.setSisar(tmp.head);
            tmp.head = x;
            x = next;
        }
        this.yhdistaKeot(this, tmp);
    }

    private void poistaNode(TreeNode poistettava) {
        pienennaArvo(poistettava, Integer.MIN_VALUE);
        extractMin();
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
            System.out.println("mitä tapahtuu");
            if (minNode.getArvo() < min) {
                min = minNode.getArvo();
                y = minNode;
            }
            minNode = minNode.getSisar();
        }
        return y;
    }

    @Override
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
        keko.Insert(3);
        keko.Insert(6);
        keko.Insert(5);
        keko.Insert(2);
        System.out.println(keko);
        System.out.println(keko.getYlin());
        keko.Delete();
        System.out.println(keko.getYlin());
    }
}