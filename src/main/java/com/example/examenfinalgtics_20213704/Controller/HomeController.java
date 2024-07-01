package com.example.examenfinalgtics_20213704.Controller;

import com.example.examenfinalgtics_20213704.Entities.Juego;
import com.example.examenfinalgtics_20213704.Repositories.JuegoRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

@Controller
public class HomeController {

    final JuegoRepository juegoRepository;
    public HomeController(JuegoRepository juegoRepository){
        this.juegoRepository = juegoRepository;
    }


    //Listar juegos :

    //Creamos clase de juego sin el id
    @CrossOrigin
    @GetMapping(value="/api/orders/lista" , produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    @ResponseBody
    public Object listarApi(){
        LinkedHashMap<String , Object> response= new LinkedHashMap<>();
        response.put("result", "success");
        //Ponemos la informacion sin los ids
        ArrayList<LinkedHashMap<String , Object>> listaDepurada = new ArrayList<LinkedHashMap<String , Object>>();
        for(Juego j : juegoRepository.findAll()){
            LinkedHashMap<String , Object> link = new LinkedHashMap<>();
            link.put("nombre", j.getNombre());
            link.put("descripcion", j.getDescripcion());
            link.put("precio", j.getPrecio());
            link.put("image", j.getImage());
            link.put("genero", j.getIdgenero().getNombre());
            link.put("plataforma", j.getIdplataforma().getNombre());
            link.put("editora", j.getIdeditora().getNombre());
            link.put("distribuidora", j.getIddistribuidora().getNombre());
            listaDepurada.add(link);
        }
        response.put("data" ,  listaDepurada);
        return response;
    }
}
