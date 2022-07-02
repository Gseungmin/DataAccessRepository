package hello.itemservice;

import hello.itemservice.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
//@Import(JdbcTemplateConfig.class) JdbcTemplate 의존관계 주입
@Import(MyBatisConfig.class)
public class ItemServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}
}
