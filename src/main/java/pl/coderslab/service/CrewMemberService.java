package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.CrewMemberData;
import pl.coderslab.model.CrewMember;
import pl.coderslab.repository.CrewMemberRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class CrewMemberService {
    CrewMemberRepository crewMemberRepository;

    public void save(CrewMemberData crewMemberData) {
        if (!crewMemberRepository.existsCrewMemberByApiId(crewMemberData.get_id())) {
            CrewMember crewMember = new CrewMember();
            crewMember.setApiId(crewMemberData.get_id());
            crewMember.setName(crewMemberData.getName());
            crewMemberRepository.save(crewMember);
        }
    }

    public CrewMember findByApiId(String apiId) {
        return crewMemberRepository.findFirstByApiId(apiId);
    }

    public List<CrewMember> findAll() {
        return crewMemberRepository.findAll();
    }
}
