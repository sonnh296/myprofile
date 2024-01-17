package com.myprofile.myprofile.service;

import com.myprofile.myprofile.entities.Profile;
import com.myprofile.myprofile.reposoitories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile getProfileById(int id) {
        return profileRepository.findById(id).orElse(null);
    }

    public void deleteProfileById(int id) {
        profileRepository.deleteById(id);
    }

    public void updateProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}
