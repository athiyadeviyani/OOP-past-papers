import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class AdvancedTutorial extends Tutorial {

	private String topic;

	public AdvancedTutorial(String topic, String tutor, String time) {
		super(tutor, time);
		this.topic = topic;
	}

	public String toString() {
		String s = "Topic: " + topic + " " + super.toString();
		return s;
	}

	public boolean couldCombineWith(AdvancedTutorial at) {
		boolean a = this.getTime().equals(at.getTime());
		boolean b = this.topic.equals(at.topic);
		return a && b;
	}

//	public static HashMap<String, AdvancedTutorial> construct(String[] strings) {
//		ArrayList<AdvancedTutorial> arraylist = new ArrayList<AdvancedTutorial>();
//		HashMap<String, AdvancedTutorial> hashmap = new HashMap<String, AdvancedTutorial>();
//
//		ArrayList<String> keys = new ArrayList<String>();
//
//		for (int i = 0; i < strings.length; i++) {
//			if (i % 3 == 0) {
//					AdvancedTutorial at = new AdvancedTutorial(strings[i], strings[i+1], strings[i+2]);
//					arraylist.add(at);
//					hashmap.put(strings[i],at);
//			}
//		}
//		
////		for (int i = 0; i < strings.length; i++) {
////			if (i%3 == 0) {
////				keys.add(strings[i]);
////				for (String key : keys) {
////					hashmap.put(key, arraylist);
////				}
////			}
////		}
//		
//	//	System.out.println(Arrays.toString(arraylist.toArray()));
//		return hashmap;
//	}
	
	public String getTopic() {
		return topic;
	}
	
	public static HashMap<String, ArrayList<AdvancedTutorial>> construct(String[] data) {
		HashMap<String, ArrayList<AdvancedTutorial>> sorted = new HashMap<String, ArrayList<AdvancedTutorial>>();
		ArrayList<AdvancedTutorial> tuts = new ArrayList<AdvancedTutorial>();
		
		for (int i = 0; i < data.length; i+=3) {
			AdvancedTutorial a = new AdvancedTutorial(data[i], data[i+1], data[i+2]);
			tuts.add(a);
		}
		
		for (AdvancedTutorial t : tuts) {
			String topic = t.getTopic();
			ArrayList<AdvancedTutorial> sameTopic = new ArrayList<AdvancedTutorial>();
			for (AdvancedTutorial t2 : tuts) {
				String topic2 = t2.getTopic();
				if (topic.equals(topic2)) {
					sameTopic.add(t2);
				}
			}
			sorted.put(topic, sameTopic);
			}
		return sorted;
	}


	public static void main(String[] args) {
		if (args.length % 3 != 0) {
			System.out.println("Wrong number of arguments!");
		}

		String[] strings = new String[args.length];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = args[i];
		}

		System.out.println(construct(strings).toString());
	}
}