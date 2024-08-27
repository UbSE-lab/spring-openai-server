package org.springframework.ai.openai.samples.helloworld.review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lectureId" , nullable = false)
    private Long lectureId;

    @Column(nullable = false, length = 45 , unique = false)
    private String lectureName;

    @Column(nullable = true, unique = false)
    private Long averageStarLating;

    @Column(nullable = true, unique = false)
    private Long totalStarLating;

    @Column(nullable = true, unique = false)
    private Long reviewCount;

    @Column(nullable = false, length = 45, unique = false)
    private String department;

    @Column(nullable = false, length = 45, unique = false)
    private String university;


    @Enumerated(EnumType.STRING)
    private LectureType lectureType;


    public Long updateAverageStarLating(Long updateLating){
        this.averageStarLating = updateLating;
        return this.averageStarLating;
    }

    public Long updateTotalStarLating(Long plusLating){
        this.totalStarLating = totalStarLating + plusLating;
        return this.totalStarLating;
    }

    public Long addReviewCount(Lecture lecture){

        this.reviewCount = reviewCount+1;
        return this.reviewCount;
    }

    public Long cancelTotalStarLating(Long minusLating){
        this.totalStarLating = totalStarLating - minusLating;
        return this.totalStarLating;
    }

    public Long cancelReviewCount(){
        this.reviewCount = reviewCount - 1;
        return this.reviewCount;
    }


}
