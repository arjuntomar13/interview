package designPatterns;

public class Subscriber implements Observer{

	private String name;
	public Subject topic;
	
	public Subscriber(String name){
		this.name = name;
	}
	
	@Override
	public void update(String message) {
		String msg = topic.getUpdate(this);
		if(msg == null){
			System.out.println(name + " : No new message");
		}else{
			System.out.println(name + " : Topic has changed : Message : " + msg);
		}
	}
	
	@Override
	public void setSubject(Subject sub){
		this.topic = sub;
	}
	
}
