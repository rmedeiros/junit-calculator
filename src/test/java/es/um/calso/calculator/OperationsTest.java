package es.um.calso.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Vector;

import org.jtestcase.JTestCase;
import org.jtestcase.JTestCaseException;
import org.jtestcase.TestCaseInstance;
import org.jtestcase.util.MultiKeyHashtable;
import org.junit.Before;
import org.junit.Test;

import es.um.calso.calculator.exeception.NonDivisionByZeroExeption;
import es.um.calso.calculator.main.Operations;

public class OperationsTest {

	/** Initialization code that has to be run before each test. */
	private Operations op;
	private JTestCase jTestCase;

	@Before
	public void initialization() throws FileNotFoundException, JTestCaseException {
		op = new Operations();
		String dataFile = "src/main/resources/operationstest.xml";
		jTestCase = new JTestCase(dataFile, "Operations");

	}

	/* Test the division method exception */
	/*
	 * In JUnit exception testing can be done as following --> @Test(expected =
	 * NonDivisionByZeroExeption.class)
	 */
	@Test
	public void divisionByZeroTest() {
		String strExpectedMessage = null;

		try {
			Vector<?> testCases = jTestCase.getTestCasesInstancesInMethod("division");

			for (int i = 0; i < testCases.size(); i++) {
				// retrieve name of test case
				TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);

				// get hashed params for this test case
				HashMap<?, ?> params = testCase.getTestCaseParams();
				int a = (Integer) params.get("numerator");
				int b = (Integer) params.get("denominator");

				MultiKeyHashtable asserts = testCase.getTestCaseAssertParams();
				String[] strKeys = { "message", "EQUALS" };
				strExpectedMessage = ((String) asserts.get(strKeys));
				int result = op.division(a, b);
				boolean succeed = testCase.assertTestVariable("result", result);
				assertTrue(testCase.getFailureReason(), succeed);
			}
		} catch (JTestCaseException e) {
			fail("JTestCase framework fail");
		} catch (NonDivisionByZeroExeption e) {
			if (strExpectedMessage != null) {
				assertEquals(null, strExpectedMessage, e.getMessage());
			} else {
				fail("A non-expected exception was thrown");
			}
		}

	}

	/** Test the division method exception */
	@Test
	public void additionTest() {

		try {
			Vector<?> testCases = jTestCase.getTestCasesInstancesInMethod("addition");

			for (int i = 0; i < testCases.size(); i++) {
				// retrieve name of test case
				TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);

				// get hashed params for this test case
				HashMap<?, ?> params = testCase.getTestCaseParams();
				int a = (Integer) params.get("param1");
				int b = (Integer) params.get("param2");
				int result = op.addition(a, b);
				boolean succeed = testCase.assertTestVariable("result", result);
				assertTrue(testCase.getFailureReason(), succeed);
			}
		} catch (JTestCaseException e) {
			fail("JTestCase framework fail");
		}
		
	}

	/** Test the division method exception */
	@Test
	public void substractionTest() {
		try {
			Vector<?> testCases = jTestCase.getTestCasesInstancesInMethod("substraction");

			for (int i = 0; i < testCases.size(); i++) {
				// retrieve name of test case
				TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);

				// get hashed params for this test case
				HashMap<?, ?> params = testCase.getTestCaseParams();
				int a = (Integer) params.get("param1");
				int b = (Integer) params.get("param2");
				int result = op.substraction(a, b);
				boolean succeed = testCase.assertTestVariable("result", result);
				assertTrue(testCase.getFailureReason(), succeed);
			}
		} catch (JTestCaseException e) {
			fail("JTestCase framework fail");
		}

	}

	/** Test the division method exception */
	@Test
	public void multiplicationTest() throws NonDivisionByZeroExeption {
		try {
			Vector<?> testCases = jTestCase.getTestCasesInstancesInMethod("multiplication");

			for (int i = 0; i < testCases.size(); i++) {
				// retrieve name of test case
				TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);

				// get hashed params for this test case
				HashMap<?, ?> params = testCase.getTestCaseParams();
				int a = (Integer) params.get("param1");
				int b = (Integer) params.get("param2");
				int result = op.multiplication(a, b);
				boolean succeed = testCase.assertTestVariable("result", result);
				assertTrue(testCase.getFailureReason(), succeed);
			}
		} catch (JTestCaseException e) {
			fail("JTestCase framework fail");
		}

	}

	/** Test the division method exception */
	@Test
	public void biggestTest() {
		try {
			Vector<?> testCases = jTestCase.getTestCasesInstancesInMethod("biggest");

			for (int i = 0; i < testCases.size(); i++) {
				// retrieve name of test case
				TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);

				// get hashed params for this test case
				HashMap<?, ?> params = testCase.getTestCaseParams();
				int a = (Integer) params.get("param1");
				int b = (Integer) params.get("param2");
				int result = op.biggest(a, b);
				boolean succeed = testCase.assertTestVariable("result", result);
				assertTrue(testCase.getFailureReason(), succeed);
			}
		} catch (JTestCaseException e) {
			fail("JTestCase framework fail");
		}
	}

	/** Test the division method exception */
	@Test
	public void smallestTest() {
		try {
			Vector<?> testCases = jTestCase.getTestCasesInstancesInMethod("smallest");

			for (int i = 0; i < testCases.size(); i++) {
				// retrieve name of test case
				TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);

				// get hashed params for this test case
				HashMap<?, ?> params = testCase.getTestCaseParams();
				int a = (Integer) params.get("param1");
				int b = (Integer) params.get("param2");
				int result = op.smallest(a, b);
				boolean succeed = testCase.assertTestVariable("result", result);
				assertTrue(testCase.getFailureReason(), succeed);
			}
		} catch (JTestCaseException e) {
			fail("JTestCase framework fail");
		}
	}
}
