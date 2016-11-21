import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class TraceMergeHelper {
	
	
	String exeOutFile = "totalTmteTrace.log";
	String callOutFile = "totalTmdcTrace.log";
	String tracerFileDirectory = "./traces/";
	
	List<String> fileNames = new ArrayList<String>();
	
	public void mergeTraceFiles(){
		List<String> exeFiles = getTraceExecutionTraceFiles();
		List<String> callFiles = getTraceCallsTraceFiles();
		mergeTraceFiles(exeFiles, tracerFileDirectory,  exeOutFile);
		mergeTraceFiles(callFiles, tracerFileDirectory, callOutFile);

	}
	
	private void mergeTraceFiles(List<String> fileList, String fileDirectory, String outputFile){
		List<String> records = new ArrayList<String>();
		try {
			for (String file : fileList) {
				BufferedReader reader = new BufferedReader(new FileReader(fileDirectory + file));
				String line;
				while((line = reader.readLine()) != null){
					records.add(line);
				}
				reader.close();	

			}
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDirectory + outputFile));
			//Writer fileWriter = new FileWriter(fileDirectory + outputFile);
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
	}
	

	
	private List<String> getTraceExecutionTraceFiles(){
		List<String> list = new ArrayList<String>();
		list.add("tmteTrace1.log");
		list.add("tmteTrace2.log");
		list.add("tmteTrace3.log");
		list.add("tmteTrace4.log");
		list.add("tmteTrace5.log");
		list.add("tmteTrace6.log");
		return list;
	}
	
	private List<String> getTraceCallsTraceFiles(){
		List<String> list = new ArrayList<String>();
		list.add("tmdcTrace1.log");
		list.add("tmdcTrace2.log");
		list.add("tmdcTrace3.log");
		list.add("tmdcTrace4.log");
		list.add("tmdcTrace5.log");
		list.add("tmdcTrace6.log");
		return list;
	}
}
