package teste.aular.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teste.aular.domain.contract.AddressRepository;
import teste.aular.domain.contract.PetRepository;
import teste.aular.domain.contract.PetTutorRepository;
import teste.aular.domain.entity.PetTutor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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


    @Test
    @DisplayName("Class must return 201 with body")
    void mustReturn201WithBody() {
        String documentId = "11223344";
        when(repository.existsByDocumentId(
                documentId)).thenReturn(true);

        ResponseEntity<PetTutor> response = controller.addPetTutor(new PetTutor());

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    @DisplayName("Class must return 403")
    void mustReturn403() {
        ResponseEntity<PetTutor> response = controller.addPetTutor(null);

        assertEquals(403, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}