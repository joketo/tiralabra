package kekoilua;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaarikekoTest {

    public Binaarikeko keko;
    public ArrayList<Integer> semikeko;
    
    @Before
    public void setUp() {
        keko = new Binaarikeko();
    }


    @Test
    public void InsertToimiiKunKekoOnTyhja() {
        int alkio = 4;
        keko.insert(alkio);
        assertEquals(4, keko.getYlin());
    }
    
    @Test
    public void InsertToimiiKunKekoEiOleTyhja(){
        keko.insert(1);
        keko.insert(3);
        keko.insert(5);
        assertEquals(5, keko.getYlin());
    }

    /**
     * Test of pop method, of class Binaarikeko.
     */
    @Test
    public void DeleteToimiiKunKekoOnTyhja() {
        keko.pop();
        assertEquals(-1, keko.getYlin()); //-1 on tyhjän keon merkki
    }
    
    @Test
    public void DeleteToimiiKunKeossaYksiAlkio(){
        keko.insert(1);
        keko.pop();
        assertEquals(-1, keko.getYlin());
    }
    
    @Test
    public void DeleteToimiiKunKeossaNeljaAlkiota(){
        keko.insert(4);
        keko.insert(3);
        keko.insert(2);
        keko.insert(1);
        keko.pop();
        assertEquals(3, keko.getYlin());
    }
    
    @Test
    public void GetYlinToimii(){
        keko.insert(3);
        keko.insert(5);
        assertEquals(5, keko.getYlin());
    }
}