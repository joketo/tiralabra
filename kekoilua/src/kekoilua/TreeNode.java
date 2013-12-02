
package kekoilua;

import java.util.LinkedList;
import java.util.List;


public class TreeNode {
    private int arvo;
    private LinkedList<TreeNode> lapset;
    private int aste;
    private TreeNode vanhempi;
    private TreeNode sisar;
    private TreeNode vasinLapsi;
    
    public TreeNode(int juurenarvo){
        this.lapset = new LinkedList<>();
        this.arvo = juurenarvo;
        this.aste = 0;
        this.vanhempi = null;
        this.sisar = null;
        this.vasinLapsi = null;
    }
    private void paivitaVasinLapsi(){
        this.vasinLapsi = lapset.getFirst();
    }
    
    public void lisaaLapsi(TreeNode i){
        lapset.add(i);
        paivitaVasinLapsi();
    }
    public void setSisar(TreeNode i){
        this.sisar = i;
    }
    
    public void Yhdista(TreeNode z){
        this.vanhempi = z;
        this.sisar = z.lapsi();
        z.setVasinLapsi(this);
        z.setAste(z.getAste()+1);
        /*
        if(this.getArvo() <= b.getArvo()){ //halutaanko tähän aste vai arvo?
            this.lisaaLapsi(b);
            b.setVanhempi(this);
            this.aste++;
            return this;
        }
        else{
            b.lisaaLapsi(this);
            this.vanhempi = b;
            b.aste++;
            return b;
        }*/
    }
    public void setArvo(int newArvo){
        this.arvo = newArvo;
    }
    public void setVanhempi(TreeNode vanhempi){
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
    public TreeNode getVanhempi(){
        return this.vanhempi;
    }
    public TreeNode getSisar(){
        return this.sisar;
    }
    
    public TreeNode lapsi(){
        return this.vasinLapsi;
    }
    public void setVasinLapsi(TreeNode i){
        this.vasinLapsi = i;
    }
    public boolean onkoTyhja(){
        if(lapset.isEmpty()){
            return true;
        }else{
          return false;  
        }
    }
    public List<TreeNode> annaLapset(){
        return lapset;
    }
    public String toString(){
        return "aste: " + aste +" arvo: "+ arvo + ", lapset: " + lapset.size() + "\n";
    }
}
