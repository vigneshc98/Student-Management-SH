package org.vtech.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.vtech.entity.Admins;
import org.vtech.repository.AdminRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Admins user = adminRepo.findByName(username).orElseThrow(()-> new RuntimeException("not found"));
		
		System.out.println("USER:"+user);
		
		return user;
	}

}
