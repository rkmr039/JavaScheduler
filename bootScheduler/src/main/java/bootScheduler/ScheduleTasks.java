package bootScheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
public class ScheduleTasks {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	// makes Spring run the task on periodic intervals even if the last invocation may still be running
	@Scheduled(fixedRate = 5000)
	public void performTask() {
		System.out.println("FixedRate task performed at          :" + dateFormat.format(new Date()));
	}
	
	// specifically controls the next execution time when the last execution finishes
	@Scheduled(fixedDelay = 5000)
	public void performDelayTask() throws InterruptedException {
		System.out.println("FixedDelay task performed at         :" + dateFormat.format(new Date()));
		Thread.sleep(10000);
	}
	
	// run this task at every five minutes
	@Scheduled(cron = "*/5 * * * * *")
	public void performCronTask() {
		System.out.println("Regular task performed using Cron at :" + dateFormat.format(new Date()));
	}
}
