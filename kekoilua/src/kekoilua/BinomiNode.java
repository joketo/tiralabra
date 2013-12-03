
package kekoilua;

public class BinomiNode {
    private int arvo;
    private int aste;
    private BinomiNode vanhempi;
    private BinomiNode sisar;
    private BinomiNode vasinLapsi; //vasemmanpuoleisin lapsi
    
    public BinomiNode(int juurenarvo){
        this.arvo = juurenarvo;
        this.aste = 0;
        this.vanhempi = null;
        this.sisar = null;
        this.vasinLapsi = null;
    }
  
    public boolean onkoJuuri(){
        if(this.vanhempi == null){
            return true;
        }
        else return false;
    }
    
    public void setSisar(BinomiNode i){
        this.sisar = i;
    }
    
    public void Yhdista(BinomiNode z){
        this.vanhempi = z;
        this.sisar = z.getlapsi();
        z.setVasinLapsi(this);
        z.setAste(z.getAste()+1);
    }
    
    public void setArvo(int newArvo){
        this.arvo = newArvo;
    }
    
    public void setVanhempi(BinomiNode vanhempi){
        this.vanhempi = vanhempi;
    }
    
    public void setAste(int aste){
        this.aste = aste;
    }
    
    public int getArvo(){
        return arvo;
    }
    
    public int getAste(){
        return aste;
    }
    
    public BinomiNode getVanhempi(){
        return this.vanhempi;
    }
    
    public BinomiNode getSisar(){
        return this.sisar;
    }
    
    public BinomiNode getlapsi(){
        return this.vasinLapsi;
    }
    
    public void setVasinLapsi(BinomiNode i){
        this.vasinLapsi = i;
    }
    
    @Override
    public String toString(){
        if (this == null){
            return "tyhjä";
        }
        return "aste: " + this.aste +" arvo: "+ this.arvo + ", lapsi:  ("+this.vasinLapsi+" SISAR: "+ this.sisar +")\n";
    }
}
