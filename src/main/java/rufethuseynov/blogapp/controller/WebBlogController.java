package rufethuseynov.blogapp.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rufethuseynov.blogapp.dto.dto.CreateResponseDto;
import rufethuseynov.blogapp.dto.dto.EntityByIdDto;
import rufethuseynov.blogapp.dto.request.ContactUserSaveRequestDto;
import rufethuseynov.blogapp.dto.response.BlogPageResponse;
import rufethuseynov.blogapp.dto.response.WebBlogReadByIdResponse;
import rufethuseynov.blogapp.service.web.WebBlogReadService;
import rufethuseynov.blogapp.service.web.WebBlogReadAllService;
import rufethuseynov.blogapp.service.web.WebContactUserSaveService;

@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/web")
public class WebBlogController {

    WebBlogReadAllService webBlogReadAllService;
    WebBlogReadService webBlogReadService;
    WebContactUserSaveService webContactUserSaveService;
    Logger logger = LoggerFactory.getLogger(WebBlogController.class);


    @GetMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public BlogPageResponse getAllBlogs(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count) {
        logger.info("getAll request accepted");
        return webBlogReadAllService.getAllBlogs(page, count);
    }

    @PostMapping("/read-by-id")
    @ResponseStatus(HttpStatus.OK)
    public WebBlogReadByIdResponse getBlogById(@RequestBody EntityByIdDto dto) {
        return webBlogReadService.getBlogById(dto);
    }

    @PostMapping("/contact/save")
    @ResponseStatus(HttpStatus.OK)
    public CreateResponseDto save(@RequestBody ContactUserSaveRequestDto dto){
        return webContactUserSaveService.save(dto);
    }
}
