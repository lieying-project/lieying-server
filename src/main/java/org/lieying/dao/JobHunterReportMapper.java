package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.JobHunterReport;

import java.util.List;

public interface JobHunterReportMapper {
    JobHunterReport selectJobHunterReportByJobHunterIdAndPositionId(@Param("job_hunter_id") Integer jobHunterId,
                                                                    @Param("position_id") Integer positionId);

    int updateJobHunterReport(@Param("job_hunter_report_reason") String reason,
                              @Param("job_hunter_report_footnote") String footnote,
                              @Param("job_hunter_report_evidence_screen_shot")
                                      String evidenceScreenShot,
                              @Param("job_hunter_report_state")String state,
                              @Param("job_hunter_id") Integer jobHunterId,
                              @Param("position_id") Integer positionId,
     @Param("job_hunter_report_id")Integer jobHunterReportId);

    int insertJobHunterReport(@Param("job_hunter_report_reason") String reason,
                              @Param("job_hunter_report_footnote") String footnote,
                              @Param("job_hunter_report_evidence_screen_shot")
                                      String evidenceScreenShot,
                              @Param("job_hunter_id") Integer jobHunterId,
                              @Param("position_id") Integer positionId);
    List<JobHunterReport> selectAllJobHunterReports();

    List<JobHunterReport> selectJobHunterReportsByCriteria(
            @Param("position_name")String positionName,
            @Param("job_hunter_name")String jobHunterName,
            @Param("job_hunter_report_reason")String reportReason,
            @Param("job_hunter_report_state")String state
    );
}
