
package kekoilua;

import java.util.LinkedList;
import java.util.List;


public class TreeNode {
    private int arvo;
    LinkedList<TreeNode> lapset;
    private int aste;
    
    public TreeNode(int juurenarvo, int aste){
        this.lapset = new LinkedList<>();
        this.arvo = juurenarvo;
        this.aste = aste;
    }
    
    public void lisaaLapsi(TreeNode i){
        lapset.add(i);
    }
    
    public TreeNode Yhdista(TreeNode b){
        if(this.getArvo() <= b.getArvo()){ //halutaanko tähän aste vai arvo?
            this.lisaaLapsi(b);
            return this;
        }
        else{
            b.lisaaLapsi(this);
            return b;
        }
    }
    
    public int getArvo(){
        return arvo;
    }
    
    public int getAste(){
        return aste;
    }
    
    public boolean onkoTyhja(){
        if(lapset.isEmpty()){
            return true;
        }else{
          return false;  
        }
    }
    public List annaLapset(){
        return lapset;
    }
    
}
