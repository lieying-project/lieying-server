package org.lieying.service;

import org.apache.ibatis.annotations.Param;
import org.lieying.bean.JobHunterReport;

import java.util.List;

public interface JobHunterReportService  {
    JobHunterReport queryJobHunterReportByJobHunterIdAndPositionId(int jobHunterId,int positionId);
    Boolean updateJobHunterReport(JobHunterReport jobHunterReport);
    Boolean addJobHunterReport(JobHunterReport jobHunterReport);
    List<JobHunterReport> queryAllJobHunterReports();
    List<JobHunterReport> queryJobHunterReportsByCriteria(String positionName,
                                                          String jobHunterName,
                                                          String reportReason,

                                                          String state);

}
