package com.dc.pfd;


public class MarksCalculator {


    public static String calculate(float myFirstInSem, float mySecondInSem, float myFinalSem, float myAttendance, float myAssignment) {

        float total = ((myFirstInSem) * 30) / 100 + (mySecondInSem * 30) / 100 + (myFinalSem * 50) / 100 + (myAssignment)
                + (myAttendance);


        if (total >= 35) {
            if (myFinalSem >= 35) {
                return  ("You are Safe and you crossed Danger Zone, Your extra marks is " + (total - 35) + ".");


            } else {
                return  ("You are UnSafe and you have to gain " + (35 - myFinalSem) + " more marks from Teacher (Current Time)." +
                        " Means Next time in Final Back Paper you have to score Only 35 Marks. ");

            }
        } else {
            if ((myFinalSem + (35 - total) * 2) < 35) {
                return ((("You are UnSafe and you have to gain ") + ((35 - total) * 2) + " more marks from Teacher (Current Time)."
                + " Means Next time in Final Back Paper you have to score Only 35 Marks."));

            } else {
                return (" You are UnSafe and you have to gain " + ((35 - total) * 2) + " more marks from Teacher (Current Time).") +
                        (" Means Next time in Final Back Paper you have to score Only " + (myFinalSem + (35 - total) * 2) + " Marks");

            }
        }
    }
}
