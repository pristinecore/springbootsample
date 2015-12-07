package com.mysample.springbootsample.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mysample.springbootsample.domain.UserRole;

@Repository
@Qualifier(value = "userRoleRepository")
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

}
