package com.example.giftsertificate.repository;

import com.example.giftsertificate.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.HTML;

@Repository
public interface TagRepository extends JpaRepository<TagEntity,Long> {
    TagEntity searchTagEntityByName(String name);
    TagEntity searchTagEntityByNameContainsIgnoreCase(String name);
}
