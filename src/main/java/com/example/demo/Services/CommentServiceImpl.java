package com.example.demo.Services;

import com.example.demo.Entities._Comment_;
import com.example.demo.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public _Comment_ SaveComment(_Comment_ comment) {
        return commentRepository.save(comment);
    }

    @Override
    public _Comment_ GetCommentById(long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteAllCommentsOfPost() {

    }

    @Override
    public List<_Comment_> getAllCommentsOfPost(Long post) {
        return commentRepository.findByBlogPostId(post);
    }
    @Override
    public Page<_Comment_> GetAllCommentsByPage(int page, int size) {
        return null;
    }
}
