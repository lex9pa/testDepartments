package com.skobeev.project.service;

import com.skobeev.project.exception.CustomException;

public interface DeleteService {

    void delete(Object ob, Long id) throws CustomException;
}
