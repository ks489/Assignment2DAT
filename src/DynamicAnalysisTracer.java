
public class DynamicAnalysisTracer {
	
	public static void main(String args[]){
		TraceMergeHelper merger = new TraceMergeHelper();
		merger.mergeTraceFiles();
		
		String[] headers = new String[] {
			"ExecutionTime",
			"Class",
			"Method"
		};
		
		String executionInputFileName = "totalTmteTrace";
		String executionOutputFileName = "methodExecution";
		String fileDirectory = "./traces/";
		
		TraceConverterHelper converter = new TraceConverterHelper();
		converter.convertLogToCSV(headers, executionInputFileName, executionOutputFileName, fileDirectory);
		
		String callInputFileName = "totalTmdcTrace";
		String callOutputFileName = "methodCalls";
		converter.convertLogToDigraph(callInputFileName, callOutputFileName, fileDirectory);
		//TODO convert files
		//
		//String exeOutFile = "totalTmteTrace.log";
		//String callOutFile = "totalTmdcTrace.log";
		//String tracerFileDirectory = "./traces/";
	}
}
