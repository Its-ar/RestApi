package nutech.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nutech.restapi.Entities.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

}
