package com.example.giftsertificate.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @CreationTimestamp
    protected LocalDateTime createdDate;

    @CreationTimestamp
    protected LocalDateTime updatedDate;
}
