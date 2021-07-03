package DispatcherConfiguration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import DAO.UserDao;
import Services.employeeServices;


@Configuration
@EnableScheduling
public class AppConfig {
	
	@Bean
	public UserDao getUserDao() {
		return new UserDao();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
		template.getMessageConverters().add(new StringHttpMessageConverter());
		template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return template;		
	}
	
	@Bean
	public employeeServices getemployeeServices(){
		return new employeeServices();
	}
}
