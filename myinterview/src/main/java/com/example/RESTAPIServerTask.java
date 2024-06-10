package com.example;
import Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * This task expects you to create an implementation of a REST API Server.
 * Your code should expose a REST API. 
 * Feel free to explore possibilities/functionalities/capabilities following Rest standard (best practices) 
 * and any framework or library to help you in this journey.
 * We suggest that your implementation have at least a CRUD scenario about any subject.
 * Be creative!
 *
 */

// Para fim de exemplificação, montei de forma abstrata o que seria o CRUD do
//json recebido na task dos clientes. Usei como base minha experiência com o 
//framework Spring, portanto talvez falte algumas dependencias e linhas de código. 
//Também ainda falta um arquivo para a conexão com o BD e um modelo para ser 
//montada as tabelas, porém por falta de tempo não consiguirei implementar, então 
//fiz foi um esboço de como ficaria o CRUD. 

@RestController
 public class RESTAPIServerTask {
    //@Autowired
    // private RecordsRepo recordsRepo
    // Teoricamente colocariamos aqui o modelo para a table, o Autowired ajuda
    //atualizando a table automaticamente, para não ter que haver redeploy

    // Exemplo de função get, poderia implementar para mandar os dados
    //dos records armazenados no BD
    @GetMapping(value = "/")
    public String menu(){
        return "Hello world!";
    }

    
    // Exemplo função post, poderia implementar para mandar os dados
    //dos records do BD para o front
    @PostMapping(value = "/save")
    public Records saveRecords(@RequestBody Records records){
        // Fazer um verificação do conteudo enviado antes de inserir no BD, 
        //pois caso tenha erro precisamos verificar e resolve-lo.
        recordsRepo.save(records)
    }

    // Exemplo função put, poderia implementar para atualizar os dados
    //dos records do BD 
    @PutMapping(value = "/update/{id}")
    public Records updateRecords(int id, @RequestBody Records record){
        Records newRecord = recordsRepo.findById(id).get()
        // Verificar se houve algum acerto
        // Caso houve, podemos atualizar o record.
    }

    @DeleteMapping(value = "/delete/{id")
    public Records deleteRecords(int id){
        Records deletedRecord = recordsRepo.findById(id).get()
        // Verificar se houve algum acerto
        // Caso houve, podemos atualizar o record.
        recordRepo.delete(deletedRecord);
    }
}