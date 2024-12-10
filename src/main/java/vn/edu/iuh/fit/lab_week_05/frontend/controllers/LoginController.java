package vn.edu.iuh.fit.lab_week_05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab_week_05.backend.models.Candidate;
import vn.edu.iuh.fit.lab_week_05.backend.models.CandidateSkill;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.CandidateSkillRepository;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    public CandidateRepository candidateRepository;
    @Autowired
    public CandidateSkillRepository candidateSkillRepository;

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
        for (Candidate candidate : candidates) {
            if (candidate.getFullName().equals(username) && "123".equals(password)) {
                model.addAttribute("candidate", candidate);
                model.addAttribute("candidateSkills", candidateSkillRepository.findByCanId(candidate.getId()));
                return "home";
            }
        }
        model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác");
        return "login"; // Quay lại trang đăng nhập nếu thất bại
    }
}
