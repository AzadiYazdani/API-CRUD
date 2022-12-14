package com.tecnotree.demo.mapper;


import com.tecnotree.demo.api.post.dto.PostRequestDto;
import com.tecnotree.demo.api.post.dto.PostResponseDto;
import com.tecnotree.demo.database.entity.PostEntity;
import com.tecnotree.demo.model.Post;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Mapping(target = "id", ignore = true)
    public abstract Post toModel(PostRequestDto requestDto);

    @Mapping(target = "userId", source = "entity.user.id")
    public abstract Post toModel(PostEntity entity);

    @Mapping(target = "registerTime", expression = "java(java.time.LocalDateTime.now())")
    public abstract PostEntity toNewEntity(Post post);

    public abstract List<Post> toModelList(List<PostEntity> postEntityList);

    public abstract PostResponseDto toDtoResponse(Post entity);

    public abstract List<PostResponseDto> toDtoResponseList(List<Post> postList);

}
