package com.verizon.expenseapp.repositories;

import java.util.Optional;

import com.verizon.expenseapp.entities.User;

public interface UserRepository {

	Optional<User> findByName(String username);

}
