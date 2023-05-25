package com.example.giftsertificate.service;

import com.example.giftsertificate.dto.CreatedTagDto;
import com.example.giftsertificate.entity.TagEntity;
import com.example.giftsertificate.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TagService {
    private final TagRepository tagRepository;
    private final ModelMapper mapper;

    public int add(CreatedTagDto dto){
        TagEntity tagEntity=mapper.map(dto, TagEntity.class);
         tagRepository.save(tagEntity);
         return 1;
    }

    public List<TagEntity>getAllTags(){
        return tagRepository.findAll();
    }

    public void deleteById(Long id){
        tagRepository.deleteById(id);
    }

    public TagEntity getByNameTags(String name){
        return tagRepository.searchTagEntityByName(name);
    }
}
