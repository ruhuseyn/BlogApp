package rufethuseynov.blogapp.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rufethuseynov.blogapp.dto.dto.AdminReadByStatusDto;
import rufethuseynov.blogapp.dto.dto.CreateResponseDto;
import rufethuseynov.blogapp.dto.dto.EntityByIdDto;
import rufethuseynov.blogapp.dto.request.BlogSaveRequestDto;
import rufethuseynov.blogapp.dto.response.AdminBlogReadResponse;
import rufethuseynov.blogapp.service.serviceImpl.admin.AdminBlogDeleteService;
import rufethuseynov.blogapp.service.serviceImpl.admin.AdminBlogReadService;
import rufethuseynov.blogapp.service.serviceImpl.admin.AdminBlogSaveService;

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

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponseDto save(@RequestBody BlogSaveRequestDto dto) {
        return adminBlogSaveService.save(dto);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteBlog(@RequestBody EntityByIdDto dto){
        adminBlogDeleteService.deleteBlog(dto);
    }

    @PostMapping("/read-all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<AdminBlogReadResponse> readAll(@RequestBody AdminReadByStatusDto dto){
        return adminBlogReadService.readAll(dto);
    }
}
