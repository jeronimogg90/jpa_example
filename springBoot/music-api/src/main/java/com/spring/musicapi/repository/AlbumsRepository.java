package com.spring.musicapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.musicapi.entity.Album;

public interface AlbumsRepository extends JpaRepository<Album, Integer>{
    
}
