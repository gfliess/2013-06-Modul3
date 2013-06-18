package at.edu.hti.calculator.parser;

import static org.mockito.Mockito.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import at.edu.hti.calculator.Calculator;
import at.edu.hti.calculator.Calculator.Operation;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNullParser() {
		new Parser(null);
	}

	@Test(expected = FileNotFoundException.class)
	public void testParserInvalidFile() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("invalid"));
	}

	@Test
	public void testParserTest01Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("test/resources/test01.xml"));
		
		// hier sollte der Parser folgende Methoden aufgerufen haben:
		verify(cal).push(1.0);
		verify(cal).push(2.0);
		verify(cal).perform(Operation.add);

		//Sonst sollten keine Methoden aufgerufen worden sein
		verifyNoMoreInteractions(cal);
	}

}
