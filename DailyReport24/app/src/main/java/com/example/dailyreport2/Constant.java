package com.example.dailyreport2;

public class Constant {
    public static final String DB_NAME="Daily_Activity_DB";

    //db version
    public static final int DB_VERSION= 1;
    //db table
    public static final String TABLE_NAME="DailyActivity_INFO_TABLE";
    //table columns
    public static final String C_ID= "ID";
    public static final String C_DATE="DATE";
    public static final String C_PROJECT="PROJECT";
    public static final String C_CHALLENGE="CHALLENGE";
    public static final String C_DIFFICULTY="DIFFICULTY";
    public static final String C_STAFFNAME="STAFFNAME";
    public static final String C_TIME= "TIME";
    public static final String C_VILLAGE= "VILLAGE";
    public static final String C_PERSONGROUP= "PERSONGROUP";
    public static final String C_MEETINGPOINT= "MEETINGPOINT";
    public static final String C_ACTIONPOINT= "ACTIONPOINT";
    public static final String C_NEXTDAYPLANNING= "NEXTDAYPLANNING";
     //create a query for table
    public static final String CREATE_TABLE= "CREATE TABLE "+ TABLE_NAME+" ("
             +C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
             +C_DATE + " TEXT,"
             +C_PROJECT + " TEXT,"
             +C_CHALLENGE + " TEXT,"
             +C_DIFFICULTY + " TEXT,"
             +C_STAFFNAME + " TEXT,"
             +C_TIME + " TEXT,"
             +C_VILLAGE + " TEXT,"
             +C_PERSONGROUP + " TEXT,"
             +C_MEETINGPOINT + " TEXT,"
             +C_ACTIONPOINT + " TEXT,"
             +C_NEXTDAYPLANNING + " TEXT"
             +");";
}
