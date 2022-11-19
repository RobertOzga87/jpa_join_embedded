package com.icerik.test;

import com.icerik.test.model.Person;
import com.icerik.test.model.Document;
import com.icerik.test.model.ObjectRef;
import com.icerik.test.repository.PersonRepository;
import com.icerik.test.repository.DocumentRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RepositoriesTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    DocumentRepository docRepo;

    @Autowired
    PersonRepository perRepo;

    @Test
    void test(){
        //given
        var ref = new ObjectRef("id", "doc");
        var doc = createDoc("My doc", ref);
        var per = createPers("new", ref);

        //debug
        docRepo.findAll().forEach(d -> logger.info(d.toString()));
        perRepo.findAll().forEach(d -> logger.info(d.toString()));

        //when
        var result = docRepo.findById(doc.getId());

        //then
        assertThat(result).isPresent().get().extracting("person").isEqualTo(per);

    }

    Document createDoc(String name, ObjectRef ref){
        var doc = new Document();
        doc.setName(name);
        doc.setObject(ref);
        return docRepo.save(doc);
    }

    Person createPers(String name, ObjectRef ref){
        var assigment = new Person();
        assigment.setName(name);
        assigment.setObject(ref);
        return perRepo.save(assigment);
    }
}
