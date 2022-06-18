package com.example.springpracticeagain.service;

import com.example.springpracticeagain.entity.District;
import com.example.springpracticeagain.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    public List<District> findAll() {
        return districtRepository.findAll();
    }
}
