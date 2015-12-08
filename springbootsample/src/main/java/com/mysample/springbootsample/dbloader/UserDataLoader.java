/*******************************************************************************
 * Copyright 2015 Brient Oh @ Pristine Core
 * boh@pristinecore.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.mysample.springbootsample.dbloader;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mysample.springbootsample.domain.Address;
import com.mysample.springbootsample.domain.User;
import com.mysample.springbootsample.domain.UserRole;
import com.mysample.springbootsample.repository.UserRepository;
import com.mysample.springbootsample.repository.UserRoleRepository;

@Component
public class UserDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private Logger logger = Logger.getLogger(UserDataLoader.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("123456");
		admin.setFirstName("Foo");
		admin.setLastName("Bar");
		
		Set<Address> addressSet = new HashSet<Address>(0);
		Address adminAddr1 = new Address();
		adminAddr1.setAddress1("Street Address 1-1");
		adminAddr1.setAddress2("Street Address 1-2");
		adminAddr1.setAddrCity("Los Angeles");
		adminAddr1.setAddrState("CA");
		adminAddr1.setZipCode("90001");
		adminAddr1.setUser(admin);
		addressSet.add(adminAddr1);

		Address adminAddr2 = new Address();
		adminAddr2.setAddress1("Street Address 2-1");
		adminAddr2.setAddress2("Street Address 2-1");
		adminAddr2.setAddrCity("Los Angeles");
		adminAddr2.setAddrState("CA");
		adminAddr2.setZipCode("90002");
		adminAddr2.setUser(admin);
		addressSet.add(adminAddr2);
		
		UserRole adminRole = new UserRole();
		adminRole.setUserRoleName("Administrator");
		adminRole.setUser(admin);
		Set<UserRole> adminRoles = new HashSet<UserRole>(0);
		adminRoles.add(adminRole);

		admin.setAddressSet(addressSet);
		admin.setUserRoles(adminRoles);
		
		userRepository.save(admin);
		logger.debug("Saved admin ID: " + admin.getUserId());
		

		User user1 = new User();
		user1.setUsername("johndoe");
		user1.setPassword("123456");
		user1.setFirstName("John");
		user1.setLastName("Doe");

		UserRole userRole = new UserRole();
		userRole.setUserRoleName("User");
		userRole.setUser(user1);
		Set<UserRole> userRoles = new HashSet<UserRole>(0);
		userRoles.add(userRole);
		
		user1.setUserRoles(userRoles);
		
		userRepository.save(user1);
		logger.debug("Saved user1 ID: " + user1.getUserId());
		
	}

}
