import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string:    417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	
	public static final String CorString =				"417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	public static final String InCorSubGridString =		"417369825432158947958724316825437169791586432346912758289643571573291684164875293";
	public static final String IncorrecrColumnsString =	"417369825632158947958724316825437169791586432346912758289643571573291684364875291";
	public static final String AlphaString =			"417369abc632158947958724316825437169791586432346912758289643571573291684164875293";
	public static final String IncorLinesString =		"414369825632158947958724316825437169791586432346912758289643571573291684164875293";
	public static final String IncorString = 			"123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	public static final String ShortString =			"1234567899123456788912345677891234566789123455678912344567891233456";
	public static final String longString = 			"1234567899123456788912345677891234566789123455678912344567891233456789123455678912344567891233456";
									

	public static SudokuVerifier sudoku;

	@Before
	public void SetUp(){
		sudoku = new SudokuVerifier();
	}
	
	@Test
	public void TestWithCorrectInput(){
		int result = sudoku.verify(CorString);
		assertEquals("Verifier returns something other than 0 with correct string", SudokuVerifier.AllOk, result);
	}
	@Test
	public  void TestTooLongString(){
		int result = sudoku.verify(longString);
		assertEquals("Test returns something else than -1 with too long string", SudokuVerifier.FailedNumbers, result);
	}
	@Test 
	public void TestTooShortString(){
		int result = sudoku.verify(ShortString);
		assertEquals("Test returns something else than -1 with too short string", SudokuVerifier.FailedNumbers, result);
	}
	@Test
	public void TestWithIncorrectLineString(){
		int result = sudoku.verify(IncorLinesString);
		assertTrue(SudokuVerifier.FailedRow == result || SudokuVerifier.FailedSubGrid == result);
	}
	@Test
	public void TestWithStringThatHasAlpabetsIn(){
		int rsult = sudoku.verify(AlphaString);
		assertEquals("A string with aplhabets were given and something else than -1 was returned", SudokuVerifier.FailedNumbers, rsult);
	}
	@Test
	public void TestIncorrectColumns(){
		int result = sudoku.verify(IncorrecrColumnsString);
		assertTrue(result == SudokuVerifier.FailedColumn || result == SudokuVerifier.FailedSubGrid);
		
	}
	@Test
	public void TestIncorrectSubGrids(){
		int result = sudoku.verify(InCorSubGridString);
		assertEquals("A string with incorrect subgrids were given and something else than -4 was returned", SudokuVerifier.FailedSubGrid, result);
	}

}
