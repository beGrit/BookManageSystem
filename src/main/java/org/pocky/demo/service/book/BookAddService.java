package org.pocky.demo.service.book;

import org.pocky.demo.exceptions.bookstore.AddBookFailedException;
import org.pocky.demo.models.Book;

public interface BookAddService {
    /**
     * 添加一本书
     * @param book
     * @throws AddBookFailedException can't add book
     */
    void addOneBook(Book book) throws AddBookFailedException;
}
