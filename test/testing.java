/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import caesarcipher.CaesarCipher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 348848128
 */
public class testing {
    
 public testing(){
     
 }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    CaesarCipher cipher = new CaesarCipher();
     @Test
     public void tests() {
         assertEquals(cipher.encode("life is like a box of chocolates", 7),"spml pz sprl h ive vm jovjvshalz");
         assertEquals(cipher.encode("you never know what you are going to get", 13),"lbh arire xabj jung lbh ner tbvat gb trg");
         assertEquals(cipher.encode("ROSES ARE RED", 9),"AXBNB JAN ANM");
         assertEquals(cipher.encode("vIoLeTs aRe blUe", 9),"eRxUnCb jAn kuDn");
         assertEquals(cipher.decode("spml pz sprl h ive vm jovjvshalz", 7),"life is like a box of chocolates");
         assertEquals(cipher.decode("lbh arire xabj jung lbh ner tbvat gb trg", 13),"you never know what you are going to get");
         assertEquals(cipher.decode("AXBNB JAN ANM", 9),"ROSES ARE RED");
         assertEquals(cipher.decode("eRxUnCb jAn kuDn", 9),"vIoLeTs aRe blUe");
        //String breakTest[] = {"If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out."};
        //assertArrayEquals(cipher.breakCode("nk mj mfi fsdymnsl htsknijsynfq yt xfd, mj bwtyj ny ns hnumjw, ymfy nx, gd xt hmfslnsl ymj twijw tk ymj qjyyjwx tk ymj fqumfgjy, ymfy sty f btwi htzqi gj rfij tzy."),breakTest);
         
         
     }
}
