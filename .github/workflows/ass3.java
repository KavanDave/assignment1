import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Process 
{ 
    int pid; // Process ID 
    int bt; // Burst Time 
    int at; // Arrival Time 
      
    public Process(int   pid, int  at, int  bt) 
    { 
        this.pid = pid; 
        this.bt = bt; 
        this.at = at; 
    } 
} 
public class Assignment3 {
	
		static void findWaitingTime(Process proc[], int n,int wt[])  
		{  
			int service_time[] = new int[n];  
			service_time[0] = 0;  
			wt[0] = 0;
			for (int i = 1; i < n ; i++)  
			{
				service_time[i] = service_time[i-1] + proc[i-1].bt;
				wt[i] = service_time[i] - proc[i].at; 
				if (wt[i] < 0)  
					wt[i] = 0;  
			}  
		}  
		static void findTurnAroundTime(Process proc[], int n,int wt[], int tat[])  
		{  
		
			for (int i = 0; i < n ; i++)  
				tat[i] = proc[i].bt + wt[i];  
		}
		static void findavgTime(Process proc[], int n) throws Exception
		{  
			int wt[] = new int[n], tat[] = new int[n];
			findWaitingTime(proc, n,wt);
			findTurnAroundTime(proc,n,wt,tat);
			 FileWriter fstreamWrite = new FileWriter("D:\\output.txt",true);
			    BufferedWriter out = new BufferedWriter(fstreamWrite);    	
			out.append("Processes " + " Burst Time " + " Arrival Time " + " Waiting Time " + " Turn-Around Time " + " Completion Time \n");  
			out.newLine();
			int total_wt = 0, total_tat = 0;  
			for (int i = 0 ; i < n ; i++)  
			{  
				total_wt = total_wt + wt[i];  
				total_tat = total_tat + tat[i];  
				int compl_time = tat[i] + proc[i].at; 
				out.newLine();
				out.write(i+1 + "\t\t" + proc[i].bt + "\t\t" + proc[i].at + "\t\t" + wt[i] + "\t\t " + tat[i] + "\t\t " + compl_time);  
			}   
			out.newLine();
			out.append("Average waiting time = " + (float)total_wt / (float)n);  
			out.newLine();
			out.append("\nAverage turn around time = " + (float)total_tat / (float)n+"\n");  
			out.close();
			
			}  
			public static void main(String args[]) throws Exception 
			{
				java.io.File file=new java.io.File("D:\\inpset4.txt");
				Scanner input=new Scanner(file);
				while(input.hasNext())
				{

				int at1  	= input.nextInt();
				int bt1	= input.nextInt();  	
				int at2 	= input.nextInt();
				int bt2	= input.nextInt();  	
				int at3 	= input.nextInt();
				int bt3	= input.nextInt();  	
				int at4 	= input.nextInt();
				int bt4	= input.nextInt();  	
				int at5 	= input.nextInt();
				int bt5	= input.nextInt(); 	

				         Process proc[] = { new Process(1,at1,bt1),  
				                                         new Process(2,at2,bt2), 
				                                         new Process(3,at3,bt3),
				                                         new Process(4,at4,bt4),
				                                       new Process(5,at5,bt5),
				};  
				        
				         findavgTime(proc, proc.length); 

				}
				input.close();
			}  
		}
