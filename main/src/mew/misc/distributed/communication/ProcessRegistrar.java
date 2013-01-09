package mew.misc.distributed.communication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessRegistrar {
	private static Map<String, Process> processMap= new HashMap<String, Process>();

	private static ProcessRegistrar regis = new ProcessRegistrar();
	
	private ProcessRegistrar(){
		
	}
	
	public static ProcessRegistrar getRegis() {
		return regis;
	}
	
	public void register(Process pr){
		processMap.put(pr.getID(), pr);
		
		sendUndeliveredMessages(pr);
	}

	private void sendUndeliveredMessages(Process pr) {
		List<Message> list = MessageRepos.getRepos().getMessage(pr.getID());
		
		for(Message msg : list){
			if(!msg.isDelivered()){
				pr.receiveMessage(msg);
			}
		}
	}

	public Process getProcess(String id) {
		return processMap.get(id);
	}
}
