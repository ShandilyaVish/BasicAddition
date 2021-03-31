package Calculator;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Adder implements Addable {

	@Override
	public long addNumbers(String input) throws NumberFormatException,InputMismatchException{
		//if empty
		if(input.length() == 0) {
			return 0;
		}
		
		StringBuilder del = new StringBuilder("[,\n]");
		StringBuilder modifiedInput = new StringBuilder(input);
		if(input.startsWith("//")) {
			String stripNewLine[] = input.split("\n",2);
			del = new StringBuilder(stripNewLine[0].substring(2));
			modifiedInput = new StringBuilder(stripNewLine[1]);
		}
		
		return Arrays.stream(modifiedInput.toString().split(del.toString())).
			mapToLong(Long :: parseLong).sum();
		
	}

}
