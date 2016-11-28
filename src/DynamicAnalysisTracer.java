import java.util.List;

public class DynamicAnalysisTracer {
	
	public static void main(String args[]){
		TraceMergeHelper merger = new TraceMergeHelper();
		merger.mergeTraceFiles();
		
		String[] methodHeaders = new String[] {
			"ExecutionTime",
			"Class",
			"Method"
		};
		String[] classHeaders = new String[] {
			"ExecutionTime",
			"Class",
		};
		
		String executionInputFileName = "totalTmteTrace";
		String executionOutputFileName = "methodExecution";
		String fileDirectory = "./traces/";
		
		TraceHelper tHelper = new TraceHelper();
		List<String> executionData = tHelper.getFileRecords(executionInputFileName, fileDirectory);
		
		//Sort out list for graph outputs
		List<String> methodExecutionTimes = tHelper.getCsvMethodExecutionAverage(executionData);
		//List<String> classExecutionTimes = tHelper.GetCsvClassExecutionAverage(executionData);
		
		//Convert lists into their respective output types
		
		TraceConverterHelper converter = new TraceConverterHelper();
		converter.convertLogToCSV(methodHeaders, executionInputFileName, executionOutputFileName, fileDirectory);
		
		String callInputFileName = "totalTmdcTrace";
		String callOutputFileName = "methodCalls";
		//converter.convertLogToCSV(methodHeaders, methodExecutionTimes, "methodExecutionTimes", fileDirectory);
		//converter.convertLogToCSV(classHeaders, classExecutionTimes, "classExecutionTimes", fileDirectory);
		converter.convertLogToDigraph(callInputFileName, callOutputFileName, fileDirectory);
		//TODO convert files
		//
		//String exeOutFile = "totalTmteTrace.log";
		//String callOutFile = "totalTmdcTrace.log";
		//String tracerFileDirectory = "./traces/";
	}
}
