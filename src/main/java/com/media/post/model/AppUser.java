package com.media.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @JoinColumn(name = "user_name")
    private String name;

    @OneToMany(mappedBy = "appUser")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    private Set<Post> posts;
}
