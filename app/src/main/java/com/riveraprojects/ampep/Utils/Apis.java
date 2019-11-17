package com.riveraprojects.ampep.Utils;

public class Apis {

    public static String URL_0001 = "http://192.168.1.124:8080/";

    public static PersonService getPersonService() {
        return Client.getClient(URL_0001).create(PersonService.class);
    }
}
