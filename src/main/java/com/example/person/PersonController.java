package com.example.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping("/persons")
    public List<Person> getVideoList() {
        return personService.getPersonList();
    }

    @RequestMapping("/persons/{id}")
    public Person getVideo(@PathVariable long id) {
        return personService.getPerson(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/persons")
    public void addVideo(@RequestBody Person Person) {
        personService.addPerson(Person);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/persons/{id}")
    public void updateVideo(@PathVariable long id, @RequestBody Person Person) {
        personService.updatePerson(id, Person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/persons/{id}")
    public void deleteVideo(@PathVariable long id) {
        personService.deletePerson(id);
    }

}
