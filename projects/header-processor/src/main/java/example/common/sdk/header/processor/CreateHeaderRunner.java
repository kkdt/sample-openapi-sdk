package example.common.sdk.header.processor;

import example.common.sdk.header.generated.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

/**
 * Creates the {@link Header} and output string to log.
 */
@Component
public class CreateHeaderRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(CreateHeaderRunner.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Header header = new Header();
        // sdk attributes
        header.setTimestamp(OffsetDateTime.now());
        header.setClassification(CreateHeaderRunner.class.getSimpleName().toUpperCase());
        // custom attributes
        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json");
        logger.info("Header: {}", header);
        logger.info("Header.timestamp: {}", header.getTimestamp());
        logger.info("Header.classification: {}", header.getClassification());
    }
}
