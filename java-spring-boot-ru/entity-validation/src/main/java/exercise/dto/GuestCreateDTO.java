package exercise.dto;

// BEGIN
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;


@Setter
@Getter
public class GuestCreateDTO {
    @NotNull
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^\\+\\d{11,13}$")
    private String phoneNumber;
    @Pattern(regexp = "^\\d{4}$")
    private String clubCard;
    @FutureOrPresent 
    private LocalDate cardValidUntil;
}
// END
