import java.util.*;

public class sjf_preemitive {
	
	public float sjfp(int Arr_time[],int Burst_time[],int n){
		int s1,s2,temp,i;
		int Burst_time_temp[] = new int[n];
		int Completion_time[] = new int[n];
		int Waiting_time[] = new int[n];
		int time[] = new int[n];
		temp = 0;
		for (i=0;i<n;i++){
			Burst_time_temp[i] = Burst_time[i];
		}
		int t,p=0,M=Arr_time[0];
		for(i=1;i<n;i++){
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
		int Temp[]=new int[n];
		int k=Arr_time[0]+1;
		
		for(i=0;i<n;i++)
		{
			Temp[i]=Burst_time[i];
		}
		Completion_time[0]++;
		Burst_time[0]--;
		int cnt=0,j=0,flag=0;
		int id=0;
		int c=0;
		float m;
		while(0<1){
			for (i=0;i<n;i++){
				if (Burst_time[i]!=0){
					flag=1;
					break;
				}
			}
			if (flag==0)
			{
				break;
			}
			id=MinBurst(Arr_time,Burst_time,k,n);
			if(id!=-1)
			{
			Completion_time[id]=k+1;
			
			Waiting_time[id]=Completion_time[id] - (Arr_time[id] + Temp[id]);
			Burst_time[id]--;
			}
			k++;
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
		m=T/n;
		for (i=0;i<n;i++){
			Burst_time[i] = Burst_time_temp[i];
		}
		return m;
		
	}
		public static int MinBurst(int Arr_time[],int Burst_time[],int k,int n){
			int m=10000,j=0,flag=1;
			for(int i=0;i<n;i++){
				if (k>=Arr_time[i]){
					if (m>Burst_time[i] && Burst_time[i]>0){
						m=Burst_time[i];
						j=i;
						flag=0;
					}
					}
			}
					if(flag==1){
						j=-1;
					}
			return j;
		}
}
