package example.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.views.View;
import io.micronaut.http.server.util.HttpHostResolver

@Controller
class HomeController {

    private final HttpHostResolver hostResolver

    HomeController(HttpHostResolver hostResolver) {
        this.hostResolver = hostResolver
    }

    @Produces(MediaType.TEXT_HTML)
    @Get
    @View("home")
    Map<String, Object> index(HttpRequest<?> request) {
        return Collections.singletonMap("serverUrl", hostResolver.resolve(request)
                .replaceAll("http://", "")
                .replaceAll("https://", ""))
    }
}
