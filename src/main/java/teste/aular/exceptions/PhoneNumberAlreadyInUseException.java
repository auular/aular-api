package teste.aular.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Phone number already in use")
public class PhoneNumberAlreadyInUseException extends RuntimeException{

}
