package rufethuseynov.blogapp.service.serviceImpl.admin;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.dto.EntityByIdDto;
import rufethuseynov.blogapp.mapper.BlogMapper;
import rufethuseynov.blogapp.mapper.ImageMapper;
import rufethuseynov.blogapp.repository.BlogRepository;
import rufethuseynov.blogapp.repository.ImageRepository;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AdminBlogDeleteService {

    BlogRepository blogRepository;
    ImageRepository imageRepository;
    BlogMapper blogMapper;
    ImageMapper imageMapper;

    public void deleteBlog(EntityByIdDto dto){

    }
}
