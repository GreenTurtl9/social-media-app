package com.media.post.service;

import com.media.post.model.Post;

import java.util.Collection;

public interface PostService {

    Post create(Post server);

    Collection<Post> list(int limit);

    Post get(Long id);

    Collection<Post> getPostsByUserId(Long userId);

    Post update(Post post);

    Boolean delete(Long id);
}
