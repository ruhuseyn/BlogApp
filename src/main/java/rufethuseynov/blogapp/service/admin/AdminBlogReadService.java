package rufethuseynov.blogapp.service.admin;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.dto.AdminBlogReadDto;
import rufethuseynov.blogapp.dto.dto.AdminReadByStatusDto;
import rufethuseynov.blogapp.dto.response.AdminBlogReadResponse;
import rufethuseynov.blogapp.entity.BlogEntity;
import rufethuseynov.blogapp.entity.ImageEntity;
import rufethuseynov.blogapp.mapper.BlogMapper;
import rufethuseynov.blogapp.mapper.ImageMapper;
import rufethuseynov.blogapp.repository.BlogRepository;
import rufethuseynov.blogapp.repository.ImageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AdminBlogReadService {
    BlogRepository blogRepository;
    ImageRepository imageRepository;
    BlogMapper blogMapper;
    ImageMapper imageMapper;

    public List<AdminBlogReadResponse> readAll(AdminReadByStatusDto dto){
        List<AdminBlogReadResponse> response = new ArrayList<>();
        List<BlogEntity> blogEntityList = blogRepository.findAllByStatus(dto.getStatus());
        for(BlogEntity entity: blogEntityList){
            List<ImageEntity> imageEntityList = imageRepository.findByFkBlogId(entity.getId());
            AdminBlogReadResponse adminBlogReadResponse = AdminBlogReadResponse
                    .builder()
                    .adminBlogReadDto(blogMapper.toAdminBlogReadDto(entity))
                    .adminImageReadDtoList(imageEntityList.stream().map(imageMapper::toAdminImageReadDto).toList())
                    .build();
            response.add(adminBlogReadResponse);
        }
        return response;
    }
}
