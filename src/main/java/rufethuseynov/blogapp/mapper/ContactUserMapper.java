package rufethuseynov.blogapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import rufethuseynov.blogapp.dto.request.ContactUserSaveRequestDto;
import rufethuseynov.blogapp.dto.response.WebContactUserReadAllResponse;
import rufethuseynov.blogapp.entity.ContactUserEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactUserMapper {

    ContactUserEntity toContactUserEntity(ContactUserSaveRequestDto dto);
    WebContactUserReadAllResponse toWebContactUserReadAllResponse(ContactUserEntity entity);
}
