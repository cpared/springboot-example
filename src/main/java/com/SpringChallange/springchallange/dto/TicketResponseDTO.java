package com.SpringChallange.springchallange.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter @Setter
public class TicketResponseDTO {
    private Integer id;
    private List<ArticleDTO> articles;
    private Integer total;
    private StatusCodeDTO statusResponse;
}
