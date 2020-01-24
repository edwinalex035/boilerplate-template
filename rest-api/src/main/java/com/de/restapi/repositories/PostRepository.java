package com.de.restapi.repositories;

import com.de.restapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<User, Long> {

}
