package com.webgram.repository;

import com.webgram.entity.Nature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureRepository extends JpaRepository<Nature, Long>
{
    //
}