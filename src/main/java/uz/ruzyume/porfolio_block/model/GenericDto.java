package uz.ruzyume.porfolio_block.model;

import lombok.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericDto implements Serializable {

    private  Long id;
}
