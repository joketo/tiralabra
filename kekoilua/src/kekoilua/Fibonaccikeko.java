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
            FiboNode ekalapsi = x;
            if (this.minRoot == null || x.getArvo() < this.minRoot.getArvo()) {
                this.minRoot = x;
            } else {
                minRoot.setVasenSisar(x);
            }
            x.setVanhus(null); //lasten vanhemmaksi null
            x = x.getOikeaSisar(); //
            while (x != ekalapsi) { //laita kaikki lapset pinon rootlistiin, mennään kunnes lapset ympäri
                if (this.minRoot == null || x.getArvo() < this.minRoot.getArvo()) {
                    this.minRoot = x;
                } else {
                    minRoot.setVasenSisar(x);
                }
                x.setVanhus(null);
                x = x.getOikeaSisar();
            }
            //poista z rootlististä...
            if (z == z.getOikeaSisar()) {
                this.minRoot = null;
            } else {
                this.minRoot = x.getOikeaSisar();
            }
            consolidate();
            this.nodeja--;
        }
    }

    private void consolidate() {
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
        //konkatinoidaan this.rootlist ja rootlist jossa x...
        if (this.minRoot == null || x.getArvo() < this.minRoot.getArvo()) {
            this.minRoot = x;
        } else {
            minRoot.setVasenSisar(x);
        }
        nodeja++;
    }

    private void yhdistaKeot(Fibonaccikeko B2) {
    }

    @Override
    public int getYlin() {
        return this.minRoot.getArvo();
    }
}
