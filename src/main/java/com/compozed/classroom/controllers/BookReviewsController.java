package com.compozed.classroom.controllers;


import com.compozed.classroom.models.NYTBookReviewResults;
import com.compozed.classroom.services.NYTBookReviewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookReviewsController {
    private NYTBookReviewsService nytBookReviewsService;

    BookReviewsController(NYTBookReviewsService nytBookReviewsService) {
        this.nytBookReviewsService = nytBookReviewsService;
    }

    @GetMapping("/book-reviews")
    public NYTBookReviewResults getReviews(@RequestParam String search) {
        return nytBookReviewsService.forTitle(search);

    }
}

