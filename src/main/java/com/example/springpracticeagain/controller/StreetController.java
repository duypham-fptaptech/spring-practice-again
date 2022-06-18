package com.example.springpracticeagain.controller;

import com.example.springpracticeagain.entity.Street;
import com.example.springpracticeagain.repository.StreetRepository;
import com.example.springpracticeagain.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/streets")
public class StreetController {

    @Autowired
    StreetRepository streetRepository;

    final StreetService streetService;

    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Street street) {
        street.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.ok(streetService.saves(street));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(streetService.findAll());
    }
}
