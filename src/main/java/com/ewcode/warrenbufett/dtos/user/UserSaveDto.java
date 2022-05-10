package com.ewcode.warrenbufett.dtos.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record UserSaveDto(@NotNull
                          String name,
                          @NotNull
                          @Email(message = "should be a valid e-mail")
                          String email) {
}
