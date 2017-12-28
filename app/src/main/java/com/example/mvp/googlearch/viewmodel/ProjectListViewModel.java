package com.example.mvp.googlearch.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.mvp.googlearch.service.model.Project;
import com.example.mvp.googlearch.service.repository.project.ProjectRepository;
import com.example.mvp.googlearch.service.repository.project.ProjectRepositoryImpl;

import java.util.List;

/**
 * Created by vadim on 27.12.2017.
 */

public class ProjectListViewModel extends AndroidViewModel {
	private ProjectRepository projectRepository = new ProjectRepositoryImpl();
	private final LiveData<List<Project>> projectLiveData;

	private final String REPO_NAME = "Google";

	public ProjectListViewModel(@NonNull Application application) {
		super(application);
		this.projectLiveData = this.projectRepository.getProjectList(REPO_NAME);
	}

	public LiveData<List<Project>> getProjectLiveData() {
		return this.projectLiveData;
	}
}
