package io.spring.api.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.spring.application.data.ProfileData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("profile")
public class ProfileResponse {
  private ProfileData profile;
}
