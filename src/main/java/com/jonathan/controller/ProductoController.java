package com.jonathan.controller;

import com.jonathan.model.Producto;
import com.jonathan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")// Esta sera la URL : http://localhost:8080/productos
public class ProductoController {
    @Autowired
    private ProductRepository productRepository;

    // metodo para listar(GET)
    @GetMapping
    public List<Producto> listar(){
       return productRepository.findAll(); //Usamos findAll()para traer todo
    }

    // Metodo para guardar (Post)
    @PostMapping
    public Producto guardar (@RequestBody Producto producto){
        return productRepository.save(producto);
    }

    //Buscar un producto especifico por su ID
    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }

    //3. Metodo para actualizar un producto(PUT)
    @PutMapping("{id}")
    public Producto actualizar(@PathVariable Long id,@RequestBody Producto detallesProducto){

     Producto productoExistente = productRepository.findById(id).orElse(null);
     if (productoExistente != null){
         productoExistente.setNombre(detallesProducto.getNombre());
         productoExistente.setPrecio(detallesProducto.getPrecio());
         productoExistente.setStock(detallesProducto.getStock());

         return productRepository.save(productoExistente);
     }
     return null;
    }

    //4.- Metodo para borrar un producto (DELETE)
    @DeleteMapping("/{id}")
    public String borrar (@PathVariable long id){
        productRepository.deleteById(id);
        return "El producto a sido eliminado correctamente.";
    }
}
