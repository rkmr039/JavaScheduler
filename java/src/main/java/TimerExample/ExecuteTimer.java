package TimerExample;

import java.util.Timer;

public class ExecuteTimer {
	
	public static void main(String[] args) {
		TimerExample e1 = new TimerExample("Task1");
		TimerExample e2 = new TimerExample("Task2");
		
		Timer t = new Timer();
		
		t.scheduleAtFixedRate(e1, 0, 5*1000);
		t.scheduleAtFixedRate(e2, 0, 1000);
	}

}
