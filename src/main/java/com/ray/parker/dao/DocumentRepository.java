package com.ray.parker.dao;


import com.ray.parker.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RP on 25/01/18.
 */
public interface DocumentRepository extends JpaRepository<Document, String> {

}
