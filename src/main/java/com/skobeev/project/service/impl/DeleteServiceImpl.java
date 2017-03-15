package com.skobeev.project.service.impl;

import com.skobeev.project.dao.CommonDelete;
import com.skobeev.project.dao.impl.CommonDeleteImpl;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.service.DeleteService;

public class DeleteServiceImpl implements DeleteService {

    private CommonDelete commonDelete = new CommonDeleteImpl();

    public void delete(Object ob, Long id) throws CustomException {
        commonDelete.delete(ob, id);
    }
}
