package com.example.intermediate.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends Timestamped {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private String imgUrl;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comment> comments;

  @JoinColumn(name = "member_id", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Member member;

  @Column
  private int likes;


  //회원정보 검증
  public boolean validateMember(Member member) {
    return !this.member.equals(member);
  }

//  public void addLike() {
//    this.likes += 1;
//    System.out.println("this.content = " + this.content);
//    System.out.println("this.likes = " + this.likes);
//  }
//  public void delteLike(){
//    this.likes -= 1;
//  }

 // 라이크 신기능
public void updatelikes(int num) {
  this.likes = (num);
}


}
