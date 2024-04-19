package rufethuseynov.blogapp.service.admin;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.request.AdminBlogFilterRequestDto;
import rufethuseynov.blogapp.dto.response.AdminBlogFilterResponse;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.mapper.BlogMapper;
import rufethuseynov.blogapp.repository.BlogRepository;
import rufethuseynov.blogapp.utility.BlogEntitySpecification;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AdminBlogFilterService {

    BlogRepository blogRepository;
    BlogMapper blogMapper;

    public List<AdminBlogFilterResponse> search(AdminBlogFilterRequestDto dto) {
        return blogRepository
                .findAll(BlogEntitySpecification.nameLikeAndDateBetween(dto.getName(),dto.getMin(),dto.getMax()))
                .stream().map(blogMapper::toAdminBlogFilterResponse).toList();
    }

}
