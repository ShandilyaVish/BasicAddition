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
		
		return Arrays.stream(input.split("[,\n]")).
			mapToLong(Long :: parseLong).sum();
		
	}

}
