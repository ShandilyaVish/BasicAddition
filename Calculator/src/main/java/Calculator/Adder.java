package Calculator;

public class Adder implements Addable {

	@Override
	public long addNumbers(String input) {
		//if empty
		if(input.length() == 0) {
			return 0;
		}
		
		String digits[] = input.split(",");
		long sumOfNumbers = 0;
		for(int i = 0;i < digits.length;i++) {
			long number = Long.valueOf(digits[i]);
			sumOfNumbers += number;
		}
		return sumOfNumbers;
	}

}
