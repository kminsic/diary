package com.example.intermediate.repository;

import com.example.intermediate.domain.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public  interface LikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByRequestIdAndNickname(Long Id , String nickname);
    List<PostLike> findAllByRequestId(Long RequestID);


}

