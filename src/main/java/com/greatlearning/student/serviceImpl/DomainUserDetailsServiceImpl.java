package com.greatlearning.student.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.student.model.DomainUserDetails;
import com.greatlearning.student.repository.UserRepository;

@Service
public class DomainUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = this.userRepo.findByUsername(username).map(DomainUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Username entered."));
		System.out.println("User : " + user.getUsername());
		System.out.println("Roles : " + user.getAuthorities());
		return user;
	}

}
