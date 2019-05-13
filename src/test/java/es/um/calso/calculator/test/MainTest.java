package es.um.calso.calculator.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Vector;

import org.jtestcase.JTestCase;
import org.jtestcase.JTestCaseException;
import org.jtestcase.TestCaseInstance;
import org.junit.Before;
import org.junit.Test;

import es.um.calso.calculator.main.Calculator;

public class MainTest {

	/** Initialization code that has to be run before each test. */
	private JTestCase jTestCase;

	@Before
	public void initialization() throws FileNotFoundException, JTestCaseException {
		String dataFile = "src/main/resources/maintest.xml";
		jTestCase = new JTestCase(dataFile, "Calculator");

	}

	@Test
	public void MainMethodTest() {
		try {
			@SuppressWarnings("unused")
			Calculator c = new Calculator();

			Vector<?> testCases = jTestCase.getTestCasesInstancesInMethod("main");

			for (int i = 0; i < testCases.size(); i++) {
				TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);

				// get hashed params for this test case
				HashMap<?, ?> params = testCase.getTestCaseParams();
				String input = (String) params.get("input");
				ByteArrayOutputStream bytes = new ByteArrayOutputStream();
				PrintStream console = System.out;
				try {
					System.setOut(new PrintStream(bytes));
					System.setIn(new ByteArrayInputStream(input.getBytes()));
					Calculator.main(null);
				} finally {
					System.setOut(console);
				}
				String out = bytes.toString();
				boolean succeed = testCase.assertTestVariable("result", out.replaceAll("\\s",""));
				assertTrue(testCase.getFailureReason(), succeed);
			}
		} catch (JTestCaseException e) {
			e.printStackTrace();
		}
	}

}
