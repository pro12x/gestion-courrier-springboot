package com.webgram.repository;

import com.webgram.entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long>
{
    @Query("select task from Tache task where task.isArchived = false")
    List<Tache> getAllTache();

    @Query("select task from Tache task where task.isArchived = true")
    List<Tache> getAllTacheArchived();


}
