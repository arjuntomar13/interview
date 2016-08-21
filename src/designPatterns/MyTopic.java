package designPatterns;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject{

	private List<Observer> observers;
	private boolean updated;
	private String message;
	
	public MyTopic(){
		this.observers = new ArrayList<Observer>();
	}
	
	public void register(Observer obj){
		if(!observers.contains(obj)){
			observers.add(obj);
		}
	}

	public void unregister(Observer obj){
		observers.remove(obj);
	}
	
	//Make this thread safe
	public void sendNotification(){
		
		if(updated){
			for(Observer observer : observers){
				observer.update(message);
			}
		}
	}
	
	public void postMessage(String message){
		this.message = message;
		this.updated = true;
		sendNotification();
	}
	
	public String getUpdate(Observer obj){
		return this.message;
	}
	
}
