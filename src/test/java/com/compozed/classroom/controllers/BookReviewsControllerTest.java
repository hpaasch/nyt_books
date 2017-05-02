//written after controller was created

package com.compozed.classroom.controllers;

import com.compozed.classroom.models.NYTBookReviewResults;
import com.compozed.classroom.services.NYTBookReviewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookReviewsControllerTest {
    @MockBean
    NYTBookReviewsService nytBookReviewsService;

    @Test
    public void getReviews_callsTheNytBookReviewsService() {
        when(nytBookReviewsService.forTitle("Some Book"))
                .thenReturn(new NYTBookReviewResults());

        BookReviewsController bookReviewsController = new BookReviewsController(nytBookReviewsService);
        bookReviewsController.getReviews("Some Book");

        verify(nytBookReviewsService).forTitle("Some Book");
    }
}
