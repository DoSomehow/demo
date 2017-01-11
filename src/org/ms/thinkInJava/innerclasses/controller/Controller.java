package ms.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

public class Controller {

	private List<Event> eventList = new ArrayList<Event>();

	public void addEvent(Event c){
		eventList.add(c);
	}
	
	public void run(){
		while(eventList.size() > 0){
			//复制eventList集合，这样就可以对当前遍历的元素进行修改
			for(Event e:new ArrayList<Event>(eventList)){
				if(e.ready()){
					System.out.println(e.toString());
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
	
}
