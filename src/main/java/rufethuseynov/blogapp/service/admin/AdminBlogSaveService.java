package rufethuseynov.blogapp.service.admin;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.dto.CreateResponseDto;
import rufethuseynov.blogapp.dto.request.BlogSaveRequestDto;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.entity.ImageEntity;
import rufethuseynov.blogapp.mapper.BlogMapper;
import rufethuseynov.blogapp.mapper.ImageMapper;
import rufethuseynov.blogapp.repository.BlogRepository;
import rufethuseynov.blogapp.repository.ImageRepository;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AdminBlogSaveService {

    BlogRepository blogRepository;
    ImageRepository imageRepository;
    BlogMapper blogMapper;
    ImageMapper imageMapper;

    public CreateResponseDto save(BlogSaveRequestDto dto) {
        BlogEntity blogEntity = blogMapper.toBlogEntity(dto.getBlogSaveDto());
        blogEntity.setViewCount(0L);
        blogEntity.setStatus("A");
        blogRepository.save(blogEntity);
        List<ImageEntity> imageEntityList = dto.getImageSaveDtoList().stream().map(imageMapper::toImageEntity).toList();
        for(ImageEntity imageEntity: imageEntityList){
            imageEntity.setFkBlogId(blogEntity.getId());
            imageEntity.setIsCover("0");
            imageEntity.setStatus("A");
            imageRepository.save(imageEntity);
        }
        return CreateResponseDto.builder().id(blogEntity.getId()).build();
    }
}
