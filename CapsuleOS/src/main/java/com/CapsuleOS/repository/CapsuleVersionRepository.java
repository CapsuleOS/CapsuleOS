package com.CapsuleOS.repository;

import com.CapsuleOS.models.CapsuleVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CapsuleVersionRepository extends JpaRepository<CapsuleVersion, Long> {
    List<CapsuleVersion> findByCapsuleIdOrderByVersionNumberDesc(Long capsuleId);

    Optional<CapsuleVersion> findTopByCapsuleIdOrderByVersionNumberDesc(Long capsuleId);
}
