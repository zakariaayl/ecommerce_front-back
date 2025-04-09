package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Customer;
import com.example.ecommerce.Repository.customerRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class myownUserDetailsService implements UserDetailsService {
  private final customerRepo customRepo;

  public myownUserDetailsService(customerRepo customRepo) {
    this.customRepo = customRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Customer customer= customRepo.findbyemail(email)
      .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    List<GrantedAuthority> grantedAuthorities=List.of(new SimpleGrantedAuthority(customer.getRole()));
    return new User(customer.getEmail(),customer.getPassword(),grantedAuthorities);

  }
}
