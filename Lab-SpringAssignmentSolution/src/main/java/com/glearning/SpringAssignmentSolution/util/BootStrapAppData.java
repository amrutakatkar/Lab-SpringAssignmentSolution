package com.glearning.SpringAssignmentSolution.util;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.glearning.SpringAssignmentSolution.model.Role;
import com.glearning.SpringAssignmentSolution.model.Student;
import com.glearning.SpringAssignmentSolution.repository.RoleRepository;
import com.glearning.SpringAssignmentSolution.repository.StudentRepository;
import com.glearning.SpringAssignmentSolution.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class BootStrapAppData implements ApplicationListener<ApplicationReadyEvent>{
	
	private final PasswordEncoder passwordencoder;
	
	private final StudentRepository studentRepository;
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		for(int i=0; i<10; i++) {
			Student student = new Student();
			student.setFirstName("Test1" + i);
			student.setLastName("TestLastName" + i);
			student.setCountry("India" + i);
			student.setCourse("IT" + i);
			studentRepository.save(student);
		}
		
		
		Role userRole=new Role();
		userRole.setRoleName("ROLE_USER");
		
		Role adminRole=new Role();
		adminRole.setRoleName("ROLE_ADMIN");
		
		
		
		com.glearning.SpringAssignmentSolution.model.User user=new com.glearning.SpringAssignmentSolution.model.User();
		user.setUserName("Ahana");
		user.setPassword(this.passwordencoder.encode("test"));
		
		com.glearning.SpringAssignmentSolution.model.User admin=new com.glearning.SpringAssignmentSolution.model.User();
		admin.setUserName("Anita");
		admin.setPassword(this.passwordencoder.encode("test"));
				
		admin.addRole(adminRole);
		admin.addRole(userRole);
		
		user.addRole(userRole);
		
		userRepository.save(user);
		userRepository.save(admin);
		roleRepository.save(userRole);
		roleRepository.save(adminRole);
	}

}
