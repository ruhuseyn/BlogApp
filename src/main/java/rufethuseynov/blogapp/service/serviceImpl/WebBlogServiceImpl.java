package rufethuseynov.blogapp.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.dto.EntityByIdDto;
import rufethuseynov.blogapp.dto.dto.WebBlogReadDto;
import rufethuseynov.blogapp.dto.response.BlogPageResponse;
import rufethuseynov.blogapp.dto.response.WebBlogReadByIdResponse;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.entity.ImageEntity;
import rufethuseynov.blogapp.mapper.BlogMapper;
import rufethuseynov.blogapp.mapper.ImageMapper;
import rufethuseynov.blogapp.repository.BlogRepository;
import rufethuseynov.blogapp.repository.ImageRepository;
import rufethuseynov.blogapp.service.WebBlogService;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WebBlogServiceImpl implements WebBlogService {

    BlogRepository blogRepository;
    BlogMapper blogMapper;
    ImageRepository imageRepository;
    ImageMapper imageMapper;

    @Override
    public BlogPageResponse getAllBlogs(int page, int count) {
        Page<BlogEntity> userPage = blogRepository.findAll(PageRequest.of(page, count));

        return new BlogPageResponse(
                userPage.getContent().stream().map(blogMapper::blogPageDto).toList(),
                userPage.getTotalElements(),
                userPage.getTotalPages(),
                userPage.hasNext()
        );
    }

    @Override
    public WebBlogReadByIdResponse getBlogById(EntityByIdDto dto) {
        BlogEntity blogEntity = blogRepository.findById(dto.getId()).get();
        List<ImageEntity> imageList = imageRepository.findByFkBlogId(blogEntity.getId());

        return WebBlogReadByIdResponse
                .builder()
                .webBlogReadDto(blogMapper.toWebBlogReadDto(blogEntity))
                .webBlogReadByIdDtoList(imageList.stream().map(imageMapper::toWebBlogReadIdDto).toList())
                .build();
    }
}
