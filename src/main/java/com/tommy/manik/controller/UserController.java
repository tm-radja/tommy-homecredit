package com.tommy.manik.controller;

	import java.util.HashMap;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tommy.manik.entity.ModulesEntity;
import com.tommy.manik.entity.RoleModulesEntity;
import com.tommy.manik.entity.User;
import com.tommy.manik.service.UserService;

@RestController
@RequestMapping(value={"/user"})
public class UserController {
	@Autowired
	UserService userService;

    @GetMapping(value = "/findBy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, List<RoleModulesEntity>>> findUserById(@RequestParam(value = "userId", defaultValue = "") int id) {
        System.out.println("Fetching User with id " + id);
        
        List<RoleModulesEntity> mEnt = userService.getModulesByUser(id);
        HashMap<String, List<RoleModulesEntity>> returnMap = new HashMap<>();
        returnMap.put("Modules", mEnt);
        if(mEnt == null || mEnt.equals(null)) {
        	return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(returnMap);
        }else {
        	return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(returnMap);
        }
        
    }
    
	 @PostMapping(value="/createUser",headers="Accept=application/json")
	 public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating User "+user.getName());
	     userService.createUser(user);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/getAll", headers="Accept=application/json")
	 public ResponseEntity<List<User>> findAllUser() {	 
	  List<User> tasks=userService.getUser();
	  return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(tasks);
	
	 }

}
