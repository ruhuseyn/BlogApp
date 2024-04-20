package rufethuseynov.blogapp.service.web;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.response.BlogPageResponse;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.mapper.BlogMapper;
import rufethuseynov.blogapp.repository.BlogRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WebBlogReadAllService {

    BlogRepository blogRepository;
    BlogMapper blogMapper;

    public BlogPageResponse getAllBlogs(int page, int count) {
        Page<BlogEntity> userPage = blogRepository.findAll(PageRequest.of(page, count));
        List<BlogEntity> blogEntityList = new ArrayList<>();
        for(BlogEntity entity: userPage.getContent()){
            if(entity.getStatus().equals("A")){
                blogEntityList.add(entity);
            }
        }

        return new BlogPageResponse(
                blogEntityList.stream().map(blogMapper::blogPageDto).toList(),
                userPage.getTotalElements(),
                userPage.getTotalPages(),
                userPage.hasNext()
        );
    }
}
