package pl.coderslab.warsztaty_5.service;

import pl.coderslab.warsztaty_5.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getList();

    void deleteById(int id);
}
