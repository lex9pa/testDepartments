package com.skobeev.project.dao;

import com.skobeev.project.exception.CustomException;

public interface CommonDelete {

    void delete(Object ob, Long id) throws CustomException;
}
