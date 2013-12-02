
package kekoilua;

import java.util.LinkedList;
import java.util.List;


public class TreeNode {
    private int arvo;
    private int aste;
    private TreeNode vanhempi;
    private TreeNode sisar;
    private TreeNode vasinLapsi;
    
    public TreeNode(int juurenarvo){
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
    
    public void setSisar(TreeNode i){
        this.sisar = i;
    }
    
    public void Yhdista(TreeNode z){
        System.out.println("testaus");
        this.vanhempi = z;
        this.sisar = z.getlapsi();
        z.setVasinLapsi(this);
        z.setAste(z.getAste()+1);
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
    public TreeNode getlapsi(){
        return this.vasinLapsi;
    }
    public void setVasinLapsi(TreeNode i){
        this.vasinLapsi = i;
    }
    @Override
    public String toString(){
        if (this == null){
            return "tyhjä";
        }
        return "aste: " + this.aste +" arvo: "+ this.arvo + ", lapsi:  ("+this.vasinLapsi+")\n";
    }
}
