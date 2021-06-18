package example.micronaut

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import io.micronaut.websocket.RxWebSocketClient
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class MicronautguideSpec extends Specification {

    @Inject
    EmbeddedApplication<?> application

    void 'test it works'() {
        expect:
        application.running
    }

}
