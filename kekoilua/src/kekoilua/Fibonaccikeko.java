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
    public int pop() {
        FiboNode z = this.minRoot;
        if (z == null) {
            throw new EmptyStackException();
        }
        int pieninArvo = minRoot.getArvo(); //palautusta varten

// jos z:lla on lapsia, lisätään ne juurilistaan
        FiboNode x = z.getLapsi();
        if (x != null) {
            FiboNode vika = x.getVasenSisar();
            while (true) {
                FiboNode seuraava = x.getOikeaSisar();
                lisaaRootListiin(x);

                if (x == vika) {
                    break;
                }
                x = seuraava;
            }
        }

        z.getVasenSisar().setOikeaSisar(z.getOikeaSisar());
        z.getOikeaSisar().setVasenSisar(z.getVasenSisar());

        if (z == z.getOikeaSisar()) {
            this.minRoot = null;
        } else {
            minRoot = z.getOikeaSisar();
            this.consolidate();
        }
        this.nodeja--;

        return pieninArvo;
    }

    private FiboNode[] alustaAstelista() {
        FiboNode[] asteet;
        FiboNode a = this.minRoot;
        int koko = (int) (Math.log(nodeja) / Math.log(2) + 1);
        asteet = new FiboNode[koko + 1];
        for (int i = 0; i < koko; i++) {
            asteet[i] = null;
        }
        return asteet;
    }

    private void consolidate() {
        if (minRoot == null) {
            return;
        }
        FiboNode i = this.minRoot;
        FiboNode[] asteet = alustaAstelista();
        FiboNode vika = this.minRoot.getVasenSisar();
        int laskuri = 0;
//jokaiselle rootlistin nodelle x
        while (true) {
            FiboNode seuraava = i.getOikeaSisar();
            FiboNode x = i;
            int d = x.getAste();
            laskuri++;
            while (asteet[d] != null) {
//y:llä sama aste kuin x:llä
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
                if (d >= asteet.length) {
                    System.out.println("fuuck");
                }
            }
            asteet[d] = x;
// kaikki käyty jo läpi
            if (i == vika) {
                break;
            }
            i = seuraava;
        }

// uudelleenrakennetaan juurilista
        this.minRoot = null;
        for (int j = 0; j < asteet.length; j++) {
            if (asteet[j] != null) {
//lisää asteet[u] rootlistiin
                this.lisaaRootListiin(asteet[j]);
                if (minRoot == null || asteet[j].getArvo() < minRoot.getArvo()) {
                    minRoot = asteet[j];
                }
            }
        }
        laskuri++;
    }

    private void lisaaRootListiin(FiboNode x) {
        x.setVanhus(null);
        if (minRoot == null) {
            minRoot = x;
            x.setOikeaSisar(x);
            x.setVasenSisar(x);
        } else {
            minRoot.getOikeaSisar().setVasenSisar(x);
            x.setOikeaSisar(minRoot.getOikeaSisar());
            minRoot.setOikeaSisar(x);
            x.setVasenSisar(minRoot);
        }
    }

//tee juuresta y x:n lapsi
    private void heapLink(FiboNode y, FiboNode x) {
// poista y juurilistasta
        y.getVasenSisar().setOikeaSisar(y.getOikeaSisar());
        y.getOikeaSisar().setVasenSisar(y.getVasenSisar());
        y.setVanhus(x); //yystä x:n lapsi
        x.kasvataAstettaYhdella();
        if (x.getLapsi() == null) {
            x.setLapsi(y);
            y.setOikeaSisar(y);
            y.setVasenSisar(y);
        } else { // aseta x:n lapset osoittamaan oikein
            x.getLapsi().getVasenSisar().setOikeaSisar(y);
            y.setVasenSisar(x.getLapsi().getVasenSisar());
            x.getLapsi().setVasenSisar(y);
            y.setOikeaSisar(x.getLapsi());
        }
        y.setMark(false);
    }

    @Override
    public void insert(int a) {
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