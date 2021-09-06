package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.CrewMember;

@Repository
public interface CrewMemberRepository extends JpaRepository<CrewMember,Long> {

    CrewMember findFirstByApiId(String apiId);
    boolean existsCrewMemberByApiId(String apiId);
}
