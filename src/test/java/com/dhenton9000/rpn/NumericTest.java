package com.dhenton9000.rpn;

import static org.junit.Assert.*;
import org.junit.Test;

public class NumericTest {

    @Test
    public void testSimpleNumber() {
        String s = "7";

        RPNCalculator r = new RPNCalculator();
        assertTrue(r.isNumeric(s));
    }
    
    @Test
    public void testSimpleNegativeNumber() {
        String s = "-7";

        RPNCalculator r = new RPNCalculator();
        assertTrue(r.isNumeric(s));
    }
    
    @Test
    public void testNumberWithDecimal() {
        String s = "-7.34";

        RPNCalculator r = new RPNCalculator();
        assertTrue(r.isNumeric(s));
    }
    
    
    @Test
    public void testNumberWithType() {
        String s = "-7.34f";

        RPNCalculator r = new RPNCalculator();
        assertFalse(r.isNumeric(s));
    }
    

    @Test
    public void testSimpleString() {
        String s = "fred";

        RPNCalculator r = new RPNCalculator();
        assertFalse(r.isNumeric(s));
    }

    @Test
    public void testBiggerNumber() {
        String s = "734";

        RPNCalculator r = new RPNCalculator();
        assertTrue(r.isNumeric(s));
    }

}
