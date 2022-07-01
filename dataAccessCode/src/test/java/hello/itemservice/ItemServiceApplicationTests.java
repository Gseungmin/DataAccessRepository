package hello.itemservice;

import hello.itemservice.config.JdbcTemplateConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(JdbcTemplateConfig.class)
class ItemServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
