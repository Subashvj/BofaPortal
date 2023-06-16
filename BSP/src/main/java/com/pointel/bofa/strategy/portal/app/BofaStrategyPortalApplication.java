package com.pointel.bofa.strategy.portal.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pointel.bofa.strategy.portal.app.logger.PointelLogger;


@SpringBootApplication
@EnableTransactionManagement
@PropertySource("file:${CONF_DIR}/application.properties")
@EnableJpaRepositories("com.pointel.bofa.strategy.portal.app.*")
@ComponentScan(basePackages = {"com.pointel.bofa.strategy.portal.app.*"})
@EntityScan(basePackages="com.pointel.bofa.strategy.portal.app.*")
public class BofaStrategyPortalApplication {
	
	@Value("${log.file.path:default}")
	private String logFilePath;
	@Value("${log.file.name::default}")
	private String fileName;
	@Value("${log.file.count:10}")
	private String fileCount;
	@Value("${log.file.size:10}")
	private String fileSize;
	@Value("${log.level:6}")
	private String logLevel;
	@Value("${log.isStackTraceEnabled:true}")
	private boolean isStackTraceEnabled;
	@Value("${log.file.errorLogPath::default}")
	private String errorFileName;
	@Autowired
	private PointelLogger pointelLogger;
	
	@PostConstruct
	public void init() {
		
		pointelLogger.initializeLog(logFilePath, fileName, fileCount, fileSize, logLevel, fileCount,errorFileName);;

	}

	public static void main(String[] args) {
		SpringApplication.run(BofaStrategyPortalApplication.class, args);
		
		
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("*")
	                    .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
	        }
	    };
	}

}
