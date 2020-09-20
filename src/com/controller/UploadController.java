package com.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pojo.Food;
import com.pojo.Recipe;
import com.service.FoodService;
import com.service.RecipeService;
import com.service.UserService;
import com.utils.FileUpload;

@Controller
public class UploadController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value ="/headUpload")
	@ResponseBody
	public String head_image(@RequestParam(value = "file", required = false) MultipartFile file,String username,HttpServletRequest request) throws IOException {
		if (!file.isEmpty()) {  
           String filePath = FileUpload.uploadFile(file, request);
           if(filePath!=null) {
        	   return String.valueOf(userService.updateHeadImg(username, filePath));
           }else {
			return "0";
           }
        }else {
			return "-1";
		}  
	}
	
	@RequestMapping(value ="/recipeRelease")
	@ResponseBody
	public String recipe_release(@RequestParam(value = "coverFile") MultipartFile coverFile,String title,String username,String ingre,String step,
			String tip,String sort,@RequestParam(value = "files") MultipartFile[] files,HttpServletRequest request)throws IOException{
		
		String coverString = FileUpload.uploadFile(coverFile, request);
		String stepImgUrl = FileUpload.uploadFiles(files, request);
		Recipe recipe = new Recipe();
		recipe.setCover(coverString);
		recipe.setTitle(title);
		recipe.setIngredients(ingre);
		recipe.setStep(step);
		recipe.setStepImg(stepImgUrl);
		recipe.setTips(tip);
		recipe.setSort(sort);
		
		int u = recipeService.addRecipe(recipe, username);
		
		return String.valueOf(u);
	}
	
	@RequestMapping(value ="/recipeUpdate")
	@ResponseBody
	public String recipe_update(@RequestParam(value = "coverFile") MultipartFile coverFile,String title,String rid,String ingre,String step,
			String tip,String sort,@RequestParam(value = "files") MultipartFile[] files,HttpServletRequest request)throws IOException{
		
		String coverString = FileUpload.uploadFile(coverFile, request);
		String stepImgUrl = FileUpload.uploadFiles(files, request);
		Recipe recipe = new Recipe();
		recipe.setRid(rid);
		recipe.setCover(coverString);
		recipe.setTitle(title);
		recipe.setIngredients(ingre);
		recipe.setStep(step);
		recipe.setStepImg(stepImgUrl);
		recipe.setTips(tip);
		recipe.setSort(sort);
		
		int u = recipeService.updateRecipe(recipe);
		
		return String.valueOf(u);
	}
	
	@RequestMapping(value ="/foodUpdate")
	@ResponseBody
	public String food_update(@RequestParam(value = "file") MultipartFile file,String title,String content,String fid,String tag,
			HttpServletRequest request)throws IOException{
		
		String fileString = FileUpload.uploadFile(file, request);
		
		Food food = new Food();
		food.setFid(fid);
		food.setFphoto(fileString);
		food.setTitle(title);
		food.setMessage(content);
		food.setTag(tag);
		
		int u = foodService.updateFood(food);
		return String.valueOf(u);
	}
	
	
	@RequestMapping(value ="/foodRelease")
	@ResponseBody
	public String food_release(@RequestParam(value = "file") MultipartFile file,String title,String content,String username,String tag,
			HttpServletRequest request)throws IOException{
		
		String fileString = FileUpload.uploadFile(file, request);
		
		Food food = new Food();
		food.setFphoto(fileString);
		food.setTitle(title);
		food.setMessage(content);
		food.setTag(tag);
		
		int u = foodService.addFood(food, username);
		return String.valueOf(u);
	}
}
