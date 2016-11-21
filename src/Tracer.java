import java.io.*;

public class Tracer {
	
	public void BuildTracers(){
		String path = "../";
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "echo \"Hello\", ", "f:", "cd Projects/University/uol-inf co7506/Git/Assignment2/Tracer/TraceMethodTimeExecution", 
				"ajc -cp ..\\Libraries\\aspectjrt.jar -outxml -outjar tmteTracer.jar TraceMethodTimeExecution.java");
		
		builder.redirectErrorStream(true);
		
		try {
			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while(true){
				line = r.readLine();
				if(line == null){
				
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Process process = Runtime.getRuntime().exec(command)
	}
}

