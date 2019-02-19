package it;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MastermindController {

    private static final long serialVersionUID=1L;

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String getMessage() {
        return "ciao mondo";
    }


}
