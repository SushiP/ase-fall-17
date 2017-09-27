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
        
        //Check whenever or not the two operands have negative value. 
        if(m > 0 && n < 0) return this.subtract(m, -n); // m -n.
        else if(m < 0) return this.subtract(n, -m);     // n -m or -m -n.
        
        for(int i = 0; i < n; i++) result++;
        
        return result;
    }

    @Override
    public int subtract(int m, int n) {
        //Check whenever or not the two operands have negative value. 
        if(m > 0 && n < 0) return this.sum(m, -n);  //m - (-n) = m + n. 
        else if(n < 0){ int a = -m; m = -n; n = a; }//(-m) - (-n) = n - m;
        
        int result = m;
        
        for(int i = 0; i < n; i++) result--;
        
        return result;
    }

    @Override
    public int divide(int m, int n) {
        //Check the input is right.
        if(n == 0) throw new ArithmeticException("You cannot divide by 0");
        
        boolean changeSign = false;
        int result;
        
        //Check whenever or not the sign must be changed and make the value positive;
        if(m < 0){ m = - m; changeSign ^= true; }
        if(n < 0){ n = -n; changeSign ^= true; }
        
        //Compute division using subtraction.
        for(result = 0; m >= n; result++) m -= n;
        
        return changeSign ? -result : result;
    }

    @Override
    public int multiply(int m, int n) {
        int result = 0;
        boolean changeSign = false;
        
        //Check whenever or not the sign must be changed and make the value positive;
        if(m < 0){ m = - m; changeSign ^= true; }
        if(n < 0){ n = -n; changeSign ^= true; }
        
        for(int i = 0; i < m ; i++ ) result += n;
      
        //Return the result with right sign.
        return changeSign ? -result : result;
    }
    
}
