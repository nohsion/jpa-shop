package jpabook.jpashop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DiscriminatorValue("M")
@Entity
public class Movie extends Item {

    private String director;
    private String actor;

}
