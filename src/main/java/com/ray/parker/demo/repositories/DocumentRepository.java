package com.ray.parker.demo.repositories;


import com.ray.parker.demo.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RP on 25/01/18.
 */
public interface DocumentRepository extends JpaRepository<Document, String> {
}
