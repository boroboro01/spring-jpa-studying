package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jpabook.jpashop.domain.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Book")
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;

    /**
     * Book Entity를 생성하는 팩토리 메서드
     * @param name
     * @param price
     * @param stockQuantity
     * @param author
     * @param isbn
     * @return
     */
    public static Book createBook(String name, int price, int stockQuantity, String author, String isbn) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        book.setAuthor(author);
        book.setIsbn(isbn);
        return book;
    }

}
