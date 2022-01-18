package uz.ruzyume.porfolio_block.model.create;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LanguageCreateDto implements Serializable {

    @NotNull(message = "This column cannot be null!")
    private String language;

    @NotNull(message = "This column cannot be null!")
    private String level;

    @Length(max = 5, min = 1)
    private double rate;
}
