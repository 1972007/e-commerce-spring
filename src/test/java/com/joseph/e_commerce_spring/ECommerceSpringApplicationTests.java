package com.joseph.e_commerce_spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.joseph.e_commerce_spring.model.Role;
import com.joseph.e_commerce_spring.model.User;
import com.joseph.e_commerce_spring.repositories.*;
import com.joseph.e_commerce_spring.security2.SecurityConfig;

@SpringBootTest
class ECommerceSpringApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;



	@Test
	void findAdminById(){
		
		assertThat(userRepository.findByUsername("admin").get().getUsername() ).isEqualTo("admin");
	}
	@Test
	void findRoles() {
		List<Role> roles = new ArrayList<>();
		roles.add(new Role(1, "superadmin"));
		roles.add(	new Role(2, "user"));
		roles.add(	new Role(3, "merchant_admin"));
		
		assertThat(roleRepository.findAll()).containsAll(roles);
	}

	
	@Test
	void adminContainsAdminRole() {
		User user = userRepository.findByUsername("admin").get();
		Role[] roles = {roleRepository.findById(1).get()};
		System.out.print(roles.toString());
		assertThat(user.getRoles()).contains(roles);
	}
}
