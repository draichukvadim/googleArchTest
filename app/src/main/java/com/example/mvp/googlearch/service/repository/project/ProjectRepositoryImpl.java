package com.example.mvp.googlearch.service.repository.project;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mvp.googlearch.service.model.Project;
import com.example.mvp.googlearch.service.service.GitHubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vadim on 27.12.2017.
 */

public class ProjectRepositoryImpl implements ProjectRepository {
	private GitHubService gitHubService;

	public ProjectRepositoryImpl() {
		this.gitHubService = new Retrofit.Builder()
				.baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(GitHubService.class);
	}

	@Override
	public LiveData<List<Project>> getProjectList(String userId) {
		final MutableLiveData<List<Project>> data = new MutableLiveData<>();

		gitHubService.getProjectList(userId).enqueue(new Callback<List<Project>>() {
			@Override
			public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
				data.setValue(response.body());
			}

			@Override
			public void onFailure(Call<List<Project>> call, Throwable t) {

			}
		});

		return data;
	}
}