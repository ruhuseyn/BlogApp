package rufethuseynov.blogapp.service.serviceImpl.admin;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.dto.EntityByIdDto;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.entity.ImageEntity;
import rufethuseynov.blogapp.exception.subexceptions.BlogNotFoundException;
import rufethuseynov.blogapp.mapper.BlogMapper;
import rufethuseynov.blogapp.mapper.ImageMapper;
import rufethuseynov.blogapp.repository.BlogRepository;
import rufethuseynov.blogapp.repository.ImageRepository;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AdminBlogDeleteService {

    BlogRepository blogRepository;
    ImageRepository imageRepository;

    public void deleteBlog(EntityByIdDto dto){
        BlogEntity entity = blogRepository.findById(dto.getId())
                .orElseThrow(()->new BlogNotFoundException("Blog is not found"));
        entity.setStatus("D");
        blogRepository.save(entity);

        List<ImageEntity> imageEntityList = imageRepository.findByFkBlogId(dto.getId());
        for(ImageEntity image: imageEntityList){
            image.setStatus("D");
            imageRepository.save(image);
        }
    }
}
