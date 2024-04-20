package rufethuseynov.blogapp.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rufethuseynov.blogapp.dto.dto.AdminReadByStatusDto;
import rufethuseynov.blogapp.dto.dto.CreateResponseDto;
import rufethuseynov.blogapp.dto.dto.EntityByIdDto;
import rufethuseynov.blogapp.dto.request.AdminBlogFilterRequestDto;
import rufethuseynov.blogapp.dto.request.BlogSaveRequestDto;
import rufethuseynov.blogapp.dto.response.AdminBlogFilterResponse;
import rufethuseynov.blogapp.dto.response.AdminBlogReadResponse;
import rufethuseynov.blogapp.service.admin.AdminBlogDeleteService;
import rufethuseynov.blogapp.service.admin.AdminBlogFilterService;
import rufethuseynov.blogapp.service.admin.AdminBlogReadService;
import rufethuseynov.blogapp.service.admin.AdminBlogSaveService;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/admin")
public class AdminBlogController {

    AdminBlogSaveService adminBlogSaveService;
    AdminBlogDeleteService adminBlogDeleteService;
    AdminBlogReadService adminBlogReadService;
    AdminBlogFilterService adminBlogFilterService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponseDto save(@RequestBody BlogSaveRequestDto dto) {
        return adminBlogSaveService.save(dto);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBlog(@RequestBody EntityByIdDto dto){
        adminBlogDeleteService.deleteBlog(dto);
    }

    @PostMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminBlogReadResponse> readAll(@RequestBody AdminReadByStatusDto dto){
        return adminBlogReadService.readAll(dto);
    }

    @PostMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminBlogFilterResponse> filterBlog(@RequestBody AdminBlogFilterRequestDto dto){
        return adminBlogFilterService.search(dto);
    }
}
