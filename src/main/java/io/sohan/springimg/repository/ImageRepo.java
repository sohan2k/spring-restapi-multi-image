package io.sohan.springimg.repository;

import io.sohan.springimg.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Images, Long> {
}
