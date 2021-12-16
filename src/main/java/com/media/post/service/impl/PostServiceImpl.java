package com.media.post.service.impl;

import com.media.post.model.AppUser;
import com.media.post.model.Post;
import com.media.post.repo.PostRepository;
import com.media.post.service.AppUserService;
import com.media.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final AppUserService userService;

    @Override
    public Post create(Post post) {
        log.info("Saving new post: {}", post.getContent());
        return postRepository.save(post);
    }

    @Override
    public Collection<Post> list(int limit) {
        log.info("Fetching all posts");
        return postRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Post get(Long id) {
        log.info("Fetching post by ID: {}", id);
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        log.info("Fetching post by ID: {}", userId);
        AppUser appUser = userService.get(userId);
        return postRepository.findPostByAppUserOrderByPostId(appUser);
    }

    @Override
    public Post update(Post post) {
        log.info("Updating post: {}", post.getContent());
        return postRepository.save(post);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting post by ID: {}", id);
        postRepository.deleteById(id);
        return TRUE;
    }
}
