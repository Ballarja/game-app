package com.GameApp.repository;

import com.GameApp.model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface RegistrationRepository extends JpaRepository <RegistrationModel, UUID> {
    Optional<RegistrationModel> findByEmail(String email);
}
