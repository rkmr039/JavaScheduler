package bootScheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@EnableAsync
public class FixedRateAsyncScheduler {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	@Async
	@Scheduled(fixedRate = 1000)
	public  void performSchedulerTask() {
		System.out.println("Async FixedRate task performed at         :" + dateFormat.format(new Date()));
	}
}
