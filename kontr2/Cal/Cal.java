package Cal;

public class Cal {
	public double operand1;
	public double operand2;
	public char operator;

	public Cal(double operand1, double operand2, char operator) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;

	}

	public double sum() {

		return (operand1 + operand2);
	}

	public double mult() {

		return (operand1 * operand2);
	}

	public double minus() {

		return (operand1 - operand2);
	}

	public double div() {

		return (operand1 / operand2);
	}

	public double calculate(char operator) {

		if (operator == '+')
			return sum();

		if (operator == '-')
			return minus();

		if (operator == '*')
			return mult();

		if (operator == '/')
			return div();
		return operator;

	}

	public void Answer() {

		System.out.println(calculate(operator));
	}
}