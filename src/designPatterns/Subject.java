package designPatterns;

public interface Subject {

	
	public void register(Observer obj);
	public void unregister(Observer obj);
	public void sendNotification();
	public String getUpdate(Observer obj);
	
}