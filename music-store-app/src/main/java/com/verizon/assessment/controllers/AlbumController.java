package com.verizon.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.assessment.entities.Album;
import com.verizon.assessment.services.AlbumService;

@RestController
public class AlbumController {
	
	@Autowired
	AlbumService albumService;
	
	@GetMapping("/allalbums")
	public Iterable<Album> getallAlbums() {
		return albumService.getallAlbums();
	}
	
	@PostMapping("/albums")
	public Album createAlbum(@RequestBody Album album) {
		return albumService.createAlbum(album);
	}
	
	@DeleteMapping("/albums/{id}")
	public void deletealbum(@PathVariable Integer id) {
		albumService.deletealbum(id);
	}

	
	

}
