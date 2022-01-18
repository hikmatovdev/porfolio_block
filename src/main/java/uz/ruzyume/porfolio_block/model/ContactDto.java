package uz.ruzyume.porfolio_block.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto extends GenericDto{
    @NotNull(message = "This column cannot be null!")
    private String contactName;

    @NotNull(message = "This column cannot be null!")
    private String contact;

}
