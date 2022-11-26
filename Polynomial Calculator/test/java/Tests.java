
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Tests {
    Model m = new Model();

    @Test
    public void produs() throws Exception {
        m = new Model("8x^2+3x^8-1x^5-5x^6+2x^4-1", "2x^6-5x^7+6x^4-5x^2+5");
        assertEquals( m.multiply().toString(), "[-15x^15, +6x^14, +25x^13, +13x^12, -12x^11, -41x^10, -46x^9, +68x^8, +10x^7, +11x^6, -5x^5, -36x^4, +45x^2, -5]");
    }

    @Test
    public void cat() throws Exception {
        m = new Model("8x^2+3x^8-1x^5-5x^6+2x^4-1", "2x^6-5x^7+6x^4-5x^2+5");
        assertEquals( m.div().toString(), "[+1]");
    }

    @Test
    public void suma() throws Exception {
        m = new Model("8x^2+3x^8-1x^5-5x^6+2x^4-1", "2x^6-5x^7+6x^4-5x^2+5");
        assertEquals( m.add().toString(),"+3x^8-5x^7-3x^6-1x^5+8x^4+3x^2+4");
    }

    @Test
    public void diferenta() throws Exception {
        m = new Model("8x^2+3x^8-1x^5-5x^6+2x^4-1", "2x^6-5x^7+6x^4-5x^2+5");
        assertEquals( m.sub().toString(),"+3x^8+5x^7-7x^6-1x^5-4x^4+13x^2-6");
    }

    @Test
    public void derivare() throws Exception {
        m = new Model("8x^2+3x^8-1x^5-5x^6+2x^4-1", "2x^6-5x^7+6x^4-5x^2+5");
        assertEquals(m.derivation().toString(), "[+24x^7, -30x^5, -5x^4, +8x^3, +16x]");
    }

    @Test
    public void integrare() throws Exception {
        m = new Model("8x^2+3x^8-1x^5-5x^6+2x^4-1", "2x^6-5x^7+6x^4-5x^2+5");
        assertEquals( m.integrare().toString(), "[+0.3x^8, -0.625x^6, -0.14285714285714285x^5, +0.3333333333333333x^4, +2.0x^2, -0.5]");
    }
//
//    @Test
//    public void integrare1() throws Exception {
//        m = new Model("4x^2+3x^8-1x^5-5x^6+2x^4-1", "2x^6-5x^7+6x^4-5x^2+5");
//        assertEquals( m.integrare().toString(), "[+0.3x^8, -0.625x^6, -0.14285714285714285x^5, +0.3333333333333333x^4, +2.0x^2, -0.5]");
//    }


}
