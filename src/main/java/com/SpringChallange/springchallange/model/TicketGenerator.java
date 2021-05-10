package com.SpringChallange.springchallange.model;

import com.SpringChallange.springchallange.dto.ArticleDTO;
import com.SpringChallange.springchallange.dto.TicketResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TicketGenerator {
    private final List<Integer> tickets = new ArrayList<>();

    public TicketResponseDTO generateTicket(List<ArticleDTO> articles) {
        TicketResponseDTO response = new TicketResponseDTO();
        response.setArticles(articles);
        response.setId(this.generateTicketId());
        return response;
    }

    private Integer generateTicketId(){
        int MIN = 0;
        int MAX = 1000;
        int ticket = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        while(tickets.contains(ticket)) ticket = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        return ticket;
    }
}
