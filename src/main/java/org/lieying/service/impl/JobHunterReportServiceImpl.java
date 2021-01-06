package org.lieying.service.impl;

import org.lieying.bean.JobHunter;
import org.lieying.bean.JobHunterReport;
import org.lieying.bean.Position;
import org.lieying.dao.JobHunterReportMapper;
import org.lieying.exception.NullObjectAttributeException;
import org.lieying.service.JobHunterReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHunterReportServiceImpl implements JobHunterReportService {

    @Autowired
    private JobHunterReportMapper jobHunterReportMapper;

    @Override
    public JobHunterReport queryJobHunterReportByJobHunterIdAndPositionId(int jobHunterId, int positionId) {
        return jobHunterReportMapper.selectJobHunterReportByJobHunterIdAndPositionId(jobHunterId, positionId);
    }

    @Override
    public Boolean updateJobHunterReport(JobHunterReport jobHunterReport) {
        if (jobHunterReport.getPosition() == null) {
            throw new NullObjectAttributeException("jobHunterReport object has null position object attribute");
        } else if (jobHunterReport.getJobHunter() == null) {
            throw new NullObjectAttributeException("jobHunterReport object has  null position object attribute");
        } else {
            return jobHunterReportMapper.updateJobHunterReport(jobHunterReport.getReason(),
                    jobHunterReport.getFootnote(), jobHunterReport.getEvidenceScreenShot(),
                    jobHunterReport.getState(),
                    jobHunterReport.getJobHunter().getId(), jobHunterReport.getPosition().getId(),
                    jobHunterReport.getId()) == 1;

        }

    }

    @Override
    public Boolean addJobHunterReport(JobHunterReport jobHunterReport) {
        Position position=jobHunterReport.getPosition();
        JobHunter jobHunter=jobHunterReport.getJobHunter();
        String reason=jobHunterReport.getReason();
        String footnote=jobHunterReport.getFootnote();
        String evidenceScreenShot=jobHunterReport.getEvidenceScreenShot();
        if (position==null||jobHunter==null){
            return null;
        }
        return jobHunterReportMapper.insertJobHunterReport(reason,footnote,evidenceScreenShot,jobHunter.getId(), position.getId())==1;
    }

    @Override
    public List<JobHunterReport> queryAllJobHunterReports() {
        return jobHunterReportMapper.selectAllJobHunterReports();
    }

    @Override
    public List<JobHunterReport> queryJobHunterReportsByCriteria(String positionName, String jobHunterName, String reportReason,String state) {
        return jobHunterReportMapper.selectJobHunterReportsByCriteria(positionName,jobHunterName,reportReason,state);
    }
}
