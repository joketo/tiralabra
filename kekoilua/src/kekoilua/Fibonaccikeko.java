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
                minRoot = z.getOikeaSisar();
                consolidate();
            }
            this.nodeja--;
        }
    }
    /*
     private KasvavaArray<FiboNode> alustaAstelista() {
     KasvavaArray<FiboNode> asteet = new KasvavaArray<>();
     FiboNode a = this.minRoot;
     if (a == null) {
     return asteet;
     }
     for (int i = 0; i < this.nodeja; i++) {
     asteet.add(null);
     //asteet.set(a.getAste(), null);
     a = a.getOikeaSisar();
     }
     return asteet;
     }*/

    private ArrayList<FiboNode> alustaAstelista() {
        ArrayList<FiboNode> asteet = new ArrayList<>();
        FiboNode a = this.minRoot;
        if (a == null) {
            return asteet;
        }
        int suurinAste = 0;
        for (int i = 0; i < this.nodeja; i++) {
            if (a.getAste() > suurinAste) {
                suurinAste = a.getAste();
            }
            a = a.getOikeaSisar();
        }
        for (int i = 0; i < suurinAste; i++) {
            // asteet.add(null);
            asteet.set(a.getAste(), null);
            a = a.getOikeaSisar();
        }
        return asteet;
    }

    private void consolidate() {
        //KasvavaArray<FiboNode> asteet = alustaAstelista();
       // ArrayList<FiboNode> asteet = alustaAstelista();
        //FiboNode eka = this.minRoot;
        FiboNode[] asteet = new FiboNode[];
        System.out.println("TEST ASTEET2:" + asteet.toString() + "\n");

        FiboNode i = this.minRoot;
        if (i != null) {
            for (int j = 0; j < this.nodeja; j++) {
                FiboNode x = i;
                int d = x.getAste();
                while (asteet.get(d) != null) {
                    FiboNode y = (FiboNode) asteet.get(d); //miksei tämä palauta FiboNodea..
                    if (x.getArvo() > y.getArvo()) {
                        //vaihda x ja y
                        FiboNode safe = x;
                        x = y;
                        y = safe;
                    }//onkohan tässä iffin loppu..
                    heapLink(y, x);
                    asteet.set(d, null);
                    d++;
                }
                asteet.set(d, x);
                i = i.getOikeaSisar(); //liikutaan rootlistissa eteenpäin
            }
        }
        System.out.println("TEST ASTEET:" + asteet.toString() + "\n");
        this.minRoot = null;
        for (int u = 0; u < nodeja; u++) {
            if (asteet.get(u) != null) {
                FiboNode nyk = asteet.get(u);
                //lisää asteet[u] rootlistiin
                this.lisaaRootListiin(nyk);
                if (minRoot == null || nyk.getArvo() < minRoot.getArvo()) {
                    minRoot = nyk;
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
        FiboNode a = this.minRoot;
        for (int i = 0; i < this.nodeja; i++) {
            if (a == y) {
                a.getVasenSisar().setOikeaSisar(a.getOikeaSisar());
                a.getOikeaSisar().setVasenSisar(a.getVasenSisar());
                this.nodeja--;
            }
            a = a.getOikeaSisar();
        }
        y.setVanhus(x); //yystä x:n lapsi
        x.setLapsi(y);
        x.kasvataAstettaYhdella();
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
