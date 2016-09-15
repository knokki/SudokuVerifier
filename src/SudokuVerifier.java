import java.util.HashMap;
import java.util.Map;

public class SudokuVerifier {
	
	private Map<Integer, Integer> sudokuMapping;
	int rowMultiplayer = 42;
	
	public SudokuVerifier(){
		this.sudokuMapping = new HashMap<Integer, Integer>();
	}
	
	public int verify(String candidateSolution) {
		
		if (!this.TestStringLenght(candidateSolution)){
			return -1;
		}
		int spliceResult =this.SpliceStringToMap(candidateSolution); 
		if (spliceResult != 0){
			return spliceResult;
		}
		int LineTestResult = this.TestLines();
		
		// returns 0 if the candidate solution is correct
		return 0;
	}
	private int TestLines() {
		for (int i=0; i<9; i++){
			
		}
		return 0;
	}

	private int SpliceStringToMap(String str){
		int index = 0;
		for (int row=0; row<9; row++){
			for (int column=0; column<9; column++){
				char value = str.charAt(index);
				int cellValue = this.GetNumberFromString(value);
				if (cellValue <= 0 && cellValue > 9){
					return -1;
				}
				else {
					this.sudokuMapping.put((row*this.rowMultiplayer+column), cellValue);
				}
				index++;
			}
		}
		
		return 0;
	}
	private boolean TestStringLenght(String str){
		if (str.length() != 81){
			return false;
		}
		return true;
	}
	private int GetNumberFromString(char str){
		String singleChar = String.valueOf(str);
		try {
			int returnValue = Integer.parseInt(singleChar);
			return returnValue;
		} catch (NumberFormatException e){
			return -1;
		}
	}
}
