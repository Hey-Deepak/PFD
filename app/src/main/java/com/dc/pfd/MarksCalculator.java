package com.dc.pfd;


public class MarksCalculator {

    float firstInSem, secondInSem, finalSem, assignment, attendance;
    float total;


    public MarksCalculator(float myFirstInSem, float mySecondInSem, float myFinalSem, float myAttendance, float myAssignment) {


        firstInSem = myFirstInSem;

        secondInSem = mySecondInSem;

        finalSem = myFinalSem;

        assignment = myAttendance;

        attendance = myAssignment;
        total = ((firstInSem) * 30) / 100 + (secondInSem * 30) / 100 + (finalSem * 50) / 100 + (assignment)
                + (attendance);


        if (total >= 35) {
            System.out.println("You are Safe and you crossed Danger Zone, Your extra marks is " + (total - 35));
        } else
            System.out.println("You are UnSafe and you have to gain " + (35 - total) * 2
                    + "more marks.\n Means Next time in Final Back Paper you have to score "
                    + (finalSem + (35 - total) * 2));

    }

}
