/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  <Colin Karch>
 *  Date          :  <2018-01-24>
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2017-12-25  B.J. Johnson  Updated for Spring 2018
 */
public class CalendarStuff {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY   = MONDAY    + 1;
   private static final int WEDNESDAY = TUESDAY   + 1;
   private static final int THURSDAY  = WEDNESDAY + 1;
   private static final int FRIDAY    = THURSDAY  + 1;
   private static final int SATURDAY  = FRIDAY    + 1;



  // you can finish the rest on your own

  /**
   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
   */
   private static final int JANUARY    = 0;
   private static final int FEBRUARY   = JANUARY   + 1;
   private static final int MARCH      = FEBRUARY  + 1;
   private static final int APRIL      = MARCH     + 1;
   private static final int MAY        = APRIL     + 1;
   private static final int JUNE       = MAY       + 1;
   private static final int JULY       = JUNE      + 1;
   private static final int AUGUST     = JULY      + 1;
   private static final int SEPTEMBER  = AUGUST    + 1;
   private static final int OCTOBER    = SEPTEMBER + 1;
   private static final int NOVEMBER   = OCTOBER   + 1;
   private static final int DECEMBER   = NOVEMBER  + 1;

  // you can finish these on your own, too

  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   *  NOTE: this is optional, but suggested
   */
   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class
   */
   public void CalendarStuffEmpty() {
      System.out.println( "Constructor called..." );  // replace this with the actual code
   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear( long year ) {
     if ((year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
       return true;
     } else {
      return false;
     }
   }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ) {
     if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
       return 31;
     }
     if (month == 4 || month == 6 || month == 9 || month == 11) {
       return 30;
     }
     if (month == 2 && (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
       return 29;
     } else {
       return 28;
     }
   }




  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
        if ((month1 == month2) && (day1 == day2) && (year1 == year2)){
            return true;
        } else {
            return false;
        }
    }



  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
        if (year1 > year2) {
            return -1;
        } else if (year1 < year2) {
            return 1;
        } else { // If years are equal
            if (month1 > month2) {
                return -1;
            } else if (month1 < month2) {
                return 1;
            } else { // If years and months are equal
                if(day1 > day2) {
                    return 1;
                } else if(day1 < day2) {
                    return -1;
                } else {
                    return 0; // they are the same date
                }
            }
        }
    }



  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
    public static boolean isValidDate( long month, long day, long year ) {
        int integerMonth = (int) month;
        switch(integerMonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(day <= 31) {
                    return true;
                } else {
                    return false;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if(day <= 30) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if(isLeapYear(year)) {
                    if(day <= 29) {
                        return true;
                    } else {
                        return false;
                    }
                } else if(day <= 28) {
                    return true;
                } else {
                    return false;
                }
        }
        return false; // Default to false ??
    }



    /**
    * A method to return a string version of the month name
    * @param    month long   containing month number, starting with "1" for "January"
    * @return         String containing the string value of the month (no spaces)
    */
    public static String toMonthString(int month) {
        switch(month) {
            case 0:
                return "Janurary";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July" ;
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";

            default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
      }
   }

    /**
    * A method to return a string version of the day of the week name
    * @param    day int    containing day number, starting with "1" for "Sunday"
    * @return       String containing the string value of the day (no spaces)
    */
    public static String toDayOfWeekString( int day ) {
        switch( day - 1 ) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";

            default: throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
        }
    }

    /**
    * A method to return a count of the total number of days between two valid dates
    * @param    month1 long   containing month number, starting with "1" for "January"
    * @param    day1   long   containing day number
    * @param    year1  long   containing four-digit year
    * @param    month2 long   containing month number, starting with "1" for "January"
    * @param    day2   long   containing day number
    * @param    year2  long   containing four-digit year
    * @return          long   count of total number of days
    */
    public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
        long dayCount = 0;

        while (day1 > 1) {
            day1 -= 1;
            dayCount -= 1;
        }
        while ( year1 < year2 ) {
            if ((year2 % 4 == 0 && (year2 % 100 != 0 || year2 % 400 == 0))) {
                dayCount += 366;
            } else {
                dayCount += 365;
            }
            year1 += 1;
        }
        while ( month1 < month2 ) {
            if (month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
                dayCount += 31;
            } else if (month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
                dayCount += 30;
            }
            month1 += 1;
        }
        while ( month1 > month2 ) {
            if (month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
                dayCount -= 31;
            } else if (month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
                dayCount -= 30;
            } else if ((month1 == 2) && (month1 == 2 && ( year1 % 4 == 0) && (year1 % 100 != 0) || (year1 % 400 == 0))) {
                dayCount -= 29;
            } else if ((month1 == 2)) {
                dayCount -= 28;
            }
            month1 -= 1;
        }
        while ( day1 < day2 ) {
            day1 += 1;
            dayCount += 1;
        }
        return dayCount;
    }

}
