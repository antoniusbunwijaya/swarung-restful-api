package com.noranekoit.swarung.api.controller

import com.noranekoit.swarung.api.model.*
import com.noranekoit.swarung.api.service.ProductService
import org.springframework.web.bind.annotation.*

//injection productService
//menandakan rest
@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse>{
        val productResponse = productService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data= productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    //gak perlu consume karena gak perlu data body

    )
    //inject idProduct
    fun getProduct(@PathVariable("idProduct")id: String): WebResponse<ProductResponse>{
        val productResponse = productService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }
    @PutMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(@PathVariable("idProduct") id: String,
                      @RequestBody updateProductRequest : UpdateProductRequest) :WebResponse<ProductResponse>{

       val productResponse = productService.update(id, updateProductRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<String>{
        productService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }
    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProducts(@RequestParam(value = "size", defaultValue = "10") size : Int,
                     @RequestParam(value = "page",defaultValue = "0") page:Int) : WebResponse<List<ProductResponse>>{
        val request = ListProductRequest(page = page, size = size)
        val response = productService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}
