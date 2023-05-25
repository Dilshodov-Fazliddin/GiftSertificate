package com.example.giftsertificate.service;

import com.example.giftsertificate.dto.CreatedGiftDto;
import com.example.giftsertificate.entity.GiftEntity;
import com.example.giftsertificate.entity.TagEntity;
import com.example.giftsertificate.repository.GiftRepository;
import com.example.giftsertificate.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftService {
    private final GiftRepository giftRepository;
    private final ModelMapper modelMapper;
    private final TagRepository tagRepository;
    public GiftEntity add(CreatedGiftDto dto){
        GiftEntity gift=modelMapper.map(dto,GiftEntity.class);
      return giftRepository.save(gift);
    }

    public List<GiftEntity>giftEntities(){
        return giftRepository.findAll();
    }

    public void update(CreatedGiftDto dto,Long id){
        GiftEntity gift = giftRepository.getById(id);
        modelMapper.map(dto,gift);
        giftRepository.save(gift);
    }
    public void deleteById(Long id){
        giftRepository.deleteById(id);
    }
    public List<GiftEntity> getByNameGift(String name){
        return giftRepository.getByName(name);
    }

    public List<GiftEntity>getByTagNameAndSearch(String tagName,String searchWord){
          TagEntity tag = tagRepository.searchTagEntityByNameContainsIgnoreCase(tagName);
          return giftRepository
                  .findGiftCertificatesByTagsContainsAndNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(
                          tag, searchWord, searchWord, Sort.by(Sort.Order.asc("createdDate"))
                  );
      }
    }
