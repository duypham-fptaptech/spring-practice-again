package com.example.springpracticeagain.service;

import com.example.springpracticeagain.search.SearchCriteria;
import com.example.springpracticeagain.search.SearchCriteriaOperator;
import com.example.springpracticeagain.search.SearchStreet;
import com.example.springpracticeagain.entity.Street;
import com.example.springpracticeagain.repository.StreetRepository;
import com.example.springpracticeagain.search.StreetSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {
    @Autowired
    final StreetRepository streetRepository;

    public StreetService(StreetRepository streetRepository){
        this.streetRepository = streetRepository;
    }

    public List<Street> findAll(SearchStreet searchStreet){
        Specification<Street> specification= Specification.where(null);
        if (searchStreet.getStreetName() != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("street", SearchCriteriaOperator.EQUALS, searchStreet.getStreetName());
            StreetSpecification filter = new StreetSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        if (searchStreet.getDistrictName() != null) {
            SearchCriteria searchCriteria
                    = new SearchCriteria("district", SearchCriteriaOperator.EQUALS, searchStreet.getDistrictName());
            StreetSpecification filter = new StreetSpecification(searchCriteria);
            specification = specification.and(filter);
        }
        return streetRepository.findAll(
                specification);
    }

    public List<Street> findAll(
                               Specification<Street> streetSpecification) {
        return streetRepository.findAll(
                streetSpecification);
    }

    public Street save (Street street){
        return streetRepository.save(street);
    }
}
