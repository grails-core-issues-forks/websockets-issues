package example.micronaut

import spock.util.concurrent.PollingConditions

class WebsocketSpec extends GebEmbeddedServerSpecification {

    def "check websocket connects"() {
        when:
        WebSocketsHomePage homePage = browser.to(WebSocketsHomePage)

        then:
        browser.at(WebSocketsHomePage)

        and:
        new PollingConditions(timeout: 3).eventually {
            homePage.receivedMessages() == ['joined!']
            !homePage.sentMessages()
        }

        when:
        homePage.send('Hello')

        then:
        new PollingConditions().eventually {
            homePage.receivedMessages() == ['joined!', 'Hello']
            homePage.sentMessages() == ['Hello']
        }

        when:
        homePage.close()

        then:
        homePage.status().contains('Disconnected')
    }
}