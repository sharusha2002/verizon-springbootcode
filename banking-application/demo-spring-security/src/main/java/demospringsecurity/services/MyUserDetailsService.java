package demospringsecurity.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demospringsecurity.entities.User;
import demospringsecurity.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<User> user = repo.findByName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("User name not found"+username)); 
		return user.map(MyUserDetails::new).get();
	}
	
	public Iterable<User> getAllUsers() {
		return repo.findAll();
	}
	
	
	public Optional<User> getUserById(Integer id) {
		return repo.findById(id);
	}
	
	


}
