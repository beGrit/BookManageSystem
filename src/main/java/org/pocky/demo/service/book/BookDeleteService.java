package org.pocky.demo.service.book;

import org.pocky.demo.exceptions.bookstore.DeleteBookException;

import java.util.List;

public interface BookDeleteService {
    /**
     * delete books whose id in idList
     * @param idList
     * @return
     * @throws DeleteBookException
     */
    void deleteByIdList(List<String> idList) throws DeleteBookException;
}
