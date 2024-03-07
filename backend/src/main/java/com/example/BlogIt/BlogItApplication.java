package com.example.BlogIt;

import com.example.BlogIt.entities.Role;
import com.example.BlogIt.repositories.CategoryRepository;
import com.example.BlogIt.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogItApplication implements ApplicationRunner {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogItApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//CREATE 2 ROLES IF NOT EXISTS WITH CUSTOM ID
		//1-NORMAL
		//2-ADMIN

//		Role role;
//		if(roleRepository.findById(1).isEmpty()) {
//			role=new Role();
//			role.setRid(1);
//			role.setRoleName(GlobalConstants.ROLE_NORMAL);
//			roleRepository.save(role);
//		}
//
//		if(roleRepository.findById(2).isEmpty()) {
//			role=new Role();
//			role.setRid(2);
//			role.setRoleName(GlobalConstants.ROLE_ADMIN);
//			roleRepository.save(role);
//		}
//
//		//create 3 Categories by default
//		Category category;
//		if(categoryRepository.findById(1).isEmpty()) {
//			category=new Category();
//			category.setName("Technology");
//			category.setDescription("Content regarding Tools and Technology.");
//			categoryRepository.save(category);
//		}
//		if(categoryRepository.findById(2).isEmpty()) {
//			category=new Category();
//			category.setName("Sports");
//			category.setDescription("Content regarding Sports.");
//			categoryRepository.save(category);
//		}
//		if(categoryRepository.findById(3).isEmpty()) {
//			category=new Category();
//			category.setName("Bollywood");
//			category.setDescription("Content regarding Bollywood.");
//			categoryRepository.save(category);
//		}
	}
}
