package com.example.mvp.googlearch.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mvp.googlearch.R;
import com.example.mvp.googlearch.service.model.Project;

import java.util.List;

/**
 * Created by vadim on 27.12.2017.
 */

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {
	private List<Project> projectList;

	public ProjectAdapter(List<Project> projectList) {
		this.projectList = projectList;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.view_repository_item, parent, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.tvTitle.setText(projectList.get(position).getName());
		holder.tvDescription.setText(projectList.get(position).getDescription());
		holder.tvDate.setText(projectList.get(position).getUpdatedAt());
	}

	@Override
	public int getItemCount() {
		return this.projectList.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		TextView tvTitle;
		TextView tvDescription;
		TextView tvDate;

		ViewHolder(LinearLayout view) {
			super(view);
			tvTitle = view.findViewById(R.id.tvTitle);
			tvDescription = view.findViewById(R.id.tvDescription);
			tvDate = view.findViewById(R.id.tvDate);
		}
	}
}
