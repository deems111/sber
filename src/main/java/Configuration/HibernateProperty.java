package Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;


@Data
@Component
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperty {
    private String dialect;
    private String defaultSchema;
    private Boolean showSql;
    private Boolean enableLazyLoad;
    private Connection connection = new Connection();

    @Data
    public static class Connection {
        private String driverClass;
        private String url;
        private String username;
        private String password;
    }
}
