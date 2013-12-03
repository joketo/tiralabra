
package kekoilua;

public class FiboNode {
    private FiboNode vanhus;
    private FiboNode lapsi;
    private FiboNode vasenSisar;
    private FiboNode oikeaSisar;
    private int aste;
    private int arvo;
    private boolean mark;
    
    public FiboNode(int arvo){
        this.mark = false;
        this.arvo = arvo;
        this.aste = 0;
    }

    public FiboNode getVanhus() {
        return vanhus;
    }
    public void setArvo(int arvo){
        this.arvo = arvo;
    }
    public void kasvataAstettaYhdella(){
        this.aste++;
    }

    public int getArvo(){
        return this.arvo;
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

 
    public FiboNode getVasenSisar() {
        return vasenSisar;
    }


    public void setVasenSisar(FiboNode vasen) {
        this.vasenSisar = vasen;
    }

 
    public FiboNode getOikeaSisar() {
        return oikeaSisar;
    }

 
    public void setOikeaSisar(FiboNode oikea) {
        this.oikeaSisar = oikea;
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
