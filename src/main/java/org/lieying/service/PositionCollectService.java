package org.lieying.service;

import org.lieying.bean.PositionCollect;

public interface PositionCollectService {
    Boolean addPositionCollect(PositionCollect positionCollect);
    Boolean removePositionCollect(int id);
}
