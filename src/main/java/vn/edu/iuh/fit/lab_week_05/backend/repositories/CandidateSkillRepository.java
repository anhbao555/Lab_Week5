package vn.edu.iuh.fit.lab_week_05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab_week_05.backend.models.CandidateSkill;
import vn.edu.iuh.fit.lab_week_05.backend.models.CandidateSkillId;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Long> {
    List<CandidateSkill> findByCanId(Long candidateId);
}
