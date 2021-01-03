package org.lieying.service;


import org.lieying.bean.Information;

import java.util.List;

public interface InformationService {
    List<Information> queryAllInformations();
    Information queryDetailInformationById(int id);

    Boolean addInformation(Information information);
}
