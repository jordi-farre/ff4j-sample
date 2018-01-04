package feature.toggle;

import org.ff4j.FF4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/yandex")
public class YandexController {

    private FF4j ff4j;

    public YandexController(final FF4j ff4j) {
        this.ff4j = ff4j;
    }

    @RequestMapping(path = "/enabled", method = GET, produces = MediaType.TEXT_HTML_VALUE)
    public @ResponseBody String isEnabled() {
        if (ff4j.check("yandex")) {
            return "<html><body><h1 style='color:green'>Yandex is enabled</h1></body></html>";
        } else {
            return "<html><body><h1 style='color:red'>Yandex is disabled</h1></body></html>";
        }
    }

}
