package io.spring.api.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.spring.application.data.CommentData;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("comments")
public class CommentsResponse {
  private List<CommentData> comments;
}
