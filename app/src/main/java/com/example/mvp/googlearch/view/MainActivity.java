package com.example.mvp.googlearch.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvp.googlearch.R;
import com.example.mvp.googlearch.service.model.Project;
import com.example.mvp.googlearch.view.adapter.ProjectAdapter;
import com.example.mvp.googlearch.viewmodel.ProjectListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
	private ProjectListViewModel projectListViewModel;
	private RecyclerView rvProjects;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.rvProjects = findViewById(R.id.rvProjects);
		this.rvProjects.setLayoutManager(new LinearLayoutManager(this));

		this.projectListViewModel = ViewModelProviders.of(this).get(ProjectListViewModel.class);
		this.projectListViewModel.getProjectLiveData().observe(this, new Observer<List<Project>>() {
			@Override
			public void onChanged(@Nullable List<Project> projects) {
				if (projects != null) {
					rvProjects.setAdapter(new ProjectAdapter(projects));
				}
			}
		});
	}
}
