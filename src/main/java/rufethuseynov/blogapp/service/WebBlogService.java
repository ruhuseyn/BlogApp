package rufethuseynov.blogapp.service;

import rufethuseynov.blogapp.dto.response.BlogPageResponse;

public interface WebBlogService {

    BlogPageResponse getAllBlogs(int page, int count);
}
