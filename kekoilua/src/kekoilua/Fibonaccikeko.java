
package kekoilua;


public class Fibonaccikeko implements Keko{
    private FiboNode minRoot; //rootlistin pienimmän alkion sisältävä root
    private int nodeja; //kuinka monta nodea rootlistissä on
    
    public Fibonaccikeko(){
        minRoot = null;
        nodeja = 0;
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insert(int a) {
        FiboNode x = new FiboNode(a);
        x.setAste(0);
        x.setVanhus(null);
        x.setLapsi(null);
        x.setVasenlapsi(x);
        x.setOikealapsi(x);
        x.setMark(false);
        //conkatinoi this.rootlist ja rootlist jossa x
        if(this.minRoot == null || x.getArvo() < this.minRoot.getArvo()){
            this.minRoot = x;
        }
        nodeja++;
    }

    @Override
    public int getYlin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
