package com.odco.project.repository;

import com.odco.project.entity.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoopRepository extends JpaRepository<Cooperative, Integer> {
}
