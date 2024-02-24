package com.verizon.telecombilling.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.verizon.telecombilling.entities.UserIssue;

public interface UserIssueRepository extends CrudRepository<UserIssue, String> {

}
