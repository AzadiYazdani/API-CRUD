package com.tecnotree.demo.mapper;


import com.tecnotree.demo.api.comment.dto.CommentRequestDto;
import com.tecnotree.demo.api.comment.dto.CommentResponseDto;
import com.tecnotree.demo.api.comment.dto.CommentUpdateRequestDto;
import com.tecnotree.demo.database.entity.CommentEntity;
import com.tecnotree.demo.model.Comment;
import com.tecnotree.demo.model.CommentUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class CommentMapper {

    @Mapping(target = "id", ignore = true)
    public abstract Comment toModel(CommentRequestDto requestDto);

    @Mapping(target = "id", ignore = true)
    public abstract CommentUpdateRequest toModel(CommentUpdateRequestDto requestDto);

    @Mapping(target = "postId", source = "entity.post.id")
    public abstract Comment toModel(CommentEntity entity);

    @Mapping(target = "registerTime", expression = "java(java.time.LocalDateTime.now())")
    public abstract CommentEntity toNewEntity(Comment post);

    public abstract List<Comment> toModelList(List<CommentEntity> postEntityList);

    public abstract CommentResponseDto toDtoResponse(Comment entity);

    public abstract List<CommentResponseDto> toDtoResponseList(List<Comment> postList);



}
