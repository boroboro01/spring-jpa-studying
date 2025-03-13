package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==Business Logic==//

    /**
     * stock의 양을 증가시키는 로직입니다.
     * @param quantity
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock의 양을 감소시키는 로직입니다.
     * @param quantity
     */
    public void removeStock(int quantity) throws NotEnoughStockException {
         int restStock = stockQuantity - quantity;
         if (restStock < 0) {
             throw new NotEnoughStockException("Stock의 수가 0보다 작을 수 없습니다.");
         }
         this.stockQuantity = restStock;
    }
}
