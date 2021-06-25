package com.indenaiten.code.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


/**
 * <p>This class handles dates and times.</p>
 * <p>It can convert dates and times between different objects and can also format them to a certain text.</p>
 * <p>The objects this class works with are the following:</p>
 * <p>For the class to format dates and times it uses the text patterns used in the DateTimeFormatter class.</p>
 * <ul>
 *  <li>LocalDate</li>
 *  <li>LocalDateTime</li>
 *  <li>LocalTime</li>
 *  <li>Date</li>
 *  <li>String</li>
 * </ul>
 *
 * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
 * @see java.time.LocalDate
 * @see java.time.LocalDateTime
 * @see java.time.LocalTime
 * @see java.time.format.DateTimeFormatter
 * @see java.time.ZoneId
 * @see java.util.Date
 * @see java.lang.String
 */
public abstract class DateTimeUtil{

    //DEFAULT PARAMETERS
    public static final String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    public static final String DEFAULT_DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm";
    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();
    public static final Locale DEFAULT_LOCALE = Locale.getDefault();

    /**
     * Private constructor to avoid instantiating the class.
     */
    private DateTimeUtil(){
        throw new IllegalStateException( "Utility class" );
    }

    /**
     * <p>Converts a "LocalDate" object in a "Date" object.</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromLocalDate( LocalDate.now() );
     * </code>
     *
     * @param dateIn The "LocalDate" object.
     *
     * @return The "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.util.Date
     */
    public static Date getDateFromLocalDate( LocalDate dateIn ){
        return DateTimeUtil.getDateFromLocalDate( dateIn, DateTimeUtil.DEFAULT_ZONE_ID );
    }

    /**
     * <p>Converts a "LocalDate" object in a "Date" object with "ZoneId".</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromLocalDate( LocalDate.now(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The "LocalDate" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static Date getDateFromLocalDate( LocalDate dateIn, ZoneId zoneIdIn ){
        return Date.from( dateIn.atStartOfDay( zoneIdIn ).toInstant() );
    }

    /**
     * <p>Converts a "LocalDateTime" object in a "Date" object.</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromLocalDateTime( LocalDateTime.now() );
     * </code>
     *
     * @param dateTimeIn The "LocalDateTime" object.
     *
     * @return The "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.util.Date
     */
    public static Date getDateFromLocalDateTime( LocalDateTime dateTimeIn ){
        return DateTimeUtil.getDateFromLocalDateTime( dateTimeIn, DateTimeUtil.DEFAULT_ZONE_ID );
    }

    /**
     * <p>Converts a "LocalDateTime" object in a "Date" object with "ZoneId".</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromLocalDateTime( LocalDateTime.now(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The "LocalDateTime" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static Date getDateFromLocalDateTime( LocalDateTime dateTimeIn, ZoneId zoneIdIn ){
        return Date.from( dateTimeIn.atZone( zoneIdIn ).toInstant() );
    }

    /**
     * <p>Converts a "Date" object in a "LocalDate" object.</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromDate( new Date() );
     * </code>
     *
     * @param dateIn The "Date" object.
     *
     * @return The "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.util.Date
     */
    public static LocalDate getLocalDateFromDate( Date dateIn ){
        return DateTimeUtil.getLocalDateFromDate( dateIn, DateTimeUtil.DEFAULT_ZONE_ID );
    }

    /**
     * <p>Converts a "Date" object in a "LocalDate" object with "ZoneId".</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromDate( new Date(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The "Date" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static LocalDate getLocalDateFromDate( Date dateIn, ZoneId zoneIdIn ){
        return dateIn.toInstant().atZone( zoneIdIn ).toLocalDate();
    }

    /**
     * <p>Converts a "Date" object in a "LocalDateTime" object.</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromDate( new Date() );
     * </code>
     *
     * @param dateIn The "Date" object.
     *
     * @return The "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.util.Date
     */
    public static LocalDateTime getLocalDateTimeFromDate( Date dateIn ){
        return DateTimeUtil.getLocalDateTimeFromDate( dateIn, DateTimeUtil.DEFAULT_ZONE_ID );
    }

    /**
     * <p>Converts a "Date" object in a "LocalDateTime" object with "ZoneId".</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromDate( new Date(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The "Date" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static LocalDateTime getLocalDateTimeFromDate( Date dateIn, ZoneId zoneIdIn ){
        return LocalDateTime.ofInstant( dateIn.toInstant(), zoneIdIn );
    }

    /**
     * <p>Converts a "LocalDate" object in a "LocalDateTime" object.</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromLocalDate( LocalDate.now() );
     * </code>
     *
     * @param dateIn The "LocalDate" object.
     *
     * @return The "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.LocalDateTime
     */
    public static LocalDateTime getLocalDateTimeFromLocalDate( LocalDate dateIn ){
        return DateTimeUtil.getLocalDateTimeFromLocalDate( dateIn, DateTimeUtil.DEFAULT_ZONE_ID );
    }

    /**
     * <p>Converts a "LocalDate" object in a "LocalDateTime" object with "ZoneId".</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromLocalDate( LocalDate.now(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The "LocalDate" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     */
    public static LocalDateTime getLocalDateTimeFromLocalDate( LocalDate dateIn, ZoneId zoneIdIn ){
        return dateIn.atStartOfDay( zoneIdIn ).toLocalDateTime();
    }

    /**
     * <p>Converts a "LocalDateTime" object in a "LocalDate" object.</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromLocalDateTime( LocalDateTime.now() );
     * </code>
     *
     * @param dateTimeIn The "LocalDateTime" object.
     *
     * @return The "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.LocalDateTime
     */
    public static LocalDate getLocalDateFromLocalDateTime( LocalDateTime dateTimeIn ){
        return DateTimeUtil.getLocalDateFromLocalDateTime( dateTimeIn, DateTimeUtil.DEFAULT_ZONE_ID );
    }

    /**
     * <p>Converts a "LocalDateTime" object in a "LocalDate" object with "ZoneId".</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromLocalDateTime( LocalDateTime.now(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The "LocalDateTime" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     */
    public static LocalDate getLocalDateFromLocalDateTime( LocalDateTime dateTimeIn, ZoneId zoneIdIn ){
        return dateTimeIn.atZone( zoneIdIn ).toLocalDate();
    }

    /**
     * <p>Converts a "LocalDateTime" object in a "LocalTime" object.</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromLocalDateTime( LocalDateTime.now() );
     * </code>
     *
     * @param dateTimeIn The "LocalDateTime" object.
     *
     * @return The "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.LocalDateTime
     */
    public static LocalTime getLocalTimeFromLocalDateTime( LocalDateTime dateTimeIn ){
        return DateTimeUtil.getLocalTimeFromLocalDateTime( dateTimeIn, DateTimeUtil.DEFAULT_ZONE_ID );
    }

    /**
     * <p>Converts a "LocalDateTime" object in a "LocalTime" object with "ZoneId".</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromLocalDateTime( LocalDateTime.now(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The "LocalDateTime" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     */
    public static LocalTime getLocalTimeFromLocalDateTime( LocalDateTime dateTimeIn, ZoneId zoneIdIn ){
        return dateTimeIn.atZone( zoneIdIn ).toLocalTime();
    }

    /**
     * <p>Converts a "Date" object in a "LocalTime" object.</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromDate( new Date() );
     * </code>
     *
     * @param dateTimeIn The "Date" object.
     *
     * @return The "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.util.Date
     */
    public static LocalTime getLocalTimeFromDate( Date dateTimeIn ){
        return DateTimeUtil.getLocalTimeFromDate( dateTimeIn, DateTimeUtil.DEFAULT_ZONE_ID );
    }

    /**
     * <p>Converts a "Date" object in a "LocalTime" object with "ZoneId".</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromDate( new Date(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The "Date" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static LocalTime getLocalTimeFromDate( Date dateTimeIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getLocalDateTimeFromDate( dateTimeIn, zoneIdIn ).toLocalTime();
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "LocalDate" object without pattern.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromString( "25/06/2021" );
     * </code>
     *
     * @param dateIn The date as "String" object with pattern "dd/MM/yyyy".
     *
     * @return The date as "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     */
    public static LocalDate getLocalDateFromString( String dateIn ){
        return DateTimeUtil.getLocalDateFromString( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID,
                DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "LocalDate" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromString( "25/06/2021", "dd/MM/yyyy" );
     * </code>
     *
     * @param dateIn The date as "String" object.
     * @param patternIn The format pattern of "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date as "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     */
    public static LocalDate getLocalDateFromString( String dateIn, String patternIn ){
        return DateTimeUtil.getLocalDateFromString( dateIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "LocalDate" object without pattern and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromString( "25/06/2021", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date as "String" object with pattern "dd/MM/yyyy".
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date as "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     */
    public static LocalDate getLocalDateFromString( String dateIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getLocalDateFromString( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "LocalDate" object without pattern and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromString( "25/06/2021", new Locale( "es", "ES") );
     * </code>
     *
     * @param dateIn The date as "String" object with pattern "dd/MM/yyyy".
     * @param localeIn The "Locale" object.
     *
     * @return The date as "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.util.Locale
     */
    public static LocalDate getLocalDateFromString( String dateIn, Locale localeIn ){
        return DateTimeUtil.getLocalDateFromString( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "LocalDate" object with "ZoneId".</p>
     * <p>"Locale" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromString( "25/06/2021", "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date as "String" object.
     * @param patternIn The format pattern of "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date as "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     */
    public static LocalDate getLocalDateFromString( String dateIn, String patternIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getLocalDateFromString( dateIn, patternIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "LocalDate" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromString( "25/06/2021", "dd/MM/yyyy", new Locale( "es", "ES") );
     * </code>
     *
     * @param dateIn The date as "String" object.
     * @param patternIn The format pattern of "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date as "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.LocalDate
     * @see java.util.Locale
     */
    public static LocalDate getLocalDateFromString( String dateIn, String patternIn, Locale localeIn ){
        return DateTimeUtil.getLocalDateFromString( dateIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "LocalDate" object without pattern and with "ZoneId" and "Locale".</p>
     * <p>"String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromString( "25/06/2021", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES") );
     * </code>
     *
     * @param dateIn The date as "String" object with pattern "dd/MM/yyyy".
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date as "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static LocalDate getLocalDateFromString( String dateIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.getLocalDateFromString( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "LocalDate" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * LocalDate result = DateTimeUtil.getLocalDateFromString( "25/06/2021", "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES") );
     * </code>
     *
     * @param dateIn The date as "String" object.
     * @param patternIn The format pattern of "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date as "LocalDate" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static LocalDate getLocalDateFromString( String dateIn, String patternIn, ZoneId zoneIdIn, Locale localeIn ){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( patternIn ).withLocale( localeIn );
        return LocalDate.parse( dateIn, dateTimeFormatter ).atStartOfDay( zoneIdIn ).toLocalDate();
    }

    /**
     * <p>Converts a date-time in "String" format with a given date pattern to the "LocalDateTime" object without pattern.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( "25/06/2021 17:36" );
     * </code>
     *
     * @param dateTimeIn The date-time as "String" object with pattern "dd/MM/yyyy HH:mm".
     *
     * @return The date as "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     */
    public static LocalDateTime getLocalDateTimeFromString( String dateTimeIn ){
        return DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID,
                DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date pattern to the "LocalDateTime" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( "25/06/2021 17:36", "dd/MM/yyyy HH:mm" );
     * </code>
     *
     * @param dateTimeIn The date-time as "String" object.
     * @param patternIn The format pattern of "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date as "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     */
    public static LocalDateTime getLocalDateTimeFromString( String dateTimeIn, String patternIn ){
        return DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date pattern to the "LocalDateTime" object without pattern and with "ZoneId".</p>
     * <p>""Locale" is set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( "25/06/2021 17:36", new Locale( "es", "ES") );
     * </code>
     *
     * @param dateTimeIn The date-time as "String" object with pattern "dd/MM/yyyy HH:mm".
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date as "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     */
    public static LocalDateTime getLocalDateTimeFromString( String dateTimeIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date pattern to the "LocalDateTime" object without pattern and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( "25/06/2021 17:36", new Locale( "es", "ES") );
     * </code>
     *
     * @param dateTimeIn The date-time as "String" object with pattern "dd/MM/yyyy HH:mm".
     * @param localeIn The "Locale" object.
     *
     * @return The date as "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.util.Locale
     */
    public static LocalDateTime getLocalDateTimeFromString( String dateTimeIn, Locale localeIn ){
        return DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date pattern to the "LocalDateTime" object with "ZoneId".</p>
     * <p>"Locale" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "String" object.
     * @param patternIn The format pattern of "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date as "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     */
    public static LocalDateTime getLocalDateTimeFromString( String dateTimeIn, String patternIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, patternIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date pattern to the "LocalDateTime" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", new Locale( "es", "ES") );
     * </code>
     *
     * @param dateTimeIn The date-time as "String" object.
     * @param patternIn The format pattern of "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date as "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.util.Locale
     */
    public static LocalDateTime getLocalDateTimeFromString( String dateTimeIn, String patternIn, Locale localeIn ){
        return DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date pattern to the "LocalDateTime" object without pattern and with "ZoneId" and
     * "Locale".</p>
     * <p>"String" date-time pattern is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( "25/06/2021 17:36", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES") );
     * </code>
     *
     * @param dateTimeIn The date-time as "String" object with pattern "dd/MM/yyyy HH:mm".
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date as "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static LocalDateTime getLocalDateTimeFromString( String dateTimeIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date pattern to the "LocalDateTime" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * LocalDateTime result = DateTimeUtil.getLocalDateTimeFromString( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ), new
     * Locale( "es", "ES") );
     * </code>
     *
     * @param dateTimeIn The date-time as "String" object.
     * @param patternIn The format pattern of "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date as "LocalDateTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static LocalDateTime getLocalDateTimeFromString( String dateTimeIn, String patternIn, ZoneId zoneIdIn, Locale localeIn ){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( patternIn ).withLocale( localeIn );
        return LocalDateTime.parse( dateTimeIn, dateTimeFormatter ).atZone( zoneIdIn ).toLocalDateTime();
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "Date" object without pattern.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromString( "25/06/2021" );
     * </code>
     *
     * @param dateIn The date in "String" format with pattern "dd/MM/yyyy".
     *
     * @return The date as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     */
    public static Date getDateFromString( String dateIn ){
        return DateTimeUtil.getDateFromString( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "Date" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromString( "25/06/2021", "dd/MM/yyyy" );
     * </code>
     *
     * @param dateIn The date in "String" format.
     * @param patternIn The date pattern of "dateIn" parameter.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     * @see java.time.ZoneId
     */
    public static Date getDateFromString( String dateIn, String patternIn ){
        return DateTimeUtil.getDateFromString( dateIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "Date" object without pattern and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromString( "25/06/2021", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date in "String" format with pattern "dd/MM/yyyy".
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.time.ZoneId
     */
    public static Date getDateFromString( String dateIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getDateFromString( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "Date" object without pattern and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromString( "25/06/2021", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date in "String" format with pattern "dd/MM/yyyy".
     * @param localeIn The "Locale" object.
     *
     * @return The date as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static Date getDateFromString( String dateIn, Locale localeIn ){
        return DateTimeUtil.getDateFromString( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "Date" object without pattern with "ZoneId" and "Locale".</p>
     * <p>"String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromString( "25/06/2021", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date in "String" format with pattern "dd/MM/yyyy".
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static Date getDateFromString( String dateIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.getDateFromString( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "Date" object with "ZoneId".</p>
     * <p>"Locale" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromString( "25/06/2021", "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date in "String" format.
     * @param patternIn The date pattern of "dateIn" parameter.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static Date getDateFromString( String dateIn, String patternIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getDateFromString( dateIn, patternIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "Date" object with and "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromString( "25/06/2021", "dd/MM/yyyy", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date in "String" format.
     * @param patternIn The date pattern of "dateIn" parameter.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static Date getDateFromString( String dateIn, String patternIn, Locale localeIn ){
        return DateTimeUtil.getDateFromString( dateIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a date in "String" format with a given date pattern to the "Date" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateFromString( "25/06/2021", "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date in "String" format.
     * @param patternIn The date pattern of "dateIn" parameter.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static Date getDateFromString( String dateIn, String patternIn, ZoneId zoneIdIn, Locale localeIn ){
        LocalDate date = DateTimeUtil.getLocalDateFromString( dateIn, patternIn, zoneIdIn, localeIn );
        return DateTimeUtil.getDateFromLocalDate( date, zoneIdIn );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date-time pattern to the "Date" object without pattern.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm).</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateTimeFromString( "25/06/2021 17:36" );
     * </code>
     *
     * @param dateTimeIn The date-time in "String" format with pattern "dd/MM/yyyy HH:mm".
     *
     * @return The date-time as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     */
    public static Date getDateTimeFromString( String dateTimeIn ){
        return DateTimeUtil.getDateTimeFromString( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID,
                DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date-time pattern to the "Date" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateTimeFromString( "25/06/2021 17:36", "dd/MM/yyyy HH:mm" );
     * </code>
     *
     * @param dateTimeIn The date-time in "String" format.
     * @param patternIn The date-time pattern of "dateTimeIn" parameter.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date-time as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     * @see java.time.ZoneId
     */
    public static Date getDateTimeFromString( String dateTimeIn, String patternIn ){
        return DateTimeUtil.getDateTimeFromString( dateTimeIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date-time pattern to the "Date" object without pattern and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm).</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateTimeFromString( "25/06/2021 17:36", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time in "String" format with pattern "dd/MM/yyyy HH:mm".
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date-time as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.time.ZoneId
     */
    public static Date getDateTimeFromString( String dateTimeIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getDateTimeFromString( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date-time pattern to the "Date" object without pattern and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm).</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateTimeFromString( "25/06/2021 17:36", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time in "String" format with pattern "dd/MM/yyyy HH:mm".
     * @param localeIn The "Locale" object.
     *
     * @return The date-time as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static Date getDateTimeFromString( String dateTimeIn, Locale localeIn ){
        return DateTimeUtil.getDateTimeFromString( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date-time pattern to the "Date" object without pattern with "ZoneId" and "Locale".</p>
     * <p>"String" date-time pattern is set as default ("dd/MM/yyyy HH:mm).</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateTimeFromString( "25/06/2021 17:36", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time in "String" format with pattern "dd/MM/yyyy HH:mm".
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static Date getDateTimeFromString( String dateTimeIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.getDateTimeFromString( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date-time pattern to the "Date" object with "ZoneId".</p>
     * <p>"Locale" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateTimeFromString( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time in "String" format.
     * @param patternIn The date-time pattern of "dateTimeIn" parameter.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date-time as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static Date getDateTimeFromString( String dateTimeIn, String patternIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getDateTimeFromString( dateTimeIn, patternIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date-time pattern to the "Date" object with and "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateTimeFromString( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time in "String" format.
     * @param patternIn The date-time pattern of "dateTimeIn" parameter.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date-time as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static Date getDateTimeFromString( String dateTimeIn, String patternIn, Locale localeIn ){
        return DateTimeUtil.getDateTimeFromString( dateTimeIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a date-time in "String" format with a given date-time pattern to the "Date" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * Date result = DateTimeUtil.getDateTimeFromString( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" )
     * );
     * </code>
     *
     * @param dateTimeIn The date-time in "String" format.
     * @param patternIn The date pattern of "dateTimeIn" parameter.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time as "Date" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static Date getDateTimeFromString( String dateTimeIn, String patternIn, ZoneId zoneIdIn, Locale localeIn ){
        LocalDateTime dateTime = DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, patternIn, zoneIdIn, localeIn );
        return DateTimeUtil.getDateFromLocalDateTime( dateTime, zoneIdIn );
    }

    /**
     * <p>Converts a time in "String" format with a given time pattern to the "LocalTime" object without pattern.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" time pattern is set as default ("HH:mm:ss).</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromString( "17:36:27" );
     * </code>
     *
     * @param timeIn The time as "String" object with pattern "HH:mm:ss".
     *
     * @return The time as "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     */
    public static LocalTime getLocalTimeFromString( String timeIn ){
        return DateTimeUtil.getLocalTimeFromString( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID,
                DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a time in "String" format with a given time pattern to the "LocalTime" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromString( "17:36:27", "HH:mm:ss" );
     * </code>
     *
     * @param timeIn The time as "String" object.
     * @param patternIn The format pattern of "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The time as "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     */
    public static LocalTime getLocalTimeFromString( String timeIn, String patternIn ){
        return DateTimeUtil.getLocalTimeFromString( timeIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a time in "String" format with a given time pattern to the "LocalTime" object without pattern and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" time pattern is set as default ("HH:mm:ss).</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromString( "17:36:27", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "String" object with pattern "HH:mm:ss".
     * @param localeIn The "ZoneId" object.
     *
     * @return The time as "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     */
    public static LocalTime getLocalTimeFromString( String timeIn, Locale localeIn ){
        return DateTimeUtil.getLocalTimeFromString( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a time in "String" format with a given time pattern to the "LocalTime" object without pattern and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" time pattern is set as default ("HH:mm:ss).</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromString( "17:36:27", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param timeIn The time as "String" object with pattern "HH:mm:ss".
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The time as "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     */
    public static LocalTime getLocalTimeFromString( String timeIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getLocalTimeFromString( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a time in "String" format with a given time pattern to the "LocalTime" object with "ZoneId".</p>
     * <p>"Locale" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromString( "17:36:27", "HH:mm:ss", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param timeIn The time as "String" object.
     * @param patternIn The format pattern of "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The time as "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static LocalTime getLocalTimeFromString( String timeIn, String patternIn, ZoneId zoneIdIn ){
        return DateTimeUtil.getLocalTimeFromString( timeIn, patternIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Converts a time in "String" format with a given time pattern to the "LocalTime" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromString( "17:36:27", "HH:mm:ss", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "String" object.
     * @param patternIn The format pattern of "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The time as "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.util.Locale
     */
    public static LocalTime getLocalTimeFromString( String timeIn, String patternIn, Locale localeIn ){
        return DateTimeUtil.getLocalTimeFromString( timeIn, patternIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Converts a time in "String" format with a given time pattern to the "LocalTime" object without pattern with "ZoneId" and "Locale".</p>
     * <p>"String" time pattern is set as default ("HH:mm:ss).</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromString( "17:36:27", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "String" object with pattern "HH:mm:ss".
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The time as "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static LocalTime getLocalTimeFromString( String timeIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.getLocalTimeFromString( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Converts a time in "String" format with a given time pattern to the "LocalTime" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * LocalTime result = DateTimeUtil.getLocalTimeFromString( "17:36:27", "HH:mm:ss", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "String" object.
     * @param patternIn The format pattern of "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The time as "LocalTime" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static LocalTime getLocalTimeFromString( String timeIn, String patternIn, ZoneId zoneIdIn, Locale localeIn ){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( patternIn ).withLocale( localeIn );
        return LocalTime.parse( timeIn, dateTimeFormatter ).atDate( LocalDate.now( zoneIdIn ) ).toLocalTime();
    }

    /**
     * <p>Formats a "LocalDate" object to "String" object without formatter.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date formatter is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( LocalDate.now() );
     * </code>
     *
     * @param dateIn The date as "LocalDate" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     */
    public static String formatDate( LocalDate dateIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalDate" object to "String" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( LocalDate.now(), "dd/MM/yyyy" );
     * </code>
     *
     * @param dateIn The date as "LocalDate" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     */
    public static String formatDate( LocalDate dateIn, String formatterIn ){
        return DateTimeUtil.formatDate( dateIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalDate" object to "String" object without formatter and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" date formatter is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( LocalDate.now(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date as "LocalDate" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     */
    public static String formatDate( LocalDate dateIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalDate" object to "String" object without formatter and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date formatter is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( LocalDate.now(), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "LocalDate" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.util.Locale
     */
    public static String formatDate( LocalDate dateIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "LocalDate" object to "String" object with "ZoneId".</p>
     * <p>"Locale" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( LocalDate.now(), "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date as "LocalDate" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     */
    public static String formatDate( LocalDate dateIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDate( dateIn, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalDate" object to "String" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( LocalDate.now(), "dd/MM/yyyy", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "LocalDate" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.util.Locale
     */
    public static String formatDate( LocalDate dateIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "LocalDate" object to "String" object without formatter and with "ZoneId" and "Locale".</p>
     * <p>"String" date formatter is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( LocalDate.now(), ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "LocalDate" object.
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDate( LocalDate dateIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "LocalDate" object to "String" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( LocalDate.now(), "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "LocalDate" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.LocalDate
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDate( LocalDate dateIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( formatterIn );
        return dateIn.atStartOfDay( zoneIdIn ).format( dateTimeFormatter.withLocale( localeIn ) );
    }

    /**
     * <p>Formats a "LocalDateTime" object to "String" object without date-time formatter and with "ZoneId" and "Locale".</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date-time formatter is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( LocalDateTime.now() );
     * </code>
     *
     * @param dateTimeIn The date-time as "LocalDateTime" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDateTime( LocalDateTime dateTimeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalDateTime" object to "String" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( LocalDateTime.now(), "dd/MM/yyyy HH:mm" );
     * </code>
     *
     * @param dateTimeIn The date-time as "LocalDateTime" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     */
    public static String formatDateTime( LocalDateTime dateTimeIn, String formatterIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalDateTime" object to "String" object without date-time formatter and with "ZoneId".</p>
     * <p>"Locale" are set as the system default and "String" date-time formatter is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( LocalDateTime.now(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "LocalDateTime" object.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     */
    public static String formatDateTime( LocalDateTime dateTimeIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalDateTime" object to "String" object without date-time formatter and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date-time formatter is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( LocalDateTime.now(), "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "LocalDateTime" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.util.Locale
     */
    public static String formatDateTime( LocalDateTime dateTimeIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "LocalDateTime" object to "String" object with "ZoneId".</p>
     * <p>"Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( LocalDateTime.now(), "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "LocalDateTime" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     */
    public static String formatDateTime( LocalDateTime dateTimeIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalDateTime" object to "String" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( LocalDateTime.now(), "dd/MM/yyyy HH:mm", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "LocalDateTime" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.util.Locale
     */
    public static String formatDateTime( LocalDateTime dateTimeIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "LocalDateTime" object to "String" object without pattern and with "ZoneId" and "Locale".</p>
     * <p>"String" date-time formatter is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( LocalDateTime.now(), ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "LocalDateTime" object.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDateTime( LocalDateTime dateTimeIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "LocalDateTime" object to "String" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( LocalDateTime.now(), "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "LocalDateTime" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDateTime( LocalDateTime dateTimeIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( formatterIn ).withLocale( localeIn );
        return dateTimeIn.atZone( zoneIdIn ).format( dateTimeFormatter );
    }

    /**
     * <p>Formats a "Date" object to "String" object without date-time formatter and with "ZoneId" and "Locale".</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date-time formatter is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( new Date() );
     * </code>
     *
     * @param dateTimeIn The date-time as "Date" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static String formatDateTime( Date dateTimeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "Date" object to "String" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( new Date() "dd/MM/yyyy HH:mm" );
     * </code>
     *
     * @param dateTimeIn The date-time as "Date" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     */
    public static String formatDateTime( Date dateTimeIn, String formatterIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "Date" object to "String" object without date-time formatter and with "ZoneId".</p>
     * <p>"Locale" are set as the system default and "String" date-time formatter is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( new Date(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "Date" object.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.time.ZoneId
     */
    public static String formatDateTime( Date dateTimeIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "Date" object to "String" object without date-time formatter and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date-time formatter is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( new Date(), "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "Date" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static String formatDateTime( Date dateTimeIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "Date" object to "String" object with "ZoneId".</p>
     * <p>"Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( new Date(), "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "Date" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.time.ZoneId
     */
    public static String formatDateTime( Date dateTimeIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "Date" object to "String" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( new Date(), "dd/MM/yyyy HH:mm", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "Date" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static String formatDateTime( Date dateTimeIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "Date" object to "String" object without pattern and with "ZoneId" and "Locale".</p>
     * <p>"String" date-time formatter is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( new Date(), ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "Date" object.
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDateTime( Date dateTimeIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "Date" object to "String" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * String result = formatDateTime.formatDate( new Date(), "dd/MM/yyyy HH:mm", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "Date" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.ZoneId
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static String formatDateTime( Date dateTimeIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        LocalDateTime dateTime = DateTimeUtil.getLocalDateTimeFromDate( dateTimeIn, zoneIdIn );
        return DateTimeUtil.formatDateTime( dateTime, formatterIn, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "Date" object to "String" object without date formatter and with "ZoneId" and "Locale".</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date formatter is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( new Date(), "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "Date" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     */
    public static String formatDate( Date dateIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "Date" object to "String" object and with "ZoneId" and "Locale".</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( new Date(), "dd/MM/yyyy" );
     * </code>
     *
     * @param dateIn The date as "Date" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     */
    public static String formatDate( Date dateIn, String formatterIn ){
        return DateTimeUtil.formatDate( dateIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "Date" object to "String" object without date formatter and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" date formatter is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( new Date(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date as "Date" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static String formatDate( Date dateIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "Date" object to "String" object without date formatter and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date formatter is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( new Date(), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "Date" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static String formatDate( Date dateIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "Date" object to "String" object with "ZoneId".</p>
     * <p>"Locale" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( new Date(), "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date as "Date" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Date
     */
    public static String formatDate( Date dateIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDate( dateIn, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "Date" object to "String" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( new Date(), "dd/MM/yyyy", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "Date" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static String formatDate( Date dateIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "Date" object to "String" object without date formatter.</p>
     * <p>"String" date formatter is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( new Date(), ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "Date" object.
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static String formatDate( Date dateIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "Date" object to "String" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( new Date(), "dd/MM/yyyy", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "Date" object.
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.ZoneId
     * @see java.util.Date
     * @see java.util.Locale
     */
    public static String formatDate( Date dateIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        LocalDateTime date = DateTimeUtil.getLocalDateTimeFromDate( dateIn, zoneIdIn );
        return DateTimeUtil.formatDateTime( date, formatterIn, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "LocalTime" object to "String" object without time formatter and with "ZoneId" and "Locale".</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" time formatter is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( LocalTime.now() );
     * </code>
     *
     * @param timeIn The time as "LocalTime" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     */
    public static String formatTime( LocalTime timeIn ){
        return DateTimeUtil.formatTime( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalTime" object to "String" object with "ZoneId" and "Locale".</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( LocalTime.now(), "HH:mm:ss" );
     * </code>
     *
     * @param timeIn The time as "LocalTime" object.
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     */
    public static String formatTime( LocalTime timeIn, String formatterIn ){
        return DateTimeUtil.formatTime( timeIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalTime" object to "String" object without time formatter and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" time formatter is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( LocalTime.now(), ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param timeIn The time as "LocalTime" object.
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     */
    public static String formatTime( LocalTime timeIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatTime( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalTime" object to "String" object without time formatter and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" time formatter is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( LocalTime.now(), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "LocalTime" object.
     * @param localeIn The "Locale" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.util.Locale
     */
    public static String formatTime( LocalTime timeIn, Locale localeIn ){
        return DateTimeUtil.formatTime( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "LocalTime" object to "String" object with "ZoneId".</p>
     * <p>"Locale" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( LocalTime.now(), "HH:mm:ss", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param timeIn The time as "LocalTime" object.
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     */
    public static String formatTime( LocalTime timeIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatTime( timeIn, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "LocalTime" object to "String" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( LocalTime.now(), "HH:mm:ss", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "LocalTime" object.
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.util.Locale
     */
    public static String formatTime( LocalTime timeIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatTime( timeIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "LocalTime" object to "String" object with "ZoneId" and "Locale".</p>
     * <p>"String" time formatter is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( LocalTime.now(), ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "LocalTime" object.
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatTime( LocalTime timeIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.formatTime( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "LocalTime" object to "String" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( LocalTime.now(), "HH:mm:ss", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "LocalTime" object.
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.format.DateTimeFormatter
     * @see java.time.LocalTime
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatTime( LocalTime timeIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( formatterIn ).withLocale( localeIn );
        return timeIn.atDate( LocalDate.now( zoneIdIn ) ).toLocalTime().format( dateTimeFormatter );
    }

    /**
     * <p>Formats a "String" date to "String" object without date pattern.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( "25/06/2021", "yyyy-MM-dd" );
     * </code>
     *
     * @param dateIn The date as "String".
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     */
    public static String formatDate( String dateIn, String formatterIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" date to "String" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( "25/06/2021", "dd/MM/yyyy", "yyyy-MM-dd" );
     * </code>
     *
     * @param dateIn The date as "String".
     * @param patternIn The format pattern of "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     */
    public static String formatDate( String dateIn, String patternIn, String formatterIn ){
        return DateTimeUtil.formatDate( dateIn, patternIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" date to "String" object without date pattern and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( "25/06/2021", "yyyy-MM-dd", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date as "String".
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     */
    public static String formatDate( String dateIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" date to "String" object without date pattern and with "Locale".</p>
     * <p>"ZoneId" id set as the system default and "String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( "25/06/2021", "yyyy-MM-dd", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "String".
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Locale
     */
    public static String formatDate( String dateIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "String" date to "String" object with "ZoneId".</p>
     * <p>"Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( "25/06/2021", "dd/MM/yyyy", "yyyy-MM-dd", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateIn The date as "String".
     * @param patternIn The format pattern of "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDate( String dateIn, String patternIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDate( dateIn, patternIn, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" date to "String" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( "25/06/2021", "dd/MM/yyyy", "yyyy-MM-dd", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "String".
     * @param patternIn The format pattern of "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Locale
     */
    public static String formatDate( String dateIn, String patternIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, patternIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "String" date to "String" object without date pattern and with "ZoneId" and "Locale".</p>
     * <p>"String" date pattern is set as default ("dd/MM/yyyy").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( "25/06/2021", "yyyy-MM-dd", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "String".
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDate( String dateIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.formatDate( dateIn, DateTimeUtil.DEFAULT_DATE_PATTERN, formatterIn, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "String" date to "String" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDate( "25/06/2021", "dd/MM/yyyy", "yyyy-MM-dd", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateIn The date as "String".
     * @param patternIn The format pattern of "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "dateIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDate( String dateIn, String patternIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        LocalDate date = DateTimeUtil.getLocalDateFromString( dateIn, patternIn, zoneIdIn, localeIn );
        return DateTimeUtil.formatDate( date, formatterIn, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "String" date-time to "String" object without date-time pattern.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( "25/06/2021 17:36", "yyyy-MM-dd//HH-mm" );
     * </code>
     *
     * @param dateTimeIn The date-time as "String".
     * @param formatterIn The format pattern to format "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     */
    public static String formatDateTime( String dateTimeIn, String formatterIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" date-time to "String" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", "yyyy-MM-dd//HH-mm" );
     * </code>
     *
     * @param dateTimeIn The date-time as "String".
     * @param patternIn The format pattern of "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     */
    public static String formatDateTime( String dateTimeIn, String patternIn, String formatterIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, patternIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" date-time to "String" object  without date-time pattern and with "ZoneId".</p>
     * <p>"Locale" is set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( "25/06/2021 17:36", "yyyy-MM-dd//HH-mm", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "String".
     * @param formatterIn The format pattern to format "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     */
    public static String formatDateTime( String dateTimeIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" date-time to "String" object without date-time pattern and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( "25/06/2021 17:36", "yyyy-MM-dd//HH-mm", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "String".
     * @param formatterIn The format pattern to format "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Locale
     */
    public static String formatDateTime( String dateTimeIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "String" date-time to "String" object with "ZoneId".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", "yyyy-MM-dd//HH-mm", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "String".
     * @param patternIn The format pattern of "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     */
    public static String formatDateTime( String dateTimeIn, String patternIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, patternIn, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" date-time to "String" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", "yyyy-MM-dd//HH-mm", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "String".
     * @param patternIn The format pattern of "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Locale
     */
    public static String formatDateTime( String dateTimeIn, String patternIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, patternIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "String" date-time to "String" object without date-time pattern and with "ZoneId" and "Locale".</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" date-time pattern is set as default ("dd/MM/yyyy HH:mm").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( "25/06/2021 17:36", "yyyy-MM-dd//HH-mm", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "String".
     * @param formatterIn The format pattern to format "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDateTime( String dateTimeIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.formatDateTime( dateTimeIn, DateTimeUtil.DEFAULT_DATE_TIME_PATTERN, formatterIn, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "String" date-time to "String" object with "ZoneId" and "Locale".</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatDateTime( "25/06/2021 17:36", "dd/MM/yyyy HH:mm", "yyyy-MM-dd//HH-mm", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param dateTimeIn The date-time as "String".
     * @param patternIn The format pattern of "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "dateTimeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The date-time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatDateTime( String dateTimeIn, String patternIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        LocalDateTime date = DateTimeUtil.getLocalDateTimeFromString( dateTimeIn, patternIn, zoneIdIn, localeIn );
        return DateTimeUtil.formatDateTime( date, formatterIn, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "String" time to "String" object without String time pattern.</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" time pattern is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( "17:36:27", "ss:mm:HH" );
     * </code>
     *
     * @param timeIn The time as "String".
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     */
    public static String formatTime( String timeIn, String formatterIn ){
        return DateTimeUtil.formatTime( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" time to "String" object.</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( "17:36:27", "HH:mm:ss", "ss:mm:HH" );
     * </code>
     *
     * @param timeIn The time as "String".
     * @param patternIn The format pattern of "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     */
    public static String formatTime( String timeIn, String patternIn, String formatterIn ){
        return DateTimeUtil.formatTime( timeIn, patternIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" time to "String" object without String time pattern and with "ZoneId".</p>
     * <p>"ZoneId" and "Locale" are set as the system default and "String" time pattern is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( "17:36:27", "ss:mm:HH", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param timeIn The time as "String".
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     */
    public static String formatTime( String timeIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatTime( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" time to "String" object without String time pattern and with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" time pattern is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( "17:36:27", "ss:mm:HH", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "String".
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Locale
     */
    public static String formatTime( String timeIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatTime( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "String" time to "String" object with "ZoneId".</p>
     * <p>"Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( "17:36:27", "HH:mm:ss", "ss:mm:HH", ZoneId.of( "Europe/Paris" ) );
     * </code>
     *
     * @param timeIn The time as "String".
     * @param patternIn The format pattern of "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     */
    public static String formatTime( String timeIn, String patternIn, String formatterIn, ZoneId zoneIdIn ){
        return DateTimeUtil.formatTime( timeIn, patternIn, formatterIn, zoneIdIn, DateTimeUtil.DEFAULT_LOCALE );
    }

    /**
     * <p>Formats a "String" time to "String" object with "Locale".</p>
     * <p>"ZoneId" is set as the system default and "String" time pattern is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( "17:36:27", "HH:mm:ss", "ss:mm:HH", new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "String".
     * @param patternIn The format pattern of "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param localeIn The "Locale" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.util.Locale
     */
    public static String formatTime( String timeIn, String patternIn, String formatterIn, Locale localeIn ){
        return DateTimeUtil.formatTime( timeIn, patternIn, formatterIn, DateTimeUtil.DEFAULT_ZONE_ID, localeIn );
    }

    /**
     * <p>Formats a "String" time to "String" object without String time pattern and with "ZoneId" and "Locale".</p>
     * <p>"String" time pattern is set as default ("HH:mm:ss").</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( "17:36:27", "ss:mm:HH", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "String".
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatTime( String timeIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        return DateTimeUtil.formatTime( timeIn, DateTimeUtil.DEFAULT_TIME_PATTERN, formatterIn, zoneIdIn, localeIn );
    }

    /**
     * <p>Formats a "String" time to "String" object with "ZoneId" and "Locale".</p>
     * <p>"ZoneId" and "Locale" are set as the system default.</p>
     * <p>Example:</p>
     * <code>
     * String result = DateTimeUtil.formatTime( "17:36:27", "HH:mm:ss", "ss:mm:HH", ZoneId.of( "Europe/Paris" ), new Locale( "es", "ES" ) );
     * </code>
     *
     * @param timeIn The time as "String".
     * @param patternIn The format pattern of "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param formatterIn The format pattern to format "timeIn".
     * <p>Rules of format pattern from "DateTimeFormatter" object.</p>
     * @param zoneIdIn The "ZoneId" object.
     * @param localeIn The "Locale" object.
     *
     * @return The time formatted as "String" object.
     *
     * @author <a href="mailto:indenaiten@gmail.com">Ángel Herce Soto</a>
     * @see java.time.ZoneId
     * @see java.util.Locale
     */
    public static String formatTime( String timeIn, String patternIn, String formatterIn, ZoneId zoneIdIn, Locale localeIn ){
        LocalTime time = DateTimeUtil.getLocalTimeFromString( timeIn, patternIn, zoneIdIn, localeIn );
        return DateTimeUtil.formatTime( time, formatterIn, zoneIdIn, localeIn );
    }

}
