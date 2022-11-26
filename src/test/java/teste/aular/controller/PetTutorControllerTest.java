package teste.aular.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teste.aular.domain.contract.AddressRepository;
import teste.aular.domain.contract.PetRepository;
import teste.aular.domain.contract.PetTutorRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PetTutorController.class)
class PetTutorControllerTest {

    @MockBean
    private PetTutorRepository repository;

    @MockBean
    private PetRepository petRepository;

    @MockBean
    private AddressRepository addressRepository;

    @Autowired
    private PetTutorController controller;

    @Test
    @DisplayName("Class must have @RequestMapping annotation")
    void mustHaveRequestMappingAnnotation() {
        assertTrue(controller.getClass().isAnnotationPresent(RequestMapping.class),
                "@RequestMapping annotation not found");
    }

    @Test
    @DisplayName("Class must have @RestController annotation")
    void mustHaveRestControllerAnnotation() {
        assertTrue(controller.getClass().isAnnotationPresent(RestController.class),
                "@RestController annotation not found");
    }

}