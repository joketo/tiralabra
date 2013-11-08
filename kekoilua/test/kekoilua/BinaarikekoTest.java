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
        keko.Insert(alkio);
        assertEquals(4, keko.getYlin());
    }
    
    @Test
    public void InsertToimiiKunKekoEiOleTyhja(){
        keko.Insert(1);
        keko.Insert(3);
        keko.Insert(5);
        assertEquals(5, keko.getYlin());
    }

    /**
     * Test of Delete method, of class Binaarikeko.
     */
    @Test
    public void DeleteToimiiKunKekoOnTyhja() {
        keko.Delete();
        assertEquals(-1, keko.getYlin()); //-1 on tyhjän keon merkki
    }
    
    @Test
    public void DeleteToimiiKunKeossaYksiAlkio(){
        keko.Insert(1);
        keko.Delete();
        assertEquals(-1, keko.getYlin());
    }
    
    @Test
    public void DeleteToimiiKunKeossaNeljaAlkiota(){
        keko.Insert(4);
        keko.Insert(3);
        keko.Insert(2);
        keko.Insert(1);
        keko.Delete();
        assertEquals(3, keko.getYlin());
    }
    
    @Test
    public void GetYlinToimii(){
        keko.Insert(3);
        keko.Insert(5);
        assertEquals(5, keko.getYlin());
    }
}