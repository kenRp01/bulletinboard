package jp.co.board.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "board.title")
@Data
public class BoardConfig {

    private String top;
    private String topUrl;
    private String main;
    private String mainUrl;
}
