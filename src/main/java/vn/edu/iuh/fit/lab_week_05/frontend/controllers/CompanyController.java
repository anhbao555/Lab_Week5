package vn.edu.iuh.fit.lab_week_05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab_week_05.backend.models.Job;
import vn.edu.iuh.fit.lab_week_05.backend.models.JobSkill;
import vn.edu.iuh.fit.lab_week_05.backend.models.JobSkillId;
import vn.edu.iuh.fit.lab_week_05.backend.models.Skill;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.JobRepository;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.lab_week_05.backend.services.JobService;
import vn.edu.iuh.fit.lab_week_05.backend.services.JobSkillService;

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

    @Autowired
    public SkillRepository skillRepository;

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

    @GetMapping("/add-job")
    public String showAddJobForm(Model model) {
        List<Skill> skills = skillRepository.findAll();
        model.addAttribute("skills", skills);
        return "companies/add-job";
    }

    @PostMapping("/submit-job")
    public String addJob(@RequestParam String jobName,
                         @RequestParam String jobDescription,
                         @RequestParam List<Long> jobSkills,
                         Model model) {
        // Tạo đối tượng Job từ dữ liệu form
        Job job = new Job();
        job.setJobName(jobName);
        job.setJobDesc(jobDescription);

        // Lưu công việc vào cơ sở dữ liệu
        jobRepository.save(job);
        System.out.println("Done 1");
        System.out.println(jobSkills);
        // Thêm các kỹ năng vào công việc
        for (Long skillId : jobSkills) {
            Skill skill = skillRepository.findById(skillId);
            if (skill != null ) {
                JobSkill jobSkill = new JobSkill();
                JobSkillId jobSkillId = new JobSkillId();

                jobSkillId.setJobId(job.getId()); // Gán jobId
                jobSkillId.setSkillId(skill.getId()); // Gán skillId

                jobSkill.setId(jobSkillId);
                jobSkill.setSkill(skill);
                jobSkill.setJob(job);
                // Gán mức độ kỹ năng ngẫu nhiên (từ 0 đến 2)
                byte skillLevel = (byte) (Math.random() * 3);
                jobSkill.setSkillLevel(skillLevel);

                jobSkillRepository.save(jobSkill);
            } else {
                // Nếu không tìm thấy skill, có thể log hoặc xử lý thêm
                System.out.println("Kỹ năng không tồn tại với ID: " + skillId);
            }
        }


        return "redirect:/post-job";
    }

}
