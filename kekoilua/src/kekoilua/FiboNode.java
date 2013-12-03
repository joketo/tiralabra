
package kekoilua;

public class FiboNode {
    private FiboNode vanhus;
    private FiboNode lapsi;
    private FiboNode vasenlapsi;
    private FiboNode oikealapsi;
    private int aste;
    //private int arvo;
    private boolean mark;
    
    public FiboNode(){
        this.mark = false;
    }

    public FiboNode getVanhus() {
        return vanhus;
    }


    public void setVanhus(FiboNode vanhus) {
        this.vanhus = vanhus;
    }

 
    public FiboNode getLapsi() {
        return lapsi;
    }


    public void setLapsi(FiboNode lapsi) {
        this.lapsi = lapsi;
    }

 
    public FiboNode getVasenlapsi() {
        return vasenlapsi;
    }


    public void setVasenlapsi(FiboNode vasenlapsi) {
        this.vasenlapsi = vasenlapsi;
    }

 
    public FiboNode getOikealapsi() {
        return oikealapsi;
    }

 
    public void setOikealapsi(FiboNode oikealapsi) {
        this.oikealapsi = oikealapsi;
    }


    public int getAste() {
        return aste;
    }

    public void setAste(int aste) {
        this.aste = aste;
    }


    public boolean isMark() {
        return mark;
    }


    public void setMark(boolean mark) {
        this.mark = mark;
    }
    
}
