import static java.lang.Integer.parseInt;

/*
Example:
'hh:mm:ssAM'
'hh:mm:ssPM'
'12:01:00PM' -> '12:01:00'.

'12:01:00AM' -> '00:01:00'.

Convert PM and AM
if charArray[8] == P
    if (hh < 12)
        hh = 12 + hh;
    if (hh == 12)
        hh = 12;
if charArray[8] == A
    start at 00 in hh
    if (hh < 12)
    hh = hh;
    if (hh == 12)
    hh = 00;

 */
public class TimeConversion {
    public static void main(String[] args) {
        String testSub = "07:05:45PM";
        System.out.println(timeConversion(testSub));
    }

    static String timeConversion(String oldTime) {
        StringBuilder newTimeBuilder = new StringBuilder();

        String timeLetter = oldTime.substring(8,9);
        String hh = oldTime.substring(0,2);
        String rest = oldTime.substring(2, 8);
        Integer hhNumber = Integer.parseInt(hh);
        if (timeLetter.equals("P")) {

            int actualHH = 12;
            if (hhNumber < 12) {
                actualHH += hhNumber;
            }
            newTimeBuilder.append(actualHH).append(rest);
        }

        if (timeLetter.equals("A")) {

            int actualHH = 0;
            if (hhNumber < 12) {
                actualHH = hhNumber;
            }
            if (hhNumber < 10) {
                newTimeBuilder.append("0" + actualHH);
            } else if (hhNumber == 12) {
                newTimeBuilder.append("00");
            } else {
                newTimeBuilder.append(actualHH);
            }

            newTimeBuilder.append(rest);
        }
        return newTimeBuilder.toString();
    }
}
