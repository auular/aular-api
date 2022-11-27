package teste.aular.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teste.aular.domain.contract.CampaignRepository;
import teste.aular.domain.contract.PartnerRepository;
import teste.aular.domain.entity.Partner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = PartnerController.class)
class PartnerControllerTest {

    @MockBean
    PartnerRepository repository;

    @Autowired
    PartnerController controller;

    @MockBean
    CampaignRepository campaignRepository;

    @Test
    @DisplayName("post returns 200 with body")
    void postReturns200withBody() {
        String documentId = "123";

        Partner partner = mock(Partner.class);

        when(repository.existsByDocumentId(documentId)).thenReturn(true);

        ResponseEntity<Partner> response = controller.addPartner(partner);

        verify(repository, times(1)).save(partner);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    @DisplayName("post returns 403")
    void postReturns403() {
        ResponseEntity<Partner> response = controller.addPartner(null);

        assertEquals(403, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

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