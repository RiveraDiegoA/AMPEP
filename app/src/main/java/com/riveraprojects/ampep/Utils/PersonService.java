package com.riveraprojects.ampep.Utils;

import com.riveraprojects.ampep.Models.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonService {

    @GET("persons/list/")
    Call<List<Person>> getPersons();
}
