// Final

// tat : Turn around time.
// wt  : waiting time.
// ct  : Completion time. 

import java.util.Scanner;
import java.util.Random;
public class fcfs {
	public float Fcfs(int Arr_time[],int Burst_time[],int n){
		int s1,s2,temp;
		System.out.println("Number of processes ?");
		int Completion_time[] = new int[n];
		int Waiting_time[] = new int[n];
		System.out.printf("Enter arrival time and burst times of %d processes\n",n);
		temp = 0;
		int i,j;
		for(i=0;i<n-1;i++){
			for(j=0;j<n-1-i;j++){
				if(Arr_time[j]>Arr_time[j+1]){
					temp = Arr_time[j];
					Arr_time[j] = Arr_time[j+1];
					Arr_time[j+1] = temp;
					temp = Burst_time[j];
					Burst_time[j] = Burst_time[j+1];
					Burst_time[j+1] = temp;			
				}
			}
		}
		for (i=0;i<n;i++){
			if(i==0){
				temp = Arr_time[i];
			}
			if(temp<Arr_time[i]){
				Completion_time[i] = Burst_time[i] + Arr_time[i];
				temp = Completion_time[i];
			}
			else{
				temp = temp + Burst_time[i];
				Completion_time[i] = temp;
			}
			Waiting_time[i] = Completion_time[i] - (Arr_time[i] + Burst_time[i]);
		}
		for (int x : Completion_time){
			System.out.println(x);
		}
		int total;
		total = 0;
		for (int x : Waiting_time){
			System.out.println(x);
			total = total + x;
		}
		float Average_time_fcfs = (float)total / (float)(n);
		System.out.printf("%f",Average_time_fcfs);
		return Average_time_fcfs;
	}
}