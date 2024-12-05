package com.mgmetehan.hibernate_exercises.controller;

import com.mgmetehan.hibernate_exercises.dto.DeveloperDTO;
import com.mgmetehan.hibernate_exercises.model.inheritance.single.Developer;
import com.mgmetehan.hibernate_exercises.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
@RequiredArgsConstructor
public class DeveloperController {

    private  DeveloperService developerService;

    @PostMapping
    public Developer createDeveloper(@RequestBody DeveloperDTO developerDTO) {
        return developerService.saveDeveloper(developerDTO);
    }

    @GetMapping
    public List<DeveloperDTO> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }
}
