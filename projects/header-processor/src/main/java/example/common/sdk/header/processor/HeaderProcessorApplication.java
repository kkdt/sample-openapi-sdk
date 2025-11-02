package example.common.sdk.header.processor;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HeaderProcessorApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(HeaderProcessorApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .logStartupInfo(false)
            .headless(false);
        app.run(args);
    }
}
