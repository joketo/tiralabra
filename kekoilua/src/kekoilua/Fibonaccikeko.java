package kekoilua;

import java.util.EmptyStackException;


public class Fibonaccikeko implements Keko {

    private FiboNode minRoot; //rootlistin pienimmän alkion sisältävä root
    private int nodeja; //kuinka monta nodea rootlistissä on

    public Fibonaccikeko() {
        minRoot = null;
        nodeja = 0;
    }

    @Override
    public int Delete() {
        int pieninArvo = minRoot.getArvo(); //palautusta varten
        if(minRoot == null){
            throw new EmptyStackException();
        }
        FiboNode z = this.minRoot;
        if (z != null) {
            FiboNode x = z.getLapsi();
            if (x != null) {
                FiboNode vika = x.getVasenSisar();
                while (true) {
                    FiboNode oikea = x.getOikeaSisar();
                    lisaaRootListiin(x);
                    if (this.minRoot == null || x.getArvo() < this.minRoot.getArvo()) {
                        this.minRoot = x;
                    }
                    x.setVanhus(null);

                    if (x == vika) {
                        break;
                    }
                    x = oikea;
                }
            }
            FiboNode a = this.minRoot;
            FiboNode eka = this.minRoot;
            do { // poistetaan z rootlististä
                if (a == z) {
                    a.getVasenSisar().setOikeaSisar(a.getOikeaSisar());
                    a.getOikeaSisar().setVasenSisar(a.getVasenSisar());
                    break;
                }

                a = a.getOikeaSisar();
            } while (a != eka);
            if (z == z.getOikeaSisar()) {
                this.minRoot = null;
            } else {
                minRoot = z.getOikeaSisar();
                consolidate();
            }
            this.nodeja--;
        }
        return pieninArvo;
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
        if (minRoot == null) {
            return;
        }
        FiboNode vika = this.minRoot.getVasenSisar();
        if (i == null) {
            return;
        }
        //jokaiselle rootlistin nodelle i
        while (true) {
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

                asteet[d] = null;
                d++;
            }
            asteet[d] = x;
            if (i == vika) {
                break;
            }
            i = i.getOikeaSisar(); //liikutaan rootlistissa eteenpäin
        }
        this.minRoot = null;
        for (int u = 0; u < asteet.length; u++) {
            if (asteet[u] != null) {//lisää asteet[u] rootlistiin
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
    }
    
    //tee yystä x:n lapsi
    private void heapLink(FiboNode y, FiboNode x) {
        if (y == null) {
            return;
        }
        y.getVasenSisar().setOikeaSisar(y.getOikeaSisar());
        y.getOikeaSisar().setVasenSisar(y.getVasenSisar());
        y.setVanhus(x); //yystä x:n lapsi
        if (x.getLapsi() == null) {
            x.setLapsi(y);
            y.setOikeaSisar(y);
            y.setVasenSisar(y);
        } else { // aseta x:n lapset osoittamaan oikein
            x.getLapsi().getVasenSisar().setOikeaSisar(y);
            y.setVasenSisar(x.getLapsi().getVasenSisar());
            x.getLapsi().setVasenSisar(y);
            y.setOikeaSisar(x);// x.setLapsi(y);
        }
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
        if (minRoot == null) {
            minRoot = x;
        } else {
            minRoot.getOikeaSisar().setVasenSisar(x);
            x.setOikeaSisar(minRoot.getOikeaSisar());
            minRoot.setOikeaSisar(x);
            x.setVasenSisar(minRoot);
        }
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