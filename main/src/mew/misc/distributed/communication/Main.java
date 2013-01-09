package mew.misc.distributed.communication;

public class Main {
	public static void main(String[] args) {
		Process pr1 = new Process();
		Process pr2 = new Process();
		Process pr3 = new Process();
		
		ProcessConnection conn = ProcessConnection.getConnection();
		conn.addNewConnection(pr1, pr2);
		conn.addNewConnection(pr1, pr3);
		
		pr1.sendMessage();
		pr2.sendMessage();
		pr3.sendMessage();
	
		System.out.println("End of Processing..");
	}
}
