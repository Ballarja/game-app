package com.GameApp.repository;

import com.GameApp.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
}
