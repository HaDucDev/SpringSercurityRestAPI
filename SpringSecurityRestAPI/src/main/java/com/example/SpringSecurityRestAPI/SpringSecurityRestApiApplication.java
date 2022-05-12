package com.example.SpringSecurityRestAPI;//SpringSecurityRestApiApplication

import com.example.SpringSecurityRestAPI.model.Book;
import com.example.SpringSecurityRestAPI.model.Role;
import com.example.SpringSecurityRestAPI.model.User;
import com.example.SpringSecurityRestAPI.repository.UserRepository;
import com.example.SpringSecurityRestAPI.service.BookService;
import com.example.SpringSecurityRestAPI.service.RoleService;
import com.example.SpringSecurityRestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityRestApiApplication  {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityRestApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return (args) -> {
			roleService.saveOrUpdate(new Role(1L, "admin"));
			roleService.saveOrUpdate(new Role(2L, "user"));

			User user1 = new User();
			user1.setEmail("ducuser123@user.com");
			user1.setName("duc123");
			user1.setMobile("0123456789");
			user1.setRole(roleService.findById(2L).get());
			user1.setPassword(new BCryptPasswordEncoder().encode("duc123"));
			User user = userRepository.findByEmail(user1.getEmail());
			if(user == null)
			{
				userService.saveOrUpdate(user1);
			}


			User user2 = new User();
			user2.setEmail("ducadmin123@admin.com");
			user2.setName("duc amdin");
			user2.setMobile("987654321");
			user2.setRole(roleService.findById(1L).get());
			user2.setPassword(new BCryptPasswordEncoder().encode("duc123"));
			User admin = userRepository.findByEmail(user2.getEmail());
			if(user == null)
			{
				userService.saveOrUpdate(user2);
			}

			// tuong tu co the lam voi ten sach

			Book book = new Book();
			book.setTitle("Clean code");
			book.setAuthor("Martin");
			book.setCoverPhotoURL("https://salt.tikicdn.com/cache/400x400/ts/product/5f/d7/35/d6a086d2450d364198cd07ebef63d8a7.jpg");
			book.setIsbnNumber(1617293989L);
			book.setPrice(10000.00);
			book.setLanguage("English");
			bookService.saveOrUpdate(book);
		};
	}
}
