package com.deg.facturacion.service;

import com.deg.facturacion.exception.ResourceAlreadyExistsException;
import com.deg.facturacion.exception.ResourceNotFoundException;
import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.model.Producto;
import com.deg.facturacion.repository.ProductoRepository;
import com.deg.facturacion.response.ClienteResponse;
import com.deg.facturacion.response.ProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Crear un Producto

    public Producto create(Producto newProducto) {
        return this.productoRepository.save(newProducto);
    }

    //BUSCAR UN PRODUCTO
    public List<ProductoResponse> findAll(){

        List<Producto> entity= this.productoRepository.findAll();
        List<ProductoResponse> response = new ArrayList<>();
        for (Producto producto :entity) {
            ProductoResponse productoResponse = new ProductoResponse();
            productoResponse.setId(producto.getId());
            productoResponse.setDescripcion(producto.getDescripcion());
            productoResponse.setPrecio_compra(producto.getPrecio_compra());
            productoResponse.setPrecio_venta(producto.getPrecio_venta());
            productoResponse.setStock(producto.getStock());
            productoResponse.setFecha_alta(producto.getFecha_alta());


            response.add(productoResponse);
        }
        return response;
    }


    //ACTUALIZAR UN PRODUCTO
    public Producto update(Producto updateProducto, Long id) throws ResourceNotFoundException {

        if( id <= 0){
            throw new IllegalArgumentException("El id ingresado no es valido");
        }

        Optional<Producto> producto = this.productoRepository.findById(id);
        if (producto.isPresent()){
            Producto produc = producto.get();
            produc.setDescripcion(updateProducto.getDescripcion());
            produc.setPrecio_compra(updateProducto.getPrecio_compra());
            produc.setPrecio_venta(updateProducto.getPrecio_venta());
            produc.setStock(updateProducto.getStock());
            produc.setFecha_alta(updateProducto.getFecha_alta());
           // produc.setDetalleVentas(updateProducto.getDetalleVentas());

            return this.productoRepository.save(produc);
        }

        return null;

    }
        //ELIMINAR UN PRODUCTO
        public void delete(Long id){
            this.productoRepository.deleteById(id);

        }



        //BUSCAR POR ID
        public Optional<Producto> findById(Long id) {

            return this.productoRepository.findById(id);


        }


}
