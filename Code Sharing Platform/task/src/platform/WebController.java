package platform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    private final CodeService codeService;

    public WebController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/new")
    public String newCode(Model model){
        return "NewCode";
    }

    @GetMapping("/code/{n}")
    public String showCode(Model model, @PathVariable int n) {
        Code c = codeService.getCode(n);
        model.addAttribute("code", c.getCode());
        model.addAttribute("lastUpdate", c.getDate());
        return "ShowCode";
    }

    @GetMapping("/code/latest")
    public String getLatestCodes(Model model) {
        model.addAttribute("codes", codeService.getLatestCodes());
        return "Latest";
    }

}
