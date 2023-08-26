package com.br.faccat.sistdist.controller;

import com.br.faccat.sistdist.LivroRepository;
import com.br.faccat.sistdist.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class LivroController {
    @Autowired
    private LivroRepository _livroRepository;

    @RequestMapping(value = "/livro", method = RequestMethod.GET)
    public List<Livro> Get() {
        return _livroRepository.findAll();
    }

    @RequestMapping(value = "/livro/{id}", method = RequestMethod.GET)
    public ResponseEntity<Livro> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Livro> livro = _livroRepository.findById(id);
        if(livro.isPresent())
            return new ResponseEntity<Livro>(livro.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/livro", method =  RequestMethod.POST)
    public Livro Post(@RequestBody Livro livro)
    {
        return _livroRepository.save(livro);
    }

    @RequestMapping(value = "/livro/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Livro> Put(@PathVariable(value = "id") long id, @RequestBody Livro newLivro)
    {
        Optional<Livro> oldLivro = _livroRepository.findById(id);
        if(oldLivro.isPresent()){
            Livro livro = oldLivro.get();
            livro.setTitulo(newLivro.getTitulo());
            livro.setPreco(newLivro.getPreco());
            _livroRepository.save(livro);
            return new ResponseEntity<Livro>(livro, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/livro/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Livro> livro = _livroRepository.findById(id);
        if(livro.isPresent()){
            _livroRepository.delete(livro.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
