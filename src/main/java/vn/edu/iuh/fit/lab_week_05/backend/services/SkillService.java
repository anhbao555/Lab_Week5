package vn.edu.iuh.fit.lab_week_05.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab_week_05.backend.models.Skill;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.SkillRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    public List<Skill> getMissingSkills(List<Skill> candidateSkills) {
        // Lấy tất cả các kỹ năng
        List<Skill> allSkills = skillRepository.findAll();
        // Lọc ra các kỹ năng không thuộc danh sách kỹ năng của ứng viên
        return allSkills.stream()
                .filter(skill -> !candidateSkills.contains(skill))
                .toList();
    }
}
