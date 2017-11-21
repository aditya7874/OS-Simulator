import java.util.*;
public class sjf_non_preemitive {
	
	public float sjfnp(int Arr_time[],int Burst_time[],int n){
		int s1,s2,temp;
		int Completion_time[] = new int[n];
		int Waiting_time[] = new int[n];
		int time[] = new int[n];
		System.out.printf("Enter arrival time and burst times of %d processes\n",n);
		temp = 0;
		int t,p=0,M=Arr_time[0];
		for(int i=1;i<n;i++){
			if (Arr_time[i]<M){
				M=Arr_time[i];
				p=i;
			}
		}
		if(p!=0)
		{
		int tem;
		tem=Arr_time[p];
		Arr_time[p]=Arr_time[0];
		Arr_time[0]=tem;
		tem=Burst_time[p];
		Burst_time[p]=Burst_time[0];
		Burst_time[0]=tem;
		time[0]=1;
		}
		int k=Burst_time[0]+Arr_time[0];
		Completion_time[0]=k;
		time[0]=1;
		Waiting_time[0]=Completion_time[0] - (Arr_time[0] + Burst_time[0]);
		
		int cnt=0,j=0,flag=0;
		float z;
		while(0<1)
		{
			int min=10000;
		
			if (cnt==n-1){
				break;
			}
			for (int i=1;i<n;i++){

					if (Arr_time[i]<=k && time[i]!=1)
					{
						if(Burst_time[i]<min){
						min=Burst_time[i];
						 j=i;
						  
						 
						 flag=1;
						}
					}	
			}
			time[j]=1;
			
			if (flag==0){
				int m=10000,s=0;
				for(int i=1;i<n;i++){
					if (m>Arr_time[i] && time[i]!=1){
						m=Arr_time[i];
						s=i;
					}
				}
				Completion_time[s]=Arr_time[s]+Burst_time[s];
				Waiting_time[s]=Completion_time[s] - (Arr_time[s] + Burst_time[s]);
				k=Completion_time[s];
				cnt++;
				time[s]=1;
			}
			if(time[j]==1 &&flag==1)
			{
			Completion_time[j]=k+min;
			k=Completion_time[j];
			cnt++;
			Waiting_time[j] = Completion_time[j] - (Arr_time[j] + Burst_time[j]);
			}	
			flag=0;
				}
		if (p!=0){
			t=Completion_time[p];
			Completion_time[p]=Completion_time[0];
			Completion_time[0]=t;
			t=Waiting_time[p];
			Waiting_time[p]=Waiting_time[0];
			Waiting_time[0]=t;
			t=Arr_time[p];
			Arr_time[p]=Arr_time[0];
			Arr_time[0]=t;
			t=Burst_time[p];
			Burst_time[p]=Burst_time[0];
			Burst_time[0]=t;
		}
		System.out.println("Arrival time");
		for(int a : Arr_time){
			System.out.println(a);
				}
		System.out.println("Burst time");
		for(int a : Burst_time){
			System.out.println(a);
				}
			
			System.out.println("Completion time");
		for(int a : Completion_time){
		System.out.println(a);
			}
		float T=0;
		System.out.println("Waiting time");
		for(int a : Waiting_time){
			System.out.println(a);
		}
		for(int a : Waiting_time){
			T=T+a;
		}
		z = T/n;
		return z;
	}		
}