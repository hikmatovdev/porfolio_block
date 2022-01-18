package uz.ruzyume.porfolio_block.model.create;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TestimonialsCreateDto implements Serializable {

    @NotNull(message = "This column cannot be null!")
    private String recommended;

    @NotNull(message = "This column cannot be null!")
    private String fullName;

    @NotNull(message = "This column cannot be null!")
    private String companyName;
}
