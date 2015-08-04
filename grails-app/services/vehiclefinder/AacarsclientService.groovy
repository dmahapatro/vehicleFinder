package vehiclefinder

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Transactional
class AacarsclientService {

    def get(String vehicleId) {

        RestBuilder builder = new RestBuilder()
        return builder.get('http://api.vcars.co.uk/car/vcarsdna-' + vehicleId)

        //def json = '{"make":"BMW","model":"3 SERIES","variant":"320d SE Business Edition","registration":"EY10UZU","colour":"Black","fueltype":"Diesel","transmission":"Manual","mileage":42000,"price":17000,"regyear":2010,"image_urls":["http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_1.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_2.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_3.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_4.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_5.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_6.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_7.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_8.jpg","http:\\/\\/img.vcars.co.uk\\/1\\/vcarsdna\\/thumbnails\\/49484_9.jpg"]}'
        //def response = new RestResponse(new ResponseEntity(json, 200))

        //return response
    }
}
