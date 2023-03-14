package com.webgram.repository;

import com.webgram.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long>
{
    //
}
