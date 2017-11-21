import java.util.Random;

public class onclick {
	public static float execute(int n,String C,int Arr_time[],int Burst_time[],int Priority[]){
		int i,j,Time_quantum;
		float k=0;
		Random abhi = new Random();
		Time_quantum = 1+abhi.nextInt(10);
//		int Arr_time[] = new int[n];
//		int Burst_time[] = new int[n];
//		int Priority[] = new int[n];
		for (i=0;i<n;i++){
			Arr_time[i] = 1+abhi.nextInt(10);
		}
		for (i=0;i<n;i++){
			Burst_time[i] = 1+abhi.nextInt(10);
		}
		if(C == "FCFS"){
			fcfs FCFS = new fcfs();
			System.out.println(FCFS.Fcfs(Arr_time,Burst_time,n));
			k=FCFS.Fcfs(Arr_time,Burst_time,n);
			return k;
		}
		else if(C == "SJFP"){
			sjf_preemitive SJF = new sjf_preemitive();
			k = SJF.sjfp(Arr_time,Burst_time,n);
			return k;
		}
		else if(C == "SJFNP"){
			sjf_non_preemitive SJFNP = new sjf_non_preemitive();
			k = SJFNP.sjfnp(Arr_time,Burst_time,n);
			return k;
		}
		else if(C == "RR"){
			round RR = new round();
			k = RR.roundrobin(Arr_time,Burst_time,n,Time_quantum);
			return k;
		}
		else if(C == "PP"){
			for (i=0;i<n;i++){
				Priority[i] = 1+abhi.nextInt(10);
			}
			priority_preemitive PP = new priority_preemitive();
			k = PP.priorityp(Arr_time,Burst_time,Priority,n);
			return k;
		}
		else{
			for (i=0;i<n;i++){
				Priority[i] = 1+abhi.nextInt(10);
			}
			prinp PNP = new prinp();
			k = PNP.prioritynp(Arr_time,Burst_time,Priority,n);
			return k;
		}
	}
	
	public static String compare(float A[],String B[],int n,int Arr_time[],int Burst_time[],int Priority[]){
		int i,j,Time_quantum;
		float k;
		Random abhi = new Random();
//		n = abhi.nextInt(10);
		Time_quantum = 1+abhi.nextInt(10);
//		int Arr_time[] = new int[n];
//		int Burst_time[] = new int[n];
//		int Priority[] = new int[n];
		for (i=0;i<n;i++){
			Arr_time[i] = 1+abhi.nextInt(10);
		}
		for (i=0;i<n;i++){
			Burst_time[i] = 1+abhi.nextInt(10);
		}
		for (i=0;i<n;i++){
			Priority[i] = 1+abhi.nextInt(10);
		}
		
		fcfs FCFS = new fcfs();
		A[0] = FCFS.Fcfs(Arr_time,Burst_time,n);
		B[0] = "FCFS      :";
		
		sjf_preemitive SJF = new sjf_preemitive();
		A[1] = SJF.sjfp(Arr_time,Burst_time,n);
		B[1] = "SJF P      :";
		
		sjf_non_preemitive SJFNP = new sjf_non_preemitive();
		A[2] = SJFNP.sjfnp(Arr_time,Burst_time,n);
		B[2] = "SJF NP   :";
		System.out.println("/////////////////////////////////////////////////");
		round RR = new round();
		A[3] = RR.roundrobin(Arr_time,Burst_time,n,Time_quantum);
		B[3] = "RR          :";
		System.out.println("////////////////////");
		priority_preemitive PP = new priority_preemitive();
		A[4] = PP.priorityp(Arr_time,Burst_time,Priority,n);
		B[4] = "PRI P      :";
		
		prinp PNP = new prinp();
		A[5] = PNP.prioritynp(Arr_time,Burst_time,Priority,n);
		B[5] = "PRI NP   :";
		int z=0;
		String S="";
		float min;
		min = 10000;
		for(i=0;i<6;i++){
			if(A[i]<min){
				min = A[i];
				z = i;
			}
		}
		if(z==0){
			S = "FCFS";
		}
		else if(z==1){
			S = "SJF P";
		}
		else if(z==2){
			S = "SJF NP";
		}
		else if(z==3){
			S = "RR";
		}
		else if(z==4){
			S = "PRI P";
		}
		else if(z==5){
			S = "PRI NP";
		}
		return S;
	}
}