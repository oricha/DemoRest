package org.example.kmuniz

import groovy.json.JsonSlurper
import org.example.controller.CarController
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.client.RestTemplate
import static org.springframework.http.HttpStatus.*
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import spock.lang.Specification


class CarControllerTest extends Specification{

    def controller = new CarController()
    RestTemplate rt

    MockMvc mockMvc = standaloneSetup(controller)

    def 'setup'(){
        rt = new RestTemplate()
    }

    def 'get car by id '(){

       when:
       def response = mockMvc.perform(get('/car/1')).andReturn().response
       def content = new JsonSlurper().parseText(response.contentAsString)

       then:
       response.status == OK.value()
       response.contentType.contains('application/json')
       response.contentType == 'application/json;charset=UTF-8'
    }
}

