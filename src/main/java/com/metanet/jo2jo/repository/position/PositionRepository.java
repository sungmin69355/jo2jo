package com.metanet.jo2jo.repository.position;

import com.metanet.jo2jo.domain.position.PositionDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PositionRepository {
    List<PositionDto> findAllByPosition();
}
