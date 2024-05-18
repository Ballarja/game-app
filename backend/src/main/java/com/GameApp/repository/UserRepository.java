package com.GameApp.repository;

import com.GameApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Integer> {
}
