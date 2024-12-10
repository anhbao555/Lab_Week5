package vn.edu.iuh.fit.lab_week_05.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab_week_05.backend.models.Candidate;
import vn.edu.iuh.fit.lab_week_05.backend.models.CandidateSkill;
import vn.edu.iuh.fit.lab_week_05.backend.models.CandidateSkillId;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.CandidateSkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateSkillService {
    @Autowired
    public CandidateSkillRepository candidateSkillRepository;
    @Autowired
    private CandidateRepository candidateRepository;
}
