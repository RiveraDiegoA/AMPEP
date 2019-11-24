package com.riveraprojects.ampep.Service;

import com.riveraprojects.ampep.Models.Anuncio;
import com.riveraprojects.ampep.Models.Login;
import com.riveraprojects.ampep.Models.UsuarioSistema;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    ////////////////////////////////
    @GET("anuncios")
    Call<List<Anuncio>> getAnuncios();

    @GET("anuncios/grado/{idGrado}")
    Call<List<Anuncio>> getAnunciosxGrado(@Path("idGrado") int idGrado);

    @GET("anuncios/usuario/{idUsuarioSist}")
    Call<List<Anuncio>> getAnunciosxUsuarioSist(@Path("idUsuarioSist") int idUsuarioSist);

    @POST("anuncios")
    Call<Anuncio> insertAnuncio(Anuncio anuncio);
}
