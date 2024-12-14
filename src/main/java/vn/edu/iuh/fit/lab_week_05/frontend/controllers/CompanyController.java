package vn.edu.iuh.fit.lab_week_05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.lab_week_05.backend.models.Job;
import vn.edu.iuh.fit.lab_week_05.backend.models.JobSkill;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.JobRepository;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.lab_week_05.backend.services.JobService;
import vn.edu.iuh.fit.lab_week_05.backend.services.JobSkillService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CompanyController {
    @Autowired
    public JobRepository jobRepository;
    @Autowired
    public JobService jobService;
    @Autowired
    public JobSkillRepository jobSkillRepository;

    @Autowired
    public JobSkillService jobSkillService;

    @GetMapping("/post-job")
    public String showJobForm(Model model) {
        List<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);

        Map<Job, List<JobSkill>> jobSkillsMap = new HashMap<>();
        for (Job job : jobs) {
            List<JobSkill> jobSkills = jobSkillRepository.findByJobId(job.getId());
            jobSkillsMap.put(job, jobSkills);
        }
        model.addAttribute("jobSkillsMap", jobSkillsMap);

        return "companies/post-job";
    }


}
