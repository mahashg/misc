package mew.misc.distributed.communication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessConnection {
	private static Map<String, List<Process>> connectionList = new HashMap<String, List<Process>>();

	private static ProcessConnection connection = new ProcessConnection();
	
	private ProcessConnection(){
		
	}
	
	public static ProcessConnection getConnection() {

		return connection;
	}
	
	public void addNewConnection(Process pr1, Process pr2){
		
		this.addNewConnection(pr1.getID(), pr2);
		this.addNewConnection(pr2.getID(), pr1);
	}

	private void addNewConnection(String id, Process pr) {
		if(!connectionList.containsKey(id)){
			connectionList.put(id, new ArrayList<Process>());
		}
		
		connectionList.get(id).add(pr);
	}
	
	public List<Process> getConnectionFor(String id){
		return connectionList.get(id);
	}
}