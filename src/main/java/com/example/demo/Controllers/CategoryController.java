package com.example.demo.Controllers;

import com.example.demo.Entities._BlogPost_;
import com.example.demo.Entities._Category_;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.lang.model.element.Element;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class CategoryController {


    @Autowired
    CategoryServiceImpl categoryService = new CategoryServiceImpl();


    @RequestMapping("/CreateCategory")
    public String CreateCategory(){
        return "CreateCategory";
    }

    @RequestMapping("/CategoryPanel")
    public String CategoryPanel(ModelMap modelMap,
                                @RequestParam(name="page",defaultValue = "0")int page,
                                @RequestParam(name="size",defaultValue = "2")int size){

        Page<_Category_> cats_list=categoryService.GetAllCategoriesByPage(page,size);
        modelMap.addAttribute("pages",new int[cats_list.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("cats_list",cats_list);
        return "CategoryPanel";
    }

    @RequestMapping("/AllCategories")
    public String AllCategories(ModelMap modelMap){
        List<_Category_>cats_list=categoryService.getAllCategories();
        modelMap.addAttribute("cats_list",cats_list);
        return "AllCategories";
    }

    @RequestMapping("SaveCategory")
    public String SaveCategory(@ModelAttribute("category")_Category_ category)throws ParseException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        category.setCreated_At(formattedDateTime);
        category.setUpdated_At(formattedDateTime);
        categoryService.SaveCategory(category);
        return "CreateCategory";
    }

    @RequestMapping("/DeleteCategory")
    public String DeleteCategory(@RequestParam("id") Long id,ModelMap modelMap,
                                 @RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="size",defaultValue = "2")int size){
        categoryService.deleteCategoryById(id);

        Page<_Category_> cats_list=categoryService.GetAllCategoriesByPage(page,size);

        modelMap.addAttribute("cats_list",cats_list);
        modelMap.addAttribute("pages",new int[cats_list.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "CategoryPanel";
    }
    @RequestMapping("/ShowCategory")
    public String ShowCategory(@RequestParam("id") Long id,ModelMap modelMap){
        _Category_ category=categoryService.GetCategoryById(id);
        modelMap.addAttribute("categoryView",category);
        return "EditCategory";
    }

    @RequestMapping("/UpdateCategory")
    public String updateCategory(@ModelAttribute ("categoryVue") _Category_ category,ModelMap modelMap,@RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="size",defaultValue = "2")int size){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        category.setUpdated_At(formattedDateTime);
        categoryService.updateCategory(category);

        Page<_Category_> cats_list=categoryService.GetAllCategoriesByPage(page,size);
        modelMap.addAttribute("pages",new int[cats_list.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("cats_list",cats_list);
        return "CategoryPanel";
    }



}
