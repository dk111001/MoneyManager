package com.deepak.kamboj.MoneyManager;

import com.deepak.kamboj.MoneyManager.model.User;
import com.deepak.kamboj.MoneyManager.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MoneyManagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(MoneyManagerApplication.class, args);

//		UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
//
//		User user = new User();
//		user.setRoles("ADMIN,USER");
//		user.setUserName("deepak");
//		user.setActive(true);
//		user.setPassword("admin");
//
//		userRepository.save(user);

	}

}
