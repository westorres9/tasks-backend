package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	
	@Test
	public void shouldReturnTrueWhenFutureDates() {
		LocalDate date = LocalDate.of(2030, 12, 15);
		boolean result = DateUtils.isEqualOrFutureDate(date);
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void shouldReturnFalseWhenPastDates() {
		LocalDate date = LocalDate.of(2022, 12, 15);
		boolean result = DateUtils.isEqualOrFutureDate(date);
		
		Assert.assertFalse(result);
	}
}
