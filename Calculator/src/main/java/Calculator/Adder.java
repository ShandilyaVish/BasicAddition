package Calculator;

import java.util.InputMismatchException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Adder implements Addable {
	
	private String delimeters;
	private String inputNumber;
	
	private Adder(String delimeters,String inputNumber) {
		this.delimeters = delimeters;
		this.inputNumber = inputNumber;
	}
	
	public Adder() {
		
	}
	
	private IntStream getNumberStream() {
		return Stream.of(inputNumber.split(delimeters))
				.mapToInt(Integer :: parseInt);
	}
	
	private long sumOfNumbers() {
		negativeNumbers();
		return getNumberStream()
				.filter(n -> n <= 1000)
				.sum();
	}
	
	private void negativeNumbers() {
		String negativeNumbers = getNumberStream().filter(n -> n < 0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if(!negativeNumbers.isEmpty()) {
			//System.out.println(negativeNumbers);
			throw new IllegalArgumentException(negativeNumbers);
		}
	}
	

	@Override
	public long addNumbers(String input) throws NumberFormatException,InputMismatchException{
		//if empty
		if(input.isEmpty()) {
			return 0;
		}
		
		StringBuilder del = new StringBuilder("[,\n]");
		StringBuilder modifiedInput = new StringBuilder(input);
		if(input.startsWith("//")) {
			String stripNewLine[] = input.split("\n",2);
			del = new StringBuilder(stripNewLine[0].substring(2));
			modifiedInput = new StringBuilder(stripNewLine[1]);
		}
		
		
		return new Adder(del.toString(),modifiedInput.toString()).sumOfNumbers();
		
	}
	

}
