package kekoilua;

public class Fibonaccikeko implements Keko {

    private FiboNode minRoot; //rootlistin pienimmän alkion sisältävä root
    private int nodeja; //kuinka monta nodea rootlistissä on

    public Fibonaccikeko() {
        minRoot = null;
        nodeja = 0;
    }

    @Override
    public void Delete() {
        FiboNode z = this.minRoot;
        if (z != null) {
            FiboNode x = z.getLapsi();
            if (x != null) {
                for (int i = 0; i < this.nodeja; i++) { // lisää kaikki x:n lapset rootlistiin
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
                    x.setVanhus(null);
                    x = x.getOikeaSisar();
                }
            }
            FiboNode a = this.minRoot;
            for (int i = 0; i < this.nodeja; i++) {
                if (a == z) {
                    a.getVasenSisar().setOikeaSisar(a.getOikeaSisar()); // z poistuu (toivottavasti)
                    a.getOikeaSisar().setVasenSisar(a.getVasenSisar());
                    this.nodeja--;
                }
                a = a.getOikeaSisar();
            }
            consolidate();
            this.nodeja--;
        }
    }

    private KasvavaArray<FiboNode> alustaAstelista() {
        KasvavaArray<FiboNode> asteet = new KasvavaArray<>();
        FiboNode a = this.minRoot;
        /* if (a == null) {
         return asteet;
         }*/
        for (int i = 0; i < this.nodeja; i++) {
            asteet.add(null);
            //asteet.set(a.getAste(), null);
            a = a.getOikeaSisar();
        }
        return asteet;
    }

    private void consolidate() {
        KasvavaArray<FiboNode> asteet = alustaAstelista();
        //FiboNode eka = this.minRoot;
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


        this.minRoot = null;

        for (int u = 0; u < nodeja; u++) {
            if (asteet.get(u) != null) {
                FiboNode nyk = (FiboNode)asteet.get(u);
                //lisää asteet[u] rootlistiin
                this.lisaaRootListiin(nyk);
                if(minRoot == null || nyk.getArvo() < minRoot.getArvo()){
                    minRoot = nyk;
                }
            }
        }
        /* FiboNode ekataas = this.minRoot; //käydään rootlistin asteet taas läpi
         FiboNode o = this.minRoot;
         if (asteet.get(o.getAste()) != null) {
         FiboNode lisattava = (FiboNode) asteet.get(o.getAste()); //miksei suoraan FiboNode..
         //lisätään asteet[o] rootlistiin
         if (this.minRoot == null || lisattava.getArvo() < this.minRoot.getArvo()) {
         this.minRoot = lisattava; //pitäisköhän täälläkin asettaa siskot oikein
         } else {
         minRoot.getVasenSisar().setOikeaSisar(lisattava); //turhaakohan?
         minRoot.setVasenSisar(lisattava);
         }
         }
         o = o.getOikeaSisar();
         while (o != ekataas) { //tehdään tämä kauhistus lopuillekin
         if (asteet.get(o.getAste()) != null) {
         FiboNode lisattava = (FiboNode) asteet.get(o.getAste()); //miksei suoraan FiboNode..
         //lisätään asteet[o] rootlistiin
         if (this.minRoot == null || lisattava.getArvo() < this.minRoot.getArvo()) {
         this.minRoot = lisattava; //pitäisköhän täälläkin asettaa siskot oikein
         } else {
         minRoot.getVasenSisar().setOikeaSisar(lisattava); //turhaakohan?
         minRoot.setVasenSisar(lisattava);
         }
         }
         o = o.getOikeaSisar();
         }*/
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
