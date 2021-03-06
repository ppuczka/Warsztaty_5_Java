package pl.coderslab.warsztaty_5.service;

import org.springframework.stereotype.Service;
import pl.coderslab.warsztaty_5.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {
    private List<Book> list;


    @Override
    public void update(Book book) {
        for (int i = 0; i < list.size(); i++ ) {
            if(this.list.get(i).getId() == book.getId()) {
                 this.list.add(i, book);
                 break;
            }
        }

    }


    @Override
    public Book getById(int id) {
        for (int i = 0; i < list.size(); i++ ) {
            if(this.list.get(i).getId() == id ) {
                return this.list.get(i);
            }
        }
        return null;
    }

    @Override
    public void insert(Book book) {
        this.list.add(book);
        book.setId(this.list.size());
    }

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getId() == id) {
                this.list.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Book> getList() {
        return this.list;
    }
}
