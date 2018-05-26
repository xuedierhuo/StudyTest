package com.xderhuo.service;

import com.xderhuo.domain.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> findAllById(String id);
}
