package com.myprofile.myprofile.controllers;

import com.myprofile.myprofile.entities.Profile;
import com.myprofile.myprofile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getAll(){
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    @PostMapping("/save")
    public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(profileService.saveProfile(profile), HttpStatus.CREATED);
    }
}
