package Calculator;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;




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
	
	@Test
	public void testForMultipleDigitNumbers() {
		//given
		String input = "5,1000,1000,1000,500,500";
		long expectedSumOfNumbers  = 4005;
		//when
		long sumOfNumbers = adder.addNumbers(input);
		//then
		assertEquals(expectedSumOfNumbers, sumOfNumbers);
	}
	
	
	@Test
	public void testForMultipleDelimeterCorrectInput() {
		//given
		String input = "1\n2,3";
		long expectedSumOfNumbers = 6;
		//when
		long sumOfNumbers = adder.addNumbers(input);
		//then
		assertEquals(expectedSumOfNumbers, sumOfNumbers);
	}
	
	@Test 
	public void testForMultipleDelimeterInCorrectInput() {
		//given
		String input = "1,\n7";
		//when
		Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> 
				adder.addNumbers(input));
		//then
		assertEquals("java.lang.NumberFormatException", 
				exception.getClass().toString().split(" ")[1]);
	}
	
	@Test
	public void testForDifferentDelimeterByUser() {
		//given
		String input = "//;\n1;2";
		long expectedSumOfNumbers = 3;
		//when
		long sumOfNumbers = adder.addNumbers(input);
		//then
		assertEquals(expectedSumOfNumbers, sumOfNumbers);
		
	}
	
	@Test
	public void testForNegativeNumbers() {
		//given
		String input = "-1,7,-6";
		//when
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> adder.addNumbers(input));
		System.out.println(exception);
		//then
		assertEquals(new IllegalArgumentException("-1,-6").getMessage(), exception.getMessage());
	}
	
	@Test
	public void testForNumbersBiggerThan1000() {
		//given
		String input = "2,1001,1005";
		long expectedSumOfNumbers = 2;
		//when
		long sumOfNumbers = adder.addNumbers(input);
		//then
		assertEquals(expectedSumOfNumbers, sumOfNumbers);
	}
	

}

