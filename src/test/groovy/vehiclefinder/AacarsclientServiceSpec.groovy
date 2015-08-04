package vehiclefinder

import grails.test.mixin.TestFor
import spock.lang.Specification

import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess
/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AacarsclientService)
class AacarsclientServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "It should pass through the response from AA Cars API"() {

        RestTemplate restTemplate = new RestTemplate()
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

        mockServer.expect(requestTo("http://api.vcars.co.uk/car/vcarsdna-49484"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{\"make\":\"BMW\",\"model\":\"3 SERIES\",\"variant\":\"320d SE Business Edition\",\"registration\":\"EY10UZU\",\"colour\":\"Black\",\"fueltype\":\"Diesel\",\"transmission\":\"Manual\",\"mileage\":42000,\"price\":17000,\"regyear\":2010,\"image_urls\":[\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_1.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_2.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_3.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_4.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_5.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_6.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_7.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_8.jpg\",\"http:\\\\/\\\\/img.vcars.co.uk\\\\/1\\\\/vcarsdna\\\\/thumbnails\\\\/49484_9.jpg\"]}",
                MediaType.APPLICATION_JSON));

        when:
        def val = AacarsclientService.get('49484')

        then:
        mockServer.verify();
    }
}
