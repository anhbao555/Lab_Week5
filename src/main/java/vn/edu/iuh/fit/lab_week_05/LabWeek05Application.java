package vn.edu.iuh.fit.lab_week_05;
import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.lab_week_05.backend.enums.SkillEnum;
import vn.edu.iuh.fit.lab_week_05.backend.models.*;
import vn.edu.iuh.fit.lab_week_05.backend.repositories.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class LabWeek05Application {
	public static void main(String[] args) {
		SpringApplication.run(LabWeek05Application.class, args);
	}
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private ExperienceRepository experienceRepository;
	@Autowired
	private CandidateSkillRepository candidateSkillRepository;
	@Autowired
	private JobSkillRepository jobSkillRepository;

	@Bean
	CommandLineRunner initData(){
		return args -> {
			Random rnd =new Random();
//			// Address And Candidate
//			for (int i = 1; i < 1000; i++) {
//				Address add = new Address(rnd.nextInt(1, 1000) + "", "Quang Trung", "HCM",
//						rnd.nextInt(70000, 80000) + "", CountryCode.VN);
//				addressRepository.save(add);
//
//				Candidate can = new Candidate("Name #" + i,
//						LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//						add,
//						rnd.nextLong(1111111111L, 9999999999L) + "",
//						"email_" + i + "@gmail.com");
//				candidateRepository.save(can);
//				System.out.println("Added: " + can);
//			}
//			// Company and Job
//			for (long j = 1; j < 20; j++) {
//				Company company = new Company("About #" + j,
//						"email_"+j+"@gmail.com", "Comp Name #" + j, rnd.nextLong(1111111111L,9999999999L)+"",
//						"http://company#" + j, addressRepository.getReferenceById(j));
//				companyRepository.save(company);
//				Job job = new Job("Description #" + j, "Job Name #" + j,company );
//				jobRepository.save(job);
//				System.out.println("Added: " + job);
//			}
//
//			// Skill
//			for (long k = 1; k < 10; k++) {
//				SkillEnum[] enumSkill = SkillEnum.values();
//				Skill skill = new Skill("Description #" + k, enumSkill[rnd.nextInt(enumSkill.length)].name(), Byte.parseByte(rnd.nextInt(3) + ""));
//				skillRepository.save(skill);
//			}
//			// Experience
//			for (long l = 1; l < 1000; l++) {
//				Experience experience = new Experience(LocalDate.of(rnd.nextInt(2010,2017),rnd.nextInt(1,13),rnd.nextInt(1,29)),
//						LocalDate.of(rnd.nextInt(2018,2024),rnd.nextInt(1,13),rnd.nextInt(1,29)), "Role #" + l, "Work Desc #" + l, "Company #" + l, candidateRepository.getReferenceById(l));
//				experienceRepository.save(experience);
//			}
			// Candidate_Skill
//			List<Candidate> candidates = candidateRepository.findTop50Candidates();
//			List<Skill> skills = skillRepository.findAll();
//			for (Candidate candidate : candidates) {
//				for (Skill skill : skills) {
//					CandidateSkillId id = new CandidateSkillId();
//					id.setCanId(skill.getId());
//					id.setSkillId(skill.getId());
//					CandidateSkill candidateSkill = new CandidateSkill(id, candidate, skill,
//							"Infos #" + (candidate.getId() + skill.getId()), Byte.parseByte(rnd.nextInt(3) + ""));
//					candidateSkillRepository.save(candidateSkill);
//				}
//			}
			// Job_Skill
//			List<Job> jobs = jobRepository.findAll();
//			List<Skill> jobSkills = skillRepository.findAll();
//			for (Job job : jobs) {
//				for (Skill skill : jobSkills) {
//					JobSkillId jobSkillId = new JobSkillId();
//					jobSkillId.setJobId(job.getId());
//					jobSkillId.setSkillId(skill.getId());
//					JobSkill jobSkill = new JobSkill(jobSkillId, job, skill,
//							"Infos #" + (job.getId() + skill.getId()), Byte.parseByte(rnd.nextInt(3) + ""));
//					jobSkillRepository.save(jobSkill);
//				}
//			}
		};
	}
}