package com.glearning.SpringAssignmentSolution.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glearning.SpringAssignmentSolution.model.DomainUserDetails;
import com.glearning.SpringAssignmentSolution.model.User;
import com.glearning.SpringAssignmentSolution.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class DomainUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = this.userRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("Invalid User"));
				
		return new DomainUserDetails(user);
	}
}
