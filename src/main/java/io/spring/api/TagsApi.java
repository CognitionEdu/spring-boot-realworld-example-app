package io.spring.api;

import io.spring.api.response.TagsResponse;
import io.spring.application.TagsQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "tags")
@AllArgsConstructor
public class TagsApi {
  private TagsQueryService tagsQueryService;

  @GetMapping
  public ResponseEntity<TagsResponse> getTags() {
    return ResponseEntity.ok(new TagsResponse(tagsQueryService.allTags()));
  }
}
