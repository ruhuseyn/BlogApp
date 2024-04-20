package rufethuseynov.blogapp.service.web;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import rufethuseynov.blogapp.dto.request.ContactUserReadAllRequestDto;
import rufethuseynov.blogapp.dto.response.WebContactUserReadAllResponse;
import rufethuseynov.blogapp.mapper.ContactUserMapper;
import rufethuseynov.blogapp.repository.ContactUserRepository;
import rufethuseynov.blogapp.utility.EntitySpecification;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WebContactUserReadAllService {

    ContactUserRepository contactUserRepository;
    ContactUserMapper contactUserMapper;

    public List<WebContactUserReadAllResponse> readAll(ContactUserReadAllRequestDto dto){
       return contactUserRepository
                .findAll(EntitySpecification.nameLikeAndEmailLikeAndPhoneNumber(dto.getName(), dto.getEmail(), dto.getPhoneNumber()))
               .stream().map(contactUserMapper::toWebContactUserReadAllResponse).toList();
    }
}
