package vn.edu.iuh.fit.lab_week_05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab_week_05.backend.models.*;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.*;
import vn.edu.iuh.fit.lab_week_05.backend.services.*;

import java.util.*;

@Controller
public class LoginController {
    @Autowired
    public CandidateRepository candidateRepository;
    @Autowired
    public CandidateService candidateService;
    @Autowired
    public CandidateSkillRepository candidateSkillRepository;
    @Autowired
    public CandidateSkillService candidateSkillService;
    @Autowired
    public JobRepository jobRepository;
    @Autowired
    public JobService jobService;
    @Autowired
    public JobSkillRepository jobSkillRepository;
    @Autowired
    public JobSkillService jobSkillService;
    @Autowired
    public SkillRepository skillRepository;
    @Autowired
    public SkillService skillService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model) {
        // Kiểm tra thông tin đăng nhập
        List<Candidate> candidates = candidateRepository.findAll();

        List<Skill> skills = skillRepository.findAll();
        model.addAttribute("skills", skills);
        for (Candidate candidate : candidates) {
            if (candidate.getFullName().equals(username) && "123".equals(password)) {
                model.addAttribute("candidate", candidate);

                List<CandidateSkill> candidateSkills = candidateSkillRepository.findByCanId(candidate.getId());
                model.addAttribute("candidateSkills", candidateSkills);

                List<Skill> candidateSkillList = candidateSkills.stream()
                        .map(CandidateSkill::getSkill)
                        .toList();

                List<Skill> missingSkills = skillService.getMissingSkills(candidateSkillList);
                model.addAttribute("missingSkills", missingSkills);

                Set<Job> jobSet = new HashSet<>();
                for (CandidateSkill candidateSkill : candidateSkills) {
                    List<Job> filter = candidateSkillService.findJobByCandidateSkill(candidateSkill.getSkill());
                    jobSet.addAll(filter);
                }
                List<Job> jobs = new ArrayList<>(jobSet);
                model.addAttribute("jobs", jobs);

                Map<Job, List<JobSkill>> jobSkillsMap = new HashMap<>();
                for (Job job : jobs) {
                    List<JobSkill> jobSkills = jobSkillRepository.findByJobId(job.getId());
                    jobSkillsMap.put(job, jobSkills);
                }
                model.addAttribute("jobSkillsMap", jobSkillsMap);

                return "home";
            }
        }
        model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác");
        return "login"; // Quay lại trang đăng nhập nếu thất bại
    }
}
