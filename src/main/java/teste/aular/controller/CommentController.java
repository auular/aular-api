package teste.aular.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import teste.aular.domain.contract.CommentRepository;
import teste.aular.domain.contract.HotelRepository;
import teste.aular.domain.contract.PetTutorRepository;
import teste.aular.domain.entity.Hotel;
import teste.aular.domain.entity.PetTutor;
import teste.aular.domain.vo.Comment;
import teste.aular.response.CommentResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PetTutorRepository petTutorRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        Optional<PetTutor> petTutor = this.petTutorRepository.findByPetTutorUuid(comment.getAuthor().getPetTutorUuid());
        Optional<Hotel> hotel = this.hotelRepository.getSimpleByHotelUuid(comment.getHotelUuid());

        if (petTutor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet tutor UUID inválido");
        }

        if (hotel.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel UUID inválido");
        }

        comment.setAuthor(petTutor.get());
        comment.setHotel(hotel.get());

        this.petTutorRepository.save(petTutor.get());
        this.hotelRepository.save(hotel.get());

        this.commentRepository.save(comment);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{hotelUuid}")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable String hotelUuid) {
        List<Comment> comments = this.commentRepository.findAllByHotelHotelUuid(hotelUuid);

        List<CommentResponse> mappedComments = comments.stream().map(comment -> {
            return new CommentResponse(comment.getAuthor().getName(), comment.getComment());
        }).collect(Collectors.toList());

        return comments.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(mappedComments);
    }
}
