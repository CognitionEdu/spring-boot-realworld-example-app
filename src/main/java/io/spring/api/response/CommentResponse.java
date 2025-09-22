package io.spring.api.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.spring.application.data.CommentData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("comment")
public class CommentResponse {
  private CommentData comment;
}
