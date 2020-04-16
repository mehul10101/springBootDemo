package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "demo")
public class DemoControlloer {

    @Autowired
    private DemoRepository demoRepository;

//    List<String> names = new ArrayList<>();
//    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
//    ResponseEntity demoById(@PathVariable Long id){
//        Optional<DemoEntity> demoEntity = demoRepository.findById(id);
//        return new ResponseEntity(demoEntity.get(), HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}")
    ResponseEntity demobyname(@PathVariable String name){
        List<DemoEntity> demoEntity = demoRepository.findByName(name);
        return new ResponseEntity(demoEntity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity demo(){
        Iterable<DemoEntity> demoEntities = demoRepository.findAll();
        return new ResponseEntity(demoEntities, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<String> demoPost(@RequestBody DemoEntity demoEntity){
//        names.add(name);
//        System.out.println("hello" + names);names
        demoRepository.save(demoEntity);
        return new ResponseEntity( HttpStatus.OK);
    }
}
