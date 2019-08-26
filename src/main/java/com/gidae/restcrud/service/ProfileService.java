package com.gidae.restcrud.service;

import com.gidae.restcrud.domain.Profile;
import com.gidae.restcrud.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> findProfileAll(){
        return profileRepository.findAll();
    }

    public Profile save(Profile profile){
        return profileRepository.save(profile);
    }

    public void delete(Profile profile){
        profileRepository.delete(profile);
    }

    public Profile findProfileByIdx(Long idx){
        return profileRepository.findById(idx).orElse(new Profile());
    }
}
