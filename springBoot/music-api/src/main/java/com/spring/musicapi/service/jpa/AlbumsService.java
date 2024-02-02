package com.spring.musicapi.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.musicapi.entity.Album;
import com.spring.musicapi.repository.AlbumsRepository;
import com.spring.musicapi.service.IAlbumService;

@Service
public class AlbumsService implements IAlbumService{

    @Autowired
    private AlbumsRepository albumsRepository;

    @Override
    public List<Album> buscarTodos() {
        // TODO Auto-generated method stub
        return albumsRepository.findAll();
    }

    @Override
    public void guardar(Album album) {
        // TODO Auto-generated method stub
        albumsRepository.save(album);
    }

    @Override
    public Album modificar(Album album) {
        // TODO Auto-generated method stub
        return albumsRepository.save(album);
    }
    
    @Override
    public void eliminar(int id) {
        // TODO Auto-generated method stub
        albumsRepository.deleteById(id);
    }
}
