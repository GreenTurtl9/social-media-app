package com.media.post.service;

import com.media.post.model.Comment;
import com.media.post.model.Post;

import java.util.Collection;
import java.util.List;

public interface CommentService {

    Comment create(Comment comment);

    Collection<Comment> list(int limit);

    Comment get(Long id);

    List<Comment> getCommentsByPostId(Long postId);

    Comment update(Comment post);

    Boolean delete(Long id);
}
