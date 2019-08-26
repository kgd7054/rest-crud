package com.gidae.restcrud.controller;

import com.gidae.restcrud.domain.Basic;
import com.gidae.restcrud.domain.Profile;
import com.gidae.restcrud.service.BasicService;
import com.gidae.restcrud.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class ProfileController {

    private ProfileService profileService;
    private BasicService basicService;

    public ProfileController(ProfileService profileService, BasicService basicService) {
        this.profileService = profileService;
        this.basicService = basicService;
    }

    @GetMapping("/profile/{idx}")
    public String read(@PathVariable Long idx, Model model){
        model.addAttribute("profile", profileService.findProfileByIdx(idx));
        return "item2";
    }

    @PostMapping("/add2")
    public String add(Profile profile, Model model){
        profile.setCreateDat(LocalDateTime.now());
        Profile saveProfile = profileService.save(profile);
        model.addAttribute("profile", profileService.findProfileByIdx(saveProfile.getIdx()));
        return "item2";
    }

    @GetMapping("/profile/new")
    public String form(Profile profile){
        return "new2";
    }

    @GetMapping("/profile/edit/{idx}")
    public String showUpdateform(@PathVariable("idx") Long idx, Model model){
        Basic basic = basicService.findBasicByIdx(idx);
        Profile profile = profileService.findProfileByIdx(idx);
        model.addAttribute("basic", basic);
        model.addAttribute("profile", profile);
        return "update2";
    }

    @PostMapping("/profile/update/{idx}")
    public String updateProfile(@PathVariable("idx") Long idx, @Valid Profile profile, BindingResult result, Model model){
        if(result.hasErrors()){
            profile.setIdx(idx);
            return "update2";
        }
        profileService.save(profile);
        model.addAttribute("basics", basicService.findBasicAll());
        model.addAttribute("profiles", profileService.findProfileAll());
        return "index";
    }

    @GetMapping("/profile/delete/{idx}")
    public String deleteProfile(@PathVariable("idx") Long idx, Model model){
        Profile profile = profileService.findProfileByIdx(idx);
        profileService.delete(profile);
        model.addAttribute("basics", basicService.findBasicAll());
        model.addAttribute("profiles", profileService.findProfileAll());
        return "index";
    }
}
