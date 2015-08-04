package vehiclefinder

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Transactional
class AacarsclientService {
    private RestBuilder builder = new RestBuilder()

    // Another way to use the builder is to declare it as a spring bean in resources.groovy and simply
    // inject it here in the service class.
    // see resources.groovy for bean declaration
    // and then `def builder` in service at Class level instead of instantiating it as a private property

    def get(String vehicleId) {
        return builder.get('http://api.vcars.co.uk/car/vcarsdna-' + vehicleId)

        //def json = '{"make":"BMW","model":"3 SERIES","variant":"320d SE Business Edition","registration":"EY10UZU","colour":"Black","fueltype":"Diesel","transmission":"Manual","mileage":42000,"price":17000,"regyear":2010,"image_urls":["http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_1.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_2.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_3.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_4.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_5.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_6.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_7.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_8.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_9.jpg"]}'
        //def response = new RestResponse(new ResponseEntity(json, 200))

        //return response
    }
}
