package controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import dto.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:WebContent/WEB-INF/dispatcher-servlet.xml"})
public class IMControllerTest {

    private MockMvc mockMvc;
    
    @Autowired
	private WebApplicationContext context;

    @Before
    public void setup() {

        //mockMvc = MockMvcBuilders.standaloneSetup(new IMCController()).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void testInicio() throws Exception {

        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(forwardedUrl("/WEB-INF/inicio.jsp"));

    }
    
    private String jsonPersona ()
    {
    	Persona p =new Persona();
    	p.setAltura(2);
    	p.setPeso(90);
    	p.setNombre("Pepi");
    	Gson gson =new Gson();
    	return gson.toJson(p);
    }
    
    @Test
    public void testPostIMC() throws Exception {

            
        mockMvc.perform(post("/imc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPersona())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        		.andExpect(model().attributeExists("resultado"));
               
    }
    
    
}