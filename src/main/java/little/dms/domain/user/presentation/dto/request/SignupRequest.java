package little.dms.domain.user.presentation.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    @Size(min = 2, max = 5, message = "이름은 최소 2자, 최대 5자 입니다.")
    private String userName;

    @Size(min = 5, max = 30, message = "아이디는 최소 5자, 최대 30자 입니다.")
    private String accountId;

    @NotNull(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(
        regexp =
            "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,32}$",
        message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String password;

}
