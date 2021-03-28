package dbBackupScheduler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class DBBackupScheduler {

	@Scheduled(cron = "0 30 1 * * ?")
	public void schedule() {

		System.out.println("Backup Started at " + new Date());
		
		Date backupDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String backupDateStr = format.format(backupDate);
		String dbNameList = "client_1 client_2";

		String fileName = "Daily_DB_Backup"; // default file name
		String folderPath = "C:\\home";
		File f1 = new File(folderPath);
		f1.mkdir(); // create folder if not exist

		String saveFileName = fileName + "_" + backupDateStr + ".sql";
		String filePath = "backup";
		String savePath = filePath + File.separator + saveFileName;

		String dbUserName = "root";
		String dbUserPassword = "rkmr";
		String executeCmd = "mysqldump -u " + dbUserName  + " -p" + dbUserPassword  + "  --databases " + dbNameList
				+ " -r " + savePath; 

		Process runtimeProcess = null;
		try {
			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int processComplete = 0;
		try {
			processComplete = runtimeProcess.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (processComplete == 0) {
			System.out.println("Backup Complete at " + new Date());
		} else {
			System.out.println("Backup Failure");
		}
	}
}