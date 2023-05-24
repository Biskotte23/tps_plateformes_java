package fr.univtours.polytech.ex5;

public class ArithmeticBean {
	private double operand1;
	private double operand2;
	private double result;

	public void setOperand1(double operand1) {
		this.operand1 = operand1;
	}

	public void setOperand2(double operand2) {
		this.operand2 = operand2;
	}

	public void performAddition() {
		result = operand1 + operand2;
	}

	public void performSubtraction() {
		result = operand1 - operand2;
	}

	public void performMultiplication() {
		result = operand1 * operand2;
	}

	public void performDivision() {
		// On verifie que on divise pas par 0 sinon on met le resultat a 0
		if (operand2 != 0) {
			result = (double) operand1 / operand2;
		} else {
			result = 0;
		}
	}

	public double getResult() {
		return result;
	}
}
