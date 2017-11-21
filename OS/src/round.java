import java.util.*;
public class round {
	public static float roundrobin(int Arr_time[],int Burst_time[],int n,int Time_quantum){
		int s1,s2,k,i,j,t;
		float avg=0;
		System.out.printf("Time=%d",Time_quantum);
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner abhi = new Scanner(System.in);
		System.out.println("Number of processes ?");
		int Burst_time_temp[] = new int[n];
		int Completion_time[] = new int[n];
		int Waiting_time[] = new int[n];
		int Visited[] = new int[n];
		System.out.printf("Enter arrival time and burst times of %d processes\n",n);
		
		for (i=0;i<n;i++){
			Burst_time_temp[i] = Burst_time[i];
		}
		for(i=0;i<n;i++){
			Visited[i] = 0;
		}
		int p=0,M=Arr_time[0];
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
		}
		Completion_time[0]=Arr_time[0]+ java.lang.Math.min(Time_quantum,Burst_time[0]);
		Burst_time[0]=Burst_time[0]-java.lang.Math.min(Time_quantum,Burst_time[0]);
		Visited[0]=1;
		
		if(Burst_time[0]>0)
			
		{
			add(queue,Arr_time,Completion_time[0],n,Visited,Burst_time);
			queue.add(0);

		}
		else
			add(queue,Arr_time,Completion_time[0],n,Visited,Burst_time);
		
		
		
		int pa=Completion_time[0];
		while(2>1){
			
			int flag=0;
			
			
				while(queue.isEmpty()!=true)
				{
					k=queue.remove();
					Completion_time[k]=pa+java.lang.Math.min(Time_quantum,Burst_time[k]);
					Burst_time[k]=Burst_time[k]-java.lang.Math.min(Time_quantum,Burst_time[k]);
					add(queue,Arr_time,Completion_time[k],n,Visited,Burst_time);
					pa=Completion_time[k];
					Visited[k]=1;
					
					if(Burst_time[k]>0)
					{	
						queue.add(k);
					}
				}
				for(i=0;i<n;i++){
					if(Burst_time[i]>0){
						flag=1;
						break;
					}
				}
				if (flag==0)
					break;
				if (queue.isEmpty()==true)
				{pa=pa+1;
					add(queue,Arr_time,pa,n,Visited,Burst_time);
			}}
		abhi.close();
		for(j=0;j<n;j++)
		{
			Waiting_time[j] = Completion_time[j] - (Arr_time[j] + Burst_time_temp[j]);
			
		}
		System.out.println("Completion time");
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
			Burst_time_temp[p]=Burst_time_temp[0];
			Burst_time_temp[0]=t;
		}
		for(i=0;i<n;i++){
		System.out.println(Completion_time[i]);
			}	
		System.out.println("Waiting time");
		for(i=0;i<n;i++){
			System.out.println(Waiting_time[i]);
		}
		
		for(int a : Waiting_time){
			avg=avg+a;
		}
		System.out.println("Waiting time is"+avg/n);
		for (i=0;i<n;i++){
			Burst_time[i] = Burst_time_temp[i];
		}
		return avg/n;
	}
	public static void add(Queue<Integer>queue,int Arr[],int m,int n,int Visited[],int Burst_time[])
	{
		for(int i=0;i<n;i++){
			if(Visited[i]!=1&&Burst_time[i]>0){
				if(Arr[i]<=m){
					System.out.println("adding");
					System.out.println(i);
					queue.add(i);
					Visited[i]=1;
				}
			}
		}
	}
}