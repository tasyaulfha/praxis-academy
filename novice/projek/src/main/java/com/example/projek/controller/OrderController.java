package com.example.projek.controller;


import com.example.projek.Dto.OrderProductDto;
import com.example.projek.model.Order;
import com.example.projek.model.OrderProduct;
import com.example.projek.model.OrderStatus;
import com.example.projek.security.services.OrderProductService;
import com.example.projek.security.services.OrderService;
import com.example.projek.security.services.ProductService;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jwt")
public class OrderController {
    ProductService productService;
    OrderService orderService;
    OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService orderService, OrderProductService orderProductService){
        this.productService=productService;
        this.orderService=orderService;
        this.orderProductService=orderProductService;
    }

    @GetMapping
    public @NotNull Iterable<Order> listAllOrders(){
        return this.orderService.getAllOrders();
    }
    @PostMapping
    public ResponseEntity<Order> create (@RequestBody OrderForm form){
        List<OrderProductDto> formDto = form.getProductOrders();
        validateProductExistance(formDto);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);


        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto: formDto){
            orderProducts.add(orderProductService.create(new OrderProduct(order,productService.getProduct(dto
            .getProduct()
            .getId()), dto.getJumlah())));
        }
        order.setOrderProducts(orderProducts);
        this.orderService.update(order);

        String uri= ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",uri);

    return new ResponseEntity<>(order,headers, HttpStatus.CREATED);
    }

    private void validateProductExistance(List<OrderProductDto> orderProducts) {
        List<OrderProductDto>list = orderProducts.stream()
                .filter(op-> Objects.isNull(productService.getProduct(op.getProduct()
                .getId())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)){
            new ResourceNotFoundException("Produk tidak diemukan");
        }
    }

    private class OrderForm {
        private List<OrderProductDto> productOrders;
        public List<OrderProductDto> getProductOrders(){
            return productOrders;
        }

        public void setProductOrders(List<OrderProductDto> productOrders) {
            this.productOrders = productOrders;
        }
    }
}
