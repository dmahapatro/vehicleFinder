package vehiclefinder

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

import grails.plugins.rest.client.RestBuilder
import org.springframework.web.client.RestTemplate

import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.client.MockRestServiceServer

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(VehicleFinderController)
@Mock(AacarsclientService)
class VehicleFinderControllerSpec extends Specification {

    def "test Index with no company or id parameter"() {
        when:
        controller.index()
        then:
        404 == controller.response.status
        'Please supply company and vehicle Id parameters.' == controller.response.text
    }

    def "test Index with no company parameter"() {
        when:
        params.id = '1234'
        controller.index()
        then:
        404 == controller.response.status
            'Please supply a company parameter.' == controller.response.text
    }

    def "test Index with no id parameter"() {
        when:
        params.company = 'aa'
        controller.index()
        then:
        404 == controller.response.status
        'Please supply a vehicle Id.' == controller.response.text
    }

    def "test Index with incorrect company parameter"() {
        when:
        params.company = 'gumtree'
        params.id 	   = '1234'
        controller.index()
        then:
        404 == controller.response.status
        'The company supplied is invalid.' == controller.response.text
    }

}
