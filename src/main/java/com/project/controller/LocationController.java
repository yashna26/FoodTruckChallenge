package com.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.project.model.FoodTruck;

@Controller
@RequestMapping("/food")
public class LocationController {
	
	private static final String GEOCODING_RESOURCE = "https://www.googleapis.com/geolocation/v1/geolocate";
    private static final String API_KEY = "dummy";
    @RequestMapping("/location")
	public List<FoodTruck> showPage() throws IOException, InterruptedException {
    	List<FoodTruck> foodTrucks = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();

        String requestUri = GEOCODING_RESOURCE + "?key=" + API_KEY;
        System.out.println("requestUri:" +requestUri);

        HttpRequest geocodingRequest = HttpRequest.newBuilder()
        		.uri(URI.create(requestUri)).POST(HttpRequest.BodyPublishers.ofString("")).build() ;   
        
        
        System.out.println("geocodingRequest:" + geocodingRequest);

        HttpResponse geocodingResponse = httpClient.send(geocodingRequest,
                HttpResponse.BodyHandlers.ofString());
        
        JSONObject myObject = new JSONObject(geocodingResponse.body().toString());
        JSONObject latlong = myObject.getJSONObject("location");
        
        BigDecimal latitude = (BigDecimal) latlong.get("lat");
        BigDecimal longitude = (BigDecimal) latlong.get("lng");
        
        String fileName = "/Users/yashnaparikh/Downloads/Mobile_Food_Facility_Permit.csv";
    	try {
    		Reader reader = Files.newBufferedReader(Paths.get(fileName));
    		CsvToBean<FoodTruck> csv = new CsvToBeanBuilder(reader).withType(FoodTruck.class)
    													.withIgnoreLeadingWhiteSpace(true).build();
    		List<FoodTruck> ft = csv.parse();
    		
    		PriorityQueue<FoodTruck> pq = new PriorityQueue<FoodTruck>();
    		
    		Iterator<FoodTruck> itr = ft.iterator();
    		
    		while(itr.hasNext()) {
    			
    			FoodTruck i = itr.next();
    			BigDecimal truckLatitude = i.getLatitude();
    			BigDecimal truckLongitude = i.getLongitude();
    			
    			
    			//Calculate distance between 2 points (UserLatitude, Userlongitude, TruckLatitude, truckLongitude) 
    			
    			//Add the objecct to Priority Queue
    			
    			//Extract first 5 values to show on front end.
    			
    			
    		}
    		
    	} catch (IllegalStateException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        
        return foodTrucks;

	}
}
    
//    private double distance(double lat1, double lon1, double lat2, double lon2) {
//        double theta = lon1 - lon2;
//        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
//        dist = Math.acos(dist);
//        dist = rad2deg(dist);
//        dist = dist * 60 * 1.1515;
//        if (unit == 'K') {
//          dist = dist * 1.609344;
//        } else if (unit == 'N') {
//          dist = dist * 0.8684;
//          }
//        return (dist);
//      }
    
//    public static double distance(BigDecimal lat1, BigDecimal lng1, 
//    		BigDecimal lat2, BigDecimal lng2){
//    		BigDecimal a = (lat1-lat2)*distPerLat(lat1);
//    		double b = (lng1-lng2)*distPerLng(lat1);
//    		return Math.sqrt(a*a+b*b);
//    }
//
//    private static double distPerLng(double lat){
//    	return 0.0003121092*Math.pow(lat, 4)
//    			+0.0101182384*Math.pow(lat, 3)
//    			-17.2385140059*lat*lat
//    			+5.5485277537*lat+111301.967182595;
//    }
//
//    private static double distPerLat(double lat){
//    	return -0.000000487305676*Math.pow(lat, 4)
//    			-0.0033668574*Math.pow(lat, 3)
//    			+0.4601181791*lat*lat
//    			-1.4558127346*lat+110579.25662316;
//    }
    
