package com.example.giftsertificate.repository;

import com.example.giftsertificate.entity.GiftEntity;
import com.example.giftsertificate.entity.TagEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends JpaRepository<GiftEntity,Long> {
    GiftEntity getById(Long id);

    List<GiftEntity> getByName(String name);
    List<GiftEntity>findGiftEntitiesByTagsContains(TagEntity tag);

    List<GiftEntity> findGiftCertificatesByTagsContainsAndNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(TagEntity tag, String name, String description, Sort sort);

    void deleteById(Long Long);

}
