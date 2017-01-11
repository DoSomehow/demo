package ms.innerclasses.controller;

public class GreenhouseControls extends Controller {
	private boolean light = false;
	public class LightOn extends Event {
		public LightOn(long delayTime){
			super(delayTime);
		}
		public void action(){
			//这里写硬件控制代码来打开灯，其他设备类似
			light = true;
		}
		public String toString() { return "Light is on"; }
	}
	public class LightOff extends Event {
		public LightOff(long delayTime){
			super(delayTime);
		}
		public void action(){
			light = false;
		}
		public String toString() { return "Light is off"; }
	}
	
	private boolean water = false;
	public class WaterOn extends Event {
		public WaterOn(long delayTime){
			super(delayTime);
		}
		public void action(){
			water = true;
		}
		public String toString() { return "Water is on"; }
	}
	public class WaterOff extends Event {
		public WaterOff(long delayTime){
			super(delayTime);
		}
		public void action(){
			water = false;
		}
		public String toString() { return "Water is off"; }
	}
	
	private String thermostat = "Day";  //恒温器
	public class ThermostatNight extends Event {
		public ThermostatNight(long delayTime){
			super(delayTime);
		}
		public void action(){
			thermostat = "Night";
		}
		public String toString() { return "Thermostat on night setting"; }
	}
	public class ThermostatDay extends Event {
		public ThermostatDay(long delayTime){
			super(delayTime);
		}
		public void action(){
			thermostat = "Day";
		}
		public String toString() { return "Thermostat on day setting"; }
	}
	
	//一个将自己放入事件集合中的action的例子
	public class Bell extends Event {
		public Bell(long delayTime){
			super(delayTime);
		}
		public void action(){
			addEvent(new Bell(delayTime));
		}
		public String toString() { return "Bing!"; }
	}
	
	public class Restart extends Event {
		private Event[] eventList;  //注意这里是数组，不是集合
		public Restart(long delayTime, Event[] eventList){
			super(delayTime);
			this.eventList = eventList;
			for(Event e:eventList){
				addEvent(e);  //调用addEvent方法，是把事件加入到了Event类中的eventList集合中
			}
		}
		public void action(){
			for(Event e:eventList){
				e.start();
				addEvent(e);
			}
			start();
			addEvent(this);  //把自己也加入事件集合中
		}
		public String toString() { return "Restarting system"; }
	}
	
	public static class Terminate extends Event {
		public Terminate(long delayTime){
			super(delayTime);
		}
		public void action(){ System.exit(0); }
		public String toString() { return "Terminating"; }
	}
}
