package rufethuseynov.blogapp.service;

import rufethuseynov.blogapp.dto.dto.EntityByIdDto;
import rufethuseynov.blogapp.dto.response.BlogPageResponse;
import rufethuseynov.blogapp.dto.response.WebBlogReadByIdResponse;

public interface WebBlogService {

    BlogPageResponse getAllBlogs(int page, int count);
    WebBlogReadByIdResponse getBlogById(EntityByIdDto dto);
}
