package rufethuseynov.blogapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import rufethuseynov.blogapp.dto.dto.AdminImageReadDto;
import rufethuseynov.blogapp.dto.dto.ImageSaveDto;
import rufethuseynov.blogapp.dto.dto.WebBlogReadImageDto;
import rufethuseynov.blogapp.entity.ImageEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ImageMapper {

    WebBlogReadImageDto toWebBlogReadIdDto(ImageEntity imageEntity);
    ImageEntity toImageEntity(ImageSaveDto imageSaveDto);
    AdminImageReadDto toAdminImageReadDto(ImageEntity entity);
}
