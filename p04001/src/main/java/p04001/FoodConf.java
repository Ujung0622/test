package p04001;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@Configurable
public class FoodConf {
	
	@Bean
	public KoreaFood kFood() {
		return new KoreaFood();
		 
	}
	
	@Bean
	public ChinaFood cFood() {
		return new ChinaFood();
	}
	
	@Bean
	public GlobalFood gFood() {
		return new GlobalFood();
	}

	
	
}
