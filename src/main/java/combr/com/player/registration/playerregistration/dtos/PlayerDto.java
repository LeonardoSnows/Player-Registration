package combr.com.player.registration.playerregistration.dtos;

import jakarta.validation.constraints.*;

public record PlayerDto(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        String grupo) {
}
