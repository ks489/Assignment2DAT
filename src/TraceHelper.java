import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TraceHelper {
	public List<String> removeDiGraphDataDuplicates(List<String> data){
		List<String> newDataList = new ArrayList<String>();
		for (String item : data) {
			if(!newDataList.contains(item)){
				newDataList.add(item);
			}
		}		
		return newDataList;
	}
	
	public List<String> GetCsvClassExecutionAverage(List<String> data){
		return null;
	}
	
	public List<String> getCsvMethodExecutionAverage(List<String> data){	
		List<String> methodNameList = new ArrayList<String>();
		List<Double> methodTotalExeList = new ArrayList<Double>();
		List<Integer> methodAmountList = new ArrayList<Integer>();
		
		List<String> returnList = new ArrayList<String>();
		
		List<String> newList = new ArrayList<String>();
		for (String row : data) {
			String[] items = row.split(",");
			
			if(!methodNameList.contains(items[2])){
				methodNameList.add(items[2]);
				methodTotalExeList.add(Double.parseDouble(items[0]));
				methodAmountList.add(1);
				
			}else{
				int position = methodNameList.indexOf(items[2]);
				methodTotalExeList.set(position, methodTotalExeList.get(position) + Double.parseDouble(items[0]));
				methodAmountList.set(position, methodAmountList.get(position) + 1);
				/*for (int i = 0; i < methodNameList.size(); i++) {
					if(methodNameList.get(i) == items[2]){
						methodTotalExeList.set(i, methodTotalExeList.get(i) + Double.parseDouble(items[0]));
					}
				}*/
			}
			
			
			//String newLineString = items[0] + "," +  items[2];
			//newList.add(newLineString);								
		}
		for (int i = 0; i < methodNameList.size(); i++) {
			double totalAmount = methodTotalExeList.get(i);
			int times = methodAmountList.get(i);
			returnList.add(totalAmount / times + "," +  methodNameList.get(i));
		}
		return returnList;
		/*for (String row : newList) {
			String[] items = row.split(",");
			if(!uniqueMethods.contains(items[1])){
				uniqueMethods.add(items[1]);
			}
			
			String newLineString = items[0] + "," +  items[1];
			newList.add(newLineString);								
		}*/
		
		
		
		
	
	}
	
	public List<String> getFileRecords(String inputFileName, String fileDirectory){
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
