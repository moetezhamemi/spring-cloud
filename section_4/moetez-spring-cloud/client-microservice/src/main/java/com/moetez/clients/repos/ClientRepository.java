package com.moetez.clients.repos;
import com.moetez.clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client, Long>  {
}
