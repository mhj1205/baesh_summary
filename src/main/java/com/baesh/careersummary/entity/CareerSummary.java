package com.baesh.careersummary.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CareerSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String career;
    private String skills;
    private String interests;

    private String jobSummary;
    private String skillSummary;
    private String interestSummary;

    private LocalDateTime createdAt = LocalDateTime.now();

    // --- Getters and Setters ---
    public Long getId() { return id; }

    public String getCareer() { return career; }
    public void setCareer(String career) { this.career = career; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getInterests() { return interests; }
    public void setInterests(String interests) { this.interests = interests; }

    public String getJobSummary() { return jobSummary; }
    public void setJobSummary(String jobSummary) { this.jobSummary = jobSummary; }

    public String getSkillSummary() { return skillSummary; }
    public void setSkillSummary(String skillSummary) { this.skillSummary = skillSummary; }

    public String getInterestSummary() { return interestSummary; }
    public void setInterestSummary(String interestSummary) { this.interestSummary = interestSummary; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
