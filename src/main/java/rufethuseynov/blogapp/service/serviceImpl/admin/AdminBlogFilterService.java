package rufethuseynov.blogapp.service.serviceImpl.admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.request.AdminBlogFilterRequestDto;
import rufethuseynov.blogapp.dto.response.AdminBlogFilterResponse;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.mapper.BlogMapper;
import rufethuseynov.blogapp.repository.BlogRepository;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AdminBlogFilterService {

    BlogRepository blogRepository;
    BlogMapper blogMapper;

    public List<AdminBlogFilterResponse> filterBlog(AdminBlogFilterRequestDto dto){
        List<BlogEntity> response = blogRepository.findByNameContainingIgnoreCaseAndPublishDateBetween(
                dto.getNameKeyword(), dto.getMinPublishDate(), dto.getMaxPublishDate());
        return response.stream().map(blogMapper::toAdminBlogFilterResponse).toList();
    }

}
