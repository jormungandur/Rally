package rally;


import org.junit.Assert;
import org.junit.Test;

public class Tester 
{

	@Test
	public void testNegitive() 
	{
		String expected = "";
		String result = (new Spiral(-1)).toString();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testZero() 
	{
		String expected = " 0\n";
		String result = (new Spiral(0)).toString();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testLarge() 
	{
		String expected = " 6 7 8 9\n 5 0 1  \n 4 3 2  \n        \n";
		String result = (new Spiral(9)).toString();
		Assert.assertEquals(expected, result);
	}




	public static void Main(String[] args)
	{
		Tester t = new Tester();
		t.testNegitive();
		t.testZero();
		t.testLarge();
	}
}
