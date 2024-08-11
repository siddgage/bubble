package com.themedia.userservice.repository;

import com.themedia.userservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
