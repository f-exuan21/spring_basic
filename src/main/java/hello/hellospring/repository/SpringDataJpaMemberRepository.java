package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository를 상속하면 스프링 데이터 JPA가 SpringDataJpaMemberRepository를 자동으로 스프링 빈에 등록해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { //인터페이스는 확장할때 extends를 쓰며, 다중 상속이 된다.

    @Override
    Optional<Member> findByName(String name); //이름 규칙에 따라 셀렉트 문이 자동으로 생성된다.

}
