package com.hector.library.controller;

import com.hector.library.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Tag(name = "category services controller")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{category}")
    @Operation(summary = "this method is used to fetch a category only one query to database")
    public ResponseEntity<?> getAllCategory(@PathVariable String category) {
        return ResponseEntity.ok(categoryService.findCategory(category));
    }

    @GetMapping("other/way/{category}")
    @Operation(summary = "this method is used to fetch a category many queries to database")
    public ResponseEntity<?> getAllCategoryOtherWay(@PathVariable String category) {
        return ResponseEntity.ok(categoryService.findCategoryOtherWay(category));
    }

}
