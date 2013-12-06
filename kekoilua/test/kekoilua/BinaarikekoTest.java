package kekoilua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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
    public void testDeleteRandomKeolla() {
        ArrayList<Integer> a = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            a.add(rand.nextInt());
        }
        Random r = new Random();
        for (int i = 0; i < a.size(); i++) {
            keko.insert(a.get(i));
        }
        Collections.sort(a);

        for (int i = 0; i < a.size(); i++) {
            assertEquals((int) a.get(i), (int) keko.pop());
        }
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
        assertEquals(1, keko.getYlin());
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
        assertEquals(2, keko.getYlin());
    }
    
    @Test
    public void GetYlinToimii(){
        keko.insert(3);
        keko.insert(5);
        assertEquals(3, keko.getYlin());
    }
}