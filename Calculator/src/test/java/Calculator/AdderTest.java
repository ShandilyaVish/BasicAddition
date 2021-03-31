package Calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AdderTest {
	private Addable adder;
	
	@Before
	public void init() {
		adder = new Adder();
	}
	
	@Test
	public void testForTwoDigitNumbers() {
		//given
		String input = "5,1000";
		long expectedSumOfNumbers = 1005;
		//when
		long sumOfNumbers = adder.addNumbers(input);
		//then
		assertEquals(expectedSumOfNumbers, sumOfNumbers);
	}
	
	@Test
	public void testForSingleDigitNumber() {
		//given
		String input = "5";
		long expectedSumOfNumber = 5;
		//when
		long sumOfNumber = adder.addNumbers(input);
		//then
		assertEquals(expectedSumOfNumber, sumOfNumber);
	}
	
	@Test
	public void testForEmptyInput() {
		//given
		String input = "";
		long expectedValue = 0;
		//when
		long sumOfNumber = adder.addNumbers(input);
		//then
		assertEquals(expectedValue, sumOfNumber);
	}
	
	

}
