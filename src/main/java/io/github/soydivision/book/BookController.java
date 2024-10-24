package io.github.soydivision.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController
{
    @Autowired
    BookService booksService;

    @GetMapping("/all")
    private List<Book> getAllBooks()
    {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    private Book getBook(@PathVariable Long id)
    {
        return booksService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteBook(@PathVariable Long id)
    {
        booksService.delete(id);
    }

    @PostMapping
    private long saveBook(@RequestBody Book book)
    {
        booksService.saveOrUpdate(book);
        return book.getId();
    }

    @PutMapping("/{id}")
    private Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id); // Ensure the ID matches the path variable, otherwise you can pass arbitrary Id in request body.
        booksService.saveOrUpdate(book);
        return book;
    }

}