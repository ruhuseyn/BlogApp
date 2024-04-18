package rufethuseynov.blogapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import rufethuseynov.blogapp.dto.dto.BlogPageDto;
import rufethuseynov.blogapp.dto.dto.BlogSaveDto;
import rufethuseynov.blogapp.dto.dto.WebBlogReadDto;
import rufethuseynov.blogapp.entity.BlogEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogMapper {

    BlogPageDto blogPageDto(BlogEntity entity);
    WebBlogReadDto toWebBlogReadDto(BlogEntity entity);
    BlogEntity toBlogEntity(BlogSaveDto dto);
}
