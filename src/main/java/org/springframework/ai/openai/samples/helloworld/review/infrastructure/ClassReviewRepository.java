package org.springframework.ai.openai.samples.helloworld.review.infrastructure;

import org.springframework.ai.openai.samples.helloworld.review.entity.ClassReview;
import org.springframework.ai.openai.samples.helloworld.review.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassReviewRepository extends JpaRepository<ClassReview, Long> {

    List<ClassReview> findAllByLecId(Lecture lecture);

}
