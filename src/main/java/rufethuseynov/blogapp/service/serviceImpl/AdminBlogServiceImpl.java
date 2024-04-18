package rufethuseynov.blogapp.service.serviceImpl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.dto.CreateResponseDto;
import rufethuseynov.blogapp.dto.request.BlogSaveRequestDto;
import rufethuseynov.blogapp.repository.BlogRepository;
import rufethuseynov.blogapp.repository.ImageRepository;
import rufethuseynov.blogapp.service.AdminBlogService;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AdminBlogServiceImpl implements AdminBlogService {

    BlogRepository blogRepository;
    ImageRepository imageRepository;

    @Override
    public CreateResponseDto save(BlogSaveRequestDto dto) {
        return null;
    }
}
