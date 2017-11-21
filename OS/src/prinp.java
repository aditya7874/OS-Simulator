

import java.util.*;
public class prinp {
	public static float prioritynp(int Arr_time[],int Burst_time[],int Priority[],int n){
		int i;
		int Priority_number[] = new int[n];
		int time[]=new int[n];
		int Completion_time[] = new int[n];
		int Waiting_time[] = new int[n];
		int t,p=0,M=Arr_time[0];
		for( i=1;i<n;i++){
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
		tem=Priority_number[p];
		Priority_number[p]=Priority_number[0];
		Priority_number[0]=tem;
		
		}
		int k;
		Completion_time[0]=Arr_time[0]+Burst_time[0];
		k=Completion_time[0];
		time[0]=1;
		int cnt=0,j=0,fla=0;
		int id=0;
		int c=0;
		while(0<1){
			for ( i=0;i<n;i++){
				if (time[i]!=1){
					fla=1;
					break;
				}
			}
			if (fla==0)
			{
				break;
			}
			id=HighPriority(Arr_time,Priority_number,time,k,n);
			if(id==-1)
			{
				k=k+1;
			}
			else
			{
				Completion_time[id]=k+Burst_time[id];
				time[id]=1;
					k=Completion_time[id];
			fla=0;
		}
		}
		for (i=0;i<n;i++)
		{
			Waiting_time[i]=Completion_time[i] - (Arr_time[i] + Burst_time[i]);

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
			t=Priority_number[p];
			Priority_number[p]=Priority_number[0];
			Priority_number[0]=t;
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
		System.out.println("////");
		System.out.println(T/n);
		for (i=0;i<n;i++){
			System.out.printf("%d %d %d %d\n",Arr_time[i],Burst_time[i],Completion_time[i],Priority[i]);
		}
		return T/n;
	}
		public static int HighPriority(int Arr_time[],int Priority_number[],int time[],int k,int n){
			int p=0,j=0,flag=1;
			for(int i=0;i<n;i++){
				if (k>=Arr_time[i] && time[i]!=1){
					if(p<=Priority_number[i]) {
						p=Priority_number[i];
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
