package rufethuseynov.blogapp.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rufethuseynov.blogapp.dto.dto.EntityByIdDto;
import rufethuseynov.blogapp.dto.response.BlogPageResponse;
import rufethuseynov.blogapp.dto.response.WebBlogReadByIdResponse;
import rufethuseynov.blogapp.service.WebBlogService;

@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/web")
public class WebBlogController {

    WebBlogService webBlogService;
    Logger logger = LoggerFactory.getLogger(WebBlogController.class);


    @GetMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public BlogPageResponse getAllBlogs(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count) {
        logger.info("getAll request accepted");
        return webBlogService.getAllBlogs(page, count);
    }

    @PostMapping("/read-by-id")
    @ResponseStatus(HttpStatus.OK)
    public WebBlogReadByIdResponse getBlogById(@RequestBody EntityByIdDto dto) {
        return webBlogService.getBlogById(dto);
    }


}
