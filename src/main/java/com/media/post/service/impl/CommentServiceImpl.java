package com.media.post.service.impl;

import com.media.post.model.Comment;
import com.media.post.model.Post;
import com.media.post.repo.CommentRepository;
import com.media.post.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    @Override
    public Comment create(Comment comment) {
        log.info("Saving new comment: {}", comment.getContent());
        return commentRepository.save(comment);
    }

    @Override
    public Collection<Comment> list(int limit) {
        log.info("Fetching all comments");
        return commentRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Comment get(Long id) {
        log.info("Fetching comment by ID: {}", id);
        return commentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        log.info("Fetching comments by Post: {}", postId);
        Post post = postService.get(postId);
        return commentRepository.findCommentsByPostOrderByCreatedDate(post);
    }

    @Override
    public Comment update(Comment comment) {
        log.info("Updating comment: {}", comment.getContent());
        return commentRepository.save(comment);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting comment by ID: {}", id);
        commentRepository.deleteById(id);
        return TRUE;
    }
}
