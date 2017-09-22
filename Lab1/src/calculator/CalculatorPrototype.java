/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Sushi
 */
public class CalculatorPrototype implements CalculatorIF {

    @Override
    public int sum(int m, int n) {
        int result = m;
        for(int i = 0; i < n; i++) result++;
        return result;
    }

    @Override
    public int divide(int m, int n) {
        //Check the input is right.
        if(n == 0) throw new ArithmeticException("You cannot divide by 0");
        
        //Compute division using subtraction.
        int result;
        for(result = 0; m >= n; result++) m -= n;
        return result;
    }

    @Override
    public int multiply(int m, int n) {
        int result = 0;
        for(int i=0; i<n ; i++ )
            result +=n;
         //Weird comment
        return result;
    }
    
}
