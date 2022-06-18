package com.example.springpracticeagain.controller;

import com.example.springpracticeagain.entity.District;
import com.example.springpracticeagain.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/districts")
public class DistrictController {
    @Autowired
    DistrictRepository districtRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<District> districtList = this.districtRepository.findAll();
        return ResponseEntity.ok().body(districtList);
    }
}
