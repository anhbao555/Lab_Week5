package vn.edu.iuh.fit.lab_week_05.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab_week_05.backend.models.Job;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.JobRepository;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;


}
