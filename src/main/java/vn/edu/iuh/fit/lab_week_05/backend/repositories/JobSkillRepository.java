package vn.edu.iuh.fit.lab_week_05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab_week_05.backend.models.JobSkill;
import vn.edu.iuh.fit.lab_week_05.backend.models.JobSkillId;

import java.util.List;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
    public List<JobSkill> findByJobId(Long jobId);
}
