package com.example.springpracticeagain.controller;

import com.example.springpracticeagain.entity.Street;
import com.example.springpracticeagain.repository.StreetRepository;
import com.example.springpracticeagain.search.SearchCriteria;
import com.example.springpracticeagain.search.SearchCriteriaOperator;
import com.example.springpracticeagain.search.StreetSpecification;
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
        return ResponseEntity.ok(streetService.save(street));
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<?> findAll() {
//        return ResponseEntity.ok(streetRepository.findAll());
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(
            @RequestParam(defaultValue = "") String street,
            @RequestParam(defaultValue = "") String district) {

        Specification<Street> specification = Specification.where(null);

        if (street != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("status", SearchCriteriaOperator.EQUALS, street);
            StreetSpecification filter = new StreetSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (district != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("district", SearchCriteriaOperator.EQUALS, district);
            StreetSpecification filter = new StreetSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        List<Street> result = this.streetService.findAll(specification);
        return ResponseEntity.ok().body(result);
    }



}
