package com.dhenton9000.rpn;


import java.util.Arrays;
import java.util.Stack;


//http://www.math.bas.bg/bantchev/place/rpn/rpn.java.html
public class RPNCalculator {

    public Double determineRPN(String s) {
        Stack<String> tks = new Stack<>();
        tks.addAll(Arrays.asList(s.trim().split("[ \t]+")));
        double r;
        r = evalrpn2(tks);
        if (!tks.empty()) {
            throw new RuntimeException();
        }
        System.out.println(r);
        return r;

    }

    boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    private double evalrpn2(Stack<String> tks) {

        double x, y;
        if (!tks.isEmpty()) {
            String tk = tks.pop();
            if (isNumeric(tk)) {
                x = Double.parseDouble(tk);
            } else {
                y = evalrpn2(tks);
                x = evalrpn2(tks);
                switch (tk) {
                    case "+":
                        x += y;
                        break;
                    case "-":
                        x -= y;
                        break;
                    case "*":
                        x *= y;
                        break;
                    case "/":
                        x /= y;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
             return x;
        } else {
            // the stack is empty
            
            throw new IllegalStateException();
        }
       

    }

}
