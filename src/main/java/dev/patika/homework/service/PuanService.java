package dev.patika.homework.service;

import dev.patika.homework.dao.MemberDao;
import dev.patika.homework.dao.MovieDao;
import dev.patika.homework.dao.PuanDao;
import dev.patika.homework.model.Member;
import dev.patika.homework.model.Movie;
import dev.patika.homework.model.Puan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PuanService {
    private final PuanDao puanDao;
    private final MemberDao memberDao;
    private final MovieDao movieDao;

    public Optional<Puan> createPuan(Long movieId,Long memberId,Long puan){
        Member member=memberDao.getById(memberId);
        Movie movie=movieDao.getById(movieId);
        Puan puanN= Puan.builder().point(puan).member(member).movie(movie).build();

        return Optional.of(puanDao.save(puanN));

    }
}
