package vn.edu.iuh.fit.lab_week_05.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", nullable = false)
    private Long id;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "role", length = 100)
    private String role;

    @Column(name = "work_desc", length = 400)
    private String workDesc;

    @Column(name = "company", length = 120)
    private String company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate can;

    public Experience(LocalDate fromDate, LocalDate toDate, String role, String workDesc, String company, Candidate candidate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.role = role;
        this.workDesc = workDesc;
        this.company = company;
        this.can = candidate;
    }
}