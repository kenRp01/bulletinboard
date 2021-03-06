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
    private String register;
    private String registerUrl;
    private String registerInit;
    private String registerInitUrl;
    private String message;
    private String messageUrl;
    private String messageInit;
    private String messageInitUrl;
    private String management;
    private String managementUrl;
    private String logout;
    private String logoutUrl;
    
}
