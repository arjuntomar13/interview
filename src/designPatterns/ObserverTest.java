package designPatterns;

public class ObserverTest {

	public static void main(String[] args) {
		
		Subscriber sub1 = new Subscriber("First");
		Subscriber sub2 = new Subscriber("Second");
		Subscriber sub3 = new Subscriber("Third");
		
		MyTopic myTopic = new MyTopic();
		
		myTopic.register(sub1);
		myTopic.register(sub2);
		myTopic.register(sub3);
		
		sub1.setSubject(myTopic);
		sub2.setSubject(myTopic);
		sub3.setSubject(myTopic);
		
		myTopic.postMessage("Posting first Message in MyTopic");
		
	}
}