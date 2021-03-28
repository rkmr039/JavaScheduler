package bootScheduler;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSchedulerMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulerMain.class, args);
		System.out.println("===========================Execution Started at ::=========================" + new Date());

	}

}
