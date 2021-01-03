package org.lieying.service;

import org.lieying.bean.JobHunterReport;

public interface JobHunterReportService  {
    JobHunterReport queryJobHunterReportByJobHunterIdAndPositionId(int jobHunterId,int positionId);
    Boolean updateJobHunterReport(JobHunterReport jobHunterReport);
    Boolean addJobHunterReport(JobHunterReport jobHunterReport);

}
