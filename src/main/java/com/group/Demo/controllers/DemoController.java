package com.group.Demo.controllers;

import com.group.Demo.models.Notes;
import com.group.Demo.repositories.NotesRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {

    @Autowired
    NotesRepository notesRepository;
    @GetMapping(value = "/")
    public String Hello(String name, String role){
        return "Hello World";
    }

    @PostMapping("/add-notes")
    public ResponseEntity<Notes> addNotes(@RequestBody Notes notes){
        Notes _notes=notesRepository.save(new Notes(notes.getTitle(), notes.getDescription()));
        return new ResponseEntity<>(_notes, HttpStatus.CREATED);
    }

    @GetMapping("/all-notes")
    public ResponseEntity<List<Notes>> getAllNotes(){
        List<Notes> notes=notesRepository.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<Notes> getNoteById(Long id){
        Notes note=notesRepository.findById(id).orElse(null);
        if(note!=null){
            return  new ResponseEntity<>(note, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/note/{id}")
    public  ResponseEntity<HttpStatus> deleteNote(Long id){
        notesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/note/{id}")
    public ResponseEntity<Notes> updateNote(Long id, @RequestBody Notes notes){
       Optional< Notes> _note=notesRepository.findById(id);
        if(_note!=null){
            Notes updatedNote=_note.get();
            updatedNote.setTitle(notes.getTitle());
            updatedNote.setDescription(notes.getDescription());
            notesRepository.save(updatedNote);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
