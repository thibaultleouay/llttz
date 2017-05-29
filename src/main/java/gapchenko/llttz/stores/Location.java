package gapchenko.llttz.stores;

import java.util.Arrays;
import java.util.Objects;

public class Location {
    private double[] coordinates;
    private String zone;

    public Location(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public Location(final double latitude, final double longitude, final String zone) {
        this.coordinates = new double[] { latitude, longitude };
        this.zone = zone;
    }

    public double[] getCoordinates() {
        return this.coordinates;
    }

    public double getLatitude() {
        return this.coordinates[0];
    }

    public double getLongitude() {
        return this.coordinates[1];
    }

    public String getZone() {
        return zone;
    }

    @Override
    public boolean equals(Object obj) {
    	if (obj == null ) {
    		return false;
    	}
    	if(this.getClass() != obj.getClass()) {
    		return false;
    	}
        return Arrays.equals(coordinates, ((Location) obj).getCoordinates());
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(coordinates,zone);
    }
}
