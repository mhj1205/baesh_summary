package com.baesh.careersummary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.baesh.careersummary.dto.PortfolioRequest;
import com.baesh.careersummary.dto.SummaryResponse;
import com.baesh.careersummary.entity.CareerSummary;
import com.baesh.careersummary.repository.CareerSummaryRepository;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {

    private final CareerSummaryRepository repository;

    public SummaryService(CareerSummaryRepository repository) {
        this.repository = repository;
    }

    public SummaryResponse summarizePortfolio(PortfolioRequest request) {
        // ✅ 더미 요약 응답
        String responseJson = """
            {
              "jobSummary": "3년차 백엔드 개발자입니다.",
              "skillSummary": "Java, Spring, JPA 사용 가능.",
              "interestSummary": "AI 채용 자동화에 관심이 많습니다."
            }
        """;

        try {
            ObjectMapper mapper = new ObjectMapper();
            SummaryResponse summary = mapper.readValue(responseJson, SummaryResponse.class);

            // ✅ DB 저장
            CareerSummary entity = new CareerSummary();
            entity.setCareer(request.getCareer());
            entity.setSkills(request.getSkills());
            entity.setInterests(request.getInterests());
            entity.setJobSummary(summary.getJobSummary());
            entity.setSkillSummary(summary.getSkillSummary());
            entity.setInterestSummary(summary.getInterestSummary());

            repository.save(entity);

            return summary;

        } catch (Exception e) {
            throw new RuntimeException("요약 파싱/저장 실패", e);
        }
    }
}
