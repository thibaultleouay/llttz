package gapchenko.llttz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gapchenko.llttz.stores.Location;
import gapchenko.llttz.stores.TimeZoneStore;

public final class Converter implements IConverter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Converter.class);
	
    private TimeZoneStore tzStore;
    private static Converter instance = null;

    private Converter(Class clazz) {
        if (!TimeZoneStore.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Illegal store provided: " + clazz.getName());
        }
        try {
            tzStore = (TimeZoneStore) clazz.newInstance();
            loadData();
        } catch (InstantiationException | IllegalAccessException e) {
        	LOGGER.error("error while instantiating :",e);
        }
    }

    public static Converter getInstance(final Class clazz) {
        if (instance == null || !instance.getStoreClass().equals(clazz)) instance = new Converter(clazz);
        return instance;
    }

    public Class getStoreClass() {
        return tzStore.getClass();
    }

    @Override
    public TimeZone getTimeZone(final double lat, final double lon) {
        return tzStore.nearestTimeZone(new Location(new double[]{lat, lon}));
    }

    private void loadData() {


        try(BufferedReader br = new BufferedReader(new InputStreamReader(Converter.class.getResourceAsStream("/timezones.csv")));) {
            String line;
            String[] location;

            while ((line = br.readLine()) != null) {
                location = line.split(";");
                tzStore.insert(new Location(Double.valueOf(location[1]), Double.valueOf(location[2]), location[0]));
            }
        } catch (IOException e) {
        	LOGGER.error("error while reading file : ", e);
        }
    }
}