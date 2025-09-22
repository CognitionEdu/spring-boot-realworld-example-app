package io.spring.api.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.spring.application.data.ArticleData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("article")
public class ArticleResponse {
  private ArticleData article;
}
