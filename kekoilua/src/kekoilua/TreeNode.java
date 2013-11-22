
package kekoilua;

import java.util.LinkedList;

//kaikki täällä on rikki, älkää katsoko tänne!

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
    
}
