package com.webgram.repository;

import com.webgram.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long>
{
    //
}