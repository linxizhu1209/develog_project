package org.log.travel.log_travel_project.repository.entity;

import lombok.RequiredArgsConstructor;
import org.log.travel.log_travel_project.repository.entity.Enum.Category;
import org.log.travel.log_travel_project.web.dto.RequestPosting;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public void savePost(RequestPosting requestPosting) {
        Posts posts = Posts.builder().title(requestPosting.getTitle())
                .content(requestPosting.getContent()).category(Category.valueOf(requestPosting.getCategory())).build();
        postRepository.save(posts);
    }
}
