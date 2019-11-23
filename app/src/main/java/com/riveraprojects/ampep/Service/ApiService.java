package com.riveraprojects.ampep.Service;

import com.riveraprojects.ampep.Models.Login;
import com.riveraprojects.ampep.Models.UsuarioSistema;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String API_BASE_URL = "http://192.168.1.124:8080/ampep/";

    @GET("usuariosistema/")
    Call<List<UsuarioSistema>> getUsuariosSistema();

    @GET("usuariosistema/login/")
    Call<UsuarioSistema> loginBody(@Body Login login);

    @GET("usuariosistema/login/{usuario}/{contrasena}")
    Call<List<UsuarioSistema>> login(@Path("usuario") String usuario,
                                     @Path("contrasena") String contrasena);

    @GET("usuariosistema/login/{usuario}/{contrasena}")
    Call<UsuarioSistema> login2(@Path("usuario") String usuario,
                                @Path("contrasena") String contrasena);
}
