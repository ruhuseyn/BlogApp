package rufethuseynov.blogapp.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rufethuseynov.blogapp.dto.response.BlogPageResponse;
import rufethuseynov.blogapp.service.WebBlogService;

@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/web")
public class WebBlogController {

    WebBlogService webBlogService;
    Logger logger = LoggerFactory.getLogger(WebBlogController.class);


    @GetMapping("/blogs")
    public BlogPageResponse getAllBlogs(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count) {
        logger.info("getAll request accepted");
        return webBlogService.getAllBlogs(page,count);
    }


}
