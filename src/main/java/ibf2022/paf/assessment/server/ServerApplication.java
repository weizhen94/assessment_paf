package ibf2022.paf.assessment.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@SpringBootApplication
public class ServerApplication {

	@Value("${MYSQL_URL}")
    private String dbUrl;

    @Value("${MYSQLUSER}")
    private String dbUsername;

    @Value("${MYSQLPASSWORD}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
