package mew.misc.distributed.communication;

import java.util.List;
import java.util.UUID;

public class Process {
	private String ID;
	
	private static  MessageRepos repository = MessageRepos.getRepos();
	private static ProcessRegistrar registrar = ProcessRegistrar.getRegis();
	private static ProcessConnection conn = ProcessConnection.getConnection();
	
	public Process(){
		this.ID = UUID.randomUUID().toString();
		registrar.register(this);
	}
	
	public String getID() {
		return ID;
	}
	
	public void sendMessage(){
		List<Process> list = conn.getConnectionFor(ID);
		
		for(Process pr : list){
			repository.sendMessage(new Message(this, pr.ID, "Hi"));
		}
	}
	
	public void receiveMessage(Message msg){
		msg.setDelivered();	// set message to be delivered.
		
		System.out.println("Received.. "+msg);
	}
	
}
