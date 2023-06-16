package com.pointel.bofa.strategy.portal.app.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PointelLogger {

	

	public void initializeLog(String logFilePath,String fileName,String fileCount,
			String fileSize,String logLevel,String isStactTraceEnabled,String errorFileName) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss__S");
		ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

		builder.setStatusLevel(getLogLevel(logLevel));
		builder.setConfigurationName("DefaultLogger");

		AppenderComponentBuilder appenderBuilder = builder.newAppender("Console", "CONSOLE").addAttribute("target",
				ConsoleAppender.Target.SYSTEM_OUT);
		appenderBuilder.add(
				builder.newLayout("PatternLayout").addAttribute("pattern", "%d{MMM-dd-yyyy HH:mm:ss.SSS} %5p %m%n"));

		LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout").addAttribute("pattern",
				"%d{MMM-dd-yyyy HH:mm:ss.SSS} %5p %m%n");
		ComponentBuilder<?> triggeringPolicy = builder.newComponent("Policies")
				.addComponent(builder.newComponent("SizeBasedTriggeringPolicy").addAttribute("size", "10MB"));
		ComponentBuilder<?> rolloverStrategy = builder.newComponent("DefaultRolloverStrategy").addAttribute("max", 3);

		// rolling.addComponent(rolloverStrategy);

		appenderBuilder = builder.newAppender("LogToRollingFile", "RollingFile")
				.addAttribute("fileName", logFilePath + fileName + sdf.format(new Date()) + ".log")
				.addAttribute("filePattern", logFilePath + fileName + sdf.format(new Date()) + ".log" + ".%i")
				.add(layoutBuilder).addComponent(triggeringPolicy).addComponent(rolloverStrategy);
		
		// create a Error appender
					AppenderComponentBuilder appenderBuilder1 = builder.newAppender("LogToRollingFile1", "RollingFile")
							.addAttribute("fileName", errorFileName+ fileName + sdf.format(new Date())+ "_error.log")
							.addAttribute("filePattern", errorFileName + fileName + sdf.format(new Date())+"_error_%i.log").add(layoutBuilder)
							.addComponent(triggeringPolicy).addComponent(rolloverStrategy);
		// create console appender
					AppenderComponentBuilder consoleBuilder = builder.newAppender("Console", "CONSOLE").addAttribute("target",
							ConsoleAppender.Target.SYSTEM_OUT).add(layoutBuilder);	
					
		builder.add(appenderBuilder);
		builder.add(appenderBuilder1);
		builder.add(consoleBuilder);
		RootLoggerComponentBuilder rootLoggerBuilder = builder.newRootLogger(Level.ALL)
				.add(builder.newAppenderRef("Console").addAttribute("level",Level.INFO))
				.add(builder.newAppenderRef("LogToRollingFile").addAttribute("level",getLogLevel(logLevel)))
				.add(builder.newAppenderRef("LogToRollingFile1").addAttribute("level", Level.ERROR));
		
		//rootLogger.add(builder.newAppenderRef("LogToRollingFile"));
		builder.add(rootLoggerBuilder);
		Configurator.reconfigure(builder.build());
	}
	public org.apache.logging.log4j.Level getLogLevel(String logLevel) {
		int s = Integer.parseInt(logLevel);

		switch (s) {
		case 0:
			// System.out.println("The value  of the level is  0 :" +s);
			return org.apache.logging.log4j.Level.OFF;
			
		case 1:
			// System.out.println("The value  of the level is 1 :" +s);
			return org.apache.logging.log4j.Level.DEBUG;
			
		case 2:
			// System.out.println("The value  of the level is 2 :" +s);
			return org.apache.logging.log4j.Level.INFO;
			
		case 3:
			// System.out.println("The value  of the level is 3 :" +s);
			return org.apache.logging.log4j.Level.ERROR;
			
		case 4:
			// System.out.println("The value  of the level is 4 :" +s);
			return org.apache.logging.log4j.Level.FATAL;
			
		case 5:
			// System.out.println("The value  of the level is 5 :" +s);
			return org.apache.logging.log4j.Level.WARN;
			
		case 6:
			// System.out.println("The value  of the level is 6 :" +s);
			return org.apache.logging.log4j.Level.ALL;
			
		
		   default: return org.apache.logging.log4j.Level.ALL;
		 
		}
	}

}
