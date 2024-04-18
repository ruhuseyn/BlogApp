package rufethuseynov.blogapp.service;

import rufethuseynov.blogapp.dto.dto.CreateResponseDto;
import rufethuseynov.blogapp.dto.request.BlogSaveRequestDto;

public interface AdminBlogService {

    CreateResponseDto save(BlogSaveRequestDto dto);
}
