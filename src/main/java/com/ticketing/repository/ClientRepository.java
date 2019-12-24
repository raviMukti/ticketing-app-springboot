package com.ticketing.repository;

import com.ticketing.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {

//    method find all client
    @Query("SELECT c FROM Client c")
    public List<Client> findAllClient();

//    method find by username
    @Query("SELECT c FROM Client c WHERE LOWER(c.userName) LIKE LOWER(:name)")
    public List<Client> findByName(@Param("name") String name);
}
