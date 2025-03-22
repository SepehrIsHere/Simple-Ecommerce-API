package org.pki.simpleecommerproject.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {
    private Long id;
    private String UID;
    private String name;
    private Long userId;
}
