package vehiclefinder

import grails.rest.RestfulController;
import grails.plugins.rest.client.RestResponse;

class VehicleFinderController {

    AacarsclientService aacarsclientService;

    static def companyLookup = [
        'aa': 'http://api.vcars.co.uk/car/vcarsdna-'
    ]

    def index() { 

    	String vehicleId = params.id
		String company 	 = params.company

		if(!company && !vehicleId) {
			render(status: 404, text: 'Please supply company and vehicle Id parameters.')
            return
		}

        if(!company) {
            render(status: 404, text: 'Please supply a company parameter.')
            return
        }

        if(!vehicleId) {
            render(status: 404, text: 'Please supply a vehicle Id.')
            return
        }

        if (!companyLookup.containsKey(company)) {
            render(status: 404, text: 'The company supplied is invalid.')
            return
        }

		RestResponse resp  = aacarsclientService.get(vehicleId)

        if (resp.status != 200){
            render(status: 404, text: 'No vehicles found for ' + company + ' using the Id ' + vehicleId)
        }

        render resp.status
    }
}
