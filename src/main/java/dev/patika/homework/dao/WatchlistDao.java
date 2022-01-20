package dev.patika.homework.dao;

import dev.patika.homework.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistDao extends JpaRepository<Watchlist,Long> {
}
