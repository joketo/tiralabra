package kekoilua;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinomikekoTest {

    public Binomikeko keko;

    @Before
    public void setUp() {
        keko = new Binomikeko();
    }
/*
    @Test
    public void toimiikoUudenKeonLuonti() {
        keko.Insert(4);
        System.out.println(keko.toString());

        keko.Insert(5);
        System.out.println(keko.toString());

        keko.Insert(6);
        System.out.println(keko.toString());
    }*/

    @Test
    public void testDelete() {
        System.out.println("Delete");
        keko.Insert(1);
        keko.Insert(2);
        System.out.println(keko.toString());
        keko.Delete();
        System.out.println(keko.toString());
        assertEquals(2, keko.getYlin());
    }/*

    @Test
    public void testInsert() {
        System.out.println("Insert");
        keko.Insert(3);
        assertEquals(keko.getYlin(), 3);
    }

    @Test
    public void testGetYlin() {
        System.out.println("testGetYlin");
        keko.Insert(7);
        keko.Insert(5);
        keko.Insert(6);
        assertEquals(5, keko.getYlin());
    }

    @Test
    public void testInsertIsommallaMaaralla() {
        System.out.println("insertIsommalla");
        keko.Insert(4);
        keko.Insert(3);
        keko.Insert(1);
        keko.Insert(5);
        keko.Insert(3);
        keko.Insert(7);
        keko.Insert(5);
        System.out.println(keko.toString());
        assertEquals(1, keko.getYlin());

    }*/
}