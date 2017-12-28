package com.example.mvp.googlearch.service.service;

import com.example.mvp.googlearch.service.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vadim on 27.12.2017.
 */

public interface GitHubService {
	String HTTPS_API_GITHUB_URL = "https://api.github.com/";

	@GET("users/{user}/repos")
	Call<List<Project>> getProjectList(@Path("user") String user);

	@GET("/repos/{user}/{repositoryName}")
	Call<Project> getProjectDetails(@Path("user") String user, @Path("repositoryName") String projectName);
}
