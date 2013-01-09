package mew.misc.distributed.communication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageRepos {
	private static final MessageRepos repos = new MessageRepos();
	
	private Map<String, List<Message>> store;
	
	private MessageRepos(){
		store = new HashMap<String, List<Message>>();
	}
	
	public static MessageRepos getRepos() {
		return repos;
	}
	
	public void sendMessage(Message msg){
		if(msg == null){
			return ;
		}
		
		if(store.containsKey(msg.getTo())){
			List<Message> list = store.get(msg.getTo());
			list.add(msg);
		}else {
			// add new entry
			List<Message> list = new ArrayList<Message>();
			list.add(msg);
			
			store.put(msg.getTo(), list);
		}
		
		ProcessRegistrar.getRegis().getProcess(msg.getTo()).receiveMessage(msg);
	}
	
	public List<Message> getMessage(String toID){
		return store.get(toID);
	}
}
