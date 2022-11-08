package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    
    public static enum Month {
        JANUARY("January", 31),
        FEBRUARY("February", 28),
        MARCH("March", 31),
        APRIL("April", 30),
        MAY("May", 31),
        JUNE("June", 30),
        JULY("July", 31),
        AUGUST("August", 31),
        SEPTEMBER("September", 30),
        OCTOBER("October", 31),
        NOVEMBER("November", 30),
        DECEMBER("December", 31);

        private final String actualName;
        private final int daysNumber;

        private Month(String actualName, int daysNumber) {
            this.actualName = actualName;
            this.daysNumber = daysNumber;
        }

        public String getName() {
            return this.actualName;
        } 

        public int getDays() {
            return this.daysNumber;
        }
 
        private static Month fromString(String partialName) {
            Month result = null;
            for (Month month : Month.values()) {
                if (month.getName().toLowerCase().indexOf(partialName.toLowerCase()) == 0) {
                    if (result != null) {
                        throw new IllegalArgumentException(partialName + " doesn't match any month!");
                    }
                    result = month;
                }
            }
            if (result != null) {
                return result;
            }
            throw new IllegalArgumentException(partialName + " doesn't match any month!");
        }

        private static int indexOf(Month month) {
            for (int i=0; i < Month.values().length; i++) {
                if (month.equals(Month.values()[i])) {
                    return i;
                }
            }
            return -1;
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                Month month0 = Month.fromString(arg0);
                Month month1 = Month.fromString(arg1);
                if (month0.getDays() < month1.getDays()) {
                    return -1;
                }
                else if ( month0.getDays() > month1.getDays()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                Month month0 = Month.fromString(arg0);
                Month month1 = Month.fromString(arg1);
                if (Month.indexOf(month0) < Month.indexOf(month1)) {
                    return -1;
                }
                else if (Month.indexOf(month0) > Month.indexOf(month1)) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            
        };
    }
}
