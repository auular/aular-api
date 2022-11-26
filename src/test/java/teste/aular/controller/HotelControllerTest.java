package teste.aular.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teste.aular.domain.contract.*;
import teste.aular.domain.entity.Hotel;
import teste.aular.service.HotelService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = HotelController.class)
class HotelControllerTest {


    @MockBean
    private HotelService service;

    @Autowired
    private HotelController hotelController;

    @MockBean
    private HotelRepository repository;

    @MockBean
    private CampaignRepository campaignRepository;

    @MockBean
    private AddressRepository addressRepository;

    @MockBean
    private PlanRepository planRepository;

    @MockBean
    ServicesProvidedRepository servicesProvidedRepository;


    @Test
    @DisplayName("HotelController must have @RestController annotation")
    void hotelControllerMustHaveRestControllerAnnotation() {
        assertTrue(hotelController.getClass().isAnnotationPresent(RestController.class),
                "@RestController annotation not found");
    }

    @Test
    @DisplayName("HotelController must have @RequestMapping annotation")
    void hotelControllerMustHaveRequestMappingAnnotation() {
        assertTrue(hotelController.getClass().isAnnotationPresent(RequestMapping.class),
                "@RequestMapping annotation not found");
    }

//    @Test
//    void testPut(){
//        Integer idTeste = 51;
//        when(repository.existsById(idTeste)).thenReturn(false);
//
//        ResponseEntity<Hotel> resposta = hotelController.put(idTeste, mock(Hotel.class));
//
//        assertEquals(404, resposta.getStatusCodeValue());
//        assertNull(resposta.getBody());
//    }

    @Test
    @DisplayName("Post method returns 201 with body")
    void postReturns201WithBody() {
        String documentId = "12345";
        String email = "wall@test.com";

        Hotel hotel = new Hotel();

        when(repository.existsByDocumentId(documentId)).thenReturn(true);
        when(repository.existsByEmail(email)).thenReturn(true);

        ResponseEntity<Integer> response = hotelController.postHotel(hotel);

        verify(repository, times(1)).save(hotel);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());

    }

    @Test
    @DisplayName("Class must return 403 with null hotel")
    void postReturns403() {
        String documentId = "12345";
        String email = "wall@test.com";
        when(repository.existsByEmail(email)).thenReturn(false);
        ResponseEntity<Integer> response = hotelController.postHotel(null);
        assertEquals(403, response.getStatusCodeValue());
        assertNull(response.getBody());
    }


}