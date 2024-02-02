package com.spring.musicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.musicapi.entity.Album;
import com.spring.musicapi.service.IAlbumService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/albums")
public class AlbumsController {
    
    @Autowired
    private IAlbumService albumService;

    @GetMapping("/")
    public List<Album> buscarTodos() {
        return albumService.buscarTodos();
    }

    @PostMapping("/")
    public void guardar(@RequestBody Album album) {
        albumService.guardar(album);
    }

    @PutMapping("/")
    public Album modificar(@RequestBody Album album) {
        return albumService.modificar(album);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        albumService.eliminar(id);
    }
    

}
