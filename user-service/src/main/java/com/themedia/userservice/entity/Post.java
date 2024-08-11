package com.themedia.userservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_post_id")
    @SequenceGenerator(name = "seq_post_id", sequenceName = "seq_post_id", allocationSize = 1, initialValue = 1)
    private Long id;

    private String creator;

    @ManyToMany
    @JoinTable(
            name = "user_post_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> likes;

    private String caption;

    @ElementCollection
    private String[] tags;

    private String imageId;

    private String imageUrl;

    private String location;

    private LocalDate createDate;
}
