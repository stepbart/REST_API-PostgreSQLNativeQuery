package pl.suncode.recruitmentTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RecruitmentTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentTaskApplication.class, args);
	}

}
