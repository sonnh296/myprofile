package com.myprofile.myprofile.reposoitories;

import com.myprofile.myprofile.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
