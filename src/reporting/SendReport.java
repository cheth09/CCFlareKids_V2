package reporting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SendReport {

	public static void SendReportThroughMail() {
		// TODO Auto-generated method stub
		
		try{
			
			ProcessBuilder pb = new ProcessBuilder("MailReport.sh");
//			Process p = pb.start();
			Process p = Runtime.getRuntime().exec("sh MailReport.sh");
			BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while((line = buf.readLine())!= null){
				System.out.println(line);
			}
			
			
		}catch(Exception e){
			
		}

	}

}
