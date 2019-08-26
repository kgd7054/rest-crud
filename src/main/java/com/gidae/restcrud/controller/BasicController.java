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
import java.util.List;

@Controller
public class BasicController {

    private BasicService basicService;
    private ProfileService profileService;

    public BasicController(BasicService basicService, ProfileService profileService) {
        this.basicService = basicService;
        this.profileService = profileService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<Basic> basicList = basicService.findBasicAll();
        model.addAttribute("basics", basicList);

        List<Profile> profileList = profileService.findProfileAll();
        model.addAttribute("profiles", profileList);

        return "index";
    }

    @GetMapping("/basic/{idx}")
    public String read(@PathVariable Long idx, Model model){
        model.addAttribute("basic", basicService.findBasicByIdx(idx));
        return "item";
    }

    @PostMapping("/add")
    public String add(Basic basic, Model model){
        Basic saveBasic = basicService.save(basic);
        model.addAttribute("basic", basicService.findBasicByIdx(saveBasic.getIdx()));
        return "item";
    }

    @GetMapping("/basic/new")
    public String form(Basic basic){
        return "new";
    }

    @GetMapping("/basic/edit/{idx}")
    public String showUpdateform(@PathVariable("idx") Long idx, Model model){
        Basic basic = basicService.findBasicByIdx(idx);
        Profile profile = profileService.findProfileByIdx(idx);
        model.addAttribute("basic", basic);
        model.addAttribute("profile", profile);
        return "update";
    }

    @PostMapping("/basic/update/{idx}")
    public String updateBasic(@PathVariable("idx") Long idx, @Valid Basic basic, BindingResult result, Model model){
        if(result.hasErrors()){
            basic.setIdx(idx);
            return "update";
        }
        basicService.save(basic);
        model.addAttribute("basics", basicService.findBasicAll());
        model.addAttribute("profiles", profileService.findProfileAll());
        return "index";
    }

    @GetMapping("/basic/delete/{idx}")
    public String deleteBasic(@PathVariable("idx") Long idx, Model model){
        Basic basic = basicService.findBasicByIdx(idx);
        basicService.delete(basic);
        model.addAttribute("basics", basicService.findBasicAll());
        model.addAttribute("profiles", profileService.findProfileAll());
        return "index";
    }
}
