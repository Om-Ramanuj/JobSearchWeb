package com.Project.JOB.Repository;

import com.Project.JOB.Model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
