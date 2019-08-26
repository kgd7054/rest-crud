package com.gidae.restcrud.repository;

import com.gidae.restcrud.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
