package rufethuseynov.blogapp.service.web;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.dto.CreateResponseDto;
import rufethuseynov.blogapp.dto.request.ContactUserSaveRequestDto;
import rufethuseynov.blogapp.entity.ContactUserEntity;
import rufethuseynov.blogapp.mapper.ContactUserMapper;
import rufethuseynov.blogapp.repository.ContactUserRepository;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WebContactUserSaveService {

    ContactUserRepository contactUserRepository;
    ContactUserMapper contactUserMapper;

    public CreateResponseDto save(ContactUserSaveRequestDto dto){
        ContactUserEntity entity = contactUserMapper.toContactUserEntity(dto);
        entity.setStatus("A");
        contactUserRepository.save(entity);
        return CreateResponseDto.builder().id(entity.getId()).build();
    }
}
