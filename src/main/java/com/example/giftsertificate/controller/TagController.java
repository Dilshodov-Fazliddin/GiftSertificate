package com.example.giftsertificate.controller;

import com.example.giftsertificate.dto.CreatedTagDto;
import com.example.giftsertificate.entity.TagEntity;
import com.example.giftsertificate.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tag")
@RequiredArgsConstructor

public class TagController {

    private final TagService tagService;

    @RequestMapping("/addTag")
    @ResponseBody
    private String add(
        @RequestBody CreatedTagDto dto
    ){
        tagService.add(dto);
        return "Success";
    }

    @RequestMapping("/showTag")
    @ResponseBody
    private List<TagEntity>showTags(){
        return tagService.getAllTags();
    }

    @RequestMapping("/deleteTagById/{id}")
    @ResponseBody
    private String deleteTags(
            @PathVariable Long id
    ){
        tagService.deleteById(id);
        return "Success";
    }

    @GetMapping("/getTagByName")
    @ResponseBody
    private TagEntity getTagByName (
            @RequestParam String name
    ){
     return tagService.getByNameTags(name);
    }

}