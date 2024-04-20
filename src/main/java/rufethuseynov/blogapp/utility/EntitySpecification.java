package rufethuseynov.blogapp.utility;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.validator.internal.util.Contracts;
import org.springframework.data.jpa.domain.Specification;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.entity.ContactUserEntity;

public class EntitySpecification {

    public static Specification<BlogEntity> nameLikeAndDateBetween(String name, Long startDate, Long endDate) {
        return (Root<BlogEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
            Predicate datePredicate = criteriaBuilder.between(root.get("publishDate"), startDate, endDate);
            return criteriaBuilder.and(namePredicate, datePredicate);
        };
    }

    public static Specification<ContactUserEntity> nameLikeAndEmailLikeAndPhoneNumber(String name, String email, String phoneNumber) {
        return (Root<ContactUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
            Predicate emailPredicate = criteriaBuilder.like(root.get("name"), "%" + email + "%");
            Predicate phonePredicate = criteriaBuilder.like(root.get("name"), "%" + phoneNumber + "%");
            return criteriaBuilder.and(namePredicate, emailPredicate, phonePredicate);
        };
    }
}

