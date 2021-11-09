package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repostiory = new MemoryMemberRepository();

    @AfterEach //모든 각각 클래스가 끝나고 호출됨
    public void afterEach() {
        repostiory.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repostiory.save(member);
        Member result = repostiory.findById(member.getId()).get(); //optional로 리턴할 때, get()으로 한 번 까서 하나만 값을 꺼낸다.
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repostiory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repostiory.save(member2);

        Member result = repostiory.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repostiory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repostiory.save(member2);
        
        List<Member> result = repostiory.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
