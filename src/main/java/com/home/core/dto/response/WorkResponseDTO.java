package com.home.core.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkResponseDTO {

    private String messageWork;


    public WorkResponseDTO(String messageWork) {
        this.messageWork = messageWork;
    }
}
