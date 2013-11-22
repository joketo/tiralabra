
package kekoilua;

import java.util.LinkedList;


public class TreeNode {
    private int arvo;
    LinkedList lapset;
    private int aste;
    
    public TreeNode(int juurenarvo, int aste){
        this.lapset = new LinkedList();
        this.arvo = juurenarvo;
        this.aste = aste;
    }
    
    public void lisaaLapsi(TreeNode i){
        lapset.add(i);
    }
    
    public int getArvo(){
        return arvo;
    }
    public int getAste(){
        return aste;
    }
    
}
