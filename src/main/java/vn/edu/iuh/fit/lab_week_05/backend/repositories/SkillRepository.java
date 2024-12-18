package vn.edu.iuh.fit.lab_week_05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab_week_05.backend.models.Skill;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    Skill findById(Long id);
}
