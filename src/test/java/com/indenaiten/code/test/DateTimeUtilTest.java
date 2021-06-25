package com.indenaiten.code.test;

import com.indenaiten.code.util.DateTimeUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


/**
 * <p>Tests for com.indenaiten.code.util.DateTimeUtil class.</p>
 *
 * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
 * @see com.indenaiten.code.util.DateTimeUtil
 */
class DateTimeUtilTest{

    //DEFAULT PARAMETERS
    private static final String DEFAULT_DATE_STR = "25/06/2021";
    private static final String DEFAULT_DATE_FORMATTER_STR = DateTimeUtil.DEFAULT_DATE_PATTERN;
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern( DEFAULT_DATE_FORMATTER_STR );
    private static final String DEFAULT_TIME_STR = "17:36:27";
    private static final String DEFAULT_TIME_FORMATTER_STR = DateTimeUtil.DEFAULT_TIME_PATTERN;
    private static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern( DEFAULT_TIME_FORMATTER_STR );
    private static final String DEFAULT_DATE_TIME_STR = "25/06/2021 17:36";
    private static final String DEFAULT_DATE_TIME_FORMATTER_STR = DateTimeUtil.DEFAULT_DATE_TIME_PATTERN;
    private static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern( DEFAULT_DATE_TIME_FORMATTER_STR );
    private static final ZoneId DEFAULT_ZONE_ID = DateTimeUtil.DEFAULT_ZONE_ID;
    private static final Locale DEFAULT_LOCALE = DateTimeUtil.DEFAULT_LOCALE;
    private static final LocalDate DEFAULT_LOCAL_DATE = LocalDate.now();
    private static final LocalDateTime DEFAULT_LOCAL_DATE_TIME = LocalDateTime.now();
    private static final LocalTime DEFAULT_LOCAL_TIME = LocalTime.now();
    private static final Date DEFAULT_DATE = new Date();

    //MESSAGES
    private static final String MSG_IS_NULL = "El resultado es NULL";
    private static final String MSG_TEMPLATE_RESULT_EXPECTED = "RESULT: %s - EXPECTED: %s";


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getDateFromLocalDate" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getDateFromLocalDate( LocalDate:✓ ):Date:✓" )
    void givenCorrectLocalDateParameter_whenGetDateFromLocalDateIsCalled_thenReturnCorrectDate(){
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER );
        final Date EXPECTED = Date.from( DATE_IN.atStartOfDay( DEFAULT_ZONE_ID ).toInstant() );

        Date result = DateTimeUtil.getDateFromLocalDate( DATE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromLocalDate( LocalDate:✓, ZoneId:✓ ):Date:✓" )
    void givenCorrectLocalDateAndCorrectZoneIdParameter_whenGetDateFromLocalDateIsCalled_thenReturnCorrectDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER ).atStartOfDay(ZONE_ID_IN).toLocalDate();
        final Date EXPECTED = Date.from( DATE_IN.atStartOfDay( ZONE_ID_IN ).toInstant() );

        Date result = DateTimeUtil.getDateFromLocalDate( DATE_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateFromLocalDate( LocalDate:✓, ZoneId:✗ ):NullPointerException" )
    void givenCorrectLocalDateAndZoneIdAsNullParameter_whenGetDateFromLocalDateIsCalled_thenThrowsNullPointerException( final ZoneId ZONE_ID_IN ){
        final LocalDate DATE_IN = DEFAULT_LOCAL_DATE;
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateFromLocalDate( DATE_IN, ZONE_ID_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateFromLocalDate( LocalDate:✗ ):NullPointerException" )
    void givenLocalDateAsNullParameter_whenGetDateFromLocalDateIsCalled_thenThrowsNullPointerException( final LocalDate DATE_IN ){
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateFromLocalDate( DATE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getDateFromLocalDateTime" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getDateFromLocalDateTime( LocalDateTime:✓ ):Date:✓" )
    void givenCorrectLocalDateTimeParameter_whenGetDateFromLocalDateTimeIsCalled_thenReturnCorrectDate(){
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER );
        final Date EXPECTED = Date.from( DATE_TIME_IN.atZone( DEFAULT_ZONE_ID ).toInstant() );

        Date result = DateTimeUtil.getDateFromLocalDateTime( DATE_TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromLocalDateTime( LocalDateTime:✓, ZoneId:✓ ):Date:✓" )
    void givenCorrectLocalDateTimeAndCorrectZoneIdParameter_whenGetDateFromLocalDateTimeIsCalled_thenReturnCorrectDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER ).atZone( ZONE_ID_IN ).toLocalDateTime();
        final Date EXPECTED = Date.from( DATE_TIME_IN.atZone( ZONE_ID_IN ).toInstant() );

        Date result = DateTimeUtil.getDateFromLocalDateTime( DATE_TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateFromLocalDateTime( LocalDateTime:✓, ZoneId:✗ ):NullPointerException" )
    void givenCorrectLocalDateTimeAndZoneIdAsNullParameter_whenGetDateFromLocalDateTimeIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final LocalDateTime DATE_TIME_IN = DEFAULT_LOCAL_DATE_TIME;
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateFromLocalDateTime( DATE_TIME_IN, ZONE_ID_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateFromLocalDateTime( LocalDateTime:✗ ):NullPointerException" )
    void givenLocalDateTimeAsNullParameter_whenGetDateFromLocalDateTimeIsCalled_thenThrowsNullPointerException( final LocalDateTime DATE_TIME_IN ){
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateFromLocalDateTime( DATE_TIME_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalDateFromDate" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromDate( Date:✓ ):LocalDate:✓" )
    void givenCorrectDateParameter_whenGetLocalDateFromDateIsCalled_thenReturnCorrectLocalDate(){
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER ).atStartOfDay( DEFAULT_ZONE_ID ).toInstant() );
        final LocalDate EXPECTED = DATE_IN.toInstant().atZone( DEFAULT_ZONE_ID ).toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromDate( DATE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromDate( Date:✓, ZoneId:✓ ):LocalDate:✓" )
    void givenCorrectDateAndCorrectZoneIdParameter_whenGetLocalDateFromDateIsCalled_thenReturnCorrectLocalDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER ).atStartOfDay( ZONE_ID_IN ).toInstant() );
        final LocalDate EXPECTED = DATE_IN.toInstant().atZone( ZONE_ID_IN ).toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromDate( DATE_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateFromDate( Date:✓, ZoneId:✗ ):NullPointerException" )
    void givenCorrectDateAndZoneIdAsNullParameter_whenGetLocalDateFromDateIsCalled_thenThrowsNullPointerException( final ZoneId ZONE_ID_IN ){
        final Date DATE_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateFromDate( DATE_IN, ZONE_ID_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateFromDate( Date:✗ ):NullPointerException" )
    void givenDateAsNullParameter_whenGetLocalDateFromDateIsCalled_thenThrowsNullPointerException( final Date DATE_IN ){
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateFromDate( DATE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalDateTimeFromDate" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromDate( Date:✓ ):LocalDateTime:✓" )
    void givenCorrectDateParameter_whenGetLocalDateTimeFromDateIsCalled_thenReturnCorrectLocalDateTime(){
        final Date DATE_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER ).atZone( DEFAULT_ZONE_ID ).toInstant() );
        final LocalDateTime EXPECTED = LocalDateTime.ofInstant( DATE_IN.toInstant(), DEFAULT_ZONE_ID );

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromDate( DATE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromDate( Date:✓, ZoneId:✓ ):LocalDateTime:✓" )
    void givenCorrectDateAndCorrectZoneIdParameter_whenGetLocalDateTimeFromDateIsCalled_thenReturnCorrectLocalDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date DATE_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER ).atZone( ZONE_ID_IN ).toInstant() );
        final LocalDateTime EXPECTED = LocalDateTime.ofInstant( DATE_IN.toInstant(), ZONE_ID_IN );

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromDate( DATE_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromDate( Date:✓, ZoneId:✗ ):NullPointerException" )
    void givenCorrectDateAdnZoneIdAsNullParameter_whenGetLocalDateTimeFromDateIsCalled_thenThrowsNullPointerException( final ZoneId ZONE_ID_IN ){
        final Date DATE_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateTimeFromDate( DATE_IN, ZONE_ID_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromDate( Date:✗ ):NullPointerException" )
    void givenDateAsNullParameter_whenGetLocalDateTimeFromDateIsCalled_thenThrowsNullPointerException( final Date DATE_IN ){
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateTimeFromDate( DATE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalDateTimeFromLocalDate" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromLocalDate( LocalDate:✓ ):LocalDateTime:✓" )
    void givenCorrectLocalDateParameter_whenGetLocalDateTimeFromLocalDateIsCalled_thenReturnCorrectLocalDateTime(){
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER );
        final LocalDateTime EXPECTED = DATE_IN.atStartOfDay( DEFAULT_ZONE_ID ).toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromLocalDate( DATE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromLocalDate( LocalDate:✓, ZoneId:✓ ):LocalDateTime:✓" )
    void givenCorrectLocalDateAndCorrectZoneIdParameter_whenGetLocalDateTimeFromLocalDateIsCalled_thenReturnCorrectLocalDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER ).atStartOfDay(ZONE_ID_IN).toLocalDate();
        final LocalDateTime EXPECTED = DATE_IN.atStartOfDay( ZONE_ID_IN ).toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromLocalDate( DATE_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromLocalDate( LocalDate:✓, ZoneId:✗ ):NullPointerException" )
    void givenCorrectLocalDateAndZoneIdAsNullParameter_whenGetLocalDateTimeFromLocalDateIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final LocalDate DATE_IN = DEFAULT_LOCAL_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateTimeFromLocalDate( DATE_IN, ZONE_ID_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromLocalDate( LocalDate:✗ ):NullPointerException" )
    void givenLocalDateAsNullParameter_whenGetLocalDateTimeFromLocalDateIsCalled_thenThrowsNullPointerException( final LocalDate DATE_IN ){
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateTimeFromLocalDate( DATE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalDateFromLocalDateTime" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromLocalDateTime( LocalDateTime:✓ ):LocalDate:✓" )
    void givenCorrectLocalDateTimeParameter_whenGetLocalDateFromLocalDateTimeIsCalled_thenReturnCorrectLocalDate(){
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER );
        final LocalDate EXPECTED = DATE_TIME_IN.atZone( DEFAULT_ZONE_ID ).toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromLocalDateTime( DATE_TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromLocalDateTime( LocalDateTime:✓, ZoneId:✓ ):LocalDate:✓" )
    void givenCorrectLocalDateTimeAndCorrectZoneIdParameter_whenGetLocalDateFromLocalDateTimeIsCalled_thenReturnCorrectLocalDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER ).atZone( ZONE_ID_IN ).toLocalDateTime();
        final LocalDate EXPECTED = DATE_TIME_IN.atZone( ZONE_ID_IN ).toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromLocalDateTime( DATE_TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateFromLocalDateTime( LocalDateTime:✓, ZoneId:✗ ):NullPointerException" )
    void givenCorrectLocalDateTimeAndZoneIdAsNullParameter_whenGetLocalDateFromLocalDateTimeIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final LocalDateTime DATE_TIME_IN = DEFAULT_LOCAL_DATE_TIME;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateFromLocalDateTime( DATE_TIME_IN, ZONE_ID_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateFromLocalDateTime( LocalDateTime:✗ ):NullPointerException" )
    void givenLocalDateTimeAsNullParameter_whenGetLocalDateFromLocalDateTimeIsCalled_thenThrowsNullPointerException( final LocalDateTime DATE_TIME_IN ){
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateFromLocalDateTime( DATE_TIME_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalTimeFromLocalDateTime" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromLocalDateTime( LocalDateTime:✓ ):LocalTime:✓" )
    void givenCorrectLocalDateTimeParameter_whenGetLocalTimeFromLocalDateTimeIsCalled_thenReturnCorrectLocalTime(){
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER );
        final LocalTime EXPECTED = DATE_TIME_IN.atZone( DEFAULT_ZONE_ID ).toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromLocalDateTime( DATE_TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromLocalDateTime( LocalDateTime:✓, ZoneId:✓ ):LocalTime:✓" )
    void givenCorrectLocalDateTimeAndCorrectZoneIdParameter_whenGetLocalTimeFromLocalDateTimeIsCalled_thenReturnCorrectLocalTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER ).atZone( ZONE_ID_IN ).toLocalDateTime();
        final LocalTime EXPECTED = DATE_TIME_IN.atZone( ZONE_ID_IN ).toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromLocalDateTime( DATE_TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalTimeFromLocalDateTime( LocalDateTime:✓, ZoneId:✗ ):NullPointerException" )
    void givenCorrectLocalDateTimeAndZoneIdAsNullParameter_whenGetLocalTimeFromLocalDateTimeIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final LocalDateTime DATE_TIME_IN = DEFAULT_LOCAL_DATE_TIME;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalTimeFromLocalDateTime( DATE_TIME_IN, ZONE_ID_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalTimeFromLocalDateTime( LocalDateTime:✗ ):NullPointerException" )
    void givenLocalDateTimeAsNullParameter_whenGetLocalTimeFromLocalDateTimeIsCalled_thenThrowsNullPointerException( final LocalDateTime DATE_TIME_IN ){
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalTimeFromLocalDateTime( DATE_TIME_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalTimeFromDate" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromDate( Date:✓ ):LocalTime:✓" )
    void givenCorrectDateParameter_whenGetLocalTimeFromDateIsCalled_thenReturnCorrectLocalTime(){
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER ).atZone( DEFAULT_ZONE_ID ).toInstant() );
        final LocalTime EXPECTED = DATE_TIME_IN.toInstant().atZone( DEFAULT_ZONE_ID ).toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromDate( DATE_TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromDate( Date:✓, ZoneId:✓ ):LocalTime:✓" )
    void givenCorrectDateAndCorrectZoneIdParameter_whenGetLocalTimeFromDateIsCalled_thenReturnCorrectLocalTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER ).atZone( ZONE_ID_IN ).toInstant() );
        final LocalTime EXPECTED = DATE_TIME_IN.toInstant().atZone( DEFAULT_ZONE_ID ).toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromDate( DATE_TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalTimeFromDate( Date:✓, ZoneId:✗ ):NullPointerException" )
    void givenCorrectDateAndZoneIdAsNullParameter_whenGetLocalTimeFromDateIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final Date DATE_TIME_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalTimeFromDate( DATE_TIME_IN, ZONE_ID_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalTimeFromDate( Date:✗ ):NullPointerException" )
    void givenDateAsNullParameter_whenGetLocalTimeFromDateIsCalled_thenThrowsNullPointerException( final Date DATE_TIME_IN ){
        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalTimeFromDate( DATE_TIME_IN ) );
    }

    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalDateFromString" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓] ):LocalDate:✓" )
    void givenCorrectStringDateParameters_whenGetLocalDateFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( DEFAULT_DATE_FORMATTER_STR ).withLocale( DEFAULT_LOCALE ) )
                                            .atStartOfDay( DEFAULT_ZONE_ID )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:[date:✓] ):LocalDate:✓" )
    void givenCorrectStringDateAndCorrectStringDatePatternParameters_whenGetLocalDateFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                            .atStartOfDay( DEFAULT_ZONE_ID )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], Locale:✓ ):LocalDate:✓" )
    void givenCorrectStringDateAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( DEFAULT_DATE_FORMATTER_STR ).withLocale( LOCALE_IN ) )
                                            .atStartOfDay( DEFAULT_ZONE_ID )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], ZoneId:✓ ):LocalDate:✓" )
    void givenCorrectStringDateAndCorrectZoneIdParameters_whenGetLocalDateFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( DEFAULT_DATE_FORMATTER_STR ).withLocale( DEFAULT_LOCALE ) )
                                            .atStartOfDay( ZONE_ID_IN )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:[datePattern:✓], ZoneId:✓ ):LocalDate:✓" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectZoneIdParameters_whenGetLocalDateFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                            .atStartOfDay( ZONE_ID_IN )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:[datePattern:✓], Locale:✓ ):LocalDate:✓" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                            .atStartOfDay( DEFAULT_ZONE_ID )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], ZoneId:✓, Locale:✓ ):LocalDate:✓" )
    void givenCorrectStringDateAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( DEFAULT_DATE_FORMATTER_STR ).withLocale( LOCALE_IN ) )
                                            .atStartOfDay( ZONE_ID_IN )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:[datePattern:✓], ZoneId:✓, Locale:✓ ):LocalDate:✓" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                            .atStartOfDay( ZONE_ID_IN )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✓, Locale:✓ ):LocalDate:✓" )
    void givenCorrectStringDateTimeAndStringDateTimePatternWithTimeAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenReturnLocalDate(){
        final String DATE_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate EXPECTED = LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                            .atStartOfDay( ZONE_ID_IN )
                                            .toLocalDate();

        LocalDate result = DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy", "dd/tt/yyyy", "dd/MM/tttt" } )
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:✗ ):IllegalArgumentException" )
    void givenCorrectStringDateAndIncorrectStringDatePatternParameters_whenGetLocalDateFromStringIsCalled_thenThrowsIllegalArgumentException(
            final String PATTERN_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "dd-MM-yyyy", "xx/MM/yyyy", "dd/xx/yyyy", "dd/MM/xxxx" } )
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:[datePattern:✗] ):DateTimeParseException" )
    void givenCorrectStringDateAndIncorrectStringDatePatternParameters_whenGetLocalDateFromStringIsCalled_thenThrowsDateTimeParseException(
            final String PATTERN_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "00/06/2021", "25/00/2021", "25/06/0000" } )
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✗], String:[datePattern:✓] ):DateTimeParseException" )
    void givenIncorrectStringDateAndCorrectStringDatePatternParameter_whenGetLocalDateFromStringIsCalled_thenThrowsDateTimeParseException(
            final String DATE_IN ){
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:✗, String:[datePattern:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenStringDateAsNullAndCorrectStringDatePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenThrowsNullPointerException(
            final String DATE_IN ){
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateAndStringDatePatternAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenThrowsNullPointerException(
            final String PATTERN_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:[datePattern:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndZoneIdAsNullAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateFromString( String:[date:✓], String:[datePattern:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectZoneIdAndLocaleAsNullParameters_whenGetLocalDateFromStringIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalDateTimeFromString" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓] ):LocalDateTime:✓" )
    void givenCorrectStringDateTimeParameters_whenGetLocalDateTimeFromStringIsCalled_thenReturnCorrectLocalDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final LocalDateTime EXPECTED = LocalDateTime.parse( DATE_TIME_IN,
                DateTimeFormatter.ofPattern( DEFAULT_DATE_TIME_FORMATTER_STR ).withLocale( DEFAULT_LOCALE ) )
                                                    .atZone( DEFAULT_ZONE_ID )
                                                    .toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓] ):LocalDateTime:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternParameters_whenGetLocalDateTimeFromStringIsCalled_thenReturnCorrectLocalDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final LocalDateTime EXPECTED = LocalDateTime.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                                    .atZone( DEFAULT_ZONE_ID )
                                                    .toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], Locale:✓ ):LocalDateTime:✓" )
    void givenCorrectStringDateTimeAndCorrectLocaleParameters_whenGetLocalDateTimeFromStringIsCalled_thenReturnCorrectLocalDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime EXPECTED = LocalDateTime.parse( DATE_TIME_IN,
                DateTimeFormatter.ofPattern( DEFAULT_DATE_TIME_FORMATTER_STR ).withLocale( LOCALE_IN ) ).atZone( DEFAULT_ZONE_ID ).toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], ZoneId:✓ ):LocalDateTime:✓" )
    void givenCorrectStringDateTimeAndCorrectZoneIdParameters_whenGetLocalDateTimeFromStringIsCalled_thenReturnCorrectLocalDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDateTime EXPECTED = LocalDateTime.parse( DATE_TIME_IN,
                DateTimeFormatter.ofPattern( DEFAULT_DATE_TIME_FORMATTER_STR ).withLocale( DEFAULT_LOCALE ) ).atZone( ZONE_ID_IN ).toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✓ ):LocalDateTime:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectZoneIdParameters_whenGetLocalDateTimeFromStringIsCalled_thenReturnCorrectLocalDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final LocalDateTime EXPECTED = LocalDateTime.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                                    .atZone( ZONE_ID_IN )
                                                    .toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], Locale:✓ ):LocalDateTime:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectLocaleParameters_whenGetLocalDateTimeFromStringIsCalled_thenReturnCorrectLocalDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime EXPECTED = LocalDateTime.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                                    .atZone( DEFAULT_ZONE_ID )
                                                    .toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], ZoneId:✓, Locale:✓ ):LocalDateTime:✓" )
    void givenCorrectStringDateTimeAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateTimeFromStringIsCalled_thenReturnCorrectLocalDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime EXPECTED = LocalDateTime.parse( DATE_TIME_IN,
                DateTimeFormatter.ofPattern( DEFAULT_DATE_TIME_FORMATTER_STR ).withLocale( LOCALE_IN ) ).atZone( ZONE_ID_IN ).toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✓, Locale:✓ ):LocalDateTime:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateTimeFromStringIsCalled_thenReturnCorrectLocalDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime EXPECTED = LocalDateTime.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                                    .atZone( ZONE_ID_IN )
                                                    .toLocalDateTime();

        LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[date:✓], String:[datePattern:✓] ):DateTimeParseException" )
    void givenCorrectStringDateTimeAndCorrectZoneIdAndStringDatePatternWithTimeAndCorrectLocaleParameters_whenGetLocalDateFromStringIsCalled_thenThrowsDateTimeParseException(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getLocalDateTimeFromString( DATE_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy HH:mm:ss", "dd/tt/yyyy HH:mm:ss", "dd/MM/tttt HH:mm:ss", "dd/MM/yyyy tt:mm:ss", "dd/MM/yyyy HH:tt:ss", "dd/MM/yyyy HH:mm:tt" } )
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✗] ):IllegalArgumentException" )
    void givenCorrectStringDateTimeAndIncorrectStringDateTimePatternParameters_whenGetLocalDateTimeFromStringIsCalled_thenThrowsIllegalArgumentException(
            final String PATTERN_IN ){
        final String DATE_TIME_IN = "25/06/2021 17:36:27";

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "dd-MM-yyyy HH:mm:ss", "xx/MM/yyyy HH:mm:ss", "dd/xx/yyyy HH:mm:ss", "dd/MM/xxxx HH:mm:ss", "dd/MM/yyyy xx:mm:ss", "dd/MM/yyyy HH:xx:ss", "dd/MM/yyyy HH:mm:xx" } )
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✗] ):DateTimeParseException" )
    void givenCorrectStringDateTimeAndIncorrectStringDateTimePatternParameters_whenGetLocalDateTimeFromStringIsCalled_thenThrowsDateTimeParseException(
            final String PATTERN_IN ){
        final String DATE_TIME_IN = "25/06/2021 17:36:27";

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "25-06-2021 17/36/27", "00/06/2021 17:36:27", "25/00/2021 17:36:27", "25/06/0000 17:36:27", "25/06/2021 99:36:27", "25/06/2021 17:99:27", "25/06/2021 17:36:99" } )
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✗], String:[dateTimePattern:✓] ):DateTimeParseException" )
    void givenIncorrectStringDateTimeAndCorrectStringDateTimePatternParameter_whenGetLocalDateTimeFromStringIsCalled_thenThrowsDateTimeParseException(
            final String DATE_TIME_IN ){
        final String PATTERN_IN = "dd/MM/yyyy HH:mm:ss";

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:✗, String:[dateTimePattern:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenStringDateTimeAsNullAndCorrectStringDateTimePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateTimeFromStringIsCalled_thenThrowsNullPointerException(
            final String DATE_TIME_IN ){
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateTimeAndStringDateTimePatternAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalDateTimeFromStringIsCalled_thenThrowsNullPointerException(
            final String PATTERN_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndZoneIdAsNullAndCorrectLocaleParameters_whenGetLocalDateTimeFromStringIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectZoneIdAndLocaleAsNullParameters_whenGetLocalDateTimeFromStringIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getDateFromString" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓] ):Date:✓" )
    void givenCorrectStringDateParameters_whenGetDateFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final Date EXPECTED = Date.from(
                LocalDate.parse( DATE_IN, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) ).atStartOfDay( DEFAULT_ZONE_ID ).toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:[datePattern:✓] ):Date:✓" )
    void givenCorrectStringDateAndCorrectStringDatePatternParameters_whenGetDateFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final Date EXPECTED = Date.from( LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                                  .atStartOfDay( DEFAULT_ZONE_ID )
                                                  .toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], Locale:✓ ):Date:✓" )
    void givenCorrectStringDateAndCorrectLocaleParameters_whenGetDateFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from(
                LocalDate.parse( DATE_IN, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) ).atStartOfDay( DEFAULT_ZONE_ID ).toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], ZoneId:✓ ):Date:✓" )
    void givenCorrectStringDateAndCorrectZoneIdParameters_whenGetDateFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date EXPECTED = Date.from(
                LocalDate.parse( DATE_IN, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) ).atStartOfDay( ZONE_ID_IN ).toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:[datePattern:✓], ZoneId:✓ ):Date:✓" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectZoneIdParameters_whenGetDateFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final Date EXPECTED = Date.from( LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                                  .atStartOfDay( ZONE_ID_IN )
                                                  .toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:[datePattern:✓], Locale:✓ ):Date:✓" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectLocaleParameters_whenGetDateFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from( LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                                  .atStartOfDay( DEFAULT_ZONE_ID )
                                                  .toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], ZoneId:✓, Locale:✓ ):Date:✓" )
    void givenCorrectStringDateAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from(
                LocalDate.parse( DATE_IN, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) ).atStartOfDay( ZONE_ID_IN ).toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:[datePattern:✓], ZoneId:✓, Locale:✓ ):Date:✓" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from( LocalDate.parse( DATE_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                                  .atStartOfDay( ZONE_ID_IN )
                                                  .toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✓, Locale:✓ ):Date:✓" )
    void givenCorrectStringDateTimeAndStringDateTimePatternWithTimeAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateFromStringIsCalled_thenReturnDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from( LocalDate.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                                  .atStartOfDay( ZONE_ID_IN )
                                                  .toInstant() );

        Date result = DateTimeUtil.getDateFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy", "dd/tt/yyyy", "dd/MM/tttt" } )
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:[datePattern:✗] ):IllegalArgumentException" )
    void givenCorrectStringDateAndIncorrectStringDatePatternParameters_whenGetDateFromStringIsCalled_thenThrowsIllegalArgumentException(
            final String PATTERN_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "dd-MM-yyyy", "xx/MM/yyyy", "dd/xx/yyyy", "dd/MM/xxxx" } )
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:[datePattern:✗] ):DateTimeParseException" )
    void givenCorrectStringDateAndIncorrectStringDatePatternParameters_whenGetDateFromStringIsCalled_thenThrowsDateTimeParseException(
            final String PATTERN_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "00/06/2021", "25/00/2021", "25/06/0000" } )
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✗], String:[datePattern:✓] ):DateTimeParseException" )
    void givenIncorrectStringDateAndCorrectStringDatePatternParameter_whenGetDateFromStringIsCalled_thenThrowsDateTimeParseException(
            final String DATE_IN ){
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateFromString( String:✗, String:[datePattern:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenStringDateAsNullAndCorrectStringDatePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateFromStringIsCalled_thenThrowsNullPointerException(
            final String DATE_IN ){
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateAndStringDatePatternAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateFromStringIsCalled_thenThrowsNullPointerException(
            final String PATTERN_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:[datePattern:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndZoneIdAsNullAndCorrectLocaleParameters_whenGetDateFromStringIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateFromString( String:[date:✓], String:[datePattern:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectZoneIdAndLocaleAsNullParameters_whenGetDateFromStringIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateFromString( DATE_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getDateTimeFromString" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓] ):Date:✓" )
    void givenCorrectStringDateTimeParameters_whenGetDateTimeFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final Date EXPECTED = Date.from(
                LocalDateTime.parse( DATE_TIME_IN, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) ).atZone( DEFAULT_ZONE_ID ).toInstant() );

        Date result = DateTimeUtil.getDateTimeFromString( DATE_TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓] ):Date:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternParameters_whenGetDateTimeFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Date EXPECTED = Date.from( LocalDateTime.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                                      .atZone( DEFAULT_ZONE_ID )
                                                      .toInstant() );

        Date result = DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], Locale:✓ ):Date:✓" )
    void givenCorrectStringDateTimeAndCorrectLocaleParameters_whenGetDateTimeFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from(
                LocalDateTime.parse( DATE_TIME_IN, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) ).atZone( DEFAULT_ZONE_ID ).toInstant() );

        Date result = DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], ZoneId:✓ ):Date:✓" )
    void givenCorrectStringDateTimeAndCorrectZoneIdParameters_whenGetDateTimeFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date EXPECTED = Date.from(
                LocalDateTime.parse( DATE_TIME_IN, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) ).atZone( ZONE_ID_IN ).toInstant() );

        Date result = DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✓ ):Date:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectZoneIdParameters_whenGetDateTimeFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Date EXPECTED = Date.from( LocalDateTime.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                                      .atZone( ZONE_ID_IN )
                                                      .toInstant() );

        Date result = DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], Locale:✓ ):Date:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectLocaleParameters_whenGetDateTimeFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN_TIME = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from( LocalDateTime.parse( DATE_IN_TIME, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                                      .atZone( DEFAULT_ZONE_ID )
                                                      .toInstant() );

        Date result = DateTimeUtil.getDateTimeFromString( DATE_IN_TIME, PATTERN_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], ZoneId:✓, Locale:✓ ):Date:✓" )
    void givenCorrectStringDateTimeAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateTimeFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_IN_TIME = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from(
                LocalDateTime.parse( DATE_IN_TIME, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) ).atZone( ZONE_ID_IN ).toInstant() );

        Date result = DateTimeUtil.getDateTimeFromString( DATE_IN_TIME, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✓, Locale:✓ ):Date:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateTimeFromStringIsCalled_thenReturnCorrectDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date EXPECTED = Date.from( LocalDateTime.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                                      .atZone( ZONE_ID_IN )
                                                      .toInstant() );

        Date result = DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy HH:mm", "dd/tt/yyyy HH:mm", "dd/MM/tttt HH:mm", "dd/MM/yyyy tt:mm", "dd/MM/yyyy HH:tt" } )
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:✗ ):IllegalArgumentException" )
    void givenCorrectStringDateTimeAndIncorrectStringDateTimePatternParameters_whenGetDateTimeFromStringIsCalled_thenThrowsIllegalArgumentException(
            final String PATTERN_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "dd-MM-yyyy HH/mm", "xx/MM/yyyy HH:mm", "dd/xx/yyyy HH:mm", "dd/MM/xxxx HH:mm", "dd/MM/yyyy xx:mm", "dd/MM/yyyy HH:xx" } )
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✗] ):DateTimeParseException" )
    void givenCorrectStringDateTimeAndIncorrectStringDateTimePatternParameters_whenGetDateTimeFromStringIsCalled_thenThrowsDateTimeParseException(
            final String PATTERN_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "00/06/2021 17:36", "25/00/2021 17:36", "25/06/0000 17:36", "25/06/2021 99:36", "25/06/2021 17:99" } )
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:✗, String:[dateTimePattern:✓] ):DateTimeParseException" )
    void givenIncorrectStringDateTimeAndCorrectStringDateTimePatternParameter_whenGetDateTimeFromStringIsCalled_thenThrowsDateTimeParseException(
            final String DATE_TIME_IN ){
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:✗, String:[dateTimePattern:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenStringDateTimeAsNullAndCorrectStringDateTimePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateTimeFromStringIsCalled_thenThrowsNullPointerException(
            final String DATE_TIME_IN ){
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateTimeAndStringDateTimePatternAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenGetDateTimeFromStringIsCalled_thenThrowsNullPointerException(
            final String PATTERN_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndZoneIdAsNullAndCorrectLocaleParameters_whenGetDateTimeFromStringIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getDateTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectZoneIdAndLocaleAsNullParameters_whenGetDateTimeFromStringIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getDateTimeFromString( DATE_TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "getLocalTimeFromString" method.
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓] ):LocalTime:✓" )
    void givenCorrectStringTimeParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final LocalTime EXPECTED = LocalTime.parse( TIME_IN, DEFAULT_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                            .atDate( LocalDate.now( DEFAULT_ZONE_ID ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], String:[timePattern:✓] ):LocalTime:✓" )
    void givenCorrectStringTimeAndCorrectStringTimePatternParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final LocalTime EXPECTED = LocalTime.parse( TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                            .atDate( LocalDate.now( DEFAULT_ZONE_ID ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], Locale:✓ ):LocalTime:✓" )
    void givenCorrectStringTimeAndCorrectLocaleParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime EXPECTED = LocalTime.parse( TIME_IN, DEFAULT_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                            .atDate( LocalDate.now( DEFAULT_ZONE_ID ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( TIME_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], ZoneId:✓ ):LocalTime:✓" )
    void givenCorrectStringTimeAndCorrectZoneIdParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalTime EXPECTED = LocalTime.parse( TIME_IN, DEFAULT_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                            .atDate( LocalDate.now( ZONE_ID_IN ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], String:[timePattern:✓], ZoneId:✓ ):LocalTime:✓" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectZoneIdParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final LocalTime EXPECTED = LocalTime.parse( TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                            .atDate( LocalDate.now( ZONE_ID_IN ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], String:[timePattern:✓], Locale:✓ ):LocalTime:✓" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectLocaleParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime EXPECTED = LocalTime.parse( TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                            .atDate( LocalDate.now( DEFAULT_ZONE_ID ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], ZoneId:✓, Locale:✓ ):LocalTime:✓" )
    void givenCorrectStringTimeAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime EXPECTED = LocalTime.parse( TIME_IN, DEFAULT_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                            .atDate( LocalDate.now( ZONE_ID_IN ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( TIME_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], String:[timePattern:✓], ZoneId:✓, Locale:✓ ):LocalTime:✓" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime EXPECTED = LocalTime.parse( TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( LOCALE_IN ) )
                                            .atDate( LocalDate.now( ZONE_ID_IN ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[dateTime:✓], String:[dateTimePattern:✓] ):LocalTime:✓" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternParameters_whenGetLocalTimeFromStringIsCalled_thenReturnCorrectLocalTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final LocalTime EXPECTED = LocalTime.parse( DATE_TIME_IN, DateTimeFormatter.ofPattern( PATTERN_IN ).withLocale( DEFAULT_LOCALE ) )
                                            .atDate( LocalDate.now( DEFAULT_ZONE_ID ) )
                                            .toLocalTime();

        LocalTime result = DateTimeUtil.getLocalTimeFromString( DATE_TIME_IN, PATTERN_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[date:✓], String:[datePattern:✓] ):DateTimeParseException" )
    void givenCorrectStringDateTimeAndIncorrectStringDateTimePatternParameters_whenGetLocalTimeFromStringIsCalled_thenThrowsDateTimeParseException(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getLocalTimeFromString( DATE_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt:mm:ss", "HH:tt:ss", "HH:mm:tt" } )
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], String:[timePattern:✗] ):IllegalArgumentException" )
    void givenCorrectStringTimeAndIncorrectStringTimePatternParameters_whenGetLocalTimeFromStringIsCalled_thenThrowsIllegalArgumentException(
            final String PATTERN_IN ){
        final String TIME_IN = DEFAULT_TIME_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "HH/mm/ss", "xx:mm:ss", "HH:xx:ss", "HH:mm:xx" } )
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], String:[timePattern:✗] ):DateTimeParseException" )
    void givenCorrectStringTimeAndIncorrectStringTimePatternParameters_whenGetLocalTimeFromStringIsCalled_thenThrowsDateTimeParseException(
            final String PATTERN_IN ){
        final String TIME_IN = DEFAULT_TIME_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource( strings = { "17-36-27", "99:36:27", "17:99:27", "17:36:99" } )
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:✗, String:[timePattern:✓] ):DateTimeParseException" )
    void givenIncorrectStringTimeAndCorrectStringTimePatternParameter_whenGetLocalTimeFromStringIsCalled_thenThrowsDateTimeParseException(
            final String TIME_IN ){
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:✗, String:[timePattern:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenStringTimeAsNullAndCorrectStringTimePatternAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalTimeFromStringIsCalled_thenThrowsNullPointerException(
            final String TIME_IN ){
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringTimeAndStringTimePatternAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenGetLocalTimeFromStringIsCalled_thenThrowsNullPointerException(
            final String PATTERN_IN ){
        final String TIME_IN = DEFAULT_TIME_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:time:✓], String:[timePattern:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndZoneIdAsNullAndCorrectLocaleParameters_whenGetLocalTimeFromStringIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.getLocalTimeFromString( String:[time:✓], String:[timePattern:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectZoneIdAndLocaleAsNullParameters_whenGetLocalTimeFromStringIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.getLocalTimeFromString( TIME_IN, PATTERN_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "formatDate" method (LocalDate).
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓ ):String[date:✓]" )
    void givenCorrectLocalDateParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atStartOfDay( DEFAULT_ZONE_ID )
                                           .toLocalDate();
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateFormatter:✓] ):String:[date:✓]" )
    void givenCorrectLocalDateAndCorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atStartOfDay( DEFAULT_ZONE_ID )
                                           .toLocalDate();
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, Locale:✓ ):String:[date:✓]" )
    void givenCorrectLocalDateAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) )
                                         .atStartOfDay( DEFAULT_ZONE_ID )
                                         .toLocalDate();
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, ZoneId:✓ ):String:[date:✓]" )
    void givenCorrectLocalDateAndCorrectZoneIdParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                        .atStartOfDay( ZONE_ID_IN )
                                        .toLocalDate();
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateFormatter:✓], ZoneId:✓ ):String:[date:✓]" )
    void givenCorrectLocalDateAndCorrectStringDateFormatterAndCorrectZoneIdParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atStartOfDay( ZONE_ID_IN )
                                           .toLocalDate();
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateFormatter:✓], Locale:✓ ):String:[date:✓]" )
    void givenCorrectLocalDateAndCorrectStringDateFormatterAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atStartOfDay( DEFAULT_ZONE_ID )
                                           .toLocalDate();
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, ZoneId:✓, Locale:✓ ):String:[date:✓]" )
    void givenCorrectLocalDateAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atStartOfDay( ZONE_ID_IN )
                                           .toLocalDate();
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateFormatter:✓], ZoneId:✓, Locale:✓ ):String:[date:✓]" )
    void givenCorrectLocalDateAndCorrectStringDateFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atStartOfDay( ZONE_ID_IN )
                                           .toLocalDate();
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateTimeFormatter:✓] ):String:[date:✓]" )
    void givenCorrectLocalDateAndCorrectStringDateTimeFormatterEmptyParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate( ){
        final LocalDate DATE_IN = LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atStartOfDay( DEFAULT_ZONE_ID )
                                           .toLocalDate();
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String EXPECTED = String.format( "%s 00:00", DEFAULT_DATE_STR );

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateFormatter:✓][Empty] ):String:[date:✓][Empty]" )
    void givenCorrectLocalDateAndCorrectStringDateFormatterEmptyParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDateEmpty( final String FORMATTER_IN ){
        final LocalDate DATE_IN = DEFAULT_LOCAL_DATE;
        final String EXPECTED = "";

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy", "dd/tt/yyyy", "dd/MM/tttt" } )
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateFormatter:✗] ):IllegalArgumentException" )
    void givenCorrectLocalDateAndIncorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenThrowsIllegalArgumentException(
            final String FORMATTER_IN ){
        final LocalDate DATE_IN = DEFAULT_LOCAL_DATE;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✗, String:[dateFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenLocalDateAsNullAndCorrectStringDateFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(
            final LocalDate DATE_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectLocalDateAndStringDateFormatterAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(
            final String FORMATTER_IN ){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate DATE_IN = DEFAULT_LOCAL_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateFormatter:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectLocalDateAndCorrectStringDateFormatterAndZoneIdAsNullAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDate DATE_IN = DEFAULT_LOCAL_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( LocalDate:✓, String:[dateFormatter:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectLocalDateAndCorrectStringDateFormatterAndCorrectZoneIdAndLocaleAsNullParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDate DATE_IN = DEFAULT_LOCAL_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "formatDateTime" method (LocalDateTime).
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓ ):String[dateTime:✓]" )
    void givenCorrectLocalDateTimeParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atZone( DEFAULT_ZONE_ID )
                                           .toLocalDateTime();
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateTimeFormatter:✓] ):String:[dateTime:✓]" )
    void givenCorrectLocalDateTimeAndCorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atZone( DEFAULT_ZONE_ID )
                                           .toLocalDateTime();
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, Locale:✓ ):String:[dateTime:✓]" )
    void givenCorrectLocalDateTimeAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atZone( DEFAULT_ZONE_ID )
                                           .toLocalDateTime();
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, ZoneId:✓ ):String:[dateTime:✓]" )
    void givenCorrectLocalDateTimeAndCorrectZoneIdParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atZone( ZONE_ID_IN )
                                           .toLocalDateTime();
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateTimeFormatter:✓], ZoneId:✓ ):String:[dateTime:✓]" )
    void givenCorrectLocalDateTimeAndCorrectStringDateTimeFormatterAndCorrectZoneIdParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atZone( ZONE_ID_IN )
                                           .toLocalDateTime();
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateTimeFormatter:✓], Locale:✓ ):String:[dateTime:✓]" )
    void givenCorrectLocalDateTimeAndCorrectStringDateTimeFormatterAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atZone( DEFAULT_ZONE_ID )
                                           .toLocalDateTime();
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, ZoneId:✓, Locale:✓ ):String:[dateTime:✓]" )
    void givenCorrectLocalDateTimeAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atZone( ZONE_ID_IN )
                                           .toLocalDateTime();
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateTimeFormatter:✓], ZoneId:✓, Locale:✓ ):String:[dateTime:✓]" )
    void givenCorrectLocalDateTimeAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atZone( ZONE_ID_IN )
                                           .toLocalDateTime();
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateFormatter:✓] ):String:[date:✓]" )
    void givenCorrectLocalDateTimeAndCorrectStringDateFormatterEmptyParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDate( ){
        final LocalDateTime DATE_TIME_IN = LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atZone( DEFAULT_ZONE_ID )
                                           .toLocalDateTime();
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateTimeFormatter:✓][Empty] ):String:[dateTime:✓][Empty]" )
    void givenCorrectLocalDateTimeAndCorrectStringDateTimeFormatterEmptyParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTimeEmpty( final String FORMATTER_IN ){
        final LocalDateTime DATE_TIME_IN = DEFAULT_LOCAL_DATE_TIME;
        final String EXPECTED = "";

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy HH:mm", "dd/tt/yyyy HH:mm", "dd/MM/tttt HH:mm", "dd/MM/yyyyy tt:mm", "dd/MM/yyyyy HH:tt" } )
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateTimeFormatter:✗] ):IllegalArgumentException" )
    void givenCorrectLocalDateTimeAndIncorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenThrowsIllegalArgumentException(
            final String FORMATTER_IN ){
        final LocalDateTime DATE_TIME_IN = DEFAULT_LOCAL_DATE_TIME;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✗, String:[dateTimeFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenLocalDateTimeAsNullAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(
            final LocalDateTime DATE_TIME_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectLocalDateTimeAndStringDateTimeFormatterAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(
            final String FORMATTER_IN ){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime DATE_TIME_IN = DEFAULT_LOCAL_DATE_TIME;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateTimeFormatter:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectLocalDateTimeAndCorrectStringDateTimeFormatterAndZoneIdAsNullAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalDateTime DATE_TIME_IN = DEFAULT_LOCAL_DATE_TIME;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( LocalDateTime:✓, String:[dateTimeFormatter:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectLocalDateTimeAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndLocaleAsNullParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalDateTime DATE_TIME_IN = DEFAULT_LOCAL_DATE_TIME;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "formatDateTime" method (Date).
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓ ):String[dateTime:✓]" )
    void givenCorrectDateParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                        .atZone( DEFAULT_ZONE_ID )
                                                        .toInstant() );
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateTimeFormatter:✓] ):String:[dateTime:✓]" )
    void givenCorrectDateAndCorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                        .atZone( DEFAULT_ZONE_ID )
                                                        .toInstant() );
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, Locale:✓ ):String:[dateTime:✓]" )
    void givenCorrectDateAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                                        .atZone( DEFAULT_ZONE_ID )
                                                        .toInstant() );
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, ZoneId:✓ ):String:[dateTime:✓]" )
    void givenCorrectDateAndCorrectZoneIdParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                        .atZone( ZONE_ID_IN )
                                                        .toInstant() );
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateTimeFormatter:✓], ZoneId:✓ ):String:[dateTime:✓]" )
    void givenCorrectDateAndCorrectStringDateTimeFormatterAndCorrectZoneIdParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                        .atZone( ZONE_ID_IN )
                                                        .toInstant() );
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateTimeFormatter:✓], Locale:✓ ):String:[dateTime:✓]" )
    void givenCorrectDateAndCorrectStringDateTimeFormatterAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                                        .atZone( DEFAULT_ZONE_ID )
                                                        .toInstant() );
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, ZoneId:✓, Locale:✓ ):String:[dateTime:✓]" )
    void givenCorrectDateAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                                        .atZone( ZONE_ID_IN )
                                                        .toInstant() );
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateTimeFormatter:✓], ZoneId:✓, Locale:✓ ):String:[dateTime:✓]" )
    void givenCorrectDateAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                                        .atZone( ZONE_ID_IN )
                                                        .toInstant() );
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateFormatter:✓] ):String:[date:✓]" )
    void givenCorrectDateAndCorrectStringDateFormatterEmptyParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDate( ){
        final Date DATE_TIME_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                        .atZone( DEFAULT_ZONE_ID )
                                                        .toInstant() );
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateTimeFormatter:✓][Empty] ):String:[dateTime:✓][Empty]" )
    void givenCorrectDateAndCorrectStringDateTimeFormatterEmptyParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTimeEmpty( final String FORMATTER_IN ){
        final Date DATE_TIME_IN = DEFAULT_DATE;
        final String EXPECTED = "";

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy HH:mm", "dd/tt/yyyy HH:mm", "dd/MM/tttt HH:mm", "dd/MM/yyyyy tt:mm", "dd/MM/yyyyy HH:tt" } )
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateTimeFormatter:✗] ):IllegalArgumentException" )
    void givenCorrectDateAndIncorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenThrowsIllegalArgumentException(
            final String FORMATTER_IN ){
        final Date DATE_TIME_IN = DEFAULT_DATE;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✗, String:[dateTimeFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenDateAsNullAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(
            final Date DATE_TIME_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectDateAndStringDateTimeFormatterAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(
            final String FORMATTER_IN ){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_TIME_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateTimeFormatter:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectDateAndCorrectStringDateTimeFormatterAndZoneIdAsNullAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_TIME_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( Date:✓, String:[dateTimeFormatter:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectDateAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndLocaleAsNullParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date DATE_TIME_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "formatDate" method (Date).
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:✓ ):String[date:✓]" )
    void givenCorrectDateParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atStartOfDay( DEFAULT_ZONE_ID ).toInstant() );
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:[dateFormatter:✓] ):String:[date:✓]" )
    void givenCorrectDateAndCorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                      .atStartOfDay( DEFAULT_ZONE_ID ).toInstant() );
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, Locale:✓ ):String:[date:✓]" )
    void givenCorrectDateAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) )
                                                      .atStartOfDay( DEFAULT_ZONE_ID ).toInstant() );
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, ZoneId:✓ ):String:[date:✓]" )
    void givenCorrectDateAndCorrectZoneIdParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                      .atStartOfDay( ZONE_ID_IN ).toInstant() );
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:[dateFormatter:✓], ZoneId:✓ ):String:[date:✓]" )
    void givenCorrectDateAndCorrectStringDateFormatterAndCorrectZoneIdParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                      .atStartOfDay( ZONE_ID_IN ).toInstant() );
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:[dateFormatter:✓], Locale:✓ ):String:[date:✓]" )
    void givenCorrectDateAndCorrectStringDateFormatterAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) )
                                                      .atStartOfDay( DEFAULT_ZONE_ID ).toInstant() );
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, ZoneId:✓, Locale:✓ ):String:[date:✓]" )
    void givenCorrectDateAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) )
                                                      .atStartOfDay( ZONE_ID_IN ).toInstant() );
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:[dateFormatter:✓], ZoneId:✓, Locale:✓ ):String:[date:✓]" )
    void givenCorrectDateAndCorrectStringDateFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_IN = Date.from( LocalDate.parse( DEFAULT_DATE_STR, DEFAULT_DATE_FORMATTER.withLocale( LOCALE_IN ) )
                                                      .atStartOfDay( ZONE_ID_IN ).toInstant() );
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( Date:[dateTime:✓], String:[dateTimeFormatter:✓] ):String:[date:✓]" )
    void givenCorrectDateAndCorrectStringDateTimeFormatterEmptyParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate( ){
        final Date DATE_IN = Date.from( LocalDateTime.parse( DEFAULT_DATE_TIME_STR, DEFAULT_DATE_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                                      .atZone( DEFAULT_ZONE_ID ).toInstant() );
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:[dateFormatter:✓][Empty] ):String:[date:✓][Empty]" )
    void givenCorrectDateAndCorrectStringDateFormatterEmptyParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDateEmpty( final String FORMATTER_IN ){
        final Date DATE_IN = DEFAULT_DATE;
        final String EXPECTED = "";

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy", "dd/tt/yyyy", "dd/MM/tttt", "dd/MM/yyyy tt:mm", "dd/MM/yyyy HH:tt" } )
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:[dateFormatter:✗] ):IllegalArgumentException" )
    void givenCorrectDateAndIncorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenThrowsIllegalArgumentException(
            final String FORMATTER_IN ){
        final Date DATE_IN = DEFAULT_DATE;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( Date:✗, String:[dateFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenDateAsNullAndCorrectStringDateFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(
            final Date DATE_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectDateAndStringDateFormatterAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(
            final String FORMATTER_IN ){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:[dateFormatter:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectDateAndCorrectStringDateFormatterAndZoneIdAsNullAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final Date DATE_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( Date:✓, String:[dateFormatter:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectDateAndCorrectStringDateFormatterAndCorrectZoneIdAndLocaleAsNullParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Date DATE_IN = DEFAULT_DATE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "formatTime" method (LocalTime).
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓ ):String[time:✓]" )
    void givenCorrectLocalTimeParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final LocalTime TIME_IN = LocalTime.parse( DEFAULT_TIME_STR, DEFAULT_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atDate(LocalDate.now( DEFAULT_ZONE_ID ) ).toLocalTime();
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:[timeFormatter:✓] ):String:[time:✓]" )
    void givenCorrectLocalTimeAndCorrectStringTimeFormatterParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final LocalTime TIME_IN = LocalTime.parse( DEFAULT_TIME_STR, DEFAULT_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atDate(LocalDate.now( DEFAULT_ZONE_ID ) ).toLocalTime();
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, Locale:✓ ):String:[time:✓]" )
    void givenCorrectLocalTimeAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime TIME_IN = LocalTime.parse( DEFAULT_TIME_STR, DEFAULT_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atDate(LocalDate.now( DEFAULT_ZONE_ID ) ).toLocalTime();
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, ZoneId:✓ ):String:[time:✓]" )
    void givenCorrectLocalTimeAndCorrectZoneIdParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalTime TIME_IN = LocalTime.parse( DEFAULT_TIME_STR, DEFAULT_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atDate(LocalDate.now( ZONE_ID_IN ) ).toLocalTime();
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:[timeFormatter:✓], ZoneId:✓ ):String:[time:✓]" )
    void givenCorrectLocalTimeAndCorrectStringTimeFormatterAndCorrectZoneIdParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final LocalTime TIME_IN = LocalTime.parse( DEFAULT_TIME_STR, DEFAULT_TIME_FORMATTER.withLocale( DEFAULT_LOCALE ) )
                                           .atDate(LocalDate.now( ZONE_ID_IN ) ).toLocalTime();
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:[timeFormatter:✓], Locale:✓ ):String:[time:✓]" )
    void givenCorrectLocalTimeAndCorrectStringTimeFormatterAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime TIME_IN = LocalTime.parse( DEFAULT_TIME_STR, DEFAULT_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atDate(LocalDate.now( DEFAULT_ZONE_ID ) ).toLocalTime();
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, ZoneId:✓, Locale:✓ ):String:[time:✓]" )
    void givenCorrectLocalTimeAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime TIME_IN = LocalTime.parse( DEFAULT_TIME_STR, DEFAULT_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atDate(LocalDate.now( ZONE_ID_IN ) ).toLocalTime();
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:[timeFormatter:✓], ZoneId:✓, Locale:✓ ):String:[time:✓]" )
    void givenCorrectLocalTimeAndCorrectStringTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime TIME_IN = LocalTime.parse( DEFAULT_TIME_STR, DEFAULT_TIME_FORMATTER.withLocale( LOCALE_IN ) )
                                           .atDate(LocalDate.now( ZONE_ID_IN ) ).toLocalTime();
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:[timeFormatter:✓][Empty] ):String:[time:✓][Empty]" )
    void givenCorrectLocalTimeAndCorrectStringTimeFormatterEmptyParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTimeEmpty( final String FORMATTER_IN ){
        final LocalTime TIME_IN = DEFAULT_LOCAL_TIME;
        final String EXPECTED = "";

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt:mm:ss", "HH:tt:ss", "HH:mm:tt", "tt/MM/yyyy HH:mm", "dd/tt/yyyy HH:mm", "dd/MM/tttt HH:mm", "dd/MM/yyyyy tt:mm", "dd/MM/yyyyy HH:tt" } )
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:[timeFormatter:✗] ):IllegalArgumentException" )
    void givenCorrectLocalTimeAndIncorrectStringTimeFormatterParameters_whenFormatTimeIsCalled_thenThrowsIllegalArgumentException(
            final String FORMATTER_IN ){
        final LocalTime TIME_IN = DEFAULT_LOCAL_TIME;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✗, String:[timeFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenLocalTimeAsNullAndCorrectStringTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(
            final LocalTime TIME_IN ){
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:✗, ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectLocalTimeAndStringTimeFormatterAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(
            final String FORMATTER_IN ){
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime TIME_IN = DEFAULT_LOCAL_TIME;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:[timeFormatter:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectLocalTimeAndCorrectStringTimeFormatterAndZoneIdAsNullAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(
            final ZoneId ZONE_ID_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final LocalTime TIME_IN = DEFAULT_LOCAL_TIME;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( LocalTime:✓, String:[timeFormatter:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectDateTimeAndCorrectStringTimeFormatterAndCorrectZoneIdAndLocaleAsNullParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(
            final Locale LOCALE_IN ){
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final LocalTime TIME_IN = DEFAULT_LOCAL_TIME;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "formatDate" method (String).
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[dateFormatter:✓] ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[datePattern:✓], String[dateFormatter:✓] ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[dateFormatter:✓], ZoneId:✓ ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDateFormatterAndCorrectZoneIdParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[dateFormatter:✓], Locale:✓ ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDateFormatterAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[datePattern:✓], String[dateFormatter:✓], ZoneId:✓ ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectStringDateFormatterAndCorrectZoneIdParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[datePattern:✓], String[dateFormatter:✓], Locale:✓ ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectStringDateFormatterAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[dateFormatter:✓], ZoneId:✓, Locale:✓ ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDateFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[datePattern:✓], String[dateFormatter:✓], ZoneId:✓, Locale:✓ ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectStringDateFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[dateTime:✓], String[dateTimePattern:✓], String[dateFormatter:✓] ):String[date:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDate( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✓] ):String[date:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateTimeFormatterParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String EXPECTED = String.format( "%s 00:00", DEFAULT_DATE_STR );

        String result = DateTimeUtil.formatDate( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[datePattern:✓], String[dateTimeFormatter:✓] ):String[date:✓]" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectStringDateTimeFormatterParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String EXPECTED = String.format( "%s 00:00", DEFAULT_DATE_STR );

        String result = DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[datePattern:✓], String[dateFormatter:✓][Empty] ):String[date:✓][Empty]" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndStringDateFormatterEmptyParameters_whenFormatDateIsCalled_thenReturnCorrectStringFormattedDateEmpty( final String FORMATTER_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String EXPECTED = "";

        String result = DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy", "dd/tt/yyyy", "dd/MM/tttt" } )
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[datePattern:✗], String[dateFormatter:✓] ):IllegalArgumentException" )
    void givenCorrectStringDateAndIncorrectStringDatePatternAndCorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenThrowsIllegalArgumentException(
            final String PATTERN_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy", "dd/tt/yyyy", "dd/MM/tttt" } )
    @DisplayName( "DateTimeUtil.formatDate( String[date:✓], String[datePattern:✓], String[dateFormatter:✗] ):IllegalArgumentException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndIncorrectStringDateFormatterParameters_whenFormatDateIsCalled_thenThrowsIllegalArgumentException(
            final String FORMATTER_IN ){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( String:✗, String[datePattern:✓], String[dateFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenStringDateAsNullAndCorrectStringDatePatternAndCorrectStringDateFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(){
        final String DATE_IN = null;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( String:[date:✓], String[datePattern:✗], String[dateFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateAndStringDatePatternAsNullAndCorrectStringDateFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = null;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( String:[date:✓], String[datePattern:✓], String[dateFormatter:✗], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndStringDateFormatterAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = null;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( String:[date:✓], String[datePattern:✓], String[dateFormatter:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectStringDateFormatterAndZoneIdAsNullAndCorrectLocaleParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = null;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDate( String:[date:✓], String[datePattern:✓], String[dateFormatter:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectStringDateFormatterAndCorrectZoneIdAndLocaleAsNullParameters_whenFormatDateIsCalled_thenThrowsNullPointerException(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = null;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDate( DATE_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "formatDateTime" method (String).
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimeFormatter:✓] ):String[dateTime:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✓] ):String[dateTime:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimeFormatter:✓], ZoneId:✓ ):String[dateTime:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimeFormatterAndCorrectZoneIdParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimeFormatter:✓], Locale:✓ ):String[dateTime:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimeFormatterAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✓], ZoneId:✓ ):String[dateTime:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateTimeFormatterAndCorrectZoneIdParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✓], Locale:✓ ):String[dateTime:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateTimeFormatterAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimeFormatter:✓], ZoneId:✓, Locale:✓ ):String[dateTime:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✓], ZoneId:✓, Locale:✓ ):String[dateTime:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTime(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_DATE_TIME_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimePattern:✓], String[dateFormatter:✓] ):String[date:✓]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateFormatterParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDate(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;
        final String EXPECTED = DEFAULT_DATE_STR;

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✓][Empty] ):String[dateTime:✓][Empty]" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndStringDateTimeFormatterEmptyParameters_whenFormatDateTimeIsCalled_thenReturnCorrectStringFormattedDateTimeEmpty( final String FORMATTER_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String EXPECTED = "";

        String result = DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatDateTime( String[date:✓], String[datePattern:✓], String[dateTimeFormatter:✓] ):DateTimeParseException" )
    void givenCorrectStringDateAndCorrectStringDatePatternAndCorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenThrowsDateTimeParseException(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.formatDateTime( DATE_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy HH:mm", "dd/tt/yyyy HH:mm", "dd/MM/tttt HH:mm", "dd/MM/yyyy tt:mm", "dd/MM/yyyy HH:tt" } )
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimePattern:✗], String[dateTimeFormatter:✓] ):IllegalArgumentException" )
    void givenCorrectStringDateTimeAndIncorrectStringDateTimePatternAndCorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenThrowsIllegalArgumentException(
            final String PATTERN_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt/MM/yyyy HH:mm", "dd/tt/yyyy HH:mm", "dd/MM/tttt HH:mm", "dd/MM/yyyy tt:mm", "dd/MM/yyyy HH:tt" } )
    @DisplayName( "DateTimeUtil.formatDateTime( String[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✗] ):IllegalArgumentException" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndIncorrectStringDateTimeFormatterParameters_whenFormatDateTimeIsCalled_thenThrowsIllegalArgumentException(
            final String FORMATTER_IN ){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( String:✗, String[dateTimePattern:✓], String[dateTimeFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenStringDateTimeAsNullAndCorrectStringDateTimePatternAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(){
        final String DATE_TIME_IN = null;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( String:[dateTime:✓], String[dateTimePattern:✗], String[dateTimeFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateTimeAndStringDateTimePatternAsNullAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = null;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( String:[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✗], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndStringDateTimeFormatterAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = null;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( String:[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateTimeFormatterAndZoneIdAsNullAndCorrectLocaleParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = null;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatDateTime( String:[dateTime:✓], String[dateTimePattern:✓], String[dateTimeFormatter:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectStringDateTimeAndCorrectStringDateTimePatternAndCorrectStringDateTimeFormatterAndCorrectZoneIdAndLocaleAsNullParameters_whenFormatDateTimeIsCalled_thenThrowsNullPointerException(){
        final String DATE_TIME_IN = DEFAULT_DATE_TIME_STR;
        final String PATTERN_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = null;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatDateTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }


    // ---------------------------------------------------------------------------------------------------- \\
    // ---| Tests for "formatTime" method (String).
    // ---------------------------------------------------------------------------------------------------- \\

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timeFormatter:✓] ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimeFormatterParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timePattern:✓], String[timeFormatter:✓] ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectStringTimeFormatterParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timeFormatter:✓], ZoneId:✓ ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimeFormatterAndCorrectZoneIdParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timeFormatter:✓], Locale:✓ ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimeFormatterAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timePattern:✓], String[timeFormatter:✓], ZoneId:✓ ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectStringTimeFormatterAndCorrectZoneIdParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timePattern:✓], String[timeFormatter:✓], Locale:✓ ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectStringTimeFormatterAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timeFormatter:✓], ZoneId:✓, Locale:✓ ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timePattern:✓], String[timeFormatter:✓], ZoneId:✓, Locale:✓ ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectStringTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[dateTime:✓], String[dateTimePattern:✓], String[timeFormatter:✓] ):String[time:✓]" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectStringFormatterParameters_awhenFormatTimeIsCalled_thenReturnCorrectStringFormattedTime(){
        final String DATE_TIME_IN = String.format( "%s %s", DEFAULT_DATE_STR, DEFAULT_TIME_STR );
        final String PATTERN_IN = String.format( "%s:ss", DEFAULT_DATE_TIME_FORMATTER_STR );
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;
        final String EXPECTED = DEFAULT_TIME_STR;

        String result = DateTimeUtil.formatTime( DATE_TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timePattern:✓], String[timeFormatter:✓][Empty] ):String[time:✓][Empty]" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndStringTimeFormatterEmptyParameters_whenFormatTimeIsCalled_thenReturnCorrectStringFormattedTimeEmpty( final String FORMATTER_IN ){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String EXPECTED = "";

        String result = DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN );

        assertNotEquals( null, result, MSG_IS_NULL );
        assertInstanceOf( EXPECTED.getClass(), result );
        assertEquals( EXPECTED, result, String.format( MSG_TEMPLATE_RESULT_EXPECTED, result, EXPECTED ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timePattern:✓], String[dateFormatter:✓] ):UnsupportedTemporalTypeException" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectStringFormatterParameters_whenFormatTimeIsCalled_thenThrowsUnsupportedTemporalTypeException(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_DATE_FORMATTER_STR;

        assertThrows( UnsupportedTemporalTypeException.class, () -> DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @Test
    @DisplayName( "DateTimeUtil.formatTime( String[date:✓], String[datePattern:✓], String[timeFormatter:✓] ):DateTimeParseException" )
    void givenCorrectStringAndCorrectStringPatternAndCorrectStringTimeFormatterParameters_whenFormatTimeIsCalled_thenThrowsDateTimeParseException(){
        final String DATE_IN = DEFAULT_DATE_STR;
        final String PATTERN_IN = DEFAULT_DATE_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;

        assertThrows( DateTimeParseException.class, () -> DateTimeUtil.formatTime( DATE_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt:mm:ss", "HH:tt:ss", "HH:mm:tt" } )
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timePattern:✗], String[timeFormatter:✓] ):IllegalArgumentException" )
    void givenCorrectStringTimeAndIncorrectStringTimePatternAndCorrectStringTimeFormatterParameters_whenFormatTimeIsCalled_thenThrowsIllegalArgumentException(
            final String PATTERN_IN ){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @ParameterizedTest
    @ValueSource( strings = { "tt:mm:ss", "HH:tt:ss", "HH:mm:tt" } )
    @DisplayName( "DateTimeUtil.formatTime( String[time:✓], String[timePattern:✓], String[timeFormatter:✗] ):IllegalArgumentException" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndIncorrectStringTimeFormatterParameters_whenFormatTimeIsCalled_thenThrowsIllegalArgumentException(
            final String FORMATTER_IN ){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;

        assertThrows( IllegalArgumentException.class, () -> DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( String:✗, String[timePattern:✓], String[timeFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenStringTimeAsNullAndCorrectStringTimePatternAndCorrectStringTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(){
        final String TIME_IN = null;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( String:[time:✓], String[timePattern:✗], String[timeFormatter:✓], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringTimeAndStringTimePatternAsNullAndCorrectStringTimeFormatterAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = null;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( String:[time:✓], String[timePattern:✓], String[timeFormatter:✗], ZoneId:✓, Locale:✓ ):NullPointerException" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndStringTimeFormatterAsNullAndCorrectZoneIdAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = null;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( String:[time:✓], String[timePattern:✓], String[timeFormatter:✓], ZoneId:✗, Locale:✓ ):NullPointerException" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectStringTimeFormatterAndZoneIdAsNullAndCorrectLocaleParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = null;
        final Locale LOCALE_IN = DEFAULT_LOCALE;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

    @Test
    @NullSource
    @DisplayName( "DateTimeUtil.formatTime( String:[time:✓], String[timePattern:✓], String[timeFormatter:✓], ZoneId:✓, Locale:✗ ):NullPointerException" )
    void givenCorrectStringTimeAndCorrectStringTimePatternAndCorrectStringTimeFormatterAndCorrectZoneIdAndLocaleAsNullParameters_whenFormatTimeIsCalled_thenThrowsNullPointerException(){
        final String TIME_IN = DEFAULT_TIME_STR;
        final String PATTERN_IN = DEFAULT_TIME_FORMATTER_STR;
        final String FORMATTER_IN = DEFAULT_TIME_FORMATTER_STR;
        final ZoneId ZONE_ID_IN = DEFAULT_ZONE_ID;
        final Locale LOCALE_IN = null;

        assertThrows( NullPointerException.class, () -> DateTimeUtil.formatTime( TIME_IN, PATTERN_IN, FORMATTER_IN, ZONE_ID_IN, LOCALE_IN ) );
    }

}
