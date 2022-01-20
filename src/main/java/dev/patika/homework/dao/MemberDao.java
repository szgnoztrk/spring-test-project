package dev.patika.homework.dao;

import dev.patika.homework.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MemberDao extends JpaRepository<Member,Long> {

}
