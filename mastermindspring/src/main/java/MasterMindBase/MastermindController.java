package MasterMindBase;

import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@RestController
public class MastermindController {

    private static final long serialVersionUID=1L;

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String getMessage() {
        return "index.jsp";
    }
}
