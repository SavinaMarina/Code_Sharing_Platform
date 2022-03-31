package platform;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Long addCode(String code) {
        codeRepository.save(new Code(code));
        return codeRepository.count();
    }

    public Code getCode(int index) {
        return codeRepository.findById((long) (index)).orElseThrow(() -> new RuntimeException("Code not found"));
    }

    public List<Code> getLatestCodes() {
        var res = new ArrayList<Code>();
        var size = codeRepository.count();
        for (int i = 0; i < Math.min(size,10); i++) {
            res.add(codeRepository.findById(size-i).get());
        }
        return res;
    }

}
