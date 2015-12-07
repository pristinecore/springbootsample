package com.mysample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mysample.springbootsample.config.RepositoryConfig;
import com.mysample.springbootsample.domain.Address;
import com.mysample.springbootsample.domain.User;
import com.mysample.springbootsample.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfig.class})
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	@Transactional
	public void testSaveUser() {
		User user = new User();
		user.setUsername("boh");
		user.setPassword("123456");
		
		Set<Address> addressSet = new HashSet<Address>(0);
		Address adminAddr1 = new Address();
		adminAddr1.setAddress1("Street Address 1-1");
		adminAddr1.setAddress2("Street Address 1-2");
		adminAddr1.setAddrCity("Los Angeles");
		adminAddr1.setAddrState("CA");
		adminAddr1.setZipCode("90001");
		adminAddr1.setUser(user);
		addressSet.add(adminAddr1);

		Address adminAddr2 = new Address();
		adminAddr2.setAddress1("Street Address 2-1");
		adminAddr2.setAddress2("Street Address 2-1");
		adminAddr2.setAddrCity("Los Angeles");
		adminAddr2.setAddrState("CA");
		adminAddr2.setZipCode("90002");
		adminAddr2.setUser(user);
		addressSet.add(adminAddr2);

		user.setAddressSet(addressSet);
		
		assertNull(user.getUserId());
		userRepository.save(user);
		assertNotNull(user.getUserId());
		
		User fetchedUser = userRepository.findOne(user.getUserId());
		
		assertNotNull(fetchedUser);
		assertEquals(user.getUserId(), fetchedUser.getUserId());
		
		System.out.println("TEST1: " + fetchedUser.getUsername());
		System.out.println("TEST2: " + fetchedUser.toString());
	}
}
