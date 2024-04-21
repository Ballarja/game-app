package com.GameApp.repository;

import com.GameApp.model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository <RegistrationModel, Integer> {
}
