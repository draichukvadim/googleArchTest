package com.example.mvp.googlearch.service.repository.project;

import android.arch.lifecycle.LiveData;

import com.example.mvp.googlearch.service.model.Project;

import java.util.List;

/**
 * Created by vadim on 27.12.2017.
 */

public interface ProjectRepository {
	LiveData<List<Project>> getProjectList(String userId);
}
