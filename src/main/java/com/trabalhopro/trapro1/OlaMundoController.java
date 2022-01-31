package com.trabalhopro.trapro1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {
    List<Aluno>alunos = new ArrayList<>();




    @GetMapping
    private List<Aluno> listaAlunos(){

        return alunos ;
    }
    @PostMapping
    public Integer add(@RequestBody final Aluno aluno){
        if(aluno.getId() == null){
            aluno.setId(alunos.size()+1);
        }
        alunos.add(aluno);
        return aluno.getId();
    }

    @PutMapping
    public void update(@RequestBody final Aluno aluno){
          alunos.stream()
                .filter(al -> al.getIdade().equals(aluno.getIdade()))
                  .forEach(al-> al.setIdade(aluno.getIdade()));

          alunos.stream()
                .filter(al -> al.getNome().equals(aluno.getNome()))
                  .forEach(al-> al.setNome(aluno.getNome()));

          alunos.stream()
                .filter(al -> al.getId().equals(aluno.getId()))
                  .forEach(al-> al.setId(aluno.getId()));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        alunos.removeIf(al-> al.getId().equals(id));
    }
}
