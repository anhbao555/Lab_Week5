package vn.edu.iuh.fit.lab_week_05.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab_week_05.backend.models.*;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.JobSkillRepository;

import java.util.*;

@Service
public class CandidateSkillService {
    @Autowired
    public CandidateSkillRepository candidateSkillRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;

    public List<Job> findJobByCandidateSkill(Skill candidateSkill) {
        Set<Job> jobs = new HashSet<>();
        for (JobSkill jobSkill : jobSkillRepository.findAll()) {
            if (jobSkill.getSkill().equals(candidateSkill)) {
                jobs.add(jobSkill.getJob());
            }
        }
        return new ArrayList<>(jobs); // Trả về danh sách nếu cần
    }
}
