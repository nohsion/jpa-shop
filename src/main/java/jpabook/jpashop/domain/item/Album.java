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
@DiscriminatorValue("A")
@Entity
public class Album extends Item {

    private String artist;
    private String etc;

}
