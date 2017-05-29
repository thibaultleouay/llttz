package gapchenko.llttz;

import java.util.TimeZone;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import gapchenko.llttz.modules.ListStoreModule;
import gapchenko.llttz.stores.TimeZoneListStore;

public class ConverterTest {

	private static Converter converter;
	@BeforeClass
	public static void initData() {
		 converter = Converter.getInstance(TimeZoneListStore.class);
	}
	@Test
	public void getSomePointInAmericaNewYorkTimeZone() {
        final double latitude  = 38.8044;
        final double longitude = -77.0920;
        TimeZone result = converter.getTimeZone(latitude, longitude);
        TimeZone expected = TimeZone.getTimeZone("America/New_York");
        Assert.assertEquals(result,expected);
	}
	
	@Test
	public void getSomePointInIndiana() {
        final double latitude  = 37.952126;
        final double longitude = -86.764727;
        TimeZone result = converter.getTimeZone(latitude, longitude);
        TimeZone expected = TimeZone.getTimeZone("America/Indiana/Tell_City");
        Assert.assertEquals(result,expected);
	}
	
	@Test
	public void getSomePointInToulouse() {
        final double latitude  = 43.6047;
        final double longitude = 1.4442;
        TimeZone result = converter.getTimeZone(latitude, longitude);
        TimeZone expected = TimeZone.getTimeZone("Europe/Paris");
        Assert.assertEquals(result,expected);
	}
	
	@Test
	public void getSomePointInLille() {
        final double latitude  = 50.6292;
        final double longitude = 3.0573;
        TimeZone result = converter.getTimeZone(latitude, longitude);
        TimeZone expected = TimeZone.getTimeZone("Europe/Paris");
        Assert.assertEquals(result,expected);
	}
	
	
	@Test
	public void getLasVegasShouldBeInLosAngelesTimeZone() {	
		final double latitude = 35.9629502;
		final double longitude = -114.8354856;
        TimeZone result = converter.getTimeZone(latitude, longitude);
        System.out.println(result);
        TimeZone expected = TimeZone.getTimeZone("America/Los_Angeles");
        Assert.assertEquals(result,expected);
	}
	
	@Test
	public void getAtlantaShouldBeInLosAngelesTimeZone() {	
		final double latitude = 33.7490;
		final double longitude = -84.3880;
        TimeZone result = converter.getTimeZone(latitude, longitude);
        TimeZone expected = TimeZone.getTimeZone("America/Kentucky/Monticello");
        Assert.assertEquals(result,expected);
	}
	
	@Test
	public void getTallahasseeShouldBeInLosAngelesTimeZone() {	
		final double latitude = 30.4383;
		final double longitude = -84.2807;
        TimeZone result = converter.getTimeZone(latitude, longitude);
        TimeZone expected = TimeZone.getTimeZone("America/Kentucky/Monticello");
        Assert.assertEquals(result,expected);
	}
}
