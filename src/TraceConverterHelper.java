import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TraceConverterHelper {
	
	public void convertLogToCSV(String[] headers, List<String> inputData,  String outputFileName, String fileDirectory){
		try {

			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDirectory + outputFileName + ".csv"));
			for (String header : headers) {
				//records.add(header + ",");
				fileWriter.append(header + ",");
			}
			fileWriter.newLine();
			for (String item : inputData) {				
				fileWriter.append(item);				
				fileWriter.newLine();
			}
			
			fileWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/*public void convertLogToDigraph(List<String> inputData, String outputFileName, String fileDirectory){
		List<String> nonDuplicateRecords = new ArrayList<String>();
		try {
			//Get the file records
			//Get the CVS data from input file
			TraceHelper tHelper = new TraceHelper();
			nonDuplicateRecords = tHelper.removeDiGraphDataDuplicates(inputData);
			
			//Write the new CSV file to the output file location 
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDirectory + outputFileName + ".dot"));
			
			fileWriter.append("digraph cfg{");
			fileWriter.newLine();
			for (String item : nonDuplicateRecords) {				
				
				int firstIndex = item.indexOf('-');
				int secondIndex = item.indexOf('>');
				String firstOperand = item.substring(0, firstIndex);
				String secondOperand = item.substring(secondIndex + 1, item.length());
				fileWriter.append("\"");
				fileWriter.append(firstOperand);
				fileWriter.append("\"");
				fileWriter.append("->");
				fileWriter.append("\"");
				fileWriter.append(secondOperand);				
				fileWriter.append("\"");
				fileWriter.newLine();
			}
			fileWriter.append("}");
			fileWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	*/
	
	/*public void convertLogToCSV(String[] headers, String inputFileName, String outputFileName, String fileDirectory){
		List<String> records = new ArrayList<String>();
		try {
			//Adding headers to the CSV file
			
			//Get the file records
			records = getFileRecords(inputFileName, fileDirectory);
				
			//Write the new CSV file to the output file location 
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDirectory + outputFileName + ".csv"));
			for (String header : headers) {
				//records.add(header + ",");
				fileWriter.append(header + ",");
			}
			fileWriter.newLine();
			for (String item : records) {				
				fileWriter.append(item);				
				fileWriter.newLine();
			}
			
			fileWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}*/
	
	public void convertLogToDigraph(String inputFileName, String outputFileName, String fileDirectory){
		List<String> records = new ArrayList<String>();
		List<String> nonDuplicateRecords = new ArrayList<String>();
		try {
			//Get the file records
			records = getFileRecords(inputFileName, fileDirectory);
			//Get the CVS data from input file
			TraceHelper tHelper = new TraceHelper();
			nonDuplicateRecords = tHelper.removeDiGraphDataDuplicates(records);
			
			//Write the new CSV file to the output file location 
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDirectory + outputFileName + ".dot"));
			
			fileWriter.append("digraph cfg{");
			fileWriter.newLine();
			for (String item : nonDuplicateRecords) {
				
				
				int firstIndex = item.indexOf('-');
				int secondIndex = item.indexOf('>');
				String firstOperand = item.substring(0, firstIndex);
				String secondOperand = item.substring(secondIndex + 1, item.length());
				fileWriter.append("\"");
				fileWriter.append(firstOperand);
				fileWriter.append("\"");
				fileWriter.append("->");
				fileWriter.append("\"");
				fileWriter.append(secondOperand);				
				fileWriter.append("\"");
				fileWriter.newLine();
			}
			fileWriter.append("}");
			fileWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	

	private List<String> getFileRecords(String inputFileName, String fileDirectory){
		List<String> records = new ArrayList<String>();
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(fileDirectory + inputFileName + ".log"));
			String line;
			while((line = reader.readLine()) != null){
				records.add(line);
			}			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return records;
	}
	
	
}
