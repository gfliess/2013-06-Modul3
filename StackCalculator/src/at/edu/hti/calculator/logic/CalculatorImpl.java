package at.edu.hti.calculator.logic;

import java.util.Stack;

import at.edu.hti.calculator.Calculator;
import at.edu.hti.calculator.CalculatorException;


public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	@Override
	public double perform(Operation op) throws CalculatorException {

		double b = pop();
		double a = pop();

		switch (op) {
		case add:
			return a + b;
		case sub:
			return a - b;
		case div:

			double c = a / b;
			if (Double.isInfinite(c))
				throw new CalculatorException("Division by zero");
			return c;

		case mul:
			return a * b;

		default:
			break;
		}
		return 0;
	}

	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException("Stack is empty");
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}

	@Override
	public void clear() {
		stack_.clear();
	}

}
