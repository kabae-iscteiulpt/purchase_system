package com.kacompany.purchase_system.purchase_system.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kacompany.purchase_system.purchase_system.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findById(Long userId);

}
