package com.baesh.careersummary.repository;

import com.baesh.careersummary.entity.CareerSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerSummaryRepository extends JpaRepository<CareerSummary, Long> {
}
