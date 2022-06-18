package com.example.springpracticeagain.service;

import com.example.springpracticeagain.entity.Street;
import com.example.springpracticeagain.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {
    @Autowired
    StreetRepository streetRepository;
    public Street saves (Street street){
        return streetRepository.save(street);
    }

    public List<Street> findAll (){
        return streetRepository.findAll();
    }
}
