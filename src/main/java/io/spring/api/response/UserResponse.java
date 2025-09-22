package io.spring.api.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.spring.application.data.UserWithToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("user")
public class UserResponse {
  private UserWithToken user;
}
