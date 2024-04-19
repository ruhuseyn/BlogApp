package rufethuseynov.blogapp.utility;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import rufethuseynov.blogapp.entity.BlogEntity;

public class BlogEntitySpecification {

    public static Specification<BlogEntity> nameLikeAndDateBetween(String name, Long startDate, Long endDate) {
        return (Root<BlogEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
            Predicate datePredicate = criteriaBuilder.between(root.get("publishDate"), startDate, endDate);
            return criteriaBuilder.and(namePredicate, datePredicate);
        };
    }
}

