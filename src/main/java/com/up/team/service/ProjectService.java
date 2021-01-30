package com.up.team.service;

import com.up.team.entity.Project;

public interface ProjectService {

    void create(Project project);

    void update(Project project);

    void delete(Project project);

    Project read(int id);
}
