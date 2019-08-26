package com.dhenton9000.rpn;

import static org.junit.Assert.*;
import org.junit.Test;

public class RPNTest {

    @Test(expected = IllegalStateException.class)
    public void testSubmitEmptyString() {
        String s = "";
        RPNCalculator r = new RPNCalculator();
        Double d = r.determineRPN(s);

    }

    @Test
    public void testSimpleBinaryOp() {

        String s = "7\t4\t+\t3\t-";
        RPNCalculator r = new RPNCalculator();
        Double d = r.determineRPN(s);
        assertEquals("8.0", d.toString());
    }

    @Test
    public void testSimpleBinaryOpTwo() {

        String s = "8\t4\t/\t3\t*";
        RPNCalculator r = new RPNCalculator();
        Double d = r.determineRPN(s);
        assertEquals("6.0", d.toString());

    }

    @Test(expected = IllegalStateException.class)
    public void testJustOneSymbol() {

        String s = "+\t";
        RPNCalculator r = new RPNCalculator();
        Double d = r.determineRPN(s);
        assertEquals("7.0", d.toString());

    }

    @Test
    public void testJustReturnOneNumber() {
        
        String s = "7\t";
        RPNCalculator r = new RPNCalculator();
        Double d = r.determineRPN(s);
        assertEquals("7.0", d.toString());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowBadOperant() {
        String s = "7\t3\t$";
        RPNCalculator r = new RPNCalculator();
        Double d = r.determineRPN(s);
        assertEquals("0.0", d.toString());

    }

    @Test(expected = IllegalStateException.class)
    public void testBadOne() {
        String s = "7\t*3";
        RPNCalculator r = new RPNCalculator();
        Double d = r.determineRPN(s);

    }

}
