package org.springframework.ai.openai.samples.helloworld.keyword.infrastructure;

import org.springframework.ai.openai.samples.helloworld.keyword.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    Keyword findByLectureId(Long lectureId);
}
