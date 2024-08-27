package org.springframework.ai.openai.samples.helloworld.review.infrastructure;

import org.springframework.ai.openai.samples.helloworld.review.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
