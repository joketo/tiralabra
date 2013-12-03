package kekoilua;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Binomikeko implements Keko {

    private BinomiNode head;

    public Binomikeko() {
        head = null;
    }

    /*    private BinomiNode yhdistaRootListit(Binomikeko a, Binomikeko b) {
     System.out.println("test");
     BinomiNode yhdiste = null;
     BinomiNode aa = a.head;
     BinomiNode bb = b.head;
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
     */
    private BinomiNode minAste(BinomiNode a, BinomiNode b) {
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

    private BinomiNode BinomiMerge(Binomikeko ha, Binomikeko hb) {
        BinomiNode a = ha.head;
        BinomiNode b = hb.head;
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
                BinomiNode c = b.getSisar();
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
        BinomiNode prevX = null;
        BinomiNode x = this.head;
        BinomiNode nextX = x.getSisar();
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
    public void Delete() {
        //    pienennaArvo(this.getMinimiNode(), Integer.MIN_VALUE);
        extractMin();
        // this.poistaNode(this.getMinimiNode());
    }

    private void extractMin() { //extract-Min
        BinomiNode minEd = null;
        int min = Integer.MAX_VALUE;
        Binomikeko tmp = new Binomikeko();
        BinomiNode edellinen;
        BinomiNode i = this.head;
        if (i == null) {
            return;
        }

        edellinen = null;
        while (i.getSisar() != null) {
            if (i.getArvo() <= min) {
                min = i.getArvo();
                minEd = edellinen;
            }

            edellinen = i;
            i = i.getSisar();
        }

        BinomiNode poistettava;
        System.out.println("LISTANYT: " + this.toString());
        if (minEd == null) { // head on ainoa jolla ei isosiskoa
            poistettava = this.head;
            this.head = poistettava.getSisar();
        } else {
            poistettava = minEd.getSisar();
            minEd.setSisar(poistettava.getSisar());
        }
        
        BinomiNode l = poistettava.getlapsi();
        if(l == null) {
            return;
        }
        
        // on lapsia, yhdistetään ne
        while (l.getSisar() != null) {
            BinomiNode next = l.getSisar();
            l.setSisar(tmp.head);
            tmp.head = l;
            l = next;
        }
        l.setSisar(tmp.head);
        tmp.head = l;
        this.yhdistaKeot(this, tmp);

    }

    private void poistaNode(BinomiNode poistettava) {
        pienennaArvo(poistettava, Integer.MIN_VALUE);
        extractMin();
    }

    private void pienennaArvo(BinomiNode x, int uusiArvo) {
        if (uusiArvo > x.getArvo()) {
            System.out.println("Uuden arvon tulee olla pienempi kuin nykyisen arvon");
            return;
        }
        x.setArvo(uusiArvo);
        BinomiNode y = x;
        BinomiNode z = y.getVanhempi();
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
        BinomiNode keonEkapuu = new BinomiNode(a);
        uusikeko.head = keonEkapuu;
        yhdistaKeot(this, uusikeko);
    }

    @Override
    public int getYlin() {
        if (this.head == null) { //pino menee tyhjäksi jossain..
            return -1;
        }
        return getMinimiNode().getArvo();
    }

    private BinomiNode getMinimiNode() {
        BinomiNode y = null;
        BinomiNode minNode = this.head; //head
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
        BinomiNode i = this.head;
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
        //  System.out.println(keko.getYlin());
    }
}