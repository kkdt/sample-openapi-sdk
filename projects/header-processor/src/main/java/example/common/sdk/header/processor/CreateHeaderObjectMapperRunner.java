package example.common.sdk.header.processor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.common.sdk.header.generated.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

/**
 * Creates the {@link Header} and uses Jackson {@link ObjectMapper} to convert to JSON string.
 */
@Component
public class CreateHeaderObjectMapperRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(CreateHeaderObjectMapperRunner.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Header header = new Header();
        // sdk attributes
        header.setTimestamp(OffsetDateTime.now());
        header.setClassification(CreateHeaderObjectMapperRunner.class.getSimpleName().toUpperCase());
        // custom attributes
        header.put("mapper", ObjectMapper.class.getName());
        logger.info("Header: {}", header);
        logger.info("Header.timestamp: {}", header.getTimestamp());
        logger.info("Header.classification: {}", header.getClassification());

        // json
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.USE_DEFAULTS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = mapper.writeValueAsString(header);
        logger.info("JSON: {}", json);
    }
}