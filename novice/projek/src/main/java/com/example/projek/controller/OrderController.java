package com.example.projek.controller;


import com.example.projek.message.reques.OrderForm;
import com.example.projek.message.reques.OrderProductForm;
import com.example.projek.model.Order;
import com.example.projek.model.OrderProduct;
import com.example.projek.service.OrderProductService;
import com.example.projek.service.OrderService;
import com.example.projek.service.ProductService;
import com.example.projek.service.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/jwt")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    ResellerService resellerService;

    public OrderController(OrderService orderService, ProductService productService, OrderProductService orderProductService, ResellerService resellerService) {
        this.orderService = orderService;
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.resellerService = resellerService;
    }

    @GetMapping("/order")
    public @NotNull Iterable<Order> listAllOrders(){
        return this.orderService.getAllOrders();
    }

    @PostMapping("/order")
    public ResponseEntity<Order> create (@RequestBody OrderForm form ) {
        List<OrderProductForm> formDtos = form.getOrderProducts();

        validateProductExistance(formDtos);

        Order order = new Order();
        order.setStatus(form.getStatus());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductForm dto : formDtos){
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
            .getProduct().getId()),resellerService.getReseller(dto.getReseller().getId()),dto.getJumlah())));
        }

        order.setOrderProducts(orderProducts);
        this.orderService.update(order.getId(),order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/order/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers , HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order){
        orderService.update(id, order);
        return order;
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }


    private void validateProductExistance(List<OrderProductForm> orderProducts) {
        List<OrderProductForm> list = orderProducts.stream()
                .filter(op -> Objects.isNull(productService.getProduct(op
                .getProduct()
                        .getId())))
                .collect(Collectors.toList());

        if(!CollectionUtils.isEmpty(list)){
            new ResourceNotFoundException("Produk tidak ditemukan");
        }
    }

}
