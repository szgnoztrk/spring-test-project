package dev.patika.homework.dao;

import dev.patika.homework.model.Puan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuanDao extends JpaRepository<Puan,Long> {
}
