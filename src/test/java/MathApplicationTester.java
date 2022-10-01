import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    @InjectMocks
    MathApplication mathApplication = new MathApplication();
    @Mock
    CalculatorService calculatorService;

    @Test
    public void testAdd(){
        //add the behaviour of calc service to add two numbers
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, .01);
    }

    @Test
    public void testSubtract(){
        when(calculatorService.subtract(30.0, 20.0)).thenReturn(10.0);

        assertEquals(mathApplication.subtract(30.0, 20.0), 10.0, .01);
    }
    @Test
    public void testMultiply(){
        when(calculatorService.multipy(5.0, 4.0)).thenReturn(20.0);
        assertEquals(mathApplication.multiply(5.0, 4.0), 20.0, .001);
    }

    @Test
    public void testDivide(){
        when(calculatorService.divide(20.0, 5.0)).thenReturn(4.0);
        assertEquals(mathApplication.divide(20.0, 5.0), 4.0, .01);
    }






}
