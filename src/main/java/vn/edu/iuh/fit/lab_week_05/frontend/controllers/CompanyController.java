package vn.edu.iuh.fit.lab_week_05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.lab_week_05.backend.models.Job;
import vn.edu.iuh.fit.lab_week_05.backend.services.JobService;

@Controller
public class CompanyController {
    @Autowired
    public JobService jobService;

    @GetMapping("/post-job")
    public String showJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "companies/post-job";
    }


}
