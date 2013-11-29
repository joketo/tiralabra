package kekoilua;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KasvavaArrayTest {
    
    KasvavaArray<Integer> arI;
    KasvavaArray<String> arS;
    @Before
    public void setUp() {
        arI = new KasvavaArray<>();
        arS = new KasvavaArray<>();
    }
      
    @Test
    public void testContainsToimiiKunYksiInt(){
        arI.add(3);
        assertEquals(true, arI.contains(3));
    }
    
    @Test
    public void testContainsToimiiKunYksiString(){
        arS.add("kissa");
        assertEquals(true, arS.contains("kissa"));
    }

    @Test
    public void testAdd() {
        arI.add(2);
        assertEquals(true, arI.contains(2));
    }

    @Test
    public void testRemoveViimeinenAlkio() {
        arI.add(3);
        arI.add(2);
        System.out.println(arI.toString());
        arI.remove(1);
        System.out.println(arI.toString());
        assertEquals(false, arI.contains(2));
    }
    
    @Test
    public void testRemoveSailyykoViimeinenOikeanaJosPoistaaKeskelta(){
        arI.add(5);
        arI.add(6);
        arI.add(7);
        System.out.println(arI.toString());
        arI.remove(1);
        System.out.println(arI.toString());
        assertEquals(true, arI.contains(7));
    }

    @Test
    public void testSize() {
        arI.add(1);
        arI.add(2);
        arI.add(3);
        assertEquals(3, arI.size());
    }
    
    @Test
    public void testGet(){
        arI.add(3);
        assertEquals(3, arI.get(0));
    }
    
    @Test
    public void testIndexOf(){
        arI.add(1);
        arI.add(4);
        assertEquals(1, arI.indexOf(4));
    }
    @Test
    public void testSet(){
        arI.add(1);
        arI.add(2);
        arI.set(1, 3);
        assertEquals(3, arI.get(1));
    }
}