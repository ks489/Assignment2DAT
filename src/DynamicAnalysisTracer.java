import java.util.List;

public class DynamicAnalysisTracer {
	
	public static void main(String args[]){
		TraceMergeHelper merger = new TraceMergeHelper();
		merger.mergeTraceFiles();
		
		String[] methodHeaders = new String[] {
			"ExecutionTime",
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
		List<String> csvData = tHelper.getFileRecords(executionInputFileName, fileDirectory);
		
		//Sort out list for graph outputs
		List<String> methodExecutionTimes = tHelper.getCsvMethodExecutionAverage(csvData);
		List<String> classExecutionTimes = tHelper.GetCsvClassExecutionAverage(csvData);

		List<String> methodCount = tHelper.getCsvMethodExecutionCount(csvData);
		List<String> classCount = tHelper.GetCsvClassExecutionCount(csvData);
		
		TraceConverterHelper converter = new TraceConverterHelper();
		converter.convertLogToCSV(methodHeaders, methodExecutionTimes, "methodTimes", fileDirectory);
		converter.convertLogToCSV(classHeaders, classExecutionTimes, "classTimes", fileDirectory);
		
		converter.convertLogToCSV(methodHeaders, methodCount, "methodCount", fileDirectory);
		converter.convertLogToCSV(classHeaders, classCount, "classCount", fileDirectory);
		
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
