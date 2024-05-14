package com.example.demo.Services;

import com.example.demo.Entities._Category_;
import com.example.demo.Entities._Comment_;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    _Comment_ SaveComment(_Comment_ comment);
    _Comment_ GetCommentById(long id);
    void deleteCommentById(long id);
    void deleteAllCommentsOfPost();
    List<_Comment_> getAllCommentsOfPost(Long post);
    Page<_Comment_> GetAllCommentsByPage(int page, int size);
}
