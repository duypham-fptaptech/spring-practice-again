package com.example.springpracticeagain.search;

import com.example.springpracticeagain.entity.Street;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class StreetSpecification implements Specification<Street> {
    private SearchCriteria searchCriteria;

    public StreetSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria =searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Street> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        switch (searchCriteria.getOperator()) {
            case EQUALS:
                return criteriaBuilder.equal(
                        root.get(searchCriteria.getKey()),
                        searchCriteria.getValue());
        }
        return null;
    }

    public static void main(String[] args) {
        Specification<Street> specification = Specification.where(null);

        SearchCriteria searchCriteria1 = new SearchCriteria(
                "name",
                SearchCriteriaOperator.EQUALS,
                "0");
        StreetSpecification spec1 = new StreetSpecification(searchCriteria1);
        specification = specification.and(spec1);

        SearchCriteria searchCriteria2 = new SearchCriteria(
                "district",
                SearchCriteriaOperator.EQUALS,
                "1");
        StreetSpecification spec2 = new StreetSpecification(searchCriteria2);
        specification = specification.and(spec2);


    }
}
