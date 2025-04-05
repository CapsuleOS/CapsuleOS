package com.CapsuleOS.repository;

import com.CapsuleOS.models.Capsule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CapsuleRepository extends JpaRepository<Capsule, Long> {
    List<Capsule> findByOwnerId(Long userId);

    List<Capsule> findByParentCapsuleId(Long parentCapsuleId);

    Optional<Capsule> findByIdAndOwnerId(Long capsuleId, Long ownerId);
}

