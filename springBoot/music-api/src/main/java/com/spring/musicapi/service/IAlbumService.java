package com.spring.musicapi.service;

import java.util.List;

import com.spring.musicapi.entity.Album;

public interface IAlbumService {
    List<Album> buscarTodos();
    void guardar(Album album);
    Album modificar(Album album);
    void eliminar(int id);
}
