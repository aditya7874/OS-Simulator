import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;


public class gui_temp {

	private JFrame frame;
	private JTextField txtInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_temp window = new gui_temp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui_temp() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 744, 767);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNh = new JButton("OPTIMISED PROCESS");
		btnNh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i,j,y;
				y = 3;
				String a=txtInput.getText();	
				String m ="",S;
				float A[] = new float[6];
				String B[] = new String[6];
				int d;
				d = Integer.parseInt(a);
				int Arr_time[] = new int[d];
				int Burst_time[] = new int[d];
				int Priority[] = new int[d];
				onclick OnClick = new onclick();
				S = OnClick.compare(A,B,Integer.parseInt(a),Arr_time,Burst_time,Priority);
				m = "Arrival_time" + "       " + "Burst_time" + "         " + "Priority" + "\n";
				for(i=0;i<Integer.parseInt(a);i++){
					m = m + Arr_time[i] + "\t" + Burst_time[i] + "\t" + Priority[i] + "\n";
				}
				JTextArea txtrTable = new JTextArea();
				txtrTable.setText("");
				txtrTable.setBounds(246, 107, 271, 152);
				panel.add(txtrTable);
				txtrTable.setText(m);
				
				for(i=0;i<6;i++){
					System.out.println(A[i]);
				}
				m = "";
				for(i=0;i<6;i++){
					m = m +"           "+ B[i] +'\t'+ A[i] + '\n';
				}
				m = m +"\n"+"Min Waiting Time is for "+ S;
				JTextArea txtrOutput = new JTextArea();
				txtrOutput.setBounds(306, 529, 161, 164);
				panel.add(txtrOutput);
				txtrOutput.setText(m);
				
//				txtOutput.setText(Float.toString(A[5]));
				System.out.println(m);
			}
		});
		btnNh.setBounds(296, 448, 167, 44);
		panel.add(btnNh);
		
		txtInput = new JTextField();
		txtInput.setText("");
		txtInput.setBounds(369, 67, 116, 22);
		panel.add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnFcfs = new JButton("FCFS");
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float k;
				String n=txtInput.getText();
				String C,t;
				C = "FCFS";
				int d;
				d = Integer.parseInt(n);
				int Arr_time[] = new int[d];
				int Burst_time[] = new int[d];
				int Priority[] = new int[d];
				k = onclick.execute(Integer.parseInt(n), C,Arr_time,Burst_time,Priority);
				String m = "";
				int i;
				m = "Arrival_time" + "       " + "Burst_time" + "\n";
				for(i=0;i<Integer.parseInt(n);i++){
					m = m + Arr_time[i] + "\t" + Burst_time[i] + "\n";
				}
				JTextArea txtrTable = new JTextArea();
				txtrTable.setText("");
				txtrTable.setBounds(246, 107, 271, 152);
				panel.add(txtrTable);
				txtrTable.setText(m);
				
				JTextArea txtrOutput = new JTextArea();
				txtrOutput.setBounds(306, 529, 161, 164);
				panel.add(txtrOutput);
				txtrOutput.setText("");
				t=Float.toString(k);
				txtrOutput.setText(C+"\n"+t);
			}
		});
		btnFcfs.setBounds(182, 285, 124, 25);
		panel.add(btnFcfs);
		
		JButton btnRoundRobin = new JButton("ROUND ROBIN");
		btnRoundRobin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float k;
				String n=txtInput.getText();
				String C,t;
				C = "ROUND ROBIN";
				int d;
				d = Integer.parseInt(n);
				int Arr_time[] = new int[d];
				int Burst_time[] = new int[d];
				int Priority[] = new int[d];
				k = onclick.execute(Integer.parseInt(n), C,Arr_time,Burst_time,Priority);
				String m = "";
				int i;
				m = "Arrival_time" + "       " + "Burst_time"  + "\n";
				for(i=0;i<Integer.parseInt(n);i++){
					m = m + Arr_time[i] + "\t" + Burst_time[i] + "\n";
				}
				JTextArea txtrTable = new JTextArea();
				txtrTable.setText("");
				txtrTable.setBounds(246, 107, 271, 152);
				panel.add(txtrTable);
				txtrTable.setText(m);
				
				JTextArea txtrOutput = new JTextArea();
				txtrOutput.setBounds(306, 529, 161, 164);
				panel.add(txtrOutput);
				txtrOutput.setText("");
				t=Float.toString(k);
				txtrOutput.setText(C+"\n"+t);
				
				//txtOutput.setText(Float.toString(k));
			}
		});
		btnRoundRobin.setBounds(436, 285, 116, 25);
		panel.add(btnRoundRobin);
		
		JButton btnSjfp = new JButton("SJFP");
		btnSjfp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float k;
				String n=txtInput.getText();
				String C,t;
				C = "SJF PREEMITIVE";
				int d;
				d = Integer.parseInt(n);
				int Arr_time[] = new int[d];
				int Burst_time[] = new int[d];
				int Priority[] = new int[d];
				k = onclick.execute(Integer.parseInt(n), C,Arr_time,Burst_time,Priority);
				String m = "";
				int i;
				m = "Arrival_time" + "       " + "Burst_time" + "\n";
				for(i=0;i<Integer.parseInt(n);i++){
					m = m + Arr_time[i] + "\t" + Burst_time[i] + "\n";
				}
				JTextArea txtrTable = new JTextArea();
				txtrTable.setText("");
				txtrTable.setBounds(246, 107, 271, 152);
				panel.add(txtrTable);
				txtrTable.setText(m);
				JTextArea txtrOutput = new JTextArea();
				txtrOutput.setBounds(306, 529, 161, 164);
				panel.add(txtrOutput);
				txtrOutput.setText("");
				t=Float.toString(k);
				txtrOutput.setText(C+"\n"+t);
				//txtOutput.setText(Float.toString(k));
			}
		});
		btnSjfp.setBounds(182, 338, 124, 25);
		panel.add(btnSjfp);
		
		JButton btnPriorityp = new JButton("PRIORITYP");
		btnPriorityp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float k;
				String n=txtInput.getText();
				String C,t;
				C = "PRIORITY PREEMITIVE";
				int d;
				d = Integer.parseInt(n);
				int Arr_time[] = new int[d];
				int Burst_time[] = new int[d];
				int Priority[] = new int[d];
				k = onclick.execute(Integer.parseInt(n), C,Arr_time,Burst_time,Priority);
				String m = "";
				int i;
				m = "Arrival_time" + "       " + "Burst_time" + "         " + "Priority" + "\n";
				for(i=0;i<Integer.parseInt(n);i++){
					m = m + Arr_time[i] + "\t" + Burst_time[i] + "\t" + Priority[i] + "\n";
				}
				JTextArea txtrTable = new JTextArea();
				txtrTable.setText("");
				txtrTable.setBounds(246, 107, 271, 152);
				panel.add(txtrTable);
				txtrTable.setText(m);
				JTextArea txtrOutput = new JTextArea();
				txtrOutput.setBounds(306, 529, 161, 164);
				panel.add(txtrOutput);
				txtrOutput.setText("");
				t=Float.toString(k);
				txtrOutput.setText(C+"\n"+t);
	//			txtOutput.setText(Float.toString(k));
			}
		});
		btnPriorityp.setBounds(436, 338, 116, 25);
		panel.add(btnPriorityp);
		
		JButton btnSjfnp = new JButton("SJFNP");
		btnSjfnp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float k;
				String n=txtInput.getText();
				String C,t;
				C = "SJF NON PREEMITIVE";
				int d;
				d = Integer.parseInt(n);
				int Arr_time[] = new int[d];
				int Burst_time[] = new int[d];
				int Priority[] = new int[d];
				k = onclick.execute(Integer.parseInt(n), C,Arr_time,Burst_time,Priority);
				String m = "";
				int i;
				m = "Arrival_time" + "       " + "Burst_time" + "\n";
				for(i=0;i<Integer.parseInt(n);i++){
					m = m + Arr_time[i] + "\t" + Burst_time[i] + "\n";
				}
				JTextArea txtrTable = new JTextArea();
				txtrTable.setText("");
				txtrTable.setBounds(246, 107, 271, 152);
				panel.add(txtrTable);
				txtrTable.setText(m);
				JTextArea txtrOutput = new JTextArea();
				txtrOutput.setBounds(306, 529, 161, 164);
				panel.add(txtrOutput);
				txtrOutput.setText("");
				t=Float.toString(k);
				txtrOutput.setText(C+"\n"+t);
	//			txtOutput.setText(Float.toString(k));
			}
		});
		btnSjfnp.setBounds(182, 389, 124, 25);
		panel.add(btnSjfnp);
		
		JButton btnPrioritynp = new JButton("PRIORITYNP");
		btnPrioritynp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float k;
				String n=txtInput.getText();
				String C,t;
				C = "PRIORITY NON PREEMITIVE";
				int d;
				d = Integer.parseInt(n);
				int Arr_time[] = new int[d];
				int Burst_time[] = new int[d];
				int Priority[] = new int[d];
				k = onclick.execute(Integer.parseInt(n), C,Arr_time,Burst_time,Priority);
				String m = "";
				int i;
				m = "Arrival_time" + "       " + "Burst_time" + "         " + "Priority" + "\n";
				for(i=0;i<Integer.parseInt(n);i++){
					m = m + Arr_time[i] + "\t" + Burst_time[i] + "\t" + Priority[i] + "\n";
				}
				JTextArea txtrTable = new JTextArea();
				txtrTable.setText("");
				txtrTable.setBounds(246, 107, 271, 152);
				panel.add(txtrTable);
				txtrTable.setText(m);
				JTextArea txtrOutput = new JTextArea();
				txtrOutput.setBounds(306, 529, 161, 164);
				panel.add(txtrOutput);
				txtrOutput.setText("");
				t=Float.toString(k);
				txtrOutput.setText(C+"\n"+t);
	//			txtOutput.setText(Float.toString(k));
			}
		});
		btnPrioritynp.setBounds(436, 389, 116, 25);
		panel.add(btnPrioritynp);
		
		JTextArea txtrOutput = new JTextArea();
		txtrOutput.setText("");
		txtrOutput.setBounds(274, 527, 211, 164);
		panel.add(txtrOutput);
		
		JLabel lblNoOfProcesses = new JLabel("No. of processes :");
		lblNoOfProcesses.setBounds(223, 67, 116, 22);
		panel.add(lblNoOfProcesses);
		
		JTextArea txtrTable = new JTextArea();
		txtrTable.setText("");
		//txtrTable.setBounds(182, 107, 370, 159);
		txtrTable.setBounds(182, 107, 370, 165);
		panel.add(txtrTable);
		
	}
}