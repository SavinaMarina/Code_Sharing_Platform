package platform;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class APIController {

    private final CodeService codeService;

    public APIController(CodeService codeService) {
        this.codeService = codeService;
    }

    @PostMapping("/api/code/new")
    public Map<String, String> postCode(@RequestBody Map<String, String> code) {
        Long id = codeService.addCode(code.get("code"));
        return Map.of("id", id.toString());
    }

    @GetMapping("/api/code/{n}")
    public Code getCode(@PathVariable int n) {
        return codeService.getCode(n);
    }

    @GetMapping("/api/code/latest")
    public List<Code> getLatestCode() {
        return codeService.getLatestCodes();
    }

}
