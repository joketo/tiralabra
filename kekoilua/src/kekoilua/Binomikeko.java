package kekoilua;

public class Binomikeko implements Keko {

    private BinomiNode head;

    public Binomikeko() {
        head = null;
    }

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

    private void BinomiMerge(Binomikeko hb) {
        BinomiNode a = this.head;
        BinomiNode b = hb.head;
        this.head = minAste(a, b);
        if (this.head == null) {
            return;
        }
        if (this.head == b) {
            b = a;
        }
        a = this.head;
        while (b != null) {
            if (a.getSisar() == null) {
                a.setSisar(b);
                return;
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
    }

    private void yhdistaKeot(Binomikeko b) {
        BinomiMerge(b);
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
            } else if (x.getArvo() <= nextX.getArvo()) { //x:n ja nextx:n asteet samat
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
        extractMin(); // poistaNode(this.getMinimiNode());
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
        do {
            if (i.getArvo() <= min) {
                min = i.getArvo();
                minEd = edellinen;
            }
            edellinen = i;
            i = i.getSisar();
        } while (i != null);

        BinomiNode poistettava;
        if (minEd == null) { // head on ainoa jolla ei isosiskoa
            poistettava = this.head;
            this.head = poistettava.getSisar();
        } else {
            poistettava = minEd.getSisar();
            minEd.setSisar(poistettava.getSisar());
        }

        BinomiNode l = poistettava.getlapsi();
        if (l == null) {
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
        this.yhdistaKeot(tmp);

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
        yhdistaKeot(uusikeko);
    }

    @Override
    public int getYlin() {
        if (this.head == null) {
            return -1;
        }
        return getMinimiNode().getArvo();
    }

    private BinomiNode getMinimiNode() {
        BinomiNode y = null;
        BinomiNode minNode = this.head;
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

}