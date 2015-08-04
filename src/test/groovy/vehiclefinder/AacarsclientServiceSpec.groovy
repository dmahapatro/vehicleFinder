package vehiclefinder

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.plugins.rest.client.RestBuilder

import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

@TestFor(AacarsclientService)
class AacarsclientServiceSpec extends Specification {

    def "It should pass through the response from AA Cars API"() {
        given:
        RestBuilder rest = new RestBuilder()
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(rest.restTemplate);

        mockServer.expect(requestTo("http://api.vcars.co.uk/car/vcarsdna-49484"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{\"make\":\"BMW\",\"model\":\"3 SERIES\",\"variant\":\"320d SE Business Edition\",\"registration\":\"EY10UZU\",\"colour\":\"Black\",\"fueltype\":\"Diesel\",\"transmission\":\"Manual\",\"mileage\":42000,\"price\":17000,\"regyear\":2010,\"image_urls\":[\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_1.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_2.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_3.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_4.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_5.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_6.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_7.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_8.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_9.jpg\"]}",
                MediaType.APPLICATION_JSON))

        and: 'assign mocked rest builder to service'
        service.builder = rest

        when:
        def val = service.get('49484')

        then:
        mockServer.verify();
    }
}
