package com.verizon.assessment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.assessment.entities.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer>{

}
