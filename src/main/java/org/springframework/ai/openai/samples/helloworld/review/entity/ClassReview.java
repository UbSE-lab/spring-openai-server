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
public class ClassReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecId", nullable = false, unique = false)
    private Lecture lecId;

    @Column(nullable = false, length = 45, unique = false)
    private String postTitle;

    @Column(nullable = false, unique = false)
    private Long starLating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNumber" , nullable = false, unique = false)
    private User userNumber;

    @Column(nullable = false, length = 255, unique = false)
    private String postContent;

    @Column(nullable = false)
    private int likes;



    /**
     * 좋아요
     */
    public int like(){
        this.likes += 1;
        return this.likes;
    }

    /**
     * 좋아요 취소
     *
     */
    public int cancelLike(){
        this.likes -= 1;
        return this.likes;
    }

    /**
     * 글 수정
     */
    public void updatePost(String postTitle, String postContent){
        this.postTitle = postTitle;
        this.postContent = postContent;
    }



}
