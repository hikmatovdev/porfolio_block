package uz.ruzyume.porfolio_block.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data <T extends GenericDto>{
    List<T> data;

    long totalCount;
}
