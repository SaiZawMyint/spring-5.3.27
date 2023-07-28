package com.mtm.plan.common.conifg;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.springframework.beans.factory.annotation.Value;
/**
 * Write your deployment configuration here...<br>
 * This is the main place where to define configuration for your app.
 *
 * @author SaiZawMyint
 */
@org.springframework.stereotype.Component
public class LogInitializer {

    private final Logger logger = LogManager.getLogger(LogInitializer.class);

    @Value("${log.file.location}")
    String logFileLocation;

    @Value("${log.file.max.size}")
    Long maxLogSize;

    @PostConstruct
    public void configure() {
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        AppenderComponentBuilder consoleAppender = builder.newAppender("Console", "CONSOLE").addAttribute("target",
                ConsoleAppender.Target.SYSTEM_OUT);
        AppenderComponentBuilder fileAppender = builder.newAppender("File", "FILE")
                .addAttribute("level", Level.ALL)
                .addAttribute("fileName", generateLogFile(new File(logFileLocation)))
                .add(layout(builder));
        
        builder.add(consoleAppender);
        builder.add(fileAppender);

        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(Level.ALL)
                .add(builder.newAppenderRef("Console"))
                .add(builder.newAppenderRef("File"));
        builder.add(rootLogger);

        // Activate the configuration
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.start(builder.build());

        // Log a test message
        logger.info("Logging initialized");
    }

    private LayoutComponentBuilder layout(ConfigurationBuilder<BuiltConfiguration> builder) {
        return builder.newLayout("PatternLayout").addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c - %m%n");
    }

    private String generateLogFile(File file) {
        if(file == null || !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(file.length() > maxLogSize) {
            String[] separateFile = file.getName().split("\\.");
            File newF = new File(separateFile[0]+System.currentTimeMillis()+"."+separateFile[1]);
            try {
                newF.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return newF.getAbsolutePath();
        }
        return file.getAbsolutePath();
    }

}
