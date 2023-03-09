package com.sup.core.models.support;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupportArticleRequestModel {
  Long id;
  Long subcategoryId;
  String title;
  String content;

}
