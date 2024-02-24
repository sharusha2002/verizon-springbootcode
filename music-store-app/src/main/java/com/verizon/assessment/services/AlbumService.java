package com.verizon.assessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.assessment.entities.Album;
import com.verizon.assessment.repositories.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository albumRepository;
	
	public Iterable<Album> getallAlbums() {
		return albumRepository.findAll();
	}
	
	public Album createAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	public void deletealbum(Integer id) {
		albumRepository.deleteById(id);
	}
}
