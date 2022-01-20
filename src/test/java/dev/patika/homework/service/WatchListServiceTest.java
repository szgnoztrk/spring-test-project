package dev.patika.homework.service;

import dev.patika.homework.dao.MemberDao;
import dev.patika.homework.dao.MovieDao;
import dev.patika.homework.dao.WatchlistDao;
import dev.patika.homework.model.Member;
import dev.patika.homework.model.Movie;
import dev.patika.homework.model.Watchlist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WatchListServiceTest {
    @Mock
    MemberDao memberDao;
    @Mock
    MovieDao movieDao;
    @Mock
    WatchlistDao watchlistDao;
    @InjectMocks
    WatchlistService watchlistService;

    @Test
    public void createWatchlistTest(){
        Member member = new Member();
        Watchlist watchlist = new Watchlist();
        lenient().when(this.memberDao.getById(anyLong())).thenReturn(member);
        lenient().when(this.watchlistDao.save(any())).thenReturn(watchlist);
    }

    @Test
    public void addMovieToWatchlistTest(){
        Movie movie = new Movie();
        Watchlist watchlist = new Watchlist();

        lenient().when(this.movieDao.getById(anyLong())).thenReturn(movie);
        lenient().when(this.watchlistDao.getById(anyLong())).thenReturn(watchlist);
        lenient().when(this.watchlistDao.save(any())).thenReturn(watchlist);
    }
}
