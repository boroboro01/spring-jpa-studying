package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Movie")
@Getter @Setter
public class Movie extends Item{

    private String director;
    private String movieTitle;
}
