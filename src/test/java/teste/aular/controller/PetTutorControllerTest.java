package teste.aular.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
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

import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("post must return 201 with body")
    void postMustReturn201WithBody() {
        String documentId = "11223344";
        when(repository.existsByDocumentId(
                documentId)).thenReturn(true);

        ResponseEntity<PetTutor> response = controller.addPetTutor(new PetTutor());

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    @DisplayName("post must return 403")
    void postMustReturn403() {
        ResponseEntity<PetTutor> response = controller.addPetTutor(null);

        assertEquals(403, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("Get must return 200 with body")
    void getMustReturn200WithBody() {
        List<PetTutor> list = List.of(
                mock(PetTutor.class),
                mock(PetTutor.class)
        );

        when(repository.findAll()).thenReturn(list);

        ResponseEntity<List<PetTutor>> response = controller.getPetTutors();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }
    @Test
    @DisplayName("Get must return 202 when list is empty")
    void getMustReturn204() {

        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<PetTutor>> response = controller.getPetTutors();

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("Returns 200 with body for put request")
    void putReturns200WithBody() {
        Integer id = 13;
        PetTutor petTutor = new PetTutor();

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity<PetTutor> response = controller.updatePetTutor(id, petTutor);
        verify(repository, times(1)).save(petTutor);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    @DisplayName("Returns 404  for put request")
    void putReturns404() {
        Integer id = 13;
        PetTutor petTutor = new PetTutor();

        when(repository.existsById(id)).thenReturn(false);

        ResponseEntity<PetTutor> response = controller.updatePetTutor(id, petTutor);

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }


}