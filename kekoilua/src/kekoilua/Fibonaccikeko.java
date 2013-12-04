package kekoilua;

import java.util.ArrayList;

public class Fibonaccikeko implements Keko {

    private FiboNode minRoot; //rootlistin pienimmän alkion sisältävä root
    private int nodeja; //kuinka monta nodea rootlistissä on

    public Fibonaccikeko() {
        minRoot = null;
        nodeja = 0;
    }

    @Override
    public void Delete() {
        System.out.println("test");
        FiboNode z = this.minRoot;
        System.out.println("päästiin tänne asti");
        if (z != null) {
            System.out.println("päästiin tänne asti");
            FiboNode x = z.getLapsi();
            if (x != null) {
                FiboNode eka = x;
                do {
                    lisaaRootListiin(x);
                    if (this.minRoot == null || x.getArvo() < this.minRoot.getArvo()) {
                        this.minRoot = x;
                    }
                    x.setVanhus(null);
                    x = x.getOikeaSisar();
                } while (x != eka);
            }
            FiboNode a = this.minRoot;
            FiboNode eka = this.minRoot;
            System.out.println("minroot" + this.minRoot.toString());
            do { // poistetaan z rootlististä
                if (a == z) {
                    System.out.println("totot");
                    a.getVasenSisar().setOikeaSisar(a.getOikeaSisar()); // z poistuu (toivottavasti)
                    a.getOikeaSisar().setVasenSisar(a.getVasenSisar());
                    this.nodeja--;
                    break;
                }
                System.out.println(minRoot.toString());
                a = a.getOikeaSisar();
            } while (a != eka);
            System.out.println("mintooo");
            if (z == z.getOikeaSisar()) {
                this.minRoot = null;
            } else {
                System.out.println("tst");
                minRoot = z.getOikeaSisar();
                consolidate();
            }
            this.nodeja--;
        }
    }

    private FiboNode[] alustaAstelista() {
        FiboNode[] asteet = null;
        FiboNode a = this.minRoot;
        if (a == null) {
            return asteet;
        }

        double koko = Math.log(nodeja) / Math.log(2) + 1;
        asteet = new FiboNode[(int) koko + 1];
        for (int i = 0; i < koko; i++) {
            // asteet.add(null);
            asteet[a.getAste()] = null;
            a = a.getOikeaSisar();
        }
        return asteet;
    }

    private void consolidate() {
        FiboNode[] asteet = alustaAstelista();
        FiboNode i = this.minRoot;
        FiboNode eka = this.minRoot;
        if (i == null) {
            return;
        }
        // if (i != null) { //jokaiselle rootlistin nodelle i
        do {
            FiboNode x = i;
            int d = x.getAste();
            while (asteet[d] != null) {
                FiboNode y = asteet[d];
                if (x.getArvo() > y.getArvo()) {
                    //vaihda x ja y
                    FiboNode safe = x;
                    x = y;
                    y = safe;
                }
                heapLink(y, x);
                for (int k = 0; k < asteet.length; k++) {
                    System.out.println(asteet[k]);
                }
                asteet[d] = null;

                d++;
                if (d > asteet.length) {

                    System.out.println("astetaulukkosize" + asteet.length + " nodet " + nodeja + " d: " + d);

                }
                asteet[d] = x;
                i = i.getOikeaSisar(); //liikutaan rootlistissa eteenpäin
            }

        } while (i != eka);
        this.minRoot = null;
        for (int u = 0; u < nodeja; u++) {
            if (asteet[u] != null) {
                //lisää asteet[u] rootlistiin
                this.lisaaRootListiin(asteet[u]);
                if (minRoot == null || asteet[u].getArvo() < minRoot.getArvo()) {
                    minRoot = asteet[u];
                }
            }
        }
    }

    private void lisaaRootListiin(FiboNode x) {
        if (minRoot == null) {
            minRoot = x;
        } else {
            minRoot.getOikeaSisar().setVasenSisar(x);
            x.setOikeaSisar(minRoot.getOikeaSisar());
            minRoot.setOikeaSisar(x);
            x.setVasenSisar(minRoot);
        }
        /*if (this.minRoot == null || x.getArvo() < this.minRoot.getArvo()) {
         this.minRoot = x;
         }*/
        nodeja++;
    }

    private void heapLink(FiboNode y, FiboNode x) {
        if (y == null) {
            return;
        }
        //etsi y rootlististä ja poista se
        FiboNode eka = this.minRoot;
        FiboNode a = this.minRoot;
        do {
            if (a == y) {
                a.getVasenSisar().setOikeaSisar(a.getOikeaSisar());
                a.getOikeaSisar().setVasenSisar(a.getVasenSisar());
                break;
            }
            a = a.getOikeaSisar();
        } while (a != eka);
        y.setVanhus(x); //yystä x:n lapsi
        if (x.getLapsi() == null) {
            x.setLapsi(y);
            y.setOikeaSisar(null);
            y.setVasenSisar(null);
            x.kasvataAstettaYhdella(); //tartteeko tätä tehdä elsessä?
        } else { // aseta x:n lapset osoittamaan oikein
            FiboNode xvasenlapsi = x.getLapsi().getVasenSisar();
            FiboNode xoikealapsi = x.getLapsi().getOikeaSisar();
            xvasenlapsi.getOikeaSisar().setVasenSisar(y);
            xoikealapsi.getVasenSisar().setOikeaSisar(y);
            //   x.setLapsi(y);
        }
        y.setMark(false);
    }

    @Override
    public void Insert(int a) {
        FiboNode x = new FiboNode(a);
        x.setAste(0);
        x.setVanhus(null);
        x.setLapsi(null);
        x.setVasenSisar(x);
        x.setOikeaSisar(x);
        x.setMark(false);
        //konkatinoidaan this.rootlist ja rootlist jossa x
        if (minRoot == null) {
            minRoot = x;
        } else {
            minRoot.getOikeaSisar().setVasenSisar(x);
            x.setOikeaSisar(minRoot.getOikeaSisar());
            minRoot.setOikeaSisar(x);
            x.setVasenSisar(minRoot);
        }
        //korjaapa tätä vielä..
        if (this.minRoot == null || x.getArvo() < this.minRoot.getArvo()) {
            this.minRoot = x;
        }
        nodeja++;
    }

    private void yhdistaKeot(Fibonaccikeko B2) {
    }

    public String toString() {
        FiboNode i = minRoot;
        String t = "juuret: \n";
        for (int j = 0; j < nodeja; j++) {
            t += i.toString();
            t += "\n";
            i = i.getOikeaSisar();
        }
        return t + "\n";
    }

    @Override
    public int getYlin() {
        return this.minRoot.getArvo();
    }
}
