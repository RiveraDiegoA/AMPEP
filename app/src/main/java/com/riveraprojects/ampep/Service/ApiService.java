package com.riveraprojects.ampep.Service;

import com.riveraprojects.ampep.Models.Alumno;
import com.riveraprojects.ampep.Models.Anuncio;
import com.riveraprojects.ampep.Models.Apoderado;
import com.riveraprojects.ampep.Models.Colegio;
import com.riveraprojects.ampep.Models.GradoEscolar;
import com.riveraprojects.ampep.Models.Login;
import com.riveraprojects.ampep.Models.Profesor;
import com.riveraprojects.ampep.Models.UsuarioSistema;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    String API_BASE_URL = "http://192.168.1.124:8080/ampep/";

    ////////////////////////////////
    @GET("usuariosistema/")
    Call<List<UsuarioSistema>> getUsuariosSistema();

    @GET("usuariosistema/login/{usuario}/{contrasena}")
    Call<UsuarioSistema> login(@Path("usuario") String usuario,
                               @Path("contrasena") String contrasena);
    ////////////////////////////////

    @GET("profesor/")
    Call<List<Profesor>> getProfesor();

    @GET("profesor/{id}")
    Call<Profesor> getProfesorById(@Path("id") int id);

    @GET("apoderados")
    Call<List<Apoderado>> getApoderado();

    @GET("apoderados/{id}")
    Call<Apoderado> getApoderadoById(@Path("id") int id);

    @GET("alumnos")
    Call<List<Alumno>> getAlumno();

    @GET("alumnos/{id}")
    Call<Alumno> getAlumnoById(@Path("id") int id);

    ////////////////////////////////
    @GET("colegios")
    Call<List<Colegio>> getColegio();

    @GET("colegios/{id}")
    Call<Colegio> getColegioById(@Path("id") int id);

    @GET("colegios/{id}")
    Call<List<Colegio>> getColegioById2(@Path("id") int id);
    ////////////////////////////////
    @GET("gradosEscolares")
    Call<List<GradoEscolar>> getGradoEscolar();

    @GET("gradosEscolares/{id}")
    Call<GradoEscolar> getGradoEscolarById(@Path("id") int id);

    @GET("gradosEscolares/{id}")
    Call<List<GradoEscolar>> getGradoEscolarById2(@Path("id") int id);
    ////////////////////////////////

    ////////////////////////////////
    @GET("anuncios")
    Call<List<Anuncio>> getAnuncios();

    @GET("anuncios/grado/{idGrado}")
    Call<List<Anuncio>> getAnunciosxGrado(@Path("idGrado") int idGrado);

    @GET("anuncios/usuario/{idUsuarioSist}")
    Call<List<Anuncio>> getAnunciosxUsuarioSist(@Path("idUsuarioSist") int idUsuarioSist);

    @POST("anuncios")
    Call<Anuncio> insertAnuncio(@Body Anuncio anuncio);
    ////////////////////////////////
}
