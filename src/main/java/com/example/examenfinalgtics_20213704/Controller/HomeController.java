package com.example.examenfinalgtics_20213704.Controller;

import com.example.examenfinalgtics_20213704.Entities.Juego;
import com.example.examenfinalgtics_20213704.Repositories.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

@Controller
public class HomeController {

    final JuegoRepository juegoRepository;
    final DistribuidoraRepository distribuidoraRepository;
    final EditoraRepository editoraRepository;

    final GeneroRepository generoRepository;
    final PlataformaRepository plataformaRepository;

    public HomeController(JuegoRepository juegoRepository,
    DistribuidoraRepository distribuidoraRepository,
    EditoraRepository editoraRepository,
                          GeneroRepository generoRepository,
                          PlataformaRepository plataformaRepository
    ){
        this.plataformaRepository= plataformaRepository;
        this.generoRepository = generoRepository;
        this.editoraRepository=  editoraRepository;
        this.distribuidoraRepository = distribuidoraRepository;
        this.juegoRepository = juegoRepository;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> gestionException(HttpServletRequest request) {
        HashMap<String, String> responseMap = new HashMap<>();
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            responseMap.put("estado", "error");
            responseMap.put("msg", "Debe enviar un juego");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }


    //Listar juegos :

    //Creamos clase de juego sin el id
    @CrossOrigin
    @GetMapping(value="/api/orders/lista" , produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    @ResponseBody
    public Object listarApigit(){
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
            if(j.getIdeditora() !=null){
                link.put("editora", j.getIdeditora().getNombre());
            }else{
                link.put("editora", "No tiene editora");
            }
            link.put("distribuidora", j.getIddistribuidora().getNombre());
            listaDepurada.add(link);
        }
        response.put("data" ,  listaDepurada);
        return ResponseEntity.ok(response);
    }

    //Crear juegos


    @PostMapping(value="/api/orders/crear")
    @ResponseBody
    public Object crearJuego( @RequestParam(value="nombre") String nombre,
                              @RequestParam(value="descripcion")  String descripcion,
                              @RequestParam(value="precio")  String  precio,
                              @RequestParam( value="image") String image,
                              @RequestParam(value = "idGenero") String idGenero
                              ,@RequestParam(value="idPlataforma") String idPlataforma ,
                              @RequestParam(value="idEditora") String idEditora ,
                              @RequestParam(value="idDistribuidora") String idDistribuidora
    ){
        try{
            Juego j = new Juego();
            j.setNombre(nombre);
            j.setDescripcion(descripcion);
            j.setPrecio(Double.parseDouble(precio));
            j.setImage(image);
            j.setIdgenero(generoRepository.findById(Integer.parseInt(idGenero)).get());
            j.setIdplataforma(plataformaRepository.findById(Integer.parseInt(idPlataforma)).get());
            j.setIdeditora(editoraRepository.findById(Integer.parseInt(idEditora)).get());
            j.setIddistribuidora(distribuidoraRepository.findById(Integer.parseInt(idDistribuidora)).get());
            Juego nuevoJuego = juegoRepository.save(j);
            LinkedHashMap<String , Object> response= new LinkedHashMap<>();
            response.put("result", "success");
            LinkedHashMap<String , Object> data  = new LinkedHashMap<>();
            data.put("new_id" ,  nuevoJuego.getId());
            response.put("data" ,data );
            return ResponseEntity.ok(response);
        }catch(Exception error){
            LinkedHashMap<String , Object> response= new LinkedHashMap<>();
            response.put("result", "error");
            response.put("msg",  "parametros incorrectos");
            return ResponseEntity.badRequest().body(response);
        }
    }

    //Update juegos


    @CrossOrigin
    @PutMapping(value="/api/orders/update" , produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    @ResponseBody
    public Object updateJuego(
            @RequestParam(value="nombre", required = false) String nombre, @RequestParam(value="descripcion", required = false)  String descripcion, @RequestParam(value="precio", required = false)  String  precio,  @RequestParam( value="image", required = false) String image, @RequestParam(value = "idGenero", required = false) String idGenero
            ,@RequestParam(value="idPlataforma", required = false) String idPlataforma , @RequestParam(value="idEditora", required = false) String idEditora , @RequestParam(value="idDistribuidora", required = false) String idDistribuidora , @RequestParam(value= "idJuego") String idJuego
    ){
        try{
            Juego j = new Juego();
            j.setId(Integer.parseInt(idJuego));
            j.setNombre(nombre);
            j.setDescripcion(descripcion);
            j.setPrecio(Double.parseDouble(precio));
            j.setImage(image);
            j.setIdgenero(generoRepository.findById(Integer.parseInt(idGenero)).get());
            j.setIdplataforma(plataformaRepository.findById(Integer.parseInt(idPlataforma)).get());
            j.setIdeditora(editoraRepository.findById(Integer.parseInt(idEditora)).get());
            j.setIddistribuidora(distribuidoraRepository.findById(Integer.parseInt(idDistribuidora)).get());
            Juego nuevoJuego = juegoRepository.save(j);
            LinkedHashMap<String , Object> response= new LinkedHashMap<>();
            response.put("result", "success");
            LinkedHashMap<String , Object> data  = new LinkedHashMap<>();
            data.put("updates_id" ,  nuevoJuego.getId());
            response.put("data" ,data );
            return ResponseEntity.ok(response);
        }catch(Exception error){
            error.printStackTrace();
            LinkedHashMap<String , Object> response= new LinkedHashMap<>();
            response.put("result", "error");
            response.put("msg",  "parametros incorrectos");
            return ResponseEntity.badRequest().body(response);
        }
    }



}
