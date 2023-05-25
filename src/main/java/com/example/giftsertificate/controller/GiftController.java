package com.example.giftsertificate.controller;

import com.example.giftsertificate.dto.CreatedGiftDto;
import com.example.giftsertificate.entity.GiftEntity;
import com.example.giftsertificate.entity.TagEntity;
import com.example.giftsertificate.controller.exception.RequestValidationException;
import com.example.giftsertificate.repository.GiftRepository;
import com.example.giftsertificate.service.GiftService;
import com.example.giftsertificate.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gift")
@RequiredArgsConstructor
public class GiftController {
    private final GiftService giftService;
    private final GiftRepository giftRepository;
    private final TagService tagService;

    @PostMapping("/addGift")
    @ResponseBody
    private GiftEntity Add(
            @Valid @RequestBody CreatedGiftDto dto,
            BindingResult bindingResult
    ){

        if (bindingResult.hasErrors()){
            List<ObjectError>errorList=bindingResult.getAllErrors();
            throw new RequestValidationException(errorList);
        }
        return giftService.add(dto);
    }

    @GetMapping("/showGift")
    @ResponseBody
    private List<GiftEntity> show(){
        return giftService.giftEntities();
    }

    @PostMapping("/updateGiftById/{id}")
    @ResponseBody
    private String update(
            @PathVariable Long id,
            @RequestBody CreatedGiftDto dto
    ){
    giftService.update(dto,id);
    return "Success";
    }

    @PostMapping("/deleteGift/{id}")
    @ResponseBody
    private String deleteById(
        @PathVariable Long id
    ){
        giftService.deleteById(id);
        return "Success delete";
    }

    @GetMapping("/getGiftByName")
    @ResponseBody
    private List<GiftEntity> getGiftByName(
            @RequestParam String name
    ){
        return giftService.getByNameGift(name);
    }

    @GetMapping("/getByTags")
    @ResponseBody
    private List<GiftEntity>getGiftByTag(@RequestParam String name ){
        List<GiftEntity>getByTag;
        TagEntity tag = tagService.getByNameTags(name);
        getByTag=giftRepository.findGiftEntitiesByTagsContains(tag);
        return getByTag;
    }

    @GetMapping("/getAll")
    @ResponseBody
    private List<GiftEntity>getAll(
        @RequestParam(required = false,defaultValue = "",name="tag_name")String tag_name,
        @RequestParam(required = false,defaultValue = "",name="search")String search
    ){
        return giftService.getByTagNameAndSearch(tag_name,search);
    }
}
