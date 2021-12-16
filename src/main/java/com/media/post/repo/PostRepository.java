package com.media.post.repo;

import com.media.post.model.AppUser;
import com.media.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostByAppUserOrderByPostId(AppUser appUser);

    List<Post> findAllByOrderByPostIdDesc();
}