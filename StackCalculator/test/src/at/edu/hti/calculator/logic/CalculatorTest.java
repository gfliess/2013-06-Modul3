package at.edu.hti.calculator.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.edu.hti.calculator.Calculator;
import at.edu.hti.calculator.CalculatorException;
import at.edu.hti.calculator.Calculator.Operation;

public class CalculatorTest {

	@Test
	public void simpleAddTest() throws Exception {

		// setup
		Calculator calc = new CalculatorImpl();

		// methoden aufrufe
		calc.push(2);
		calc.push(3);

		// validierung
		assertEquals("values does not match",5,calc.perform(Operation.add), 0.001);
	}

	@Test(expected = CalculatorException.class)
	public void popOnEmptyStack() throws Exception {
		Calculator calc = new CalculatorImpl();
		calc.pop();
	}

	@Test()
	public void performOnEmptyStack() throws Exception {
		Calculator calc = new CalculatorImpl();
		try {
			calc.perform(Operation.add);
			fail("Calculator exception expected");

		} catch (CalculatorException e) {
			// TODO test cause of excetion;
			 assertEquals(e.getMessage(), "Stack is empty");
		}
	}
}
