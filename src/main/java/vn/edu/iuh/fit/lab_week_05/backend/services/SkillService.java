package vn.edu.iuh.fit.lab_week_05.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.SkillRepository;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;
}