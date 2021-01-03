package org.lieying.dao;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.JobHunterReport;

public interface JobHunterReportMapper {
    JobHunterReport selectJobHunterReportByJobHunterIdAndPositionId(@Param("job_hunter_id") Integer jobHunterId,
                                                                    @Param("position_id") Integer positionId);

    int updateJobHunterReport(@Param("job_hunter_report_reason") String reason,
                              @Param("job_hunter_report_footnote") String footnote,
                              @Param("job_hunter_report_evidence_screen_shot")
                                      String evidenceScreenShot,
                              @Param("job_hunter_id") Integer jobHunterId,
                              @Param("position_id") Integer positionId);

    int insertJobHunterReport(@Param("job_hunter_report_reason") String reason,
                              @Param("job_hunter_report_footnote") String footnote,
                              @Param("job_hunter_report_evidence_screen_shot")
                                      String evidenceScreenShot,
                              @Param("job_hunter_id") Integer jobHunterId,
                              @Param("position_id") Integer positionId);
}
