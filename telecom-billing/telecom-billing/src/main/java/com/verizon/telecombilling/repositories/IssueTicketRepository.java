package com.verizon.telecombilling.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.telecombilling.entities.IssueTicket;

@Repository
public interface IssueTicketRepository extends CrudRepository<IssueTicket, String> {

}
