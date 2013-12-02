
package kekoilua;

import java.util.LinkedList;
import java.util.List;


public class TreeNode {
    private int arvo;
    private LinkedList<TreeNode> lapset;
    private int aste;
    private TreeNode vanhempi;
    private TreeNode sisar;
    
    public TreeNode(int juurenarvo){
        this.lapset = new LinkedList<>();
        this.arvo = juurenarvo;
        this.aste = 0;
        this.vanhempi = null;
        this.sisar = null;
    }
    
    public void lisaaLapsi(TreeNode i){
        lapset.add(i);
    }
    public void setSisar(TreeNode i){
        this.sisar = i;
    }
    
    public TreeNode Yhdista(TreeNode b){
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
        }
    }
    public void setArvo(int newArvo){
        this.arvo = newArvo;
    }
    public void setVanhempi(TreeNode vanhempi){
        this.vanhempi = vanhempi;
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
