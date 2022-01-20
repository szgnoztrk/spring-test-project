package dev.patika.homework.controller;

import dev.patika.homework.api.controller.MemberController;
import dev.patika.homework.model.Member;
import dev.patika.homework.model.Watchlist;
import dev.patika.homework.service.MemberService;
import dev.patika.homework.service.WatchlistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberControllerTest {
    @Mock
    MemberService memberService;

    @Mock
    WatchlistService watchlistService;

    @Mock
    List<Member> memberList;

    @InjectMocks
    MemberController memberController;

    @Test
    public void createMemberTest(){
        //given
        Member member = new Member();
        Optional<Member> expected = Optional.of(member);
        when(this.memberService.saveMember(any())).thenReturn(expected);
        //when
        Member actual = (Member) this.memberController.createMember(member).getBody();
        //then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.get(), actual)
        );
    }

    @Test
    void getAllMembersTest(){
        lenient().when(this.memberService.getAllMembers()).thenReturn(Optional.of(memberList));
    }

    @Test
    void getMemberByIdTest(){
        //given
        Member member = new Member();
        Optional<Member> optionalMember = memberList.stream().filter(o -> o.getId() == member.getId()).findFirst();
        lenient().when(this.memberService.getMemberById(anyLong())).thenReturn(optionalMember);

        assertAll( () -> assertNotNull(optionalMember) );
    }

    @Test
    public void createWatchListTest(){
        //given
        Watchlist watchlist = new Watchlist();
        Optional<Watchlist> expected = Optional.of(watchlist);
        when(this.watchlistService.createWatchlist(anyLong(), anyString())).thenReturn(expected);
        //when
        Watchlist actual = (Watchlist) this.memberController.createWatchList(anyLong(), anyString()).getBody();
        //then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.get(), actual)
        );
    }
}
